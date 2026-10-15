package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.MonstrousWorldMod;

public class UndeadGlowMobEffect extends MobEffect {
	public UndeadGlowMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10043546);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.undead_glow_0"), 0.05, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.undead_glow_1"), 2, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.undead_glow_2"), 4, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.undead_glow_3"), 0.5, AttributeModifier.Operation.ADD_VALUE);
	}
}