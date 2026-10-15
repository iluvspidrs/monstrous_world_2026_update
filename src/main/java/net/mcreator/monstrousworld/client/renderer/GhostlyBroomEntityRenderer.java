package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.GhostlyBroomEntityEntity;
import net.mcreator.monstrousworld.client.model.ModelWitcheryBroom2;

public class GhostlyBroomEntityRenderer extends MobRenderer<GhostlyBroomEntityEntity, ModelWitcheryBroom2<GhostlyBroomEntityEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/ghostly_broom_texture.png");

	public GhostlyBroomEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelWitcheryBroom2<GhostlyBroomEntityEntity>(context.bakeLayer(ModelWitcheryBroom2.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(GhostlyBroomEntityEntity entity) {
		return entityTexture;
	}
}