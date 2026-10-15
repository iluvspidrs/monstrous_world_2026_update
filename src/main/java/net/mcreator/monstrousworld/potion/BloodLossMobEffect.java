package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.BloodLossOnEffectActiveTickProcedure;
import net.mcreator.monstrousworld.procedures.BloodLossActiveTickConditionProcedure;

public class BloodLossMobEffect extends MobEffect {
	public BloodLossMobEffect() {
		super(MobEffectCategory.HARMFUL, -6684672);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return BloodLossActiveTickConditionProcedure.execute(amplifier, duration);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		BloodLossOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}