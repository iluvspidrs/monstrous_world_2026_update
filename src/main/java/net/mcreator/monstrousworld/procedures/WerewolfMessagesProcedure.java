package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WerewolfMessagesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
			if (entity.getPersistentData().getDouble("feral_werewolf_message_1") != 0) {
				if (entity.getPersistentData().getDouble("feral_werewolf_message_1") <= world.dayTime()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your inner beast strengthens, and extreme hunger now awakens it..."), false);
					entity.getPersistentData().putDouble("feral_werewolf_message_1", 0);
				}
			}
			if (entity.getPersistentData().getDouble("feral_werewolf_message_2") != 0) {
				if (entity.getPersistentData().getDouble("feral_werewolf_message_2") <= world.dayTime()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your inner beast gets stronger! You sometimes transform when attacked!"), false);
					entity.getPersistentData().putDouble("feral_werewolf_message_2", 0);
				}
			}
			if (entity.getPersistentData().getDouble("feral_werewolf_message_3") != 0) {
				if (entity.getPersistentData().getDouble("feral_werewolf_message_3") <= world.dayTime()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your wild nature strengthens, and you must eat meat or transform!"), false);
					entity.getPersistentData().putDouble("feral_werewolf_message_3", 0);
				}
			}
			if (entity.getPersistentData().getDouble("feral_werewolf_message_4") != 0) {
				if (entity.getPersistentData().getDouble("feral_werewolf_message_4") <= world.dayTime()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your beast side grows stronger, and you transform more easily!"), false);
					entity.getPersistentData().putDouble("feral_werewolf_message_4", 0);
				}
			}
			if (entity.getPersistentData().getDouble("feral_werewolf_message_5") != 0) {
				if (entity.getPersistentData().getDouble("feral_werewolf_message_5") <= world.dayTime()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You now transform often when attacked or hungry, and stay in your beast form longer!"), false);
					entity.getPersistentData().putDouble("feral_werewolf_message_5", 0);
				}
			}
			if (entity.getPersistentData().getDouble("feral_werewolf_message_6") != 0) {
				if (entity.getPersistentData().getDouble("feral_werewolf_message_6") <= world.dayTime()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You can now barely hold your transformations back..."), false);
					entity.getPersistentData().putDouble("feral_werewolf_message_6", 0);
				}
			}
			if (entity.getPersistentData().getDouble("werewolf_message_2") != 0) {
				if (entity.getPersistentData().getDouble("werewolf_message_2") <= world.dayTime()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You can now transform outside of the full moon!"), false);
					entity.getPersistentData().putDouble("werewolf_message_2", 0);
				}
			}
			if (entity.getPersistentData().getDouble("werewolf_keybind_message") != 0) {
				if (entity.getPersistentData().getDouble("werewolf_keybind_message") <= world.dayTime()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Press [B] to transform..."), false);
					entity.getPersistentData().putDouble("werewolf_keybind_message", 0);
				}
			}
		}
	}
}