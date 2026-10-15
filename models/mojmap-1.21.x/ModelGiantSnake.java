// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelGiantSnake<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "giantsnake"), "main");
	private final ModelPart head;
	private final ModelPart segment1;
	private final ModelPart segment2;
	private final ModelPart segment3;
	private final ModelPart segment4;
	private final ModelPart segment5;
	private final ModelPart segment6;
	private final ModelPart segment7;
	private final ModelPart segment8;
	private final ModelPart segment9;
	private final ModelPart segment10;
	private final ModelPart segment11;
	private final ModelPart segment12;
	private final ModelPart segment13;

	public ModelGiantSnake(ModelPart root) {
		this.head = root.getChild("head");
		this.segment1 = root.getChild("segment1");
		this.segment2 = root.getChild("segment2");
		this.segment3 = root.getChild("segment3");
		this.segment4 = root.getChild("segment4");
		this.segment5 = root.getChild("segment5");
		this.segment6 = root.getChild("segment6");
		this.segment7 = root.getChild("segment7");
		this.segment8 = root.getChild("segment8");
		this.segment9 = root.getChild("segment9");
		this.segment10 = root.getChild("segment10");
		this.segment11 = root.getChild("segment11");
		this.segment12 = root.getChild("segment12");
		this.segment13 = root.getChild("segment13");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-1.0F, -3.0F, -16.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(2, 24)
						.addBox(-0.5F, -2.0F, -17.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition segment1 = partdefinition.addOrReplaceChild("segment1", CubeListBuilder.create().texOffs(-1, 7)
				.addBox(-2.0F, -2.0F, 1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -13.0F));

		PartDefinition segment2 = partdefinition.addOrReplaceChild("segment2", CubeListBuilder.create().texOffs(7, 7)
				.addBox(0.0F, -2.0F, -10.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition segment3 = partdefinition.addOrReplaceChild("segment3", CubeListBuilder.create().texOffs(0, 11)
				.addBox(-2.0F, -2.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 24.0F, -9.0F));

		PartDefinition segment4 = partdefinition.addOrReplaceChild("segment4", CubeListBuilder.create().texOffs(8, 11)
				.addBox(-2.0F, -2.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -7.0F));

		PartDefinition segment5 = partdefinition.addOrReplaceChild("segment5", CubeListBuilder.create().texOffs(0, 15)
				.addBox(0.0F, -2.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, -5.0F));

		PartDefinition segment6 = partdefinition.addOrReplaceChild("segment6", CubeListBuilder.create().texOffs(8, 15)
				.addBox(0.0F, -2.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -3.0F));

		PartDefinition segment7 = partdefinition.addOrReplaceChild("segment7", CubeListBuilder.create().texOffs(16, 0)
				.addBox(-1.0F, -2.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -3.0F));

		PartDefinition segment8 = partdefinition.addOrReplaceChild("segment8", CubeListBuilder.create().texOffs(16, 4)
				.addBox(-2.0F, -2.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -3.0F));

		PartDefinition segment9 = partdefinition.addOrReplaceChild("segment9", CubeListBuilder.create().texOffs(16, 8)
				.addBox(-1.0F, -2.0F, 7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -3.0F));

		PartDefinition segment10 = partdefinition.addOrReplaceChild("segment10", CubeListBuilder.create()
				.texOffs(16, 12).addBox(0.0F, -2.0F, 9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -3.0F));

		PartDefinition segment11 = partdefinition.addOrReplaceChild("segment11", CubeListBuilder.create()
				.texOffs(16, 16).addBox(-1.0F, -1.0F, 11.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -3.0F));

		PartDefinition segment12 = partdefinition.addOrReplaceChild("segment12", CubeListBuilder.create().texOffs(0, 19)
				.addBox(-2.0F, -1.0F, 13.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 24.0F, -3.0F));

		PartDefinition segment13 = partdefinition.addOrReplaceChild("segment13", CubeListBuilder.create().texOffs(8, 19)
				.addBox(0.0F, -1.0F, 12.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}