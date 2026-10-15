package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class TerrMarker5ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TerritoryMarkers == 5) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}