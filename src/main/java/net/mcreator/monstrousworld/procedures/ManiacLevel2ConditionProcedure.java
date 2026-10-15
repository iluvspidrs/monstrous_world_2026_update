package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class ManiacLevel2ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
				return true;
			}
			return false;
		}
		return false;
	}
}