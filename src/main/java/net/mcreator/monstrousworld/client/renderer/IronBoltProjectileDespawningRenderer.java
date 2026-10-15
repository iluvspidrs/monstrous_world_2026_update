package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.IronBoltProjectileDespawningEntity;
import net.mcreator.monstrousworld.client.model.ModelBolt;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class IronBoltProjectileDespawningRenderer extends EntityRenderer<IronBoltProjectileDespawningEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("monstrous_world:textures/entities/iron_block.png");
	private final ModelBolt model;

	public IronBoltProjectileDespawningRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelBolt(context.bakeLayer(ModelBolt.LAYER_LOCATION));
	}

	@Override
	public void render(IronBoltProjectileDespawningEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
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
	public ResourceLocation getTextureLocation(IronBoltProjectileDespawningEntity entity) {
		return texture;
	}
}