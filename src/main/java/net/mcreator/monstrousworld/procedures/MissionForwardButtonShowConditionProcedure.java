package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class MissionForwardButtonShowConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Page 2")) {
			return true;
		}
		return false;
	}
}