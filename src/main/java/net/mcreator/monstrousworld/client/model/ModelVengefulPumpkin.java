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

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelVengefulPumpkin<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("monstrous_world", "model_vengeful_pumpkin"), "main");
	public final ModelPart body;
	public final ModelPart arm;
	public final ModelPart rightlegfront;
	public final ModelPart rightlegback;
	public final ModelPart leftlegfront;
	public final ModelPart leftlegback;

	public ModelVengefulPumpkin(ModelPart root) {
		this.body = root.getChild("body");
		this.arm = root.getChild("arm");
		this.rightlegfront = root.getChild("rightlegfront");
		this.rightlegback = root.getChild("rightlegback");
		this.leftlegfront = root.getChild("leftlegfront");
		this.leftlegback = root.getChild("leftlegback");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -25.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
				.addBox(-4.0F, -9.0F, -6.0F, 8.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(27, 32).addBox(4.0F, -9.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition arm = partdefinition.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = arm.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(49, 35).addBox(5.0F, -25.0F, -2.3F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(6.0F, -17.0F, -3.4F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, -0.1309F, 0.2618F));
		PartDefinition rightlegfront = partdefinition.addOrReplaceChild("rightlegfront", CubeListBuilder.create().texOffs(27, 36).addBox(2.0F, 8.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 15.0F, -5.0F));
		PartDefinition cube_r2 = rightlegfront.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 2.5F, -1.0F, 2.0F, 5.5F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));
		PartDefinition cube_r3 = rightlegfront.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(6, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition rightlegback = partdefinition.addOrReplaceChild("rightlegback", CubeListBuilder.create().texOffs(27, 36).addBox(2.0F, 8.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 15.0F, 5.0F));
		PartDefinition cube_r4 = rightlegback.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 2.5F, -1.0F, 2.0F, 5.5F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));
		PartDefinition cube_r5 = rightlegback.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(6, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition leftlegfront = partdefinition.addOrReplaceChild("leftlegfront", CubeListBuilder.create().texOffs(27, 36).addBox(2.0F, 8.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 15.0F, -5.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition cube_r6 = leftlegfront.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 2.5F, -1.0F, 2.0F, 5.5F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));
		PartDefinition cube_r7 = leftlegfront.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(6, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition leftlegback = partdefinition.addOrReplaceChild("leftlegback", CubeListBuilder.create().texOffs(27, 36).addBox(3.0F, 8.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 15.0F, 5.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition cube_r8 = leftlegback.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 2.5F, -1.0F, 2.0F, 5.5F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));
		PartDefinition cube_r9 = leftlegback.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(6, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		rightlegfront.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		rightlegback.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leftlegfront.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leftlegback.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightlegback.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leftlegfront.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.rightlegfront.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftlegback.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}