package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.FeralWerewolfEntity;
import net.mcreator.monstrousworld.client.model.ModelWerewolf;

public class FeralWerewolfRenderer extends MobRenderer<FeralWerewolfEntity, ModelWerewolf<FeralWerewolfEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/werewolf_-_copy.png");

	public FeralWerewolfRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelWerewolf<FeralWerewolfEntity>(context.bakeLayer(ModelWerewolf.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FeralWerewolfEntity entity) {
		return entityTexture;
	}
}