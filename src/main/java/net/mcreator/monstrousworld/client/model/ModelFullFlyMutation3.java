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

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelFullFlyMutation3<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("monstrous_world", "model_full_fly_mutation_3"), "main");
	public final ModelPart Wing1;
	public final ModelPart Wings;
	public final ModelPart Body;
	public final ModelPart Head;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;

	public ModelFullFlyMutation3(ModelPart root) {
		this.Wing1 = root.getChild("Wing1");
		this.Wings = root.getChild("Wings");
		this.Body = root.getChild("Body");
		this.Head = root.getChild("Head");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Wing1 = partdefinition.addOrReplaceChild("Wing1", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));
		PartDefinition cube_r1 = Wing1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(42, 0).addBox(0.0F, -3.0F, -1.0F, 1.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition Wings = partdefinition.addOrReplaceChild("Wings", CubeListBuilder.create().texOffs(44, 0).addBox(1.0F, -3.0F, -1.0F, 1.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(1, 1).addBox(-4.0F, -7.0F, -13.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(2, 41).addBox(-4.0F, -6.0F, -14.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 35)
						.addBox(-2.0F, -3.0F, -14.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 2).addBox(-5.0F, -5.0F, -6.0F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(3, 4)
						.addBox(-4.0F, -2.0F, 1.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(3, 6).addBox(-3.0F, 5.0F, 2.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(2, 41)
						.addBox(1.0F, -6.0F, -14.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 8).addBox(-2.0F, 10.0F, 3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(17, 34).addBox(-1.0F, 0.5476F, -14.6896F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -4.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(10, 5).addBox(0.0F, -1.0F, -4.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 5)
				.addBox(0.0F, -1.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 5).addBox(0.0F, -1.0F, 2.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(11, 5).addBox(-2.0F, -1.0F, -4.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(11, 5)
				.addBox(-2.0F, -1.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(11, 5).addBox(-2.0F, -1.0F, 2.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Wing1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Wings.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Wings.yRot = (Mth.sin(ageInTicks * 0.6F + 3) * 0.6F);
		this.Wing1.yRot = (Mth.sin(ageInTicks * 0.6F) * 0.6F);
	}
}