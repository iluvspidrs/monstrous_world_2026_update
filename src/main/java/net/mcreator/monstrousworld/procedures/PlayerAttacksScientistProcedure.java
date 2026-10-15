package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.MadScientistNPCEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerAttacksScientistProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof ServerPlayer || sourceentity instanceof Player) {
			if (entity instanceof MadScientistNPCEntity) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == Mth.nextInt(RandomSource.create(), 1, 3) || sourceentity.getPersistentData().getDouble("StrangeSerum") >= 1) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 5) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\"Kill me and you'll never get the cure you seek!\""), false);
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\"Kill me and you'll have to make your cure yourself!\""), false);
					}
				}
			}
		}
	}
}