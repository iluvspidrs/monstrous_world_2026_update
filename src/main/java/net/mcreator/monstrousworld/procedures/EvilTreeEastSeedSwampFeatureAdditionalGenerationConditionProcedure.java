package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class EvilTreeEastSeedSwampFeatureAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		if (Math.random() < (double) MonstrousWorldConfigConfiguration.PLACE_EVIL_TREES_SWAMPS.get()) {
			return true;
		}
		return false;
	}
}