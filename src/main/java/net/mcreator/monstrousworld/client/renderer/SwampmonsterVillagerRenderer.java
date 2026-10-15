package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.SwampmonsterVillagerEntity;
import net.mcreator.monstrousworld.client.model.ModelSwampmonsterVillager;

public class SwampmonsterVillagerRenderer extends MobRenderer<SwampmonsterVillagerEntity, ModelSwampmonsterVillager<SwampmonsterVillagerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/baseskinswampmonster.png");

	public SwampmonsterVillagerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSwampmonsterVillager<SwampmonsterVillagerEntity>(context.bakeLayer(ModelSwampmonsterVillager.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SwampmonsterVillagerEntity entity) {
		return entityTexture;
	}
}