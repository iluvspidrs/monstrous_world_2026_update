package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import net.mcreator.monstrousworld.entity.ChangelingEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ChangelingRenderer extends MobRenderer<ChangelingEntity, VillagerModel<ChangelingEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/villager_vampire_base.png");

	public ChangelingRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel<ChangelingEntity>(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
		this.addLayer(new CrossedArmsItemLayer<>(this, context.getItemInHandRenderer()));
		this.addLayer(new RenderLayer<ChangelingEntity, VillagerModel<ChangelingEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/plains.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ChangelingEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
		this.addLayer(new RenderLayer<ChangelingEntity, VillagerModel<ChangelingEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/nitwit.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ChangelingEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	protected void scale(ChangelingEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.5f, 0.5f, 0.5f);
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(ChangelingEntity entity) {
		return entityTexture;
	}
}