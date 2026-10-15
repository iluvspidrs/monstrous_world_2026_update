package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.entity.EvilTreeHostileEntity;
import net.mcreator.monstrousworld.client.model.ModelEvilTreeEntityHostile;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EvilTreeHostileRenderer extends MobRenderer<EvilTreeHostileEntity, ModelEvilTreeEntityHostile<EvilTreeHostileEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/eviltreeentitytexture.png");

	public EvilTreeHostileRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEvilTreeEntityHostile<EvilTreeHostileEntity>(context.bakeLayer(ModelEvilTreeEntityHostile.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<EvilTreeHostileEntity, ModelEvilTreeEntityHostile<EvilTreeHostileEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/eviltreeentitytexture.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, EvilTreeHostileEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(EvilTreeHostileEntity entity) {
		return entityTexture;
	}
}