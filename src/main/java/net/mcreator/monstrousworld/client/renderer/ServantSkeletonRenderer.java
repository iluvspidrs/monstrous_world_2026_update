package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.ServantSkeletonEntity;
import net.mcreator.monstrousworld.client.model.ModelCorruptedSkeleton2;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ServantSkeletonRenderer extends MobRenderer<ServantSkeletonEntity, ModelCorruptedSkeleton2<ServantSkeletonEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/skeleton.png");

	public ServantSkeletonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCorruptedSkeleton2<ServantSkeletonEntity>(context.bakeLayer(ModelCorruptedSkeleton2.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<ServantSkeletonEntity, ModelCorruptedSkeleton2<ServantSkeletonEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/corrskeletoneyes.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ServantSkeletonEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ServantSkeletonEntity entity) {
		return entityTexture;
	}
}