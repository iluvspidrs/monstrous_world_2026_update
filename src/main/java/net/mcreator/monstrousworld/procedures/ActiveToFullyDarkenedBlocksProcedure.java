package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class ActiveToFullyDarkenedBlocksProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ACTIVE_DARKENED_STONE.get()) {
				world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.DARKENED_STONE.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ACTIVE_DARKENED_DIRT.get()) {
				world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ACTIVE_DARKENED_SAND.get()) {
				world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.DARKENED_SAND.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ACTIVE_DARKENED_SANDSTONE.get()) {
				world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.DARKENED_SANDSTONE.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ACTIVE_DARKENED_GRAVEL.get()) {
				world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.DARKENED_GRAVEL.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ACTIVE_DARKENED_LOG.get()) {
				world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.DARKENED_LOG.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.ACTIVE_DARKENED_LEAVES.get()) {
				world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.DARKENED_LEAVES.get().defaultBlockState(), 3);
			}
		}
	}
}