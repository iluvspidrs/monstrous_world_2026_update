package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.monstrousworld.procedures.PumpkinsRestOnEffectActiveTickProcedure;

public class PumpkinsRestMobEffect extends MobEffect {
	public PumpkinsRestMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -39424);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		PumpkinsRestOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return super.applyEffectTick(entity, amplifier);
	}
}