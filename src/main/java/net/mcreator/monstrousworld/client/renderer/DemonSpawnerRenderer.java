package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.DemonSpawnerEntity;
import net.mcreator.monstrousworld.client.model.ModelPlaceholderEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class DemonSpawnerRenderer extends MobRenderer<DemonSpawnerEntity, ModelPlaceholderEntity<DemonSpawnerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkentity.png");

	public DemonSpawnerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPlaceholderEntity<DemonSpawnerEntity>(context.bakeLayer(ModelPlaceholderEntity.LAYER_LOCATION)), 0.01f);
	}

	@Override
	protected void scale(DemonSpawnerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.5f, 0.5f, 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DemonSpawnerEntity entity) {
		return entityTexture;
	}
}