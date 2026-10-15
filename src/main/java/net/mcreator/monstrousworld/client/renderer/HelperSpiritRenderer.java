package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.HelperSpiritEntity;
import net.mcreator.monstrousworld.client.model.ModelFighterSpirit;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class HelperSpiritRenderer extends MobRenderer<HelperSpiritEntity, ModelFighterSpirit<HelperSpiritEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/bodyouter.png");

	public HelperSpiritRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFighterSpirit<HelperSpiritEntity>(context.bakeLayer(ModelFighterSpirit.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<HelperSpiritEntity, ModelFighterSpirit<HelperSpiritEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/bodyouter.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, HelperSpiritEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	protected void scale(HelperSpiritEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(HelperSpiritEntity entity) {
		return entityTexture;
	}
}