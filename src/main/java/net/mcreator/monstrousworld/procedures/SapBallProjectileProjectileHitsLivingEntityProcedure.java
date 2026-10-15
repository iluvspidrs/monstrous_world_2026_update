package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class SapBallProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), MonstrousWorldModBlocks.STICKY_SAP.get().defaultBlockState(), 3);
				MonstrousWorldMod.queueServerWork(Mth.nextInt(RandomSource.create(), 60, 220), () -> {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				});
			}
		}
	}
}