package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.DeadlyBalloonEntity;
import net.mcreator.monstrousworld.client.model.ModelDeadlyBalloon;

public class DeadlyBalloonRenderer extends MobRenderer<DeadlyBalloonEntity, ModelDeadlyBalloon<DeadlyBalloonEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/deadlyballoonred.png");

	public DeadlyBalloonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDeadlyBalloon<DeadlyBalloonEntity>(context.bakeLayer(ModelDeadlyBalloon.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DeadlyBalloonEntity entity) {
		return entityTexture;
	}
}