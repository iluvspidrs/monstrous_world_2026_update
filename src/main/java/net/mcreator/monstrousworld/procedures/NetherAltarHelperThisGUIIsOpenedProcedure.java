package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class NetherAltarHelperThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Pitchfork")) {
			RHPitchforkProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Infernal Leggings")) {
			RHInfernalLeggingsProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Infernal Tunic")) {
			RHInfernalTunicProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Charm of Deception")) {
			RHCharmOfDeceptionProcedure.execute(entity);
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Nether Bone Dagger")) {
			RHNetherBoneDaggerProcedure.execute(entity);
		}
	}
}