package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class HunterWarningWerewolfAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return Math.random() < (double) MonstrousWorldConfigConfiguration.PLACE_WEREWOLF_WARNING.get();
	}
}