package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.SwampmonsterChieftanEntity;
import net.mcreator.monstrousworld.client.model.ModelSwampmonsterChieftan;

public class SwampmonsterChieftanRenderer extends MobRenderer<SwampmonsterChieftanEntity, ModelSwampmonsterChieftan<SwampmonsterChieftanEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/baseskinswampmonster.png");

	public SwampmonsterChieftanRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSwampmonsterChieftan<SwampmonsterChieftanEntity>(context.bakeLayer(ModelSwampmonsterChieftan.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SwampmonsterChieftanEntity entity) {
		return entityTexture;
	}
}