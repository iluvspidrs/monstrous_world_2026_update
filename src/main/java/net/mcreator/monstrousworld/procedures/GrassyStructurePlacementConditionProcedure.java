package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GrassyStructurePlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x - 3, y - 3, z - 3))).is(BlockTags.create(ResourceLocation.parse("minecraft:dirt"))) && world.isEmptyBlock(BlockPos.containing(x - 3, y, z - 3))) {
			return true;
		}
		return false;
	}
}