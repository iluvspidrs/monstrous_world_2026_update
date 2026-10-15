package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

public class MSFactionDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getPersistentData().getString("TradeScreen")).equals("MSFaction")) {
			return true;
		}
		return false;
	}
}