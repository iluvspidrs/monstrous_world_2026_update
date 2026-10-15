package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class ClownTentSeedFeatureAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return Math.random() < (double) MonstrousWorldConfigConfiguration.PLACE_CIRCUS_TENT.get();
	}
}