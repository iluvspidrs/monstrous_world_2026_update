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

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelHungryTree<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("monstrous_world", "model_hungry_tree"), "main");
	public final ModelPart leaves;
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart leg1L;
	public final ModelPart leg1R;
	public final ModelPart leg2R;
	public final ModelPart leg2L;

	public ModelHungryTree(ModelPart root) {
		this.leaves = root.getChild("leaves");
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leg1L = root.getChild("leg1L");
		this.leg1R = root.getChild("leg1R");
		this.leg2R = root.getChild("leg2R");
		this.leg2L = root.getChild("leg2L");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition leaves = partdefinition.addOrReplaceChild("leaves",
				CubeListBuilder.create().texOffs(16, 139).addBox(-14.0F, -38.0F, -15.0F, 29.0F, 6.0F, 29.0F, new CubeDeformation(0.0F)).texOffs(61, 146).addBox(-14.0F, -40.0F, -15.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146)
						.addBox(2.0F, -44.0F, -14.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146).addBox(11.0F, -39.0F, -12.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146)
						.addBox(-1.0F, -38.0F, -14.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146).addBox(9.0F, -42.0F, -15.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146)
						.addBox(-16.0F, -42.0F, -1.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146).addBox(-16.0F, -39.0F, 10.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146)
						.addBox(-6.0F, -43.0F, -9.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146).addBox(13.0F, -35.0F, -2.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146)
						.addBox(11.0F, -43.0F, 4.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146).addBox(-11.0F, -43.0F, 4.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146)
						.addBox(12.0F, -40.0F, 11.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146).addBox(3.0F, -42.0F, 12.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146)
						.addBox(-8.0F, -39.0F, 11.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(61, 146).addBox(-17.0F, -39.0F, -10.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 103).addBox(-8.0F, -28.0F, -13.0F, 16.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition body = partdefinition
				.addOrReplaceChild(
						"body", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -32.0F, -12.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(48, 31).addBox(-12.0F, -32.0F, -12.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F))
								.texOffs(0, 67).addBox(-12.0F, -32.0F, 0.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(48, 67).addBox(0.0F, -32.0F, 0.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition leg1L = partdefinition.addOrReplaceChild("leg1L", CubeListBuilder.create().texOffs(96, 85).addBox(19.0F, 0.0F, -5.0F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 6.0F, -11.0F));
		PartDefinition leg1R = partdefinition.addOrReplaceChild("leg1R", CubeListBuilder.create().texOffs(96, 58).addBox(-4.0F, 0.0F, -5.0F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 6.0F, -11.0F));
		PartDefinition leg2R = partdefinition.addOrReplaceChild("leg2R", CubeListBuilder.create().texOffs(96, 31).addBox(-4.0F, 0.0F, 18.0F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 6.0F, -11.0F));
		PartDefinition leg2L = partdefinition.addOrReplaceChild("leg2L", CubeListBuilder.create().texOffs(0, 103).addBox(-4.0F, 0.0F, 19.0F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, 6.0F, -12.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		leaves.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1L.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1R.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2R.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2L.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1L.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg2L.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg1R.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg2R.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}