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
public class ModelDeadlyBalloon<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("monstrous_world", "model_deadly_balloon"), "main");
	public final ModelPart body;

	public ModelDeadlyBalloon(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 34).addBox(0.0F, -11.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 34).addBox(-1.0F, -15.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 34)
						.addBox(-1.0F, -7.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 34).addBox(0.0F, -18.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 32)
						.addBox(-1.0F, -19.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(-2.0F, -20.0F, -3.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(28, 0)
						.addBox(-2.0F, -28.0F, -3.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 10).addBox(-3.0F, -22.0F, -4.0F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 19)
						.addBox(-3.0F, -27.0F, -4.0F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.0F, -25.0F, -4.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(20, 28)
						.addBox(-2.0F, -26.0F, 3.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 26).addBox(-2.0F, -26.0F, -5.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 6)
						.addBox(4.0F, -26.0F, -3.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(28, 16).addBox(-4.0F, -26.0F, -3.0F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}