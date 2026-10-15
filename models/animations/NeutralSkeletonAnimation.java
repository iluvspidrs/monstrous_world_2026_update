// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 5.1.4 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class NeutralSkeletonAnimation {
	public static final AnimationDefinition attack_animation = AnimationDefinition.Builder.withLength(0.0F)
			.addAnimation("RightArm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.0F, KeyframeAnimations.degreeVec(-84.8246F, -14.9416F, -1.3378F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("LeftArm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.0F, KeyframeAnimations.degreeVec(-84.0777F, 32.3612F, 3.1781F),
									AnimationChannel.Interpolations.LINEAR)))
			.build();
}