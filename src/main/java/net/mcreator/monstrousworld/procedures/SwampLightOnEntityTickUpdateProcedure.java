package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;

public class SwampLightOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity.level().dimension()) == Level.NETHER) {
				if (Math.random() >= 0.99995) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.INFERNAL_LIGHT.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER) {
				if (Math.random() >= 0.9999) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.FROG.spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				}
			}
		}
	}
}