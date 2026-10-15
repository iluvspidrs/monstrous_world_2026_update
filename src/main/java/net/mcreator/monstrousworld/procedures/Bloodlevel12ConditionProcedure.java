package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

public class Bloodlevel12ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("Bloodlevel") < 12) {
			return true;
		}
		return false;
	}
}