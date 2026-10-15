package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class AwakenedPatch1DeathlyAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < (double) MonstrousWorldConfigConfiguration.PLACE_AWAKENED_SOUL_SAND_DEATHLY.get()) {
			if (world.isEmptyBlock(BlockPos.containing(x, y, z)) && world.getBlockState(BlockPos.containing(x + 3, y - 1, z + 3)).canOcclude() && world.getBlockState(BlockPos.containing(x - 3, y - 1, z + 3)).canOcclude()
					&& world.getBlockState(BlockPos.containing(x - 3, y - 1, z - 3)).canOcclude() && world.getBlockState(BlockPos.containing(x + 3, y - 1, z - 3)).canOcclude()) {
				return true;
			}
			return false;
		}
		return false;
	}
}