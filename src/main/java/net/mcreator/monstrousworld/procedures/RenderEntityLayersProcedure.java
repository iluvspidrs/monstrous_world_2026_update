package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(Dist.CLIENT)
public class RenderEntityLayersProcedure {
	@SubscribeEvent
	public static void onEntityRendered(RenderLivingEvent.Pre event) {
		execute(event, event.getEntity(), event, event.getPoseStack());
	}

	public static void renderEntity(RenderLivingEvent entityRenderEvent, LivingEntity renderEntity, EntityModel model, VertexConsumer vertexConsumer) {
		PoseStack poseStack = entityRenderEvent.getPoseStack();
		entityRenderEvent.getRenderer().getModel().copyPropertiesTo(model);
		LivingEntity eventEntity_ = entityRenderEvent.getEntity();
		model.young = eventEntity_.isBaby();
		float partialTick = entityRenderEvent.getPartialTick();
		float limbSwing = eventEntity_.walkAnimation.position(partialTick);
		float limbSwingAmount = eventEntity_.walkAnimation.speed(partialTick);
		float ageInTicks = eventEntity_.tickCount + partialTick;
		float interpolatedBodyYaw = Mth.rotLerp(partialTick, eventEntity_.yBodyRotO, eventEntity_.yBodyRot);
		float interpolatedHeadYaw = Mth.rotLerp(partialTick, eventEntity_.yHeadRotO, eventEntity_.yHeadRot);
		float netHeadYaw = interpolatedHeadYaw - interpolatedBodyYaw;
		float headPitch = Mth.lerp(partialTick, eventEntity_.xRotO, eventEntity_.getXRot());
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - interpolatedBodyYaw));
		if (eventEntity_.deathTime > 0) {
			float f = ((float) eventEntity_.deathTime + partialTick - 1f) / 20f * 1.6f;
			f = Mth.sqrt(f);
			if (f > 1f) {
				f = 1f;
			}
			poseStack.mulPose(Axis.ZP.rotationDegrees(f * 90f));
		}
		poseStack.scale(-1, -1, 1);
		poseStack.translate(0.0D, -1.501, 0.0D);
		model.prepareMobModel(renderEntity, limbSwing, limbSwingAmount, partialTick);
		model.setupAnim(renderEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		model.renderToBuffer(poseStack, vertexConsumer, entityRenderEvent.getPackedLight(), LivingEntityRenderer.getOverlayCoords(eventEntity_, 0));
		poseStack.popPose();
	}

	public static void execute(Entity entity, RenderLivingEvent entityRenderEvent, PoseStack poseStack) {
		execute(null, entity, entityRenderEvent, poseStack);
	}

	private static void execute(@Nullable Event event, Entity entity, RenderLivingEvent entityRenderEvent, PoseStack poseStack) {
		if (entity == null || entityRenderEvent == null || poseStack == null)
			return;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(ResourceLocation.parse("monstrous_world:vampirespeed"))) {
			if (entity instanceof Witch) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if ((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity2.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
					{
						LivingEntity renderEntity3 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity3) instanceof LivingEntityRenderer renderer3) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireWitch;
							renderEntity(entityRenderEvent, renderEntity3, renderer3.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
				} else {
					poseStack.pushPose();
					poseStack.scale((float) (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity4.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity5.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity6.getAttribute(Attributes.SCALE).getValue() : 0));
					{
						LivingEntity renderEntity8 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity8) instanceof LivingEntityRenderer renderer8) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireWitch;
							renderEntity(entityRenderEvent, renderEntity8, renderer8.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
					poseStack.popPose();
				}
			}
			if (entity instanceof Pillager) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if ((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity11.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
					{
						LivingEntity renderEntity12 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity12) instanceof LivingEntityRenderer renderer12) {
							ResourceLocation texture = MonstrousWorldModVariables.VampirePillager;
							renderEntity(entityRenderEvent, renderEntity12, renderer12.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
				} else {
					poseStack.pushPose();
					poseStack.scale((float) (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity13.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity14.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity15.getAttribute(Attributes.SCALE).getValue() : 0));
					{
						LivingEntity renderEntity17 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity17) instanceof LivingEntityRenderer renderer17) {
							ResourceLocation texture = MonstrousWorldModVariables.VampirePillager;
							renderEntity(entityRenderEvent, renderEntity17, renderer17.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
					poseStack.popPose();
				}
			}
			if (entity instanceof Evoker) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
			if (entity instanceof Vindicator) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if ((entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity21.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
					{
						LivingEntity renderEntity22 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity22) instanceof LivingEntityRenderer renderer22) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireVindicator;
							renderEntity(entityRenderEvent, renderEntity22, renderer22.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
				} else {
					poseStack.pushPose();
					poseStack.scale((float) (entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity23.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity24.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity25 && _livingEntity25.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity25.getAttribute(Attributes.SCALE).getValue() : 0));
					{
						LivingEntity renderEntity27 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity27) instanceof LivingEntityRenderer renderer27) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireVindicator;
							renderEntity(entityRenderEvent, renderEntity27, renderer27.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
					poseStack.popPose();
				}
			}
			if (entity instanceof Illusioner) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if ((entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity30.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
					{
						LivingEntity renderEntity31 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity31) instanceof LivingEntityRenderer renderer31) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireIllusioner;
							renderEntity(entityRenderEvent, renderEntity31, renderer31.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
				} else {
					poseStack.pushPose();
					poseStack.scale((float) (entity instanceof LivingEntity _livingEntity32 && _livingEntity32.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity32.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity33 && _livingEntity33.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity33.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity34 && _livingEntity34.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity34.getAttribute(Attributes.SCALE).getValue() : 0));
					{
						LivingEntity renderEntity36 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity36) instanceof LivingEntityRenderer renderer36) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireIllusioner;
							renderEntity(entityRenderEvent, renderEntity36, renderer36.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
					poseStack.popPose();
				}
			}
			if (entity instanceof WanderingTrader) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if ((entity instanceof LivingEntity _livingEntity39 && _livingEntity39.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity39.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
					{
						LivingEntity renderEntity40 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity40) instanceof LivingEntityRenderer renderer40) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireWanderingTrader;
							renderEntity(entityRenderEvent, renderEntity40, renderer40.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
				} else {
					poseStack.pushPose();
					poseStack.scale((float) (entity instanceof LivingEntity _livingEntity41 && _livingEntity41.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity41.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity42 && _livingEntity42.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity42.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity43 && _livingEntity43.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity43.getAttribute(Attributes.SCALE).getValue() : 0));
					{
						LivingEntity renderEntity45 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity45) instanceof LivingEntityRenderer renderer45) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireWanderingTrader;
							renderEntity(entityRenderEvent, renderEntity45, renderer45.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
						}
					}
					poseStack.popPose();
				}
			}
			if (entity instanceof Villager) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if ((entity instanceof LivingEntity _livingEntity48 && _livingEntity48.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity48.getAttribute(Attributes.SCALE).getValue() : 0) == 1) {
					{
						LivingEntity renderEntity49 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity49) instanceof LivingEntityRenderer renderer49) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireEyesVillager;
							renderEntity(entityRenderEvent, renderEntity49, renderer49.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
						}
					}
					{
						LivingEntity renderEntity50 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity50) instanceof LivingEntityRenderer renderer50) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireRobe;
							renderEntity(entityRenderEvent, renderEntity50, renderer50.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
						}
					}
				} else {
					poseStack.pushPose();
					poseStack.scale((float) (entity instanceof LivingEntity _livingEntity51 && _livingEntity51.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity51.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity52 && _livingEntity52.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity52.getAttribute(Attributes.SCALE).getValue() : 0),
							(float) (entity instanceof LivingEntity _livingEntity53 && _livingEntity53.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity53.getAttribute(Attributes.SCALE).getValue() : 0));
					{
						LivingEntity renderEntity55 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity55) instanceof LivingEntityRenderer renderer55) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireEyesVillager;
							renderEntity(entityRenderEvent, renderEntity55, renderer55.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
						}
					}
					{
						LivingEntity renderEntity56 = (LivingEntity) entity;
						if (Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(renderEntity56) instanceof LivingEntityRenderer renderer56) {
							ResourceLocation texture = MonstrousWorldModVariables.VampireRobe;
							renderEntity(entityRenderEvent, renderEntity56, renderer56.getModel(), entityRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutout(texture)));
						}
					}
					poseStack.popPose();
				}
			}
		}
	}
}