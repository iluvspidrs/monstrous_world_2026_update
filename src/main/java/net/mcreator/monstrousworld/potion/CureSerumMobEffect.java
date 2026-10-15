package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.CureSerumOnEffectActiveTickProcedure;

public class CureSerumMobEffect extends MobEffect {
	public CureSerumMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16724788);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		CureSerumOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}