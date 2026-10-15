package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class DarkSeedFeatureAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return Math.random() < (double) MonstrousWorldConfigConfiguration.DARKNESS_SPREADING_AREA.get();
	}
}