package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class GhostlyApplePlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) && !(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6)) {
			MonstrousWorldMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player)
					_player.getFoodData().setFoodLevel(0);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("This apple draws the strength from you..."), false);
			});
		}
	}
}