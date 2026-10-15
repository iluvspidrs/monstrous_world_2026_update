// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelMurkanusWorm<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "murkanusworm"), "main");
	private final ModelPart segment2;
	private final ModelPart segment1;

	public ModelMurkanusWorm(ModelPart root) {
		this.segment2 = root.getChild("segment2");
		this.segment1 = root.getChild("segment1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition segment2 = partdefinition.addOrReplaceChild("segment2", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition segment1 = partdefinition.addOrReplaceChild("segment1", CubeListBuilder.create().texOffs(0, 3)
				.addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		segment2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		segment1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}