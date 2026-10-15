package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.GiantFlyEntity;
import net.mcreator.monstrousworld.client.model.ModelFullFlyMutation3;

public class GiantFlyRenderer extends MobRenderer<GiantFlyEntity, ModelFullFlyMutation3<GiantFlyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/giantflytexture.png");

	public GiantFlyRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFullFlyMutation3<GiantFlyEntity>(context.bakeLayer(ModelFullFlyMutation3.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GiantFlyEntity entity) {
		return entityTexture;
	}
}