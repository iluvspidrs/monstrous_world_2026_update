package net.mcreator.monstrousworld.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.monstrousworld.entity.FeralGoblinEntity;
import net.mcreator.monstrousworld.client.model.ModelNPCGoblin;

public class FeralGoblinRenderer extends MobRenderer<FeralGoblinEntity, ModelNPCGoblin<FeralGoblinEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("monstrous_world:textures/entities/feral_goblin.png");

	public FeralGoblinRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelNPCGoblin<FeralGoblinEntity>(context.bakeLayer(ModelNPCGoblin.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FeralGoblinEntity entity) {
		return entityTexture;
	}
}