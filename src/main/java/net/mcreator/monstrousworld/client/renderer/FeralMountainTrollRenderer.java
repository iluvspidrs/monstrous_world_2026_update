package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.FeralMountainTrollEntity;
import net.mcreator.monstrousworld.client.model.ModelFeralTroll;

public class FeralMountainTrollRenderer extends MobRenderer<FeralMountainTrollEntity, ModelFeralTroll<FeralMountainTrollEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/feral_troll.png");

	public FeralMountainTrollRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFeralTroll<FeralMountainTrollEntity>(context.bakeLayer(ModelFeralTroll.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FeralMountainTrollEntity entity) {
		return entityTexture;
	}
}