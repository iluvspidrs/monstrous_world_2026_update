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

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelcorruptedhelmet<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("monstrous_world", "modelcorruptedhelmet"), "main");
	public final ModelPart Head;

	public Modelcorruptedhelmet(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(52, 0).addBox(-4.346F, -2.2865F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(47, 6).addBox(-1.346F, -7.2865F, -6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 5)
						.addBox(-2.346F, -11.2865F, -6.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 0).addBox(-3.346F, -1.2865F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 8)
						.addBox(-4.346F, -6.2865F, -5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 8).addBox(0.654F, -6.2865F, -5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 5)
						.addBox(0.654F, -1.2865F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(37, 3).addBox(2.654F, -2.2865F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 1)
						.addBox(-4.346F, -5.2865F, -5.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(35, 0).addBox(-1.346F, -6.2865F, -5.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 1)
						.addBox(0.654F, -5.2865F, -5.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.346F, -9.2865F, -5.0F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.346F, -11.2865F, -5.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.346F, -13.2865F, -5.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.346F, -13.2865F, 3.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.346F, -11.2865F, 1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.346F, -10.2865F, -5.0F, 6.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.346F, -9.2865F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(3.654F, -8.2865F, -5.0F, 1.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1047F, 0.0873F, 0.0F));
		PartDefinition side_r1 = Head.addOrReplaceChild("side_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.2F, -8.2865F, -5.0F, 1.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0297F, 0.0F));
		PartDefinition side_r2 = Head.addOrReplaceChild("side_r2", CubeListBuilder.create().texOffs(0, 0).addBox(3.654F, -8.2865F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition largediagonal_r1 = Head.addOrReplaceChild("largediagonal_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.346F, -13.2865F, 3.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, -0.6545F));
		PartDefinition largediagonal_r2 = Head.addOrReplaceChild("largediagonal_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.346F, -13.2865F, 2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.6545F));
		PartDefinition largediagonal_r3 = Head.addOrReplaceChild("largediagonal_r3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.346F, -14.2865F, -4.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, -0.6545F));
		PartDefinition largediagonal_r4 = Head.addOrReplaceChild("largediagonal_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-3.346F, -13.2865F, -4.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.6545F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-10.6337F, -8.105F, -10.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.48F));
		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(9.6337F, -8.105F, -10.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, -0.48F));
		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(9.6337F, -8.105F, 9.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, -0.48F));
		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-10.6337F, -8.105F, 9.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.48F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}