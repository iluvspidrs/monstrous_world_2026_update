// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelAlphaWerewolf<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "alphawerewolf"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelAlphaWerewolf(ModelPart root) {
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
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -6.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(10, 7)
						.addBox(-3.0F, -8.0F, -2.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(14, 11)
						.addBox(-3.0F, -6.0F, -5.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
						.addBox(-3.0F, -3.0F, -6.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 0)
						.addBox(-1.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 1)
						.addBox(-2.0F, -1.0F, -8.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 5)
						.addBox(-1.0F, -3.0F, -8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(2, 1)
						.addBox(1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(2, 1)
						.addBox(1.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(2, 1)
						.addBox(-2.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(2, 1)
						.addBox(-2.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Head
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(33, 4).addBox(-2.0747F, -10.1512F, -1.0F, 3.0F, 4.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition cube_r2 = Head
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(33, 4).addBox(-1.0F, -10.0F, -1.0F, 3.0F, 4.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(14, 14).addBox(
				-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(18, 22).addBox(-4.0F, -5.0F, 1.5F, 8.0F, 6.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 5.0F, -6.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r4 = Body
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(33, 20).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 9.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r5 = Body
				.addOrReplaceChild("cube_r5",
						CubeListBuilder.create().texOffs(32, 20).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 4.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 10.0F, 3.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r6 = Body
				.addOrReplaceChild("cube_r6",
						CubeListBuilder.create().texOffs(32, 20).addBox(-3.0F, 4.0F, 1.0F, 6.0F, 4.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r7 = Body
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(32, 20).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 4.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(37, 14)
				.addBox(-4.0F, -2.0F, -3.0F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(30, 46)
				.addBox(-1.0F, -2.0F, -3.0F, 5.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(-2, 15)
				.addBox(-3.0F, 0.0F, -3.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(15, 47)
				.addBox(-2.0F, 0.0F, -3.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));

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
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}