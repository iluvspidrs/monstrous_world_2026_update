package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class ClawedJournalForwardButtonShowConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Clawed Journal Page 5")) {
			return true;
		}
		return false;
	}
}