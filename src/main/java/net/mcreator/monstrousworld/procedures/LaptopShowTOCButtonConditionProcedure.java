package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class LaptopShowTOCButtonConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("None")) {
			if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider 2 DNA")) {
				if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager 2 DNA")) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}