package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class HungryTreeSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		if (world.getBlockState(BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) - 1, z)).isFaceSturdy(world,
				BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z) - 1, z), Direction.UP)) {
			return true;
		}
		return false;
	}
}