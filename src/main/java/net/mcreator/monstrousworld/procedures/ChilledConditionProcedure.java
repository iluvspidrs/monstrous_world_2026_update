package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class ChilledConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Chilled >= 1) {
				return true;
			}
			return false;
		}
		return false;
	}
}