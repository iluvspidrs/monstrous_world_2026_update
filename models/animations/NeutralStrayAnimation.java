// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 5.1.4 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class NeutralStrayAnimation {
	public static final AnimationDefinition attack_animation = AnimationDefinition.Builder.withLength(0.0F)
			.addAnimation("RightArm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.0F, KeyframeAnimations.degreeVec(-82.3199F, -12.3914F, -1.6575F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F,
					KeyframeAnimations.degreeVec(-77.852F, 34.3927F, 6.9326F), AnimationChannel.Interpolations.LINEAR)))
			.build();
}