package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SugarCaneSingleAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.WATER) {
			return true;
		}
		return false;
	}
}