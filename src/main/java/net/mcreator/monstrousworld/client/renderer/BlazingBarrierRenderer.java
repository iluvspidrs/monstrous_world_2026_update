package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.BlazingBarrierEntity;
import net.mcreator.monstrousworld.client.model.ModelPlaceholderEntity;

public class BlazingBarrierRenderer extends MobRenderer<BlazingBarrierEntity, ModelPlaceholderEntity<BlazingBarrierEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkentity.png");

	public BlazingBarrierRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPlaceholderEntity<BlazingBarrierEntity>(context.bakeLayer(ModelPlaceholderEntity.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlazingBarrierEntity entity) {
		return entityTexture;
	}
}