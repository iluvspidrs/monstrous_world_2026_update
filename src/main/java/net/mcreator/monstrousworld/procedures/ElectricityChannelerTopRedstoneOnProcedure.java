package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.entity.ChannelerSparkEntity;

public class ElectricityChannelerTopRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MonstrousWorldModBlocks.ELECTRICITY_CHANNELER_BOTTOM.get()) {
				if (!(!world.getEntitiesOfClass(ChannelerSparkEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, (y - 2), z)).inflate(1 / 2d), e -> true).isEmpty())) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.CHANNELER_SPARK.get().spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				}
			}
		}
	}
}