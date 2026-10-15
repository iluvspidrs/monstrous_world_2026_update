package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class ChannelerSparkOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == MonstrousWorldModBlocks.ELECTRICITY_CHANNELER_TOP.get()) {
				entity.getPersistentData().putString("RobotType", (getBlockNBTString(world, BlockPos.containing(x, y + 2, z), "RobotType")));
			}
			MonstrousWorldMod.queueServerWork(30, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}