package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class CharmAltarThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Trick or Treat Bag")) {
			RHTrickOrTreatBagProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Example Charm")) {
			RHExampleCharmProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Charm of Flight")) {
			RHFlightCharmProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Example Tome")) {
			RHExampleTomeProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Dark Charm")) {
			RHDarkCharmProcedure.execute(entity);
		}
	}
}