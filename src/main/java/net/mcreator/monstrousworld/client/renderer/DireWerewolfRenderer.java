package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.DireWerewolfEntity;
import net.mcreator.monstrousworld.client.model.ModelAlphaWerewolf;

public class DireWerewolfRenderer extends MobRenderer<DireWerewolfEntity, ModelAlphaWerewolf<DireWerewolfEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/alphawerewolf.png");

	public DireWerewolfRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAlphaWerewolf<DireWerewolfEntity>(context.bakeLayer(ModelAlphaWerewolf.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DireWerewolfEntity entity) {
		return entityTexture;
	}
}