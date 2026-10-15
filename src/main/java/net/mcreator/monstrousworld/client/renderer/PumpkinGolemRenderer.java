package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.PumpkinGolemEntity;
import net.mcreator.monstrousworld.client.model.ModelVengefulPumpkin;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PumpkinGolemRenderer extends MobRenderer<PumpkinGolemEntity, ModelVengefulPumpkin<PumpkinGolemEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/pumpkinnoshears.png");

	public PumpkinGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelVengefulPumpkin<PumpkinGolemEntity>(context.bakeLayer(ModelVengefulPumpkin.LAYER_LOCATION)), 1.5f);
		this.addLayer(new RenderLayer<PumpkinGolemEntity, ModelVengefulPumpkin<PumpkinGolemEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/pumpkingolemeyes.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, PumpkinGolemEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	protected void scale(PumpkinGolemEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(3f, 3f, 3f);
	}

	@Override
	public ResourceLocation getTextureLocation(PumpkinGolemEntity entity) {
		return entityTexture;
	}
}