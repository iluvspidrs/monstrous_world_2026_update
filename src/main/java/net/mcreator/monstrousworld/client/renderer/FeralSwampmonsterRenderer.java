package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.FeralSwampmonsterEntity;
import net.mcreator.monstrousworld.client.model.ModelSwampmonsterVillager;

public class FeralSwampmonsterRenderer extends MobRenderer<FeralSwampmonsterEntity, ModelSwampmonsterVillager<FeralSwampmonsterEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/feral_swampmonster.png");

	public FeralSwampmonsterRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSwampmonsterVillager<FeralSwampmonsterEntity>(context.bakeLayer(ModelSwampmonsterVillager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FeralSwampmonsterEntity entity) {
		return entityTexture;
	}
}