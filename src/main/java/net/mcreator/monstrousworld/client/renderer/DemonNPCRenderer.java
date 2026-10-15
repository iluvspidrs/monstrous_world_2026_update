package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.procedures.DemonNPCSkin2ConditionProcedure;
import net.mcreator.monstrousworld.procedures.DemonNPCSkin1ConditionProcedure;
import net.mcreator.monstrousworld.entity.DemonNPCEntity;
import net.mcreator.monstrousworld.client.model.Modeldemon;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class DemonNPCRenderer extends MobRenderer<DemonNPCEntity, Modeldemon<DemonNPCEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/demonskin.png");

	public DemonNPCRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldemon<DemonNPCEntity>(context.bakeLayer(Modeldemon.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<DemonNPCEntity, Modeldemon<DemonNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/demonskin.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, DemonNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (DemonNPCSkin1ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<DemonNPCEntity, Modeldemon<DemonNPCEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/demonskin2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, DemonNPCEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (DemonNPCSkin2ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(DemonNPCEntity entity) {
		return entityTexture;
	}
}