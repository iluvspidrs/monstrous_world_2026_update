package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GrantInfectionsProcedure {
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
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WerewolfInfectionTimer >= 1) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
				if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_INFECTION, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).WerewolfInfectionTimer, 0, true, false));
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).VampireInfection >= 1) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).VampireInfection, 0, true, false));
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).ZombieInfection >= 1) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
				if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).ZombieInfection, 0, true, false));
				}
			}
		}
	}
}