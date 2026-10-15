package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class Bag50ResultSentToDeepProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), Direction.UP)) {
				world.setBlock(BlockPos.containing(x, y - 1, z), MonstrousWorldModBlocks.ENTRANCE_PORTAL.get().defaultBlockState(), 3);
			} else if (!world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.UP)) {
				world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.ENTRANCE_PORTAL.get().defaultBlockState(), 3);
			} else if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1, z), Direction.UP)) {
				world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.ENTRANCE_PORTAL.get().defaultBlockState(), 3);
			}
		}
	}
}