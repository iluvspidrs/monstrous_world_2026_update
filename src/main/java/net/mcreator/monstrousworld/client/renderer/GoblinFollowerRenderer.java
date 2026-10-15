package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.monstrousworld.procedures.GoblinFollowerDisplayConditionProcedure;
import net.mcreator.monstrousworld.entity.GoblinFollowerEntity;
import net.mcreator.monstrousworld.client.model.ModelNPCGoblin;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GoblinFollowerRenderer extends MobRenderer<GoblinFollowerEntity, ModelNPCGoblin<GoblinFollowerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/goblin2.png");

	public GoblinFollowerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelNPCGoblin<GoblinFollowerEntity>(context.bakeLayer(ModelNPCGoblin.LAYER_LOCATION)), 0.25f);
		this.addLayer(new RenderLayer<GoblinFollowerEntity, ModelNPCGoblin<GoblinFollowerEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("monstrous_world:textures/entities/goblin3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GoblinFollowerEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (GoblinFollowerDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
	}

	@Override
	protected void scale(GoblinFollowerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.5f, 0.5f, 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinFollowerEntity entity) {
		return entityTexture;
	}
}