package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.MutantSerpentEntity;
import net.mcreator.monstrousworld.client.model.Modelmutationfour;

public class MutantSerpentRenderer extends MobRenderer<MutantSerpentEntity, Modelmutationfour<MutantSerpentEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/snake.png");

	public MutantSerpentRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmutationfour<MutantSerpentEntity>(context.bakeLayer(Modelmutationfour.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MutantSerpentEntity entity) {
		return entityTexture;
	}
}