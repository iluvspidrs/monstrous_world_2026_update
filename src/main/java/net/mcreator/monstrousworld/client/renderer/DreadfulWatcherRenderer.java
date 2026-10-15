package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.DreadfulWatcherEntity;
import net.mcreator.monstrousworld.client.model.ModelDreadfulWatcher;

public class DreadfulWatcherRenderer extends MobRenderer<DreadfulWatcherEntity, ModelDreadfulWatcher<DreadfulWatcherEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/dreadfulwatcher.png");

	public DreadfulWatcherRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDreadfulWatcher<DreadfulWatcherEntity>(context.bakeLayer(ModelDreadfulWatcher.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DreadfulWatcherEntity entity) {
		return entityTexture;
	}
}