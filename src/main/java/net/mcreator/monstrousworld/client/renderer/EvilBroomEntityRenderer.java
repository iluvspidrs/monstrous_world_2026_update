package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.EvilBroomEntityEntity;
import net.mcreator.monstrousworld.client.model.ModelWitcheryBroom2;

public class EvilBroomEntityRenderer extends MobRenderer<EvilBroomEntityEntity, ModelWitcheryBroom2<EvilBroomEntityEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/evil_broom_texture.png");

	public EvilBroomEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelWitcheryBroom2<EvilBroomEntityEntity>(context.bakeLayer(ModelWitcheryBroom2.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(EvilBroomEntityEntity entity) {
		return entityTexture;
	}
}