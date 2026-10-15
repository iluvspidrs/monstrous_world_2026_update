package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.monstrousworld.entity.MurkanusWormEntity;
import net.mcreator.monstrousworld.client.model.animations.MurkanusWormAnimation;
import net.mcreator.monstrousworld.client.model.ModelMurkanusWorm;

import com.mojang.blaze3d.vertex.PoseStack;

public class MurkanusWormRenderer extends MobRenderer<MurkanusWormEntity, ModelMurkanusWorm<MurkanusWormEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/darkened_log_side.png");

	public MurkanusWormRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelMurkanusWorm.LAYER_LOCATION)), 0.1f);
	}

	@Override
	protected void scale(MurkanusWormEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.5f, 0.5f, 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MurkanusWormEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelMurkanusWorm<MurkanusWormEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<MurkanusWormEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(MurkanusWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, MurkanusWormAnimation.WORM_MOVE, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(MurkanusWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}