package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class ShowPSPage11ButtonConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Precious Stones and You Page 11")) {
			if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Essence of Enchantment")) {
				return true;
			}
			return false;
		}
		return false;
	}
}