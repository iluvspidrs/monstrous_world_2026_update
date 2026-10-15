package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.DryEyeOnEffectActiveTickProcedure;

public class DryEyeMobEffect extends MobEffect {
	public DryEyeMobEffect() {
		super(MobEffectCategory.HARMFUL, -10791364);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		DryEyeOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}
}