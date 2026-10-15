package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.EvilClown2Entity;
import net.mcreator.monstrousworld.client.model.ModelClown_2;

public class EvilClown2Renderer extends MobRenderer<EvilClown2Entity, ModelClown_2<EvilClown2Entity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/clown2.png");

	public EvilClown2Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelClown_2<EvilClown2Entity>(context.bakeLayer(ModelClown_2.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EvilClown2Entity entity) {
		return entityTexture;
	}
}