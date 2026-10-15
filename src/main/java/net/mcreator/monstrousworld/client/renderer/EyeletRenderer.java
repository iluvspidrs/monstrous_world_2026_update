package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.EyeletEntity;
import net.mcreator.monstrousworld.client.model.ModelEyelet;

public class EyeletRenderer extends MobRenderer<EyeletEntity, ModelEyelet<EyeletEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/eyelet.png");

	public EyeletRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEyelet<EyeletEntity>(context.bakeLayer(ModelEyelet.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EyeletEntity entity) {
		return entityTexture;
	}
}