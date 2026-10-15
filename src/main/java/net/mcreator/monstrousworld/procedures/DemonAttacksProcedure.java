package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.VampireNPCEntity;
import net.mcreator.monstrousworld.entity.FeralWerewolfEntity;
import net.mcreator.monstrousworld.entity.FeralVampireEntity;
import net.mcreator.monstrousworld.entity.DemonNPCEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DemonAttacksProcedure {
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
		if (sourceentity instanceof DemonNPCEntity) {
			if (!(sourceentity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MonstrousWorldModMobEffects.HOLY_DAMAGE))) {
				if (!(entity instanceof ServerPlayer)) {
					if (!((entity instanceof LivingEntity _teamEnt && _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()) != null
							? _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()).getName()
							: "").equals("team_nether"))) {
						if (!entity.getType().is(EntityTypeTags.UNDEAD)) {
							if (!(entity instanceof VampireNPCEntity)) {
								if (!(entity instanceof FeralVampireEntity)) {
									if (!(entity instanceof FeralWerewolfEntity)) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.UNHOLY_DAMAGE, 200, 0));
										if (Math.random() >= 0.66) {
											entity.igniteForSeconds(5);
										}
									}
								}
							}
						}
					}
				} else {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType < 4) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 7) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.UNHOLY_DAMAGE, 200, 0));
										if (Math.random() >= 0.66) {
											entity.igniteForSeconds(5);
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