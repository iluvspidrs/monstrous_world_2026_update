package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.EnemyPlaceholderEntity;
import net.mcreator.monstrousworld.client.model.ModelPlaceholderEntity;

public class EnemyPlaceholderRenderer extends MobRenderer<EnemyPlaceholderEntity, ModelPlaceholderEntity<EnemyPlaceholderEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkentity.png");

	public EnemyPlaceholderRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPlaceholderEntity<EnemyPlaceholderEntity>(context.bakeLayer(ModelPlaceholderEntity.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnemyPlaceholderEntity entity) {
		return entityTexture;
	}
}