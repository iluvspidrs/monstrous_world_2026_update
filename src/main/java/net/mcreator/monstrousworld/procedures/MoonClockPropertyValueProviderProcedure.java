package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;

public class MoonClockPropertyValueProviderProcedure {
	public static double execute(LevelAccessor world) {
		return world.dimensionType().moonPhase(world.dayTime());
	}
}