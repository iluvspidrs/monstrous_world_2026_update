package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class WWLevel2ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4)) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}