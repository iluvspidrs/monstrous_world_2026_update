package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class DarkMarketSeedFeatureAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return Math.random() <= (double) MonstrousWorldConfigConfiguration.PLACE_DARK_MARKETS.get();
	}
}