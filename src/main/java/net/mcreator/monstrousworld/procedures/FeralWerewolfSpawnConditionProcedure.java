package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class FeralWerewolfSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.dimensionType().moonPhase(world.dayTime()) == 0) {
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				if (MonstrousWorldModVariables.TimeUntilNight <= 0) {
					if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.WEREWOLF_SPAWN_CHANCE.get()) {
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
}