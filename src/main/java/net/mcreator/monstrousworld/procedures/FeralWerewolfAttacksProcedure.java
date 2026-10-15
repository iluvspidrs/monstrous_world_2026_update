package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.FollowerWerewolfEntity;
import net.mcreator.monstrousworld.entity.FeralWerewolfEntity;
import net.mcreator.monstrousworld.entity.DireWerewolfEntity;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FeralWerewolfAttacksProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (sourceentity instanceof FeralWerewolfEntity || sourceentity instanceof FollowerWerewolfEntity || sourceentity instanceof DireWerewolfEntity) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
						if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0) == 0) {
							if (Math.random() < entity.getPersistentData().getDouble("Infectability")) {
								if (Math.random() < (double) MonstrousWorldConfigConfiguration.WEREWOLF_INFECTION_CHANCE.get()) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_INFECTION, Mth.nextInt(RandomSource.create(), 24000, 48000), 0, true, false));
								}
							}
						}
					}
				}
				if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
								if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0) == 0) {
									if (Math.random() < entity.getPersistentData().getDouble("Infectability")) {
										if (Math.random() < (double) MonstrousWorldConfigConfiguration.WEREWOLF_INFECTION_CHANCE.get()) {
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_INFECTION, Mth.nextInt(RandomSource.create(), 24000, 48000), 0, true, false));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}