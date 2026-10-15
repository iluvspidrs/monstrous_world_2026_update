package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MidasCurseActiveTickConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.RAW_GOLD_BLOCK.defaultBlockState(), 3);
			}
		}
	}
}