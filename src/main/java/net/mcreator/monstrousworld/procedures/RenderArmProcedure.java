package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.client.event.RenderArmEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModHumanoidModels;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(Dist.CLIENT)
public class RenderArmProcedure {
	@SubscribeEvent
	public static void onArmRendered(RenderArmEvent event) {
		Minecraft mc = Minecraft.getInstance();
		PlayerRenderer renderer = (PlayerRenderer) mc.getEntityRenderDispatcher().getRenderer(mc.player);
		execute(event, event, mc.player, (EntityModel) renderer.getModel(), event.getPoseStack());
	}

	public static void execute(RenderArmEvent armRenderEvent, Entity entity, EntityModel entityModel, PoseStack poseStack) {
		execute(null, armRenderEvent, entity, entityModel, poseStack);
	}

	private static void execute(@Nullable Event event, RenderArmEvent armRenderEvent, Entity entity, EntityModel entityModel, PoseStack poseStack) {
		if (armRenderEvent == null || entity == null || entityModel == null || poseStack == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			{
				ResourceLocation texture = MonstrousWorldModVariables.PlayerFlyOverlayWide;
				ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
				boolean partVisible = part.visible;
				part.resetPose();
				part.visible = true;
				part.zRot = 0.1f;
				part.xRot = -0.005f;
				part.y = 2;
				part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
				part.visible = partVisible;
			}
		} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			{
				ResourceLocation texture = MonstrousWorldModVariables.PlayerSerpentOverlayWide;
				ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
				boolean partVisible = part.visible;
				part.resetPose();
				part.visible = true;
				part.zRot = 0.1f;
				part.xRot = -0.005f;
				part.y = 2;
				part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
				part.visible = partVisible;
			}
		} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			{
				ResourceLocation texture = MonstrousWorldModVariables.PlayerZombieOverlay;
				ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
				boolean partVisible = part.visible;
				part.resetPose();
				part.visible = true;
				part.zRot = 0.1f;
				part.xRot = -0.005f;
				part.y = 2;
				part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
				part.visible = partVisible;
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.BLACKOUT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.BLACKOUT).getDuration() : 0) >= 1
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER).getDuration() : 0) >= 1) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			} else {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				{
					ResourceLocation texture = MonstrousWorldModVariables.player_dark_armor_arm;
					ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
					boolean partVisible = part.visible;
					part.resetPose();
					part.visible = true;
					part.zRot = 0.1f;
					part.xRot = -0.005f;
					part.y = 2;
					part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
					part.visible = partVisible;
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			{
				ResourceLocation texture = MonstrousWorldModVariables.GoblinPlayerSkinWide;
				ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
				boolean partVisible = part.visible;
				part.resetPose();
				part.visible = true;
				part.zRot = 0.1f;
				part.xRot = -0.005f;
				part.y = 2;
				part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
				part.visible = partVisible;
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			{
				ResourceLocation texture = MonstrousWorldModVariables.PlayerTrollLayerWide;
				ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
				boolean partVisible = part.visible;
				part.resetPose();
				part.visible = true;
				part.zRot = 0.1f;
				part.xRot = -0.005f;
				part.y = 2;
				part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
				part.visible = partVisible;
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			{
				ResourceLocation texture = MonstrousWorldModVariables.SwampmonsterPlayerSkinWide;
				ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
				boolean partVisible = part.visible;
				part.resetPose();
				part.visible = true;
				part.zRot = 0.1f;
				part.xRot = -0.005f;
				part.y = 2;
				part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
				part.visible = partVisible;
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
				{
					ResourceLocation texture = MonstrousWorldModVariables.WerewolfTexture;
					PlayerModel humanoidModel = MonstrousWorldModHumanoidModels.WEREWOLF_FORM;
					PlayerModel playerOriginal = (PlayerModel) entityModel;
					boolean lefthanded = armRenderEvent.getArm() == HumanoidArm.LEFT;
					ModelPart part = lefthanded ? humanoidModel.leftArm : humanoidModel.rightArm;
					boolean partVisible = part.visible;
					part.resetPose();
					if (lefthanded)
						playerOriginal.leftArm.resetPose();
					else
						playerOriginal.rightArm.resetPose();
					part.copyFrom(lefthanded ? playerOriginal.leftArm : playerOriginal.rightArm);
					part.visible = true;
					part.zRot = 0.1f;
					part.xRot = -0.005f;
					part.y = 2;
					part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
					part.visible = partVisible;
				}
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == false) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				{
					ResourceLocation texture = MonstrousWorldModVariables.PlayerDemonSkinWide;
					ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
					boolean partVisible = part.visible;
					part.resetPose();
					part.visible = true;
					part.zRot = 0.1f;
					part.xRot = -0.005f;
					part.y = 2;
					part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
					part.visible = partVisible;
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
			if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Balloon == true)) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				{
					ResourceLocation texture = MonstrousWorldModVariables.PlayerClownSkin;
					ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
					boolean partVisible = part.visible;
					part.resetPose();
					part.visible = true;
					part.zRot = 0.1f;
					part.xRot = -0.005f;
					part.y = 2;
					part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
					part.visible = partVisible;
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Balloon == true) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
		}
	}
}