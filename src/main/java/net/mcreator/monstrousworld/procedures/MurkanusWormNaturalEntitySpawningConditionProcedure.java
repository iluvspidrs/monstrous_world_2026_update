package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class MurkanusWormNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("monstrous_world:darkened_blocks")))
				|| (world.getBlockState(BlockPos.containing(x, y - 2, z))).is(BlockTags.create(ResourceLocation.parse("monstrous_world:darkened_blocks")))
				|| (world.getBlockState(BlockPos.containing(x, y - 3, z))).is(BlockTags.create(ResourceLocation.parse("monstrous_world:darkened_blocks")))
				|| (world.getBlockState(BlockPos.containing(x, y - 4, z))).is(BlockTags.create(ResourceLocation.parse("monstrous_world:darkened_blocks")))
				|| (world.getBlockState(BlockPos.containing(x, y - 5, z))).is(BlockTags.create(ResourceLocation.parse("monstrous_world:darkened_blocks")))
				|| (world.getBlockState(BlockPos.containing(x, y - 6, z))).is(BlockTags.create(ResourceLocation.parse("monstrous_world:darkened_blocks")))) {
			return true;
		}
		return false;
	}
}