package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.MonstrousWorldMod;

public class IronPoisoningMobEffect extends MobEffect {
	public IronPoisoningMobEffect() {
		super(MobEffectCategory.HARMFUL, -3342388);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.iron_poisoning_0"), -0.3, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.iron_poisoning_1"), -0.2, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.SNEAKING_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.iron_poisoning_2"), -0.1, AttributeModifier.Operation.ADD_VALUE);
	}
}