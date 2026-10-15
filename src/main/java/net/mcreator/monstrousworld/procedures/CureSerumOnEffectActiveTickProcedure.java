package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class CureSerumOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.CURE_SERUM) ? _livEnt.getEffect(MonstrousWorldModMobEffects.CURE_SERUM).getDuration() : 0) == 1) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
		}
	}
}