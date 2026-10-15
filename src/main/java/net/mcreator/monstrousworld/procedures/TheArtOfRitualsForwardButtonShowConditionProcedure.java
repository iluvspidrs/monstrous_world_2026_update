package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class TheArtOfRitualsForwardButtonShowConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("The Art of Rituals Page 38")) {
			return true;
		}
		return false;
	}
}