package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.UnholyDamageOnEffectActiveTickProcedure;
import net.mcreator.monstrousworld.procedures.UnholyDamageActiveTickConditionProcedure;

public class UnholyDamageMobEffect extends MobEffect {
	public UnholyDamageMobEffect() {
		super(MobEffectCategory.HARMFUL, -13434880);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return UnholyDamageActiveTickConditionProcedure.execute(amplifier, duration);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		UnholyDamageOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}