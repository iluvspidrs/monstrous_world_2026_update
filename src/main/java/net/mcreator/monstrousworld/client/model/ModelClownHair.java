package net.mcreator.monstrousworld.client.model;

import net.minecraft.world.entity.Entity;
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
public class ModelClownHair<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("monstrous_world", "model_clown_hair"), "main");
	public final ModelPart Body;
	public final ModelPart Head;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;

	public ModelClownHair(ModelPart root) {
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
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(-4.0F, -10.0F, -5.0F, 8.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(32, 0)
						.addBox(-4.0F, -11.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(52, 46).addBox(-4.0F, -6.0F, 4.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 25)
						.addBox(4.0F, -10.0F, -5.0F, 2.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(24, 49).addBox(6.0F, -9.0F, -5.0F, 1.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(46, 49)
						.addBox(-7.0F, -9.0F, -5.0F, 1.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(52, 41).addBox(-5.0F, -9.0F, 5.0F, 10.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 63)
						.addBox(-5.0F, -9.0F, -6.0F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 40).addBox(-6.0F, -10.0F, -5.0F, 2.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}