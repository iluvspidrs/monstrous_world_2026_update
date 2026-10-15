package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.SilverBoltSinkingProjectileEntity;
import net.mcreator.monstrousworld.client.model.ModelBoltFired;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SilverBoltSinkingProjectileRenderer extends EntityRenderer<SilverBoltSinkingProjectileEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("monstrous_world:textures/entities/block_of_silver.png");
	private final ModelBoltFired model;

	public SilverBoltSinkingProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelBoltFired(context.bakeLayer(ModelBoltFired.LAYER_LOCATION));
	}

	@Override
	public void render(SilverBoltSinkingProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, entityIn.getYRot(), entityIn.getXRot());
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(SilverBoltSinkingProjectileEntity entity) {
		return texture;
	}
}