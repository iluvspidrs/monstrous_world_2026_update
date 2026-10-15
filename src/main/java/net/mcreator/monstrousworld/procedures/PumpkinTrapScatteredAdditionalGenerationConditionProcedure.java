package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class PumpkinTrapScatteredAdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return Math.random() < (double) MonstrousWorldConfigConfiguration.PLACE_PUMPKIN_TRAP_PATCHES.get();
	}
}