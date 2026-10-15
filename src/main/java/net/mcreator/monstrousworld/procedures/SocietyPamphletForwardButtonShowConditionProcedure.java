package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class SocietyPamphletForwardButtonShowConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Society Pamphlet Page 13")) {
			return true;
		}
		return false;
	}
}