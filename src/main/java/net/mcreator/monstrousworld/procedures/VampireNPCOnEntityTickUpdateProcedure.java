package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.MonstrousWorldMod;

public class VampireNPCOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double XPos = 0;
		double YPos = 0;
		double ZPos = 0;
		Entity NearestPlayer = null;
		Entity TargetedEntity = null;
		Entity NearestShadeMarker = null;
		if (!world.isClientSide()) {
			if (world instanceof Level _lvl1 && _lvl1.isDay()) {
				if (!world.getLevelData().isRaining()) {
					MonstrousWorldMod.queueServerWork(1, () -> {
						if (world instanceof Level _lvl3 && _lvl3.isDay()) {
							if (!world.getLevelData().isRaining()) {
								if (world.canSeeSkyFromBelowWater(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
									entity.igniteForSeconds(3);
								}
							}
						}
					});
				}
			}
		}
	}
}