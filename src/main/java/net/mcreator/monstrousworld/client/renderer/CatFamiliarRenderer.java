package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.CatFamiliarEntity;
import net.mcreator.monstrousworld.client.model.ModelCatFamiliar;

import com.mojang.blaze3d.vertex.PoseStack;

public class CatFamiliarRenderer extends MobRenderer<CatFamiliarEntity, ModelCatFamiliar<CatFamiliarEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/cat_familiar.png");

	public CatFamiliarRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCatFamiliar<CatFamiliarEntity>(context.bakeLayer(ModelCatFamiliar.LAYER_LOCATION)), 0.2f);
	}

	@Override
	protected void scale(CatFamiliarEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(CatFamiliarEntity entity) {
		return entityTexture;
	}
}