package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ApplyPotionsOnRespawnProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).DarknessTimer >= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).DarknessTimer, 0));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WerewolfEffect >= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_EFFECT, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WerewolfEffect, 0, true, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WerewolfInfectionTimer >= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_INFECTION, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WerewolfInfectionTimer, 0, true, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).LunarPullTimer >= 1) {
			if (world.dimensionType().moonPhase(world.dayTime()) == 0 && world.dayTime() % 24000 >= 13000) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.LUNAR_PULL, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).LunarPullTimer, 0));
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TransformCooldown >= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.TRANSFORM_COOLDOWN, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TransformCooldown, 0, true, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).VampireInfection >= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).VampireInfection, 0, true, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM, 24000, 0, true, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).ZombieInfection >= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).ZombieInfection, 0, true, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WITCH_EFFECT, 24000, 0, true, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.GOBLIN_EFFECT, 24000, 0, true, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MURKANUS_MARTH, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MurkanusMarth, 0, false, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Trident_Countdown, 0, true, false));
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
			if (!(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS))) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.DarknessInfectable = true;
					_vars.markSyncDirty();
				}
			}
		}
	}
}