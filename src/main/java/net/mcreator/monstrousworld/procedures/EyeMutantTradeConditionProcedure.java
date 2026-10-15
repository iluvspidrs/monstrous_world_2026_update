package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class EyeMutantTradeConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Eye Mutant Trade");
	}
}