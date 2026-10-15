package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class TwoTradesButtonPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeButton).equals("Witch Button")) {
			WitchTradesButtonPressedProcedure.execute(entity);
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeButton).equals("Goblin Button")) {
			GoblinTradesButtonPressedProcedure.execute(entity);
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeButton).equals("Hunter Button")) {
			HunterTradesButtonPressedProcedure.execute(world, entity);
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeButton).equals("Mad Scientist Button")) {
			MadScientistTradesButtonPressedProcedure.execute(world, x, y, z, entity);
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeButton).equals("Swampmonster Button")) {
			SwampTradesButtonPressedProcedure.execute(entity);
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeButton).equals("Vampire Button")) {
			VampireTradesButtonPressedProcedure.execute(entity);
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeButton).equals("Werewolf Button")) {
			WerewolfTradesButtonPressedProcedure.execute(entity);
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeButton).equals("Demon Maniac Button")) {
			DemonTradesButtonPressedProcedure.execute(world, entity);
		}
	}
}