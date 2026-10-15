package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.MidasCurseActiveTickConditionProcedure;

public class MidasCurseMobEffect extends MobEffect {
	public MidasCurseMobEffect() {
		super(MobEffectCategory.HARMFUL, -409577);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		MidasCurseActiveTickConditionProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return super.applyEffectTick(entity, amplifier);
	}
}