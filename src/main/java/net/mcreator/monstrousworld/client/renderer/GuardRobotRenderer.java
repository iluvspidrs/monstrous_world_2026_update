package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.GuardRobotEntity;
import net.mcreator.monstrousworld.client.model.ModelRobotGuard;

import com.mojang.blaze3d.vertex.PoseStack;

public class GuardRobotRenderer extends MobRenderer<GuardRobotEntity, ModelRobotGuard<GuardRobotEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/guardrobot.png");

	public GuardRobotRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelRobotGuard<GuardRobotEntity>(context.bakeLayer(ModelRobotGuard.LAYER_LOCATION)), 0.9f);
	}

	@Override
	protected void scale(GuardRobotEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(GuardRobotEntity entity) {
		return entityTexture;
	}
}