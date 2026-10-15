package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class InsaneSoulPropertyValueProviderProcedure {
	public static double execute(LevelAccessor world) {
		return MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World;
	}
}