package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.HungryTreeEntity;
import net.mcreator.monstrousworld.client.model.ModelHungryTree;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class HungryTreeRenderer extends MobRenderer<HungryTreeEntity, ModelHungryTree<HungryTreeEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/hungrytreewithleaves2.png");

	public HungryTreeRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelHungryTree<HungryTreeEntity>(context.bakeLayer(ModelHungryTree.LAYER_LOCATION)), 2f);
		this.addLayer(new RenderLayer<HungryTreeEntity, ModelHungryTree<HungryTreeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/hungrytreeeyelayer.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, HungryTreeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	protected void scale(HungryTreeEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(HungryTreeEntity entity) {
		return entityTexture;
	}
}