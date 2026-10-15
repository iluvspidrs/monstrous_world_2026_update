// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelRobotGuard<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "robotguard"), "main");
	private final ModelPart body;
	private final ModelPart Head;
	private final ModelPart arm0;
	private final ModelPart arm1;
	private final ModelPart leg0;
	private final ModelPart leg1;

	public ModelRobotGuard(ModelPart root) {
		this.body = root.getChild("body");
		this.Head = root.getChild("Head");
		this.arm0 = root.getChild("arm0");
		this.arm1 = root.getChild("arm1");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 40)
						.addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 70)
						.addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, -7.0F, 1.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(9, 85)
						.addBox(-5.0F, -13.0F, -6.0F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(84, 76)
						.addBox(-8.0F, -11.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(84, 72)
						.addBox(-9.0F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(84, 72)
						.addBox(8.0F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(84, 76)
						.addBox(5.0F, -11.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -7.0F, -1.0F));

		PartDefinition arm0 = partdefinition.addOrReplaceChild("arm0", CubeListBuilder.create().texOffs(60, 21)
				.addBox(-13.0F, -2.5F, -3.0F, 4.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -7.0F, 1.0F));

		PartDefinition arm1 = partdefinition.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(60, 58).addBox(
				9.0F, -2.5F, -3.0F, 4.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 1.0F));

		PartDefinition leg0 = partdefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(37, 0)
				.addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 11.0F, 1.0F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1",
				CubeListBuilder.create().texOffs(60, 0).mirror()
						.addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(5.0F, 11.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.leg0.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.arm1.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.arm0.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}