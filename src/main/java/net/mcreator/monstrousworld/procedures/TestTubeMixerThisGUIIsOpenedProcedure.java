package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class TestTubeMixerThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Cure Serum")) {
			RHCureSerumProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Stabilizing Serum")) {
			RHStabilizingSerumProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Strange Serum Fly")) {
			RHStrangeSerumFlyProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Strange Serum Dreadful Watcher")) {
			RHStrangeSerumDreadfulWatcherProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Strange Serum Serpent")) {
			RHStrangeSerumSerpentProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Spider Syringe")) {
			RHSpiderSyringeProcedure.execute(entity);
		}
	}
}