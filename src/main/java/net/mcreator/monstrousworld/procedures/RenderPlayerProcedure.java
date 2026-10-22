package net.mcreator.monstrousworld.procedures;

import org.joml.Vector3f;

import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.EntityModel;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModHumanoidModels;

import javax.annotation.Nullable;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Collection;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(Dist.CLIENT)
public class RenderPlayerProcedure {
	@SubscribeEvent
	public static void onPlayerRendered(RenderPlayerEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getY(), event.getEntity(), (EntityModel) event.getRenderer().getModel(), event, event.getPoseStack());
	}

	public static void offsetScale(PlayerModel model, Vector3f offset) {
		model.head.offsetScale(offset);
		model.head.y += offset.x() > 0 ? 0.05 : -0.05;
		model.body.offsetScale(offset);
		model.leftArm.offsetScale(offset);
		model.rightArm.offsetScale(offset);
		model.leftLeg.offsetScale(offset);
		model.rightLeg.offsetScale(offset);
		model.hat.offsetScale(offset);
		model.hat.y += offset.x() > 0 ? 0.05 : -0.05;
		model.jacket.offsetScale(offset);
		model.leftSleeve.offsetScale(offset);
		model.rightSleeve.offsetScale(offset);
		model.leftPants.offsetScale(offset);
		model.rightPants.offsetScale(offset);
	}

	public static Collection<Runnable> capes = new ConcurrentLinkedQueue<>();

	public static void renderHumanoid(RenderPlayerEvent playerRenderEvent, PlayerModel model, VertexConsumer vertexConsumer) {
		PoseStack poseStack = playerRenderEvent.getPoseStack();
		((HumanoidModel) playerRenderEvent.getRenderer().getModel()).copyPropertiesTo(model);
		AbstractClientPlayer eventEntity_ = (AbstractClientPlayer) playerRenderEvent.getEntity();
		float partialTick = playerRenderEvent.getPartialTick();
		model.attackTime = eventEntity_.getAttackAnim(partialTick);
		float limbSwing = eventEntity_.walkAnimation.position(partialTick);
		float limbSwingAmount = eventEntity_.walkAnimation.speed(partialTick);
		float ageInTicks = eventEntity_.tickCount + partialTick;
		float interpolatedBodyYaw = Mth.rotLerp(partialTick, eventEntity_.yBodyRotO, eventEntity_.yBodyRot);
		float interpolatedHeadYaw = Mth.rotLerp(partialTick, eventEntity_.yHeadRotO, eventEntity_.yHeadRot);
		if (eventEntity_.isPassenger() && eventEntity_.getVehicle() instanceof LivingEntity vehicle) {
			interpolatedBodyYaw = Mth.rotLerp(partialTick, vehicle.yBodyRotO, vehicle.yBodyRot);
			float yawDiff = Mth.wrapDegrees(interpolatedHeadYaw - interpolatedBodyYaw);
			if (yawDiff < -85.0F)
				yawDiff = -85.0F;
			if (yawDiff >= 85.0F)
				yawDiff = 85.0F;
			interpolatedBodyYaw = interpolatedHeadYaw - yawDiff;
			if (yawDiff * yawDiff > 2500.0F) {
				interpolatedBodyYaw += yawDiff * 0.2F;
			}
			interpolatedBodyYaw = Mth.wrapDegrees(interpolatedBodyYaw);
		}
		float netHeadYaw = interpolatedHeadYaw - interpolatedBodyYaw;
		float headPitch = Mth.lerp(partialTick, eventEntity_.xRotO, eventEntity_.getXRot());
		poseStack.pushPose();
		model.prepareMobModel(eventEntity_, limbSwing, limbSwingAmount, partialTick);
		CompoundTag playerData = eventEntity_.getPersistentData();
		float oldAnimationProgress = 0;
		float oldAgeInTicks = 0;
		if (playerData.contains("PlayerAnimationProgress")) {
			oldAnimationProgress = playerData.getFloat("PlayerAnimationProgress");
			oldAgeInTicks = playerData.getFloat("LastTickTime");
		}
		model.setupAnim(eventEntity_, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		if (playerData.contains("PlayerAnimationProgress") && playerData.getFloat("PlayerAnimationProgress") > 0) {
			playerData.putFloat("PlayerAnimationProgress", oldAnimationProgress);
			playerData.putFloat("LastTickTime", oldAgeInTicks);
		} else if (oldAnimationProgress > 0) {
			model.setupAnim(eventEntity_, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
		if (eventEntity_.hasPose(Pose.SLEEPING)) {
			Direction direction = eventEntity_.getBedOrientation();
			if (direction != null) {
				float eyeHeightOffset = eventEntity_.getEyeHeight(Pose.STANDING) - 0.1F;
				poseStack.translate((float) (-direction.getStepX()) * eyeHeightOffset, 0.0F, (float) (-direction.getStepZ()) * eyeHeightOffset);
			}
		}
		playerRenderEvent.getRenderer().setupRotations(eventEntity_, poseStack, ageInTicks, interpolatedBodyYaw, partialTick, 0);
		poseStack.scale(-0.938f, -0.938f, 0.938f);
		poseStack.translate(0.0D, -1.501, 0.0D);
		Vector3f offset = new Vector3f(0.015f);
		offsetScale(model, offset);
		if (!capes.isEmpty()) {
			capes.forEach(cape -> cape.run());
			capes.clear();
		}
		model.renderToBuffer(poseStack, vertexConsumer, playerRenderEvent.getPackedLight(), LivingEntityRenderer.getOverlayCoords(eventEntity_, 0));
		offset.negate();
		offsetScale(model, offset);
		poseStack.popPose();
	}

	public static void renderEntity(RenderPlayerEvent playerRenderEvent, EntityModel model, VertexConsumer vertexConsumer) {
		PoseStack poseStack = playerRenderEvent.getPoseStack();
		PlayerModel playerModel = (PlayerModel) playerRenderEvent.getRenderer().getModel();
		playerModel.copyPropertiesTo(model);
		AbstractClientPlayer eventEntity_ = (AbstractClientPlayer) playerRenderEvent.getEntity();
		float partialTick = playerRenderEvent.getPartialTick();
		float limbSwing = eventEntity_.walkAnimation.position(partialTick);
		float limbSwingAmount = eventEntity_.walkAnimation.speed(partialTick);
		float ageInTicks = eventEntity_.tickCount + partialTick;
		float interpolatedBodyYaw = Mth.rotLerp(partialTick, eventEntity_.yBodyRotO, eventEntity_.yBodyRot);
		float interpolatedHeadYaw = Mth.rotLerp(partialTick, eventEntity_.yHeadRotO, eventEntity_.yHeadRot);
		if (eventEntity_.isPassenger() && eventEntity_.getVehicle() instanceof LivingEntity vehicle) {
			interpolatedBodyYaw = Mth.rotLerp(partialTick, vehicle.yBodyRotO, vehicle.yBodyRot);
			float yawDiff = Mth.wrapDegrees(interpolatedHeadYaw - interpolatedBodyYaw);
			if (yawDiff < -85.0F)
				yawDiff = -85.0F;
			if (yawDiff >= 85.0F)
				yawDiff = 85.0F;
			interpolatedBodyYaw = interpolatedHeadYaw - yawDiff;
			if (yawDiff * yawDiff > 2500.0F) {
				interpolatedBodyYaw += yawDiff * 0.2F;
			}
			interpolatedBodyYaw = Mth.wrapDegrees(interpolatedBodyYaw);
		}
		float netHeadYaw = interpolatedHeadYaw - interpolatedBodyYaw;
		float headPitch = Mth.lerp(partialTick, eventEntity_.xRotO, eventEntity_.getXRot());
		poseStack.pushPose();
		if (eventEntity_.hasPose(Pose.SLEEPING)) {
			Direction direction = eventEntity_.getBedOrientation();
			if (direction != null) {
				float eyeHeightOffset = eventEntity_.getEyeHeight(Pose.STANDING) - 0.1F;
				poseStack.translate((float) (-direction.getStepX()) * eyeHeightOffset, 0.0F, (float) (-direction.getStepZ()) * eyeHeightOffset);
			}
		}
		playerRenderEvent.getRenderer().setupRotations(eventEntity_, poseStack, ageInTicks, interpolatedBodyYaw, partialTick, 69);
		poseStack.scale(-0.938f, -0.938f, 0.938f);
		poseStack.translate(0.0D, -1.501, 0.0D);
		model.prepareMobModel(eventEntity_, limbSwing, limbSwingAmount, partialTick);
		model.setupAnim(eventEntity_, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		model.renderToBuffer(poseStack, vertexConsumer, playerRenderEvent.getPackedLight(), LivingEntityRenderer.getOverlayCoords(eventEntity_, 0));
		poseStack.popPose();
	}

	public static void execute(LevelAccessor world, double y, Entity entity, EntityModel entityModel, RenderPlayerEvent playerRenderEvent, PoseStack poseStack) {
		execute(null, world, y, entity, entityModel, playerRenderEvent, poseStack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double y, Entity entity, EntityModel entityModel, RenderPlayerEvent playerRenderEvent, PoseStack poseStack) {
		if (entity == null || entityModel == null || playerRenderEvent == null || poseStack == null)
			return;
		if (world.isClientSide()) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.INVISIBILITY))) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.WEBBED))) {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) < 300
							&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION).getDuration() : 0) >= 1) {
						if ((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity5.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
							{
								ResourceLocation texture = MonstrousWorldModVariables.acid_overlay;
								renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						} else {
							poseStack.pushPose();
							poseStack.scale((float) (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity7.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity8.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity9.getAttribute(Attributes.SCALE).getValue() : 0));
							{
								ResourceLocation texture = MonstrousWorldModVariables.acid_overlay;
								renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
							poseStack.popPose();
						}
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.INFESTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.INFESTED).getDuration() : 0) >= 1) {
						if ((entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity14.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
							{
								ResourceLocation texture = MonstrousWorldModVariables.popcorn_overlay;
								renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						} else {
							poseStack.pushPose();
							poseStack.scale((float) (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity16.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity17.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity18.getAttribute(Attributes.SCALE).getValue() : 0));
							{
								ResourceLocation texture = MonstrousWorldModVariables.popcorn_overlay;
								renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
							poseStack.popPose();
						}
					}
					if (entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(MonstrousWorldModMobEffects.POSSESSED_2)) {
						if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true)) {
							if ((entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity23.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerDarkPossessedFace;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerDarkPossessedEyes;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.eyes(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity26.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity27 && _livingEntity27.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity27.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity28.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerDarkPossessedFace;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerDarkPossessedEyes;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.eyes(texture)));
								}
								poseStack.popPose();
							}
						}
					}
					if (entity instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(MonstrousWorldModMobEffects.POSSESSED)) {
						if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true)) {
							if ((entity instanceof LivingEntity _livingEntity34 && _livingEntity34.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity34.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerLevPossessedFace;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerLevPossessedEyes;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.eyes(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity37 && _livingEntity37.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity37.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity38 && _livingEntity38.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity38.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity39 && _livingEntity39.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity39.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerLevPossessedFace;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerLevPossessedEyes;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.eyes(texture)));
								}
								poseStack.popPose();
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3) {
						if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.BLACKOUT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.BLACKOUT).getDuration() : 0) >= 1
								|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER).getDuration() : 0) >= 1) {
							((PlayerModel) entityModel).body.visible = false;
							((PlayerModel) entityModel).hat.visible = false;
							((PlayerModel) entityModel).head.visible = false;
							((PlayerModel) entityModel).jacket.visible = false;
							((PlayerModel) entityModel).leftArm.visible = false;
							((PlayerModel) entityModel).leftLeg.visible = false;
							((PlayerModel) entityModel).leftPants.visible = false;
							((PlayerModel) entityModel).leftSleeve.visible = false;
							((PlayerModel) entityModel).rightArm.visible = false;
							((PlayerModel) entityModel).rightLeg.visible = false;
							((PlayerModel) entityModel).rightPants.visible = false;
							((PlayerModel) entityModel).rightSleeve.visible = false;
							{
								ResourceLocation texture = MonstrousWorldModVariables.hunger_mode;
								renderEntity(playerRenderEvent, MonstrousWorldModVariables.PlayerHungerMode, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
							poseStack.translate(1, (float) (y + 1), 1);
						} else {
							if ((entity instanceof LivingEntity _livingEntity60 && _livingEntity60.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity60.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									capes.add(() -> {
										Player player = (Player) entity;
										float partialTicks = playerRenderEvent.getPartialTick();
										MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.crouching = player.isShiftKeyDown();
										if (!player.isFallFlying() && player.isAlive()) {
											double dx = player.xCloakO + (player.xCloak - player.xCloakO) * partialTicks - (player.xOld + (player.getX() - player.xOld) * partialTicks);
											double dy = player.yCloakO + (player.yCloak - player.yCloakO) * partialTicks - (player.yOld + (player.getY() - player.yOld) * partialTicks);
											double dz = player.zCloakO + (player.zCloak - player.zCloakO) * partialTicks - (player.zOld + (player.getZ() - player.zOld) * partialTicks);
											float bodyYaw = player.yBodyRotO + (player.yBodyRot - player.yBodyRotO) * partialTicks;
											double sin = Math.sin(bodyYaw * Math.PI / 180.0);
											double cos = -Math.cos(bodyYaw * Math.PI / 180.0);
											float xRot = (float) (dy * 10.0);
											xRot = Math.max(xRot, -6.0F);
											xRot = Math.min(xRot, 32.0F);
											float yRot = (float) ((dx * sin + dz * cos) * 100.0F);
											float zRot = (float) ((dx * cos - dz * sin) * 100.0F);
											yRot = Math.max(yRot, 0.0F);
											yRot = Math.min(yRot, 150.0F);
											zRot = Math.max(zRot, -20.0F);
											zRot = Math.min(zRot, 20.0F);
											if (xRot < -5.0F)
												xRot = -5.0F;
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.xRot = Math.min((float) Math.toRadians(6.0F + xRot / 2.0F + yRot / 2.0F) + MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.xRot,
													(float) 1.41);
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.yRot = 0.0F;
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.zRot = (float) Math.toRadians(zRot / 2.0F);
										} else {
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.xRot = 0.0F;
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.yRot = 0.0F;
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.zRot = 0.0F;
										}
									});
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.player_dark_armor_overlay;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.player_dark_armor_arm;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity64 && _livingEntity64.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity64.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity65 && _livingEntity65.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity65.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity66 && _livingEntity66.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity66.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									capes.add(() -> {
										Player player = (Player) entity;
										float partialTicks = playerRenderEvent.getPartialTick();
										MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.crouching = player.isShiftKeyDown();
										if (!player.isFallFlying() && player.isAlive()) {
											double dx = player.xCloakO + (player.xCloak - player.xCloakO) * partialTicks - (player.xOld + (player.getX() - player.xOld) * partialTicks);
											double dy = player.yCloakO + (player.yCloak - player.yCloakO) * partialTicks - (player.yOld + (player.getY() - player.yOld) * partialTicks);
											double dz = player.zCloakO + (player.zCloak - player.zCloakO) * partialTicks - (player.zOld + (player.getZ() - player.zOld) * partialTicks);
											float bodyYaw = player.yBodyRotO + (player.yBodyRot - player.yBodyRotO) * partialTicks;
											double sin = Math.sin(bodyYaw * Math.PI / 180.0);
											double cos = -Math.cos(bodyYaw * Math.PI / 180.0);
											float xRot = (float) (dy * 10.0);
											xRot = Math.max(xRot, -6.0F);
											xRot = Math.min(xRot, 32.0F);
											float yRot = (float) ((dx * sin + dz * cos) * 100.0F);
											float zRot = (float) ((dx * cos - dz * sin) * 100.0F);
											yRot = Math.max(yRot, 0.0F);
											yRot = Math.min(yRot, 150.0F);
											zRot = Math.max(zRot, -20.0F);
											zRot = Math.min(zRot, 20.0F);
											if (xRot < -5.0F)
												xRot = -5.0F;
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.xRot = Math.min((float) Math.toRadians(6.0F + xRot / 2.0F + yRot / 2.0F) + MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.xRot,
													(float) 1.41);
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.yRot = 0.0F;
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.zRot = (float) Math.toRadians(zRot / 2.0F);
										} else {
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.xRot = 0.0F;
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.yRot = 0.0F;
											MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE.body.zRot = 0.0F;
										}
									});
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.player_dark_armor_overlay;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DARKENED_CAPE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.player_dark_armor_arm;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
								}
								poseStack.popPose();
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1) {
						if ((entity instanceof LivingEntity _livingEntity72 && _livingEntity72.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity72.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyFace;
								renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_FLY_FACE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						} else {
							poseStack.pushPose();
							poseStack.scale((float) (entity instanceof LivingEntity _livingEntity74 && _livingEntity74.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity74.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity75 && _livingEntity75.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity75.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity76 && _livingEntity76.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity76.getAttribute(Attributes.SCALE).getValue() : 0));
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyFace;
								renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_FLY_FACE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
							poseStack.popPose();
						}
						if (((PlayerModel) entityModel).slim) {
							if ((entity instanceof LivingEntity _livingEntity81 && _livingEntity81.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity81.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity83 && _livingEntity83.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity83.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity84 && _livingEntity84.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity84.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity85 && _livingEntity85.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity85.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity89 && _livingEntity89.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity89.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyOverlayWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity91 && _livingEntity91.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity91.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity92 && _livingEntity92.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity92.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity93 && _livingEntity93.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity93.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyOverlayWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						}
						if (entity.onGround()) {
							if ((entity instanceof LivingEntity _livingEntity98 && _livingEntity98.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity98.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyWings;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.FLY_WINGS_ON_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity100 && _livingEntity100.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity100.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity101 && _livingEntity101.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity101.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity102 && _livingEntity102.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity102.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyWings;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.FLY_WINGS_ON_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
								poseStack.popPose();
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity106 && _livingEntity106.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity106.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyWingsOffGround;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.FLY_WINGS_OFF_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity108 && _livingEntity108.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity108.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity109 && _livingEntity109.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity109.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity110 && _livingEntity110.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity110.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyWingsOffGround;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.FLY_WINGS_OFF_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
								poseStack.popPose();
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2) {
						if ((entity instanceof LivingEntity _livingEntity114 && _livingEntity114.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity114.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerEyeOverlay;
								renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						} else {
							poseStack.pushPose();
							poseStack.scale((float) (entity instanceof LivingEntity _livingEntity116 && _livingEntity116.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity116.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity117 && _livingEntity117.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity117.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity118 && _livingEntity118.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity118.getAttribute(Attributes.SCALE).getValue() : 0));
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerEyeOverlay;
								renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
							poseStack.popPose();
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
						((PlayerModel) entityModel).leftLeg.visible = false;
						((PlayerModel) entityModel).rightLeg.visible = false;
						if ((entity instanceof LivingEntity _livingEntity124 && _livingEntity124.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity124.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentBody;
								renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.SERPENT_BODY, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						} else {
							poseStack.pushPose();
							poseStack.scale((float) (entity instanceof LivingEntity _livingEntity126 && _livingEntity126.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity126.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity127 && _livingEntity127.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity127.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity128 && _livingEntity128.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity128.getAttribute(Attributes.SCALE).getValue() : 0));
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentBody;
								renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.SERPENT_BODY, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
							poseStack.popPose();
						}
						if (((PlayerModel) entityModel).slim) {
							if ((entity instanceof LivingEntity _livingEntity133 && _livingEntity133.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity133.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity135 && _livingEntity135.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity135.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity136 && _livingEntity136.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity136.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity137 && _livingEntity137.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity137.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity141 && _livingEntity141.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity141.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentOverlayWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity143 && _livingEntity143.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity143.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity144 && _livingEntity144.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity144.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity145 && _livingEntity145.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity145.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentOverlayWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
						if (((PlayerModel) entityModel).slim) {
							if ((entity instanceof LivingEntity _livingEntity150 && _livingEntity150.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity150.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerZombieOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity152 && _livingEntity152.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity152.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity153 && _livingEntity153.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity153.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity154 && _livingEntity154.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity154.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerZombieOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity158 && _livingEntity158.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity158.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerZombieOverlay;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity160 && _livingEntity160.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity160.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity161 && _livingEntity161.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity161.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity162 && _livingEntity162.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity162.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerZombieOverlay;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
							if ((entity instanceof LivingEntity _livingEntity166 && _livingEntity166.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity166.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.UndeadGlowEyes;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.eyes(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity168 && _livingEntity168.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity168.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity169 && _livingEntity169.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity169.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity170 && _livingEntity170.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity170.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.UndeadGlowEyes;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.eyes(texture)));
								}
								poseStack.popPose();
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
						if (((PlayerModel) entityModel).slim) {
							if ((entity instanceof LivingEntity _livingEntity175 && _livingEntity175.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity175.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.GoblinEarsPlayer;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.GOBLIN_EARS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.GoblinPlayerSkinSlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity178 && _livingEntity178.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity178.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity179 && _livingEntity179.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity179.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity180 && _livingEntity180.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity180.getAttribute(Attributes.SCALE).getValue() : 0));
								poseStack.popPose();
								{
									ResourceLocation texture = MonstrousWorldModVariables.GoblinEarsPlayer;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.GOBLIN_EARS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.GoblinPlayerSkinSlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity185 && _livingEntity185.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity185.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.GoblinEarsPlayer;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.GOBLIN_EARS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.GoblinPlayerSkinWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity188 && _livingEntity188.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity188.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity189 && _livingEntity189.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity189.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity190 && _livingEntity190.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity190.getAttribute(Attributes.SCALE).getValue() : 0));
								poseStack.popPose();
								{
									ResourceLocation texture = MonstrousWorldModVariables.GoblinEarsPlayer;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.GOBLIN_EARS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.GoblinPlayerSkinWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
						if (((PlayerModel) entityModel).slim) {
							if ((entity instanceof LivingEntity _livingEntity196 && _livingEntity196.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity196.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerTrollLayerWide;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.TROLL_FACE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerTrollLayerSlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity199 && _livingEntity199.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity199.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity200 && _livingEntity200.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity200.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity201 && _livingEntity201.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity201.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerTrollLayerWide;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.TROLL_FACE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerTrollLayerSlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity206 && _livingEntity206.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity206.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerTrollLayerWide;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.TROLL_FACE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerTrollLayerWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity209 && _livingEntity209.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity209.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity210 && _livingEntity210.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity210.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity211 && _livingEntity211.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity211.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerTrollLayerWide;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.TROLL_FACE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerTrollLayerWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if (((PlayerModel) entityModel).slim) {
							if (!(entity instanceof LivingEntity _livEnt217 && _livEnt217.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
								if ((entity instanceof LivingEntity _livingEntity218 && _livingEntity218.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity218.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPartsTexture;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_SWAMPMONSTER_PARTS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPlayerSkinSlim;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity221 && _livingEntity221.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity221.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity222 && _livingEntity222.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity222.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity223 && _livingEntity223.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity223.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPartsTexture;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_SWAMPMONSTER_PARTS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPlayerSkinSlim;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							} else {
								if ((entity instanceof LivingEntity _livingEntity228 && _livingEntity228.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity228.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPartsTexture;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_SWAMPMONSTER_PARTS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.feral_swampmonster_player_slim;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.player_moss_overlay;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity232 && _livingEntity232.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity232.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity233 && _livingEntity233.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity233.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity234 && _livingEntity234.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity234.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPartsTexture;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_SWAMPMONSTER_PARTS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.feral_swampmonster_player_slim;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.player_moss_overlay;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							}
						} else {
							if (!(entity instanceof LivingEntity _livEnt240 && _livEnt240.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
								if ((entity instanceof LivingEntity _livingEntity241 && _livingEntity241.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity241.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPartsTexture;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_SWAMPMONSTER_PARTS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPlayerSkinWide;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity244 && _livingEntity244.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity244.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity245 && _livingEntity245.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity245.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity246 && _livingEntity246.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity246.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPartsTexture;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_SWAMPMONSTER_PARTS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPlayerSkinWide;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							} else {
								if ((entity instanceof LivingEntity _livingEntity251 && _livingEntity251.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity251.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPartsTexture;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_SWAMPMONSTER_PARTS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.feral_swampmonster_player_wide;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.player_moss_overlay;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity255 && _livingEntity255.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity255.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity256 && _livingEntity256.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity256.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity257 && _livingEntity257.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity257.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPartsTexture;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_SWAMPMONSTER_PARTS, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.feral_swampmonster_player_wide;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									{
										ResourceLocation texture = MonstrousWorldModVariables.player_moss_overlay;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
							((PlayerModel) entityModel).body.visible = false;
							((PlayerModel) entityModel).hat.visible = false;
							((PlayerModel) entityModel).head.visible = false;
							((PlayerModel) entityModel).jacket.visible = false;
							((PlayerModel) entityModel).leftArm.visible = false;
							((PlayerModel) entityModel).leftLeg.visible = false;
							((PlayerModel) entityModel).leftPants.visible = false;
							((PlayerModel) entityModel).leftSleeve.visible = false;
							((PlayerModel) entityModel).rightArm.visible = false;
							((PlayerModel) entityModel).rightLeg.visible = false;
							((PlayerModel) entityModel).rightPants.visible = false;
							((PlayerModel) entityModel).rightSleeve.visible = false;
							if ((entity instanceof LivingEntity _livingEntity275 && _livingEntity275.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity275.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.WerewolfTexture;
									renderEntity(playerRenderEvent, MonstrousWorldModVariables.WerewolfForm, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity277 && _livingEntity277.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity277.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity278 && _livingEntity278.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity278.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity279 && _livingEntity279.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity279.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.WerewolfTexture;
									renderEntity(playerRenderEvent, MonstrousWorldModVariables.WerewolfForm, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
						if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true)) {
							{
								ResourceLocation texture = MonstrousWorldModVariables.VampireEyesHuman;
								renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						} else {
							((PlayerModel) entityModel).body.visible = false;
							((PlayerModel) entityModel).hat.visible = false;
							((PlayerModel) entityModel).head.visible = false;
							((PlayerModel) entityModel).jacket.visible = false;
							((PlayerModel) entityModel).leftArm.visible = false;
							((PlayerModel) entityModel).leftLeg.visible = false;
							((PlayerModel) entityModel).leftPants.visible = false;
							((PlayerModel) entityModel).leftSleeve.visible = false;
							((PlayerModel) entityModel).rightArm.visible = false;
							((PlayerModel) entityModel).rightLeg.visible = false;
							((PlayerModel) entityModel).rightPants.visible = false;
							((PlayerModel) entityModel).rightSleeve.visible = false;
							entity.refreshDimensions();
							{
								ResourceLocation texture = MonstrousWorldModVariables.BatTexture;
								renderEntity(playerRenderEvent, MonstrousWorldModVariables.BatForm, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == false) {
							if (entity.onGround()) {
								if ((entity instanceof LivingEntity _livingEntity299 && _livingEntity299.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity299.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonParts;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DEMON_ON_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity301 && _livingEntity301.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity301.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity302 && _livingEntity302.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity302.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity303 && _livingEntity303.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity303.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonParts;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DEMON_ON_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							} else {
								if ((entity instanceof LivingEntity _livingEntity307 && _livingEntity307.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity307.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonParts;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DEMON_OFF_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity309 && _livingEntity309.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity309.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity310 && _livingEntity310.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity310.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity311 && _livingEntity311.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity311.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonParts;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DEMON_OFF_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							}
							if (((PlayerModel) entityModel).slim) {
								if ((entity instanceof LivingEntity _livingEntity316 && _livingEntity316.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity316.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonSkinSlim;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity318 && _livingEntity318.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity318.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity319 && _livingEntity319.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity319.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity320 && _livingEntity320.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity320.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonSkinSlim;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							} else {
								if ((entity instanceof LivingEntity _livingEntity324 && _livingEntity324.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity324.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonSkinWide;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity326 && _livingEntity326.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity326.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity327 && _livingEntity327.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity327.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity328 && _livingEntity328.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity328.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonSkinWide;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
						if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Balloon == true)) {
							if ((entity instanceof LivingEntity _livingEntity332 && _livingEntity332.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity332.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerClownSkin;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.ClownNoseTexture;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.CLOWN_NOSE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerClownHair;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.CLOWN_HAIR, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity339 && _livingEntity339.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity339.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity340 && _livingEntity340.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity340.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity341 && _livingEntity341.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity341.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerClownSkin;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								{
									ResourceLocation texture = MonstrousWorldModVariables.ClownNoseTexture;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.CLOWN_NOSE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
								if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity349 && _livingEntity349.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity349.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity350 && _livingEntity350.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity350.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity351 && _livingEntity351.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity351.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerClownHair;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.CLOWN_HAIR, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Balloon == true) {
							((PlayerModel) entityModel).body.visible = false;
							((PlayerModel) entityModel).hat.visible = false;
							((PlayerModel) entityModel).head.visible = false;
							((PlayerModel) entityModel).jacket.visible = false;
							((PlayerModel) entityModel).leftArm.visible = false;
							((PlayerModel) entityModel).leftLeg.visible = false;
							((PlayerModel) entityModel).leftPants.visible = false;
							((PlayerModel) entityModel).leftSleeve.visible = false;
							((PlayerModel) entityModel).rightArm.visible = false;
							((PlayerModel) entityModel).rightLeg.visible = false;
							((PlayerModel) entityModel).rightPants.visible = false;
							((PlayerModel) entityModel).rightSleeve.visible = false;
							if ((entity instanceof LivingEntity _livingEntity367 && _livingEntity367.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity367.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerBalloonForm;
									renderEntity(playerRenderEvent, MonstrousWorldModVariables.BalloonForm, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity369 && _livingEntity369.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity369.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity370 && _livingEntity370.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity370.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity371 && _livingEntity371.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity371.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerBalloonForm;
									renderEntity(playerRenderEvent, MonstrousWorldModVariables.BalloonForm, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WebbedLevel == 1) {
					((PlayerModel) entityModel).body.visible = false;
					((PlayerModel) entityModel).hat.visible = false;
					((PlayerModel) entityModel).head.visible = false;
					((PlayerModel) entityModel).jacket.visible = false;
					((PlayerModel) entityModel).leftArm.visible = false;
					((PlayerModel) entityModel).leftLeg.visible = false;
					((PlayerModel) entityModel).leftPants.visible = false;
					((PlayerModel) entityModel).leftSleeve.visible = false;
					((PlayerModel) entityModel).rightArm.visible = false;
					((PlayerModel) entityModel).rightLeg.visible = false;
					((PlayerModel) entityModel).rightPants.visible = false;
					((PlayerModel) entityModel).rightSleeve.visible = false;
					if ((entity instanceof LivingEntity _livingEntity387 && _livingEntity387.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity387.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
						{
							ResourceLocation texture = MonstrousWorldModVariables.WrappedVictim;
							renderEntity(playerRenderEvent, MonstrousWorldModVariables.WebbedVictim1, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
						}
					} else {
						poseStack.pushPose();
						poseStack.scale((float) (entity instanceof LivingEntity _livingEntity389 && _livingEntity389.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity389.getAttribute(Attributes.SCALE).getValue() : 0),
								(float) (entity instanceof LivingEntity _livingEntity390 && _livingEntity390.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity390.getAttribute(Attributes.SCALE).getValue() : 0),
								(float) (entity instanceof LivingEntity _livingEntity391 && _livingEntity391.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity391.getAttribute(Attributes.SCALE).getValue() : 0));
						{
							ResourceLocation texture = MonstrousWorldModVariables.WrappedVictim;
							renderEntity(playerRenderEvent, MonstrousWorldModVariables.WebbedVictim1, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
						}
						poseStack.popPose();
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WebbedLevel >= 2) {
					((PlayerModel) entityModel).body.visible = false;
					((PlayerModel) entityModel).hat.visible = false;
					((PlayerModel) entityModel).head.visible = false;
					((PlayerModel) entityModel).jacket.visible = false;
					((PlayerModel) entityModel).leftArm.visible = false;
					((PlayerModel) entityModel).leftLeg.visible = false;
					((PlayerModel) entityModel).leftPants.visible = false;
					((PlayerModel) entityModel).leftSleeve.visible = false;
					((PlayerModel) entityModel).rightArm.visible = false;
					((PlayerModel) entityModel).rightLeg.visible = false;
					((PlayerModel) entityModel).rightPants.visible = false;
					((PlayerModel) entityModel).rightSleeve.visible = false;
					if ((entity instanceof LivingEntity _livingEntity407 && _livingEntity407.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity407.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
						{
							ResourceLocation texture = MonstrousWorldModVariables.WrappedVictim;
							renderEntity(playerRenderEvent, MonstrousWorldModVariables.WebbedVictim2, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
						}
					} else {
						poseStack.pushPose();
						poseStack.scale((float) (entity instanceof LivingEntity _livingEntity409 && _livingEntity409.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity409.getAttribute(Attributes.SCALE).getValue() : 0),
								(float) (entity instanceof LivingEntity _livingEntity410 && _livingEntity410.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity410.getAttribute(Attributes.SCALE).getValue() : 0),
								(float) (entity instanceof LivingEntity _livingEntity411 && _livingEntity411.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity411.getAttribute(Attributes.SCALE).getValue() : 0));
						{
							ResourceLocation texture = MonstrousWorldModVariables.WrappedVictim;
							renderEntity(playerRenderEvent, MonstrousWorldModVariables.WebbedVictim2, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
						}
						poseStack.popPose();
					}
				}
			}
		}
	}
}