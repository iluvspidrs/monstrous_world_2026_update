package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class Witch6TradeConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 6");
	}
}