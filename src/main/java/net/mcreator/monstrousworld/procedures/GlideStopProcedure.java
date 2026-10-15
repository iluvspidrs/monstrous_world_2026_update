package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class GlideStopProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
				if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isFallFlying()) {
					entity.getPersistentData().putBoolean("Gliding", false);
					if (entity instanceof Player _player) {
						_player.stopFallFlying();
					}
				}
			}
		}
	}
}