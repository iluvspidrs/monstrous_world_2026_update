package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class SorceressTEntAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < (double) MonstrousWorldConfigConfiguration.PLACE_ABANDONED_TENTS.get()) {
			if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
				if (world.getBlockState(BlockPos.containing(x + 4, y - 1, z)).canOcclude()) {
					if (world.getBlockState(BlockPos.containing(x - 4, y - 1, z)).canOcclude()) {
						if (world.getBlockState(BlockPos.containing(x, y - 1, z - 4)).canOcclude()) {
							if (world.getBlockState(BlockPos.containing(x, y - 1, z + 4)).canOcclude()) {
								return true;
							}
							return false;
						}
						return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}