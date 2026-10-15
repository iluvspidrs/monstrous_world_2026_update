package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class Bookshelves1AdditionalGenerationConditionProcedure {
	public static boolean execute() {
		return Math.random() < (double) MonstrousWorldConfigConfiguration.PLACE_DARKENED_BOOKSHELVES_CAVE.get();
	}
}