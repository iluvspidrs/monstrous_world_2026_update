package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.FollowerWerewolfEntity;
import net.mcreator.monstrousworld.client.model.ModelWerewolf;

import com.mojang.blaze3d.vertex.PoseStack;

public class FollowerWerewolfRenderer extends MobRenderer<FollowerWerewolfEntity, ModelWerewolf<FollowerWerewolfEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/werewolf.png");

	public FollowerWerewolfRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelWerewolf<FollowerWerewolfEntity>(context.bakeLayer(ModelWerewolf.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(FollowerWerewolfEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(FollowerWerewolfEntity entity) {
		return entityTexture;
	}
}