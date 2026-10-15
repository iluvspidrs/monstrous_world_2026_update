package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.MentalFortitudeOnEffectActiveTickProcedure;

public class MentalFortitudeMobEffect extends MobEffect {
	public MentalFortitudeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13312);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		MentalFortitudeOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}