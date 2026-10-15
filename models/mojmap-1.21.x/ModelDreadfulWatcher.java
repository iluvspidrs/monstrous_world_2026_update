// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelDreadfulWatcher<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "dreadfulwatcher"), "main");
	private final ModelPart tentacles;
	private final ModelPart eye;

	public ModelDreadfulWatcher(ModelPart root) {
		this.tentacles = root.getChild("tentacles");
		this.eye = root.getChild("eye");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tentacles = partdefinition.addOrReplaceChild("tentacles",
				CubeListBuilder.create().texOffs(41, 14)
						.addBox(5.0F, 5.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 14)
						.addBox(9.0F, 5.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 14)
						.addBox(7.0F, 3.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 14)
						.addBox(6.0F, 3.0F, 2.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 14)
						.addBox(10.0F, 3.0F, 2.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 14)
						.addBox(9.0F, 3.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 14)
						.addBox(7.0F, 3.0F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition eye = partdefinition.addOrReplaceChild("eye",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 30)
						.addBox(-3.0F, -3.0F, 4.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 0)
						.addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 16)
						.addBox(-3.0F, -5.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 23)
						.addBox(-3.0F, 4.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(24, 16)
						.addBox(4.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(24, 28)
						.addBox(-5.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		tentacles.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}