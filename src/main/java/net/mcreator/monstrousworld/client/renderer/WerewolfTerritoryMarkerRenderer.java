package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.WerewolfTerritoryMarkerEntity;
import net.mcreator.monstrousworld.client.model.ModelPlaceholderEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class WerewolfTerritoryMarkerRenderer extends MobRenderer<WerewolfTerritoryMarkerEntity, ModelPlaceholderEntity<WerewolfTerritoryMarkerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkentity.png");

	public WerewolfTerritoryMarkerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPlaceholderEntity<WerewolfTerritoryMarkerEntity>(context.bakeLayer(ModelPlaceholderEntity.LAYER_LOCATION)), 0.01f);
	}

	@Override
	protected void scale(WerewolfTerritoryMarkerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.5f, 0.5f, 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WerewolfTerritoryMarkerEntity entity) {
		return entityTexture;
	}
}