package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

public class MSMutantDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getPersistentData().getString("TradeScreen")).equals("MSMutant")) {
			return true;
		}
		return false;
	}
}