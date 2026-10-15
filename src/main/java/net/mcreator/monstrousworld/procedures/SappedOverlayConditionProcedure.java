package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class SappedOverlayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.SAPPED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.SAPPED).getDuration() : 0) >= 1) {
			return true;
		}
		return false;
	}
}