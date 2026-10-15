package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class DryEyeOverlayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DRY_EYE) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DRY_EYE).getDuration() : 0) >= 1) {
			return true;
		}
		return false;
	}
}