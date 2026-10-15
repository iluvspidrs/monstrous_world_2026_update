package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.MonstrousWorldMod;

public class ColdBloodedMobEffect extends MobEffect {
	public ColdBloodedMobEffect() {
		super(MobEffectCategory.HARMFUL, -16724737);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.cold_blooded_0"), -0.03, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.cold_blooded_1"), -0.03, AttributeModifier.Operation.ADD_VALUE);
	}
}