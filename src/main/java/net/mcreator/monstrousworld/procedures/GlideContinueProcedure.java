package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GlideContinueProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
				if (entity.onGround()) {
					entity.getPersistentData().putBoolean("Gliding", false);
					if (entity instanceof Player _player) {
						_player.stopFallFlying();
					}
				} else {
					if (entity.getPersistentData().getBoolean("Gliding") == true) {
						if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.isFallFlying())) {
							if (entity instanceof Player _player) {
								_player.startFallFlying();
							}
						}
					}
				}
			}
		}
	}
}