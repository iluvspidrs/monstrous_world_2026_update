package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class ConcentratedMoonstoneOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (!(world instanceof Level _lvl1 && _lvl1.isDay())) {
				if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
					if (!(!world.getEntitiesOfClass(ItemEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(10 / 2d), e -> true).isEmpty())) {
						if (world.dimensionType().moonPhase(world.dayTime()) == 3 || world.dimensionType().moonPhase(world.dayTime()) == 5) {
							if (Math.random() <= 0.02) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.MOON_DUST.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (world.dimensionType().moonPhase(world.dayTime()) == 2 || world.dimensionType().moonPhase(world.dayTime()) == 6) {
							if (Math.random() <= 0.1) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.MOON_DUST.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (world.dimensionType().moonPhase(world.dayTime()) == 1 || world.dimensionType().moonPhase(world.dayTime()) == 7) {
							if (Math.random() <= 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.MOON_DUST.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (world.dimensionType().moonPhase(world.dayTime()) == 0) {
							if (Math.random() <= 0.3) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.MOON_DUST.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
				}
			}
		}
	}
}