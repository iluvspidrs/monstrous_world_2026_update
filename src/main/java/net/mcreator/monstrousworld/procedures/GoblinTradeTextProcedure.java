package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class GoblinTradeTextProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Goblin Trade");
	}
}