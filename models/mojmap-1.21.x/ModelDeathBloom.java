// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelDeathBloom<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "deathbloom"), "main");
	private final ModelPart base;
	private final ModelPart blossom;

	public ModelDeathBloom(ModelPart root) {
		this.base = root.getChild("base");
		this.blossom = root.getChild("blossom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition blossom = partdefinition.addOrReplaceChild("blossom",
				CubeListBuilder.create().texOffs(32, 20)
						.addBox(3.0F, -4.0F, -2.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 26)
						.addBox(1.0F, -4.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 32)
						.addBox(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 20)
						.addBox(3.0F, -2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 24)
						.addBox(2.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 22.0F, 0.0F));

		PartDefinition cube_r1 = blossom
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -1.0F, -4.0F, 8.0F, 1.0F, 8.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(4.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r2 = blossom.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(32, 11).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 1.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -1.0F, 8.0F, 2.7489F, 0.0F, 3.1416F));

		PartDefinition cube_r3 = blossom.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 29).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 1.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -1.0F, -8.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = blossom
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(0, 11).addBox(-8.0F, -1.0F, -4.0F, 8.0F, 1.0F, 8.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		blossom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}