package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.procedures.WebbedOnEffectActiveTickProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class WebbedMobEffect extends MobEffect {
	public WebbedMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.webbed_0"), -0.1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.webbed_1"), -1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.webbed_2"), 1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.STEP_HEIGHT, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.webbed_3"), -0.5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.webbed_4"), 10, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.webbed_5"), -0.8, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		WebbedOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}