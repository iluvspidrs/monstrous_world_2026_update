package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class Reanimate75ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.REANIMATED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.REANIMATED).getDuration() : 0) >= 150
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.REANIMATED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.REANIMATED).getDuration() : 0) < 225) {
			return true;
		}
		return false;
	}
}