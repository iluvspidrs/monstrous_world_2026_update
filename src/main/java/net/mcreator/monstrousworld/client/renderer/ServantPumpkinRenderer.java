package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.ServantPumpkinEntity;
import net.mcreator.monstrousworld.client.model.ModelVengefulPumpkin;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ServantPumpkinRenderer extends MobRenderer<ServantPumpkinEntity, ModelVengefulPumpkin<ServantPumpkinEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/shearsinhand.png");

	public ServantPumpkinRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelVengefulPumpkin<ServantPumpkinEntity>(context.bakeLayer(ModelVengefulPumpkin.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<ServantPumpkinEntity, ModelVengefulPumpkin<ServantPumpkinEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/corruptedeyes.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ServantPumpkinEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ServantPumpkinEntity entity) {
		return entityTexture;
	}
}