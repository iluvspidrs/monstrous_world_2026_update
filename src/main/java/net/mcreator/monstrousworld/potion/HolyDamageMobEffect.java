package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.HolyDamageOnEffectActiveTickProcedure;
import net.mcreator.monstrousworld.procedures.HolyDamageActiveTickConditionProcedure;

public class HolyDamageMobEffect extends MobEffect {
	public HolyDamageMobEffect() {
		super(MobEffectCategory.HARMFUL, -3342337);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return HolyDamageActiveTickConditionProcedure.execute(amplifier, duration);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		HolyDamageOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}