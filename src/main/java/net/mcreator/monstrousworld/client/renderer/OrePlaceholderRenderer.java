package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.OrePlaceholderEntity;
import net.mcreator.monstrousworld.client.model.ModelPlaceholderEntity;

public class OrePlaceholderRenderer extends MobRenderer<OrePlaceholderEntity, ModelPlaceholderEntity<OrePlaceholderEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkentity.png");

	public OrePlaceholderRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPlaceholderEntity<OrePlaceholderEntity>(context.bakeLayer(ModelPlaceholderEntity.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(OrePlaceholderEntity entity) {
		return entityTexture;
	}
}