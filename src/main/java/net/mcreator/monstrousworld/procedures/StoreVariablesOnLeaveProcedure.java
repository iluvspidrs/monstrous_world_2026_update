package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StoreVariablesOnLeaveProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.DarknessTimer = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0;
				_vars.WerewolfEffect = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT).getDuration() : 0;
				_vars.WerewolfInfectionTimer = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0;
				_vars.LunarPullTimer = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.LUNAR_PULL).getDuration() : 0;
				_vars.TransformCooldown = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRANSFORM_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRANSFORM_COOLDOWN).getDuration() : 0;
				_vars.VampireInfection = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration() : 0;
				_vars.ZombieInfection = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0;
				_vars.Trident_Countdown = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0;
				_vars.MurkanusMarth = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH).getDuration() : 0;
				_vars.markSyncDirty();
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
				if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS))) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.DarknessInfectable = true;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}