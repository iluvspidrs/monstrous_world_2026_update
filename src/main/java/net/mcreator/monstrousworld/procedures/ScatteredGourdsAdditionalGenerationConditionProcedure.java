package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class ScatteredGourdsAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < (double) MonstrousWorldConfigConfiguration.PLACE_GOURD_PATCHES.get()) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				return true;
			}
			return false;
		}
		return false;
	}
}