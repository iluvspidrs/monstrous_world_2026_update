package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.DarkenedBlossomEntity;
import net.mcreator.monstrousworld.client.model.ModelCorruptedPlant;

public class DarkenedBlossomRenderer extends MobRenderer<DarkenedBlossomEntity, ModelCorruptedPlant<DarkenedBlossomEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/corruptedplant.png");

	public DarkenedBlossomRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCorruptedPlant<DarkenedBlossomEntity>(context.bakeLayer(ModelCorruptedPlant.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DarkenedBlossomEntity entity) {
		return entityTexture;
	}
}