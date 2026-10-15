// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelOpenWings<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "openwings"), "main");
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelOpenWings(ModelPart root) {
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

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(56, 56).addBox(0.0F, 8.0F, 8.0F, 1.0F, 5.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.4266F, 1.352F, -0.2031F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(40, 16).addBox(0.0F, 7.0F, 4.0F, 1.0F, 4.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.6884F, 1.352F, -0.2031F));

		PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, 1.0F, 7.0F, 1.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 1.212F, 1.352F, -0.2031F));

		PartDefinition cube_r4 = Body.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(32, 32).addBox(0.0F, 1.0F, 2.0F, 1.0F, 8.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.9502F, 1.352F, -0.2031F));

		PartDefinition cube_r5 = Body.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(32, 32).addBox(-1.0F, 1.0F, 2.0F, 1.0F, 8.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.7852F, -1.2759F, 0.3735F));

		PartDefinition cube_r6 = Body.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(56, 56).addBox(-1.0F, 8.0F, 8.0F, 1.0F, 5.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.2616F, -1.2759F, 0.3735F));

		PartDefinition cube_r7 = Body.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 1.0F, 7.0F, 1.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 1.047F, -1.2759F, 0.3735F));

		PartDefinition cube_r8 = Body.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, 7.0F, 4.0F, 1.0F, 4.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.5234F, -1.2759F, 0.3735F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r9 = Head.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(44, 29).addBox(1.0F, -11.0F, 0.0F, 2.0F, 4.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5672F, -0.3054F, 0.0F));

		PartDefinition cube_r10 = Head.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(45, 30).addBox(1.5F, -11.75F, -8.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, -0.3054F, 0.0F));

		PartDefinition cube_r11 = Head.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(45, 30).addBox(-2.5F, -11.75F, -8.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.3054F, 0.0F));

		PartDefinition cube_r12 = Head.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(44, 29).addBox(-3.0F, -11.0F, 0.0F, 2.0F, 4.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5672F, 0.3054F, 0.0F));

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
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}