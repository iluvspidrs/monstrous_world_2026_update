package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.LunarPullOnEffectActiveTickProcedure;
import net.mcreator.monstrousworld.procedures.LunarPullEffectStartedappliedProcedure;

public class LunarPullMobEffect extends MobEffect {
	public LunarPullMobEffect() {
		super(MobEffectCategory.NEUTRAL, -8677471);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		LunarPullEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		LunarPullOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}