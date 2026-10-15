package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class ReputationThreeSkullConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -75) {
				return true;
			}
			return false;
		}
		return false;
	}
}