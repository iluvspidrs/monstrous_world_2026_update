package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class DemonNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
			if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.DEMON_SPAWN_CHANCE.get()) {
				return true;
			}
			return false;
		}
		return false;
	}
}