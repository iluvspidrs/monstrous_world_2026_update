package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.MysteriousDarknessOnEffectActiveTickProcedure;
import net.mcreator.monstrousworld.procedures.MysteriousDarknessEffectStartedappliedProcedure;

public class MysteriousDarknessMobEffect extends MobEffect {
	public MysteriousDarknessMobEffect() {
		super(MobEffectCategory.NEUTRAL, -15334378);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		MysteriousDarknessEffectStartedappliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		MysteriousDarknessOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}