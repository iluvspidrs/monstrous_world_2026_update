package net.mcreator.monstrousworld.client.renderer;

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

import net.mcreator.monstrousworld.entity.SpiritofMidasEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpiritofMidasRenderer extends HumanoidMobRenderer<SpiritofMidasEntity, HumanoidModel<SpiritofMidasEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/spirit_of_midas.png");

	public SpiritofMidasRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<SpiritofMidasEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<SpiritofMidasEntity, HumanoidModel<SpiritofMidasEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/spirit_of_midas.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, SpiritofMidasEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SpiritofMidasEntity entity) {
		return entityTexture;
	}
}