package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.procedures.WarriorTrialOnEffectActiveTickProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class WarriorTrialMobEffect extends MobEffect {
	public WarriorTrialMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10092544);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.warrior_trial_0"), 4, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_KNOCKBACK, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.warrior_trial_1"), 1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.warrior_trial_2"), 4, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		WarriorTrialOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}