package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.EvilClown1Entity;
import net.mcreator.monstrousworld.client.model.ModelClown1;

public class EvilClown1Renderer extends MobRenderer<EvilClown1Entity, ModelClown1<EvilClown1Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/clown_1.png");

	public EvilClown1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelClown1<EvilClown1Entity>(context.bakeLayer(ModelClown1.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EvilClown1Entity entity) {
		return entityTexture;
	}
}