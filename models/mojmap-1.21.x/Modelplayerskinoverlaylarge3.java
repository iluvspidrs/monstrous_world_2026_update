// Made with Blockbench 5.0.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelplayerskinoverlaylarge3<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "playerskinoverlaylarge3"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public Modelplayerskinoverlaylarge3(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(8, 8)
						.addBox(-4.0F, -8.0F, -4.05F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(48, 0)
						.addBox(-4.0F, -8.0F, 4.005F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(8, 0)
						.addBox(-4.0F, 0.005F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition side_r1 = Head.addOrReplaceChild("side_r1",
				CubeListBuilder.create().texOffs(9, 24).addBox(-3.995F, -32.0F, -4.0F, 8.0F, 8.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition side_r2 = Head.addOrReplaceChild("side_r2",
				CubeListBuilder.create().texOffs(9, 24).addBox(-4.005F, -32.0F, -4.0F, 8.0F, 8.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(
				-4.0F, 0.0F, -2.005F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(37, 31)
						.addBox(-3.0F, -2.0F, -2.005F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(55, 31)
						.addBox(-3.0F, -2.0F, 2.005F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(46, 27)
						.addBox(1.005F, -2.0F, -2.0F, 0.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(28, 27)
						.addBox(-3.005F, -2.0F, -2.0F, 0.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(24, 26)
						.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(28, 48)
						.addBox(-3.0F, 10.005F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(37, 31)
						.addBox(-1.0F, -2.0F, -2.005F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(28, 27)
						.addBox(3.005F, -2.0F, -2.0F, 0.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(46, 27)
						.addBox(-1.005F, -2.0F, -2.0F, 0.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(55, 31)
						.addBox(-1.0F, -2.0F, 2.005F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(24, 26)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(28, 48)
						.addBox(-1.0F, 10.005F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(48, 0)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(48, 0)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}