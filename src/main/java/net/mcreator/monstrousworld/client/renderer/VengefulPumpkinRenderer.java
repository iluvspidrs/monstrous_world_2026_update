package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.entity.VengefulPumpkinEntity;
import net.mcreator.monstrousworld.client.model.ModelVengefulPumpkin;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class VengefulPumpkinRenderer extends MobRenderer<VengefulPumpkinEntity, ModelVengefulPumpkin<VengefulPumpkinEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/shearsinhand.png");

	public VengefulPumpkinRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelVengefulPumpkin<VengefulPumpkinEntity>(context.bakeLayer(ModelVengefulPumpkin.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<VengefulPumpkinEntity, ModelVengefulPumpkin<VengefulPumpkinEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/vengefuleyes.png");
			final EntityModel LAYER_MODEL = new ModelVengefulPumpkin(Minecraft.getInstance().getEntityModels().bakeLayer(ModelVengefulPumpkin.LAYER_LOCATION));

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, VengefulPumpkinEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().copyPropertiesTo(LAYER_MODEL);
				LAYER_MODEL.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				LAYER_MODEL.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				LAYER_MODEL.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(VengefulPumpkinEntity entity) {
		return entityTexture;
	}
}