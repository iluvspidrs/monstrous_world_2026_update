package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;

public class TrickedOnEffectTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			entity.getPersistentData().putDouble("XCoordE", (Mth.nextInt(RandomSource.create(), (int) (entity.getX() - 16), (int) (entity.getX() + 16))));
			entity.getPersistentData().putDouble("ZCoordE", (Mth.nextInt(RandomSource.create(), (int) (entity.getZ() - 16), (int) (entity.getZ() + 16))));
			entity.getPersistentData().putDouble("YCoordE", (Mth.nextInt(RandomSource.create(), (int) entity.getY(), (int) (entity.getY() + 16))));
			if ((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("XCoordE"), entity.getPersistentData().getDouble("YCoordE"), entity.getPersistentData().getDouble("ZCoordE")))).getBlock() == Blocks.AIR
					|| (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("XCoordE"), entity.getPersistentData().getDouble("YCoordE"), entity.getPersistentData().getDouble("ZCoordE")))).getBlock() == Blocks.CAVE_AIR
					|| (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("XCoordE"), entity.getPersistentData().getDouble("YCoordE"), entity.getPersistentData().getDouble("ZCoordE")))).getBlock() == Blocks.WATER) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = MonstrousWorldModEntities.ENEMY_PLACEHOLDER.get().spawn(_level,
							BlockPos.containing(entity.getPersistentData().getDouble("XCoordE") + 0.5, entity.getPersistentData().getDouble("YCoordE") + 0.5, entity.getPersistentData().getDouble("ZCoordE") + 0.5), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
	}
}