package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.FlyMutantEntity;
import net.mcreator.monstrousworld.client.model.ModelFlyMutant;

public class FlyMutantRenderer extends MobRenderer<FlyMutantEntity, ModelFlyMutant<FlyMutantEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/mutantflymobtexture.png");

	public FlyMutantRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFlyMutant<FlyMutantEntity>(context.bakeLayer(ModelFlyMutant.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FlyMutantEntity entity) {
		return entityTexture;
	}
}