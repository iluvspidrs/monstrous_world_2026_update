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

import net.mcreator.monstrousworld.procedures.CuredVampireSkin3ConditionProcedure;
import net.mcreator.monstrousworld.procedures.CuredVampireSkin2ConditionProcedure;
import net.mcreator.monstrousworld.procedures.CuredVampireSkin1ConditionProcedure;
import net.mcreator.monstrousworld.entity.CuredVampireEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CuredVampireRenderer extends HumanoidMobRenderer<CuredVampireEntity, HumanoidModel<CuredVampireEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/cured_vampire_1.png");

	public CuredVampireRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<CuredVampireEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<CuredVampireEntity, HumanoidModel<CuredVampireEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/cured_vampire_2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CuredVampireEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CuredVampireSkin1ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<CuredVampireEntity, HumanoidModel<CuredVampireEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/cured_vampire_3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CuredVampireEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CuredVampireSkin2ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<CuredVampireEntity, HumanoidModel<CuredVampireEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/cured_vampire_4.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CuredVampireEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CuredVampireSkin3ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(CuredVampireEntity entity) {
		return entityTexture;
	}
}