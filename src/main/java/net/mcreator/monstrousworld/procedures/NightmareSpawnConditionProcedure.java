package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class NightmareSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
			return true;
		}
		return false;
	}
}