package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.WerewolfTerritoryMarkerEntity;
import net.mcreator.monstrousworld.entity.DireWerewolfEntity;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class DireWerewolfSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(WerewolfTerritoryMarkerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(200 / 2d), e -> true).isEmpty())) {
			if (world.dimensionType().moonPhase(world.dayTime()) == 0) {
				if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
					if (MonstrousWorldModVariables.TimeUntilNight <= 0) {
						if (!(!world.getEntitiesOfClass(DireWerewolfEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(200 / 2d), e -> true).isEmpty())) {
							if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.DIRE_WEREWOLF_SPAWN_CHANCE_NORMAL.get()) {
								return true;
							}
							return false;
						}
						return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		if (!world.getEntitiesOfClass(WerewolfTerritoryMarkerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(200 / 2d), e -> true).isEmpty()) {
			if (world.dimensionType().moonPhase(world.dayTime()) == 0) {
				if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
					if (MonstrousWorldModVariables.TimeUntilNight <= 0) {
						if (!(!world.getEntitiesOfClass(DireWerewolfEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(200 / 2d), e -> true).isEmpty())) {
							if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.DIRE_WEREWOLF_SPAWN_CHANCE_MARKER.get()) {
								return true;
							}
							return false;
						}
						return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}