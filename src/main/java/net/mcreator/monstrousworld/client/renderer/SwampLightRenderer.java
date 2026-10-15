package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.SwampLightEntity;
import net.mcreator.monstrousworld.client.model.ModelSwampLight;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SwampLightRenderer extends MobRenderer<SwampLightEntity, ModelSwampLight<SwampLightEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/swamplight.png");

	public SwampLightRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSwampLight<SwampLightEntity>(context.bakeLayer(ModelSwampLight.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<SwampLightEntity, ModelSwampLight<SwampLightEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/swamplight.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SwampLightEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	protected void scale(SwampLightEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(SwampLightEntity entity) {
		return entityTexture;
	}
}