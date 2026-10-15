package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class Bag5ResultRandomPanesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (Math.random() < 0.125) {
				for (int _i1 = 0; _i1 < 24; _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(MonstrousWorldModBlocks.DARKENED_GLASS_PANE.get())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (Math.random() < 0.25) {
				for (int _i1 = 0; _i1 < 24; _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(MonstrousWorldModBlocks.DARKENED_WOOD_GLASS_PANE.get())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (Math.random() < 0.375) {
				for (int _i1 = 0; _i1 < 24; _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(MonstrousWorldModBlocks.EVIL_WOOD_GLASS_PANE.get())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (Math.random() < 0.5) {
				for (int _i1 = 0; _i1 < 24; _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(MonstrousWorldModBlocks.PUMPKIN_WOOD_GLASS_PANE.get())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (Math.random() < 0.625) {
				for (int _i1 = 0; _i1 < 24; _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(MonstrousWorldModBlocks.GHOSTLY_WOOD_GLASS_PANE.get())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (Math.random() < 0.75) {
				for (int _i1 = 0; _i1 < 24; _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(MonstrousWorldModBlocks.DEATHLY_WOOD_GLASS_PANE.get())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (Math.random() < 0.875) {
				for (int _i1 = 0; _i1 < 24; _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(MonstrousWorldModBlocks.SANGUINE_WOOD_GLASS_PANE.get())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else {
				for (int _i1 = 0; _i1 < 24; _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(MonstrousWorldModBlocks.MURKWOOD_GLASS_PANE.get())));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}