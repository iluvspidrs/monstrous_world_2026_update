package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.BloodCollectorEntityEntity;
import net.mcreator.monstrousworld.client.model.ModelPlaceholderEntity;

public class BloodCollectorEntityRenderer extends MobRenderer<BloodCollectorEntityEntity, ModelPlaceholderEntity<BloodCollectorEntityEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkentity.png");

	public BloodCollectorEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPlaceholderEntity<BloodCollectorEntityEntity>(context.bakeLayer(ModelPlaceholderEntity.LAYER_LOCATION)), 0.01f);
	}

	@Override
	public ResourceLocation getTextureLocation(BloodCollectorEntityEntity entity) {
		return entityTexture;
	}
}