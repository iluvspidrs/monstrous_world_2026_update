package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.HunterVillageMarkerEntity;
import net.mcreator.monstrousworld.client.model.ModelPlaceholderEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class HunterVillageMarkerRenderer extends MobRenderer<HunterVillageMarkerEntity, ModelPlaceholderEntity<HunterVillageMarkerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkentity.png");

	public HunterVillageMarkerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPlaceholderEntity<HunterVillageMarkerEntity>(context.bakeLayer(ModelPlaceholderEntity.LAYER_LOCATION)), 0.01f);
	}

	@Override
	protected void scale(HunterVillageMarkerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.5f, 0.5f, 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HunterVillageMarkerEntity entity) {
		return entityTexture;
	}
}