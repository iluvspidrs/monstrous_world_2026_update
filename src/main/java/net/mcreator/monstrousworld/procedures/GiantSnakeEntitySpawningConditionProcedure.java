package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class GiantSnakeEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
			if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.GIANT_SNAKE_SPAWN_CHANCE.get()) {
				return true;
			}
			return false;
		}
		return false;
	}
}