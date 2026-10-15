package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.MonsterVillageMarkerEntity;
import net.mcreator.monstrousworld.client.model.ModelPlaceholderEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class MonsterVillageMarkerRenderer extends MobRenderer<MonsterVillageMarkerEntity, ModelPlaceholderEntity<MonsterVillageMarkerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkentity.png");

	public MonsterVillageMarkerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPlaceholderEntity<MonsterVillageMarkerEntity>(context.bakeLayer(ModelPlaceholderEntity.LAYER_LOCATION)), 0.01f);
	}

	@Override
	protected void scale(MonsterVillageMarkerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.5f, 0.5f, 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MonsterVillageMarkerEntity entity) {
		return entityTexture;
	}
}