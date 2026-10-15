// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelCatFamiliar<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "catfamiliar"), "main");
	private final ModelPart belly;
	private final ModelPart head;
	private final ModelPart tail2;
	private final ModelPart tail1;
	private final ModelPart backLegL;
	private final ModelPart backLegR;
	private final ModelPart frontLegL;
	private final ModelPart frontLegR;

	public ModelCatFamiliar(ModelPart root) {
		this.belly = root.getChild("belly");
		this.head = root.getChild("head");
		this.tail2 = root.getChild("tail2");
		this.tail1 = root.getChild("tail1");
		this.backLegL = root.getChild("backLegL");
		this.backLegR = root.getChild("backLegR");
		this.frontLegL = root.getChild("frontLegL");
		this.frontLegR = root.getChild("frontLegR");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition belly = partdefinition
				.addOrReplaceChild("belly",
						CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, -8.0F, -3.0F, 4.0F, 16.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 17.0F, 1.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(-1.5F, -0.0156F, -4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(-2.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 10)
						.addBox(1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.0F, -9.0F));

		PartDefinition tail2 = partdefinition.addOrReplaceChild("tail2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 23.0F, 8.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tail2_r1 = tail2
				.addOrReplaceChild("tail2_r1",
						CubeListBuilder.create().texOffs(4, 15).addBox(-0.5F, -1.0F, 7.5F, 1.0F, 8.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 5.0F, -1.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tail1 = partdefinition
				.addOrReplaceChild("tail1",
						CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 15.0F, 8.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition backLegL = partdefinition.addOrReplaceChild("backLegL", CubeListBuilder.create().texOffs(8, 13)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.1F, 18.0F, 7.0F));

		PartDefinition backLegR = partdefinition.addOrReplaceChild("backLegR", CubeListBuilder.create().texOffs(8, 13)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.1F, 18.0F, 7.0F));

		PartDefinition frontLegL = partdefinition.addOrReplaceChild("frontLegL", CubeListBuilder.create().texOffs(40, 0)
				.addBox(-1.0F, -0.2F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.2F, 14.0F, -4.0F));

		PartDefinition frontLegR = partdefinition.addOrReplaceChild("frontLegR", CubeListBuilder.create().texOffs(40, 0)
				.addBox(-1.0F, -0.2F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.2F, 14.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		belly.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backLegL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backLegR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontLegL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontLegR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.backLegL.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.frontLegR.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.backLegR.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.frontLegL.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}