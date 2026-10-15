// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelSwampmonsterHelmet2<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "swampmonsterhelmet2"), "main");
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelSwampmonsterHelmet2(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = root.getChild("Head");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 24)
						.addBox(0.0F, 0.0F, 2.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(2, 24)
						.addBox(0.0F, 1.0F, 3.0F, 0.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(0.0F, 2.0F, 4.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 24)
						.addBox(0.0F, -10.0F, -3.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(0.0F, -11.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(2, 11)
						.addBox(-5.0F, -6.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(2, 11)
						.addBox(4.0F, -6.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 7)
						.addBox(-6.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 7)
						.addBox(5.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(-9, -6)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.5F, -8.5F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(13, 16)
						.addBox(-0.5F, -11.5F, -3.5F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 11)
						.addBox(4.0F, -6.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(4.0F, -6.5F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 11)
						.addBox(-5.0F, -6.5F, -4.5F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.0F, -6.5F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(11, 11)
						.addBox(-5.0F, -6.5F, 4.5F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}