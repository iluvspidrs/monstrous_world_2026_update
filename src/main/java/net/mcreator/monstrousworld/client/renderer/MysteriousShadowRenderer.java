package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.MysteriousShadowEntity;
import net.mcreator.monstrousworld.client.model.ModelLargePossessingEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MysteriousShadowRenderer extends MobRenderer<MysteriousShadowEntity, ModelLargePossessingEntity<MysteriousShadowEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/violet_eyes.png");

	public MysteriousShadowRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLargePossessingEntity<MysteriousShadowEntity>(context.bakeLayer(ModelLargePossessingEntity.LAYER_LOCATION)), 0.1f);
		this.addLayer(new RenderLayer<MysteriousShadowEntity, ModelLargePossessingEntity<MysteriousShadowEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/violet_eyes.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MysteriousShadowEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(MysteriousShadowEntity entity) {
		return entityTexture;
	}
}