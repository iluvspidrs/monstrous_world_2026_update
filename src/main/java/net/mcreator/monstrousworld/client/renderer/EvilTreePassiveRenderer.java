package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.EvilTreePassiveEntity;
import net.mcreator.monstrousworld.client.model.ModelEvilTreeEntityHostile;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EvilTreePassiveRenderer extends MobRenderer<EvilTreePassiveEntity, ModelEvilTreeEntityHostile<EvilTreePassiveEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/eviltreeentitytexture.png");

	public EvilTreePassiveRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEvilTreeEntityHostile<EvilTreePassiveEntity>(context.bakeLayer(ModelEvilTreeEntityHostile.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<EvilTreePassiveEntity, ModelEvilTreeEntityHostile<EvilTreePassiveEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/eviltreeentitytexture.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, EvilTreePassiveEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(EvilTreePassiveEntity entity) {
		return entityTexture;
	}
}