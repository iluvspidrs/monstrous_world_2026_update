package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class WitchVampireCureTradeTextProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeHeading).equals("Witch Cure Trade");
	}
}