package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class GraveSoilOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (!(world instanceof Level _lvl1 && _lvl1.isDay())) {
				if (Math.random() < 0.125) {
					if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, new ItemStack(MonstrousWorldModItems.UNDEATHLY_ESSENCE.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
		}
	}
}