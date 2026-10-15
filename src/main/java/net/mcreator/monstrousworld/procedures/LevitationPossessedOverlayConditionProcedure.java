package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class LevitationPossessedOverlayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MonstrousWorldModMobEffects.POSSESSED)) {
			return true;
		}
		return false;
	}
}