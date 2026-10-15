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

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelFighterSpirit<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("monstrous_world", "model_fighter_spirit"), "main");
	public final ModelPart eyes;
	public final ModelPart inner;
	public final ModelPart body;

	public ModelFighterSpirit(ModelPart root) {
		this.eyes = root.getChild("eyes");
		this.inner = root.getChild("inner");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition eyes = partdefinition.addOrReplaceChild("eyes",
				CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(6, 25).addBox(5.0F, -2.0F, -1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(0.0F, 2.0F, -1.0F, 6.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(12, 24).addBox(3.0F, 3.0F, -1.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(20, 24)
						.addBox(-1.0F, 3.0F, -1.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, 16.0F, 0.0F));
		PartDefinition inner = partdefinition.addOrReplaceChild("inner", CubeListBuilder.create().texOffs(10, 30).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(4, 26).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		eyes.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		inner.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.zRot = ageInTicks;
		this.inner.yRot = ageInTicks;
	}
}