package net.mcreator.monstrousworld.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelCorruptedPlant<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("monstrous_world", "model_corrupted_plant"), "main");
	public final ModelPart body;
	public final ModelPart vines;
	public final ModelPart leg1R;
	public final ModelPart leg2R;
	public final ModelPart leg1L;
	public final ModelPart leg2L;

	public ModelCorruptedPlant(ModelPart root) {
		this.body = root.getChild("body");
		this.vines = root.getChild("vines");
		this.leg1R = root.getChild("leg1R");
		this.leg2R = root.getChild("leg2R");
		this.leg1L = root.getChild("leg1L");
		this.leg2L = root.getChild("leg2L");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(24, 9).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 9)
						.addBox(-4.0F, -8.0F, -4.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 18).addBox(0.0F, -8.0F, -4.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(18, 28)
						.addBox(-4.0F, -12.0F, -5.0F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 5).addBox(-3.0F, -13.0F, -5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 7)
						.addBox(-3.0F, -13.0F, 4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 0).addBox(-4.0F, -12.0F, 4.0F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 16)
						.addBox(-5.0F, -12.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(18, 33).addBox(-5.0F, -13.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(32, 33)
						.addBox(4.0F, -13.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 27).addBox(4.0F, -12.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));
		PartDefinition vines = partdefinition.addOrReplaceChild("vines", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 16.0F, 1.0F, 0.0F, 2.7489F, 0.0F));
		PartDefinition cube_r1 = vines.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 40).mirror().addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.0F, -7.0F, 4.0F, 0.0741F, -0.6688F, 2.8155F));
		PartDefinition cube_r2 = vines.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 40).mirror().addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.0F, -7.0F, 6.0F, -0.5444F, -0.6317F, -2.389F));
		PartDefinition cube_r3 = vines.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(20, 40).addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, -0.2182F, -0.7854F, 0.3491F));
		PartDefinition cube_r4 = vines.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(20, 40).mirror().addBox(-1.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 0.0F, 4.0F, -0.2182F, 0.7854F, -0.3491F));
		PartDefinition leg1R = partdefinition.addOrReplaceChild("leg1R", CubeListBuilder.create().texOffs(0, 39).addBox(0.0F, -1.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 18.0F, -3.0F));
		PartDefinition leg2R = partdefinition.addOrReplaceChild("leg2R", CubeListBuilder.create().texOffs(8, 39).addBox(0.0F, -1.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 18.0F, 3.0F));
		PartDefinition leg1L = partdefinition.addOrReplaceChild("leg1L", CubeListBuilder.create().texOffs(4, 39).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 18.0F, -3.0F));
		PartDefinition leg2L = partdefinition.addOrReplaceChild("leg2L", CubeListBuilder.create().texOffs(12, 39).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 18.0F, 3.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		vines.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1R.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2R.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1L.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2L.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1L.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg2L.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg1R.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg2R.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}