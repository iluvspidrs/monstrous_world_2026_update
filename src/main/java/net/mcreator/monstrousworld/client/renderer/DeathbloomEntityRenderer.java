package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.DeathbloomEntityEntity;
import net.mcreator.monstrousworld.client.model.ModelDeathBloom;

public class DeathbloomEntityRenderer extends MobRenderer<DeathbloomEntityEntity, ModelDeathBloom<DeathbloomEntityEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/deathbloom.png");

	public DeathbloomEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDeathBloom<DeathbloomEntityEntity>(context.bakeLayer(ModelDeathBloom.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DeathbloomEntityEntity entity) {
		return entityTexture;
	}
}