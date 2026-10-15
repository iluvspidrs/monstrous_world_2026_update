package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.MonstrousWorldMod;

public class SappedMobEffect extends MobEffect {
	public SappedMobEffect() {
		super(MobEffectCategory.HARMFUL, -7817615);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.sapped_0"), -8, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}