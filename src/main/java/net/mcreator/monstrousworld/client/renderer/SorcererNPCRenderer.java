package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.monstrousworld.procedures.*;
import net.mcreator.monstrousworld.entity.SorcererNPCEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SorcererNPCRenderer extends HumanoidMobRenderer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/npc1.png");

	public SorcererNPCRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<SorcererNPCEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin1ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin2ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin3ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc4.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin4ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc5.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin5ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc6.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin6ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc7.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin7ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc8.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin8ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc9.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin9ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc1_vampire.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin1VampireConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc2_vampire.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin2VampireConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc3_vampire.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin3VampireConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc4_vampire.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin4VampireConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc5_vampire.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin5VampireConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc6_vampire.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin6VampireConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc7_vampire.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin7VampireConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc8_vampire.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin8VampireConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<SorcererNPCEntity, HumanoidModel<SorcererNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/npc9_vampire.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SorcererNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (SorcererSkin9VampireConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SorcererNPCEntity entity) {
		return entityTexture;
	}
}