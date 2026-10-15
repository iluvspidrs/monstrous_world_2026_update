package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class ConfectoineryTableThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Cursed Candy")) {
			RHCursedCandyProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Cotton Candy")) {
			RHCottonCandyProcedure.execute(entity);
		}
	}
}