package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.ChannelerSparkEntity;
import net.mcreator.monstrousworld.client.model.ModelChannelerSpark;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ChannelerSparkRenderer extends MobRenderer<ChannelerSparkEntity, ModelChannelerSpark<ChannelerSparkEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/channelerspark.png");

	public ChannelerSparkRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelChannelerSpark<ChannelerSparkEntity>(context.bakeLayer(ModelChannelerSpark.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<ChannelerSparkEntity, ModelChannelerSpark<ChannelerSparkEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/channelerspark.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ChannelerSparkEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ChannelerSparkEntity entity) {
		return entityTexture;
	}
}