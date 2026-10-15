package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.monstrousworld.entity.GiantSnakeEntity;
import net.mcreator.monstrousworld.client.model.animations.GiantSnakeAnimationsAnimation;
import net.mcreator.monstrousworld.client.model.ModelGiantSnake;

import com.mojang.blaze3d.vertex.PoseStack;

public class GiantSnakeRenderer extends MobRenderer<GiantSnakeEntity, ModelGiantSnake<GiantSnakeEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/giantsnaketexture.png");

	public GiantSnakeRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelGiantSnake.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(GiantSnakeEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(GiantSnakeEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelGiantSnake<GiantSnakeEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<GiantSnakeEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(GiantSnakeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, GiantSnakeAnimationsAnimation.IDLE_ANIMATION, ageInTicks, 1f);
				this.animate(entity.animationState1, GiantSnakeAnimationsAnimation.SLITHER_ANIMATION, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(GiantSnakeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}