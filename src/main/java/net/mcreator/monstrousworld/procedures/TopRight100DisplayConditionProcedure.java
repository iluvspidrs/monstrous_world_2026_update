package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class TopRight100DisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.RECENT_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.RECENT_INFECTION).getDuration() : 0) > 150) {
			return true;
		}
		return false;
	}
}