// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelEyelet<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "eyelet"), "main");
	private final ModelPart body;

	public ModelEyelet(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(7, 0)
						.addBox(1.0F, 0.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 0)
						.addBox(1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 0)
						.addBox(0.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 0)
						.addBox(0.0F, 0.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 1)
						.addBox(-1.0F, -8.0F, 0.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 9)
						.addBox(-1.0F, -8.0F, -2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 9)
						.addBox(-1.0F, -8.0F, -3.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(13, 14)
						.addBox(0.0F, -9.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(13, 14)
						.addBox(0.0F, -4.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(13, 14)
						.addBox(3.0F, -7.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(13, 14)
						.addBox(-2.0F, -7.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 17.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(2, 18).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -6.0F, 0.0F, 0.48F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(2, 18).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -6.0F, 0.0F, 0.48F, 0.0F, 1.5708F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(2, 18).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, -3.0F, -2.6616F, 0.0F, 3.1416F));

		PartDefinition cube_r4 = body
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(2, 18).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.0F, -8.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 7.0F, -1.0F, -2.9671F, 0.7854F, 3.1416F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 7.0F, 1.0F, 0.1745F, 0.7854F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 7.0F, -1.0F, -2.9671F, -0.7854F, 3.1416F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 7.0F, 1.0F, 0.1745F, -0.7854F, 0.0F));

		PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 7.0F, 0.0F, 0.0F, -1.5708F, 0.6109F));

		PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 7.0F, 0.0F, 0.0F, 1.5708F, -0.6109F));

		PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 7.0F, -1.0F, -2.5307F, 0.0F, 3.1416F));

		PartDefinition cube_r12 = body
				.addOrReplaceChild("cube_r12",
						CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 7.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.0F, 7.0F, 1.0F, 0.6109F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}