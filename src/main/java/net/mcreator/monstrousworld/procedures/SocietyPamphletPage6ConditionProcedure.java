package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class SocietyPamphletPage6ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Society Pamphlet Page 6");
	}
}