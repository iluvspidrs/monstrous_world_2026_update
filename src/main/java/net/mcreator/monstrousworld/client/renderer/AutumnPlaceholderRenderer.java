package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.AutumnPlaceholderEntity;
import net.mcreator.monstrousworld.client.model.ModelPlaceholderEntity;

public class AutumnPlaceholderRenderer extends MobRenderer<AutumnPlaceholderEntity, ModelPlaceholderEntity<AutumnPlaceholderEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkentity.png");

	public AutumnPlaceholderRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPlaceholderEntity<AutumnPlaceholderEntity>(context.bakeLayer(ModelPlaceholderEntity.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(AutumnPlaceholderEntity entity) {
		return entityTexture;
	}
}