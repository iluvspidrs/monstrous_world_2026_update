package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.PumpkinBroomEntityEntity;
import net.mcreator.monstrousworld.client.model.ModelWitcheryBroom2;

public class PumpkinBroomEntityRenderer extends MobRenderer<PumpkinBroomEntityEntity, ModelWitcheryBroom2<PumpkinBroomEntityEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/pumpkin_broom_texture.png");

	public PumpkinBroomEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelWitcheryBroom2<PumpkinBroomEntityEntity>(context.bakeLayer(ModelWitcheryBroom2.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(PumpkinBroomEntityEntity entity) {
		return entityTexture;
	}
}