package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class LaptopCloseButtonShowConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Tin Rod") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Evil Tree Wood")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Darkened Iron Trapdoor") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Nether Gem")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("A Hint Of Insanity") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Controller")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Syringe") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Lab Coat")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Lab Glasses") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Lab Boots")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Electricity Channeler Top")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Electricity Channeler Bottom") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Spider Robot Eye")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Spider Robot Head") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Spider Robot Body")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Spider Robot Legs") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Guard Robot Head")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Guard Robot Body") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Guard Robot Arm")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Guard Robot Body And Arms") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Guard Robot Leg")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Guard Robot Legs") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Robot Table")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Hot Plate") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).RecipeGuideShow).equals("Darkness Sample")) {
			return true;
		}
		return false;
	}
}