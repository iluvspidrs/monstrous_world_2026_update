package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class LaptopForwardArrowShowConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("None")) {
			if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Main Screen Page 1") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Main Screen Page 2")
					|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Strange Serum Page 1") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Strange Serum Page 2")
					|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Create Robot Page 1") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider DNA")
					|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager DNA")) {
				return true;
			}
			return false;
		}
		return false;
	}
}