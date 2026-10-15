package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

public class MSNormalDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getPersistentData().getString("TradeScreen")).equals("MSNormal")) {
			return true;
		}
		return false;
	}
}