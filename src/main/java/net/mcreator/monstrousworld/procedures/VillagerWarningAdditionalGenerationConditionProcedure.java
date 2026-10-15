package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class VillagerWarningAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < (double) MonstrousWorldConfigConfiguration.PLACE_VILLAGER_JOURNAL.get()) {
			if (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1)).canOcclude() && world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1)).canOcclude()) {
				return true;
			}
			return false;
		}
		return false;
	}
}