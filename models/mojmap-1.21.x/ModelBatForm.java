// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelBatForm<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "batform"), "main");
	private final ModelPart Head;
	private final ModelPart body;
	private final ModelPart rightWing;
	private final ModelPart leftWing;

	public ModelBatForm(ModelPart root) {
		this.Head = root.getChild("Head");
		this.body = root.getChild("body");
		this.rightWing = root.getChild("rightWing");
		this.leftWing = root.getChild("leftWing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 7)
						.addBox(-2.0F, -3.0F, -3.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 15)
						.addBox(-4.0F, -6.0F, -2.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(8, 15)
						.addBox(1.0F, -6.0F, -2.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(
				-1.5F, 5.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition body_r1 = body
				.addOrReplaceChild("body_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -7.0F, -1.0F, 3.0F, 5.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition rightWing = partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create(),
				PartPose.offset(-1.5F, 17.0F, 0.0F));

		PartDefinition rightWingTip_r1 = rightWing.addOrReplaceChild("rightWingTip_r1",
				CubeListBuilder.create().texOffs(16, 0)
						.addBox(-9.5F, -9.0F, 0.0F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(12, 0)
						.addBox(-3.5F, -9.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 7.0F, 0.0F, 0.3155F, 0.2494F, 0.0804F));

		PartDefinition leftWing = partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create(),
				PartPose.offset(1.5F, 17.0F, 0.0F));

		PartDefinition leftWingTip_r1 = leftWing.addOrReplaceChild("leftWingTip_r1",
				CubeListBuilder.create().texOffs(16, 8)
						.addBox(3.5F, -9.0F, 0.0F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(12, 0)
						.addBox(1.5F, -9.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, 7.0F, 0.0F, 0.2706F, -0.2527F, -0.0692F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.leftWing.yRot = (Mth.sin(ageInTicks * 0.6F + 3) * 0.6F);
		this.rightWing.yRot = (Mth.sin(ageInTicks * 0.6F) * 0.6F);
	}
}