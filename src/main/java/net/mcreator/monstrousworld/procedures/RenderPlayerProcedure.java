package net.mcreator.monstrousworld.procedures;

import org.joml.Vector3f;

import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
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
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1) {
						if ((entity instanceof LivingEntity _livingEntity60 && _livingEntity60.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity60.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyFace;
								renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_FLY_FACE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						} else {
							poseStack.pushPose();
							poseStack.scale((float) (entity instanceof LivingEntity _livingEntity62 && _livingEntity62.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity62.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity63 && _livingEntity63.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity63.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity64 && _livingEntity64.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity64.getAttribute(Attributes.SCALE).getValue() : 0));
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyFace;
								renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_FLY_FACE, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
							poseStack.popPose();
						}
						if (((PlayerModel) entityModel).slim) {
							if ((entity instanceof LivingEntity _livingEntity69 && _livingEntity69.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity69.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity71 && _livingEntity71.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity71.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity72 && _livingEntity72.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity72.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity73 && _livingEntity73.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity73.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity77 && _livingEntity77.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity77.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyOverlayWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity79 && _livingEntity79.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity79.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity80 && _livingEntity80.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity80.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity81 && _livingEntity81.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity81.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyOverlayWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						}
						if (entity.onGround()) {
							if ((entity instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity86.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyWings;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.FLY_WINGS_ON_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity88 && _livingEntity88.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity88.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity89 && _livingEntity89.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity89.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity90 && _livingEntity90.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity90.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyWings;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.FLY_WINGS_ON_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
								poseStack.popPose();
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity94 && _livingEntity94.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity94.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyWingsOffGround;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.FLY_WINGS_OFF_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity96 && _livingEntity96.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity96.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity97 && _livingEntity97.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity97.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity98 && _livingEntity98.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity98.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyWingsOffGround;
									renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.FLY_WINGS_OFF_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityTranslucent(texture)));
								}
								poseStack.popPose();
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2) {
						if ((entity instanceof LivingEntity _livingEntity102 && _livingEntity102.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity102.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerEyeOverlay;
								renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						} else {
							poseStack.pushPose();
							poseStack.scale((float) (entity instanceof LivingEntity _livingEntity104 && _livingEntity104.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity104.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity105 && _livingEntity105.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity105.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity106 && _livingEntity106.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity106.getAttribute(Attributes.SCALE).getValue() : 0));
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
						if ((entity instanceof LivingEntity _livingEntity112 && _livingEntity112.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity112.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentBody;
								renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.SERPENT_BODY, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
						} else {
							poseStack.pushPose();
							poseStack.scale((float) (entity instanceof LivingEntity _livingEntity114 && _livingEntity114.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity114.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity115 && _livingEntity115.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity115.getAttribute(Attributes.SCALE).getValue() : 0),
									(float) (entity instanceof LivingEntity _livingEntity116 && _livingEntity116.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity116.getAttribute(Attributes.SCALE).getValue() : 0));
							{
								ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentBody;
								renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.SERPENT_BODY, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
							}
							poseStack.popPose();
						}
						if (((PlayerModel) entityModel).slim) {
							if ((entity instanceof LivingEntity _livingEntity121 && _livingEntity121.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity121.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity123 && _livingEntity123.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity123.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity124 && _livingEntity124.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity124.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity125 && _livingEntity125.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity125.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity129 && _livingEntity129.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity129.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentOverlayWide;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity131 && _livingEntity131.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity131.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity132 && _livingEntity132.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity132.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity133 && _livingEntity133.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity133.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if ((entity instanceof LivingEntity _livingEntity138 && _livingEntity138.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity138.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerZombieOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity140 && _livingEntity140.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity140.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity141 && _livingEntity141.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity141.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity142 && _livingEntity142.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity142.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerZombieOverlaySlim;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						} else {
							if ((entity instanceof LivingEntity _livingEntity146 && _livingEntity146.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity146.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerZombieOverlay;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity148 && _livingEntity148.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity148.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity149 && _livingEntity149.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity149.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity150 && _livingEntity150.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity150.getAttribute(Attributes.SCALE).getValue() : 0));
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerZombieOverlay;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
								poseStack.popPose();
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
							if ((entity instanceof LivingEntity _livingEntity154 && _livingEntity154.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity154.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.UndeadGlowEyes;
									renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.eyes(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity156 && _livingEntity156.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity156.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity157 && _livingEntity157.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity157.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity158 && _livingEntity158.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity158.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if ((entity instanceof LivingEntity _livingEntity163 && _livingEntity163.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity163.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
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
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity166 && _livingEntity166.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity166.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity167 && _livingEntity167.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity167.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity168 && _livingEntity168.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity168.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if ((entity instanceof LivingEntity _livingEntity173 && _livingEntity173.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity173.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
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
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity176 && _livingEntity176.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity176.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity177 && _livingEntity177.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity177.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity178 && _livingEntity178.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity178.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if ((entity instanceof LivingEntity _livingEntity184 && _livingEntity184.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity184.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
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
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity187 && _livingEntity187.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity187.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity188 && _livingEntity188.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity188.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity189 && _livingEntity189.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity189.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if ((entity instanceof LivingEntity _livingEntity194 && _livingEntity194.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity194.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
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
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity197 && _livingEntity197.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity197.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity198 && _livingEntity198.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity198.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity199 && _livingEntity199.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity199.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if (!(entity instanceof LivingEntity _livEnt205 && _livEnt205.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
								if ((entity instanceof LivingEntity _livingEntity206 && _livingEntity206.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity206.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
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
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity209 && _livingEntity209.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity209.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity210 && _livingEntity210.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity210.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity211 && _livingEntity211.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity211.getAttribute(Attributes.SCALE).getValue() : 0));
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
								if ((entity instanceof LivingEntity _livingEntity216 && _livingEntity216.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity216.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
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
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity220 && _livingEntity220.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity220.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity221 && _livingEntity221.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity221.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity222 && _livingEntity222.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity222.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if (!(entity instanceof LivingEntity _livEnt228 && _livEnt228.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
								if ((entity instanceof LivingEntity _livingEntity229 && _livingEntity229.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity229.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
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
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity232 && _livingEntity232.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity232.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity233 && _livingEntity233.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity233.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity234 && _livingEntity234.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity234.getAttribute(Attributes.SCALE).getValue() : 0));
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
								if ((entity instanceof LivingEntity _livingEntity239 && _livingEntity239.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity239.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
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
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity243 && _livingEntity243.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity243.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity244 && _livingEntity244.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity244.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity245 && _livingEntity245.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity245.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if ((entity instanceof LivingEntity _livingEntity263 && _livingEntity263.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity263.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.WerewolfTexture;
									renderEntity(playerRenderEvent, MonstrousWorldModVariables.WerewolfForm, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity265 && _livingEntity265.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity265.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity266 && _livingEntity266.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity266.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity267 && _livingEntity267.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity267.getAttribute(Attributes.SCALE).getValue() : 0));
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
								if ((entity instanceof LivingEntity _livingEntity287 && _livingEntity287.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity287.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonParts;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DEMON_ON_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity289 && _livingEntity289.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity289.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity290 && _livingEntity290.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity290.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity291 && _livingEntity291.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity291.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonParts;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DEMON_ON_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							} else {
								if ((entity instanceof LivingEntity _livingEntity295 && _livingEntity295.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity295.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonParts;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DEMON_OFF_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity297 && _livingEntity297.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity297.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity298 && _livingEntity298.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity298.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity299 && _livingEntity299.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity299.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonParts;
										renderHumanoid(playerRenderEvent, MonstrousWorldModHumanoidModels.PLAYER_DEMON_OFF_GROUND, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							}
							if (((PlayerModel) entityModel).slim) {
								if ((entity instanceof LivingEntity _livingEntity304 && _livingEntity304.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity304.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonSkinSlim;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity306 && _livingEntity306.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity306.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity307 && _livingEntity307.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity307.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity308 && _livingEntity308.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity308.getAttribute(Attributes.SCALE).getValue() : 0));
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonSkinSlim;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
									poseStack.popPose();
								}
							} else {
								if ((entity instanceof LivingEntity _livingEntity312 && _livingEntity312.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity312.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
									{
										ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonSkinWide;
										renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
									}
								} else {
									poseStack.pushPose();
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity314 && _livingEntity314.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity314.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity315 && _livingEntity315.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity315.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity316 && _livingEntity316.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity316.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if ((entity instanceof LivingEntity _livingEntity320 && _livingEntity320.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity320.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
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
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity327 && _livingEntity327.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity327.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity328 && _livingEntity328.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity328.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity329 && _livingEntity329.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity329.getAttribute(Attributes.SCALE).getValue() : 0));
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
									poseStack.scale((float) (entity instanceof LivingEntity _livingEntity337 && _livingEntity337.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity337.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity338 && _livingEntity338.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity338.getAttribute(Attributes.SCALE).getValue() : 0),
											(float) (entity instanceof LivingEntity _livingEntity339 && _livingEntity339.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity339.getAttribute(Attributes.SCALE).getValue() : 0));
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
							if ((entity instanceof LivingEntity _livingEntity355 && _livingEntity355.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity355.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
								{
									ResourceLocation texture = MonstrousWorldModVariables.PlayerBalloonForm;
									renderEntity(playerRenderEvent, MonstrousWorldModVariables.BalloonForm, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
								}
							} else {
								poseStack.pushPose();
								poseStack.scale((float) (entity instanceof LivingEntity _livingEntity357 && _livingEntity357.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity357.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity358 && _livingEntity358.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity358.getAttribute(Attributes.SCALE).getValue() : 0),
										(float) (entity instanceof LivingEntity _livingEntity359 && _livingEntity359.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity359.getAttribute(Attributes.SCALE).getValue() : 0));
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
					if ((entity instanceof LivingEntity _livingEntity375 && _livingEntity375.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity375.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
						{
							ResourceLocation texture = MonstrousWorldModVariables.WrappedVictim;
							renderEntity(playerRenderEvent, MonstrousWorldModVariables.WebbedVictim1, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
						}
					} else {
						poseStack.pushPose();
						poseStack.scale((float) (entity instanceof LivingEntity _livingEntity377 && _livingEntity377.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity377.getAttribute(Attributes.SCALE).getValue() : 0),
								(float) (entity instanceof LivingEntity _livingEntity378 && _livingEntity378.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity378.getAttribute(Attributes.SCALE).getValue() : 0),
								(float) (entity instanceof LivingEntity _livingEntity379 && _livingEntity379.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity379.getAttribute(Attributes.SCALE).getValue() : 0));
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
					if ((entity instanceof LivingEntity _livingEntity395 && _livingEntity395.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity395.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
						{
							ResourceLocation texture = MonstrousWorldModVariables.WrappedVictim;
							renderEntity(playerRenderEvent, MonstrousWorldModVariables.WebbedVictim2, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.armorCutoutNoCull(texture)));
						}
					} else {
						poseStack.pushPose();
						poseStack.scale((float) (entity instanceof LivingEntity _livingEntity397 && _livingEntity397.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity397.getAttribute(Attributes.SCALE).getValue() : 0),
								(float) (entity instanceof LivingEntity _livingEntity398 && _livingEntity398.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity398.getAttribute(Attributes.SCALE).getValue() : 0),
								(float) (entity instanceof LivingEntity _livingEntity399 && _livingEntity399.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity399.getAttribute(Attributes.SCALE).getValue() : 0));
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