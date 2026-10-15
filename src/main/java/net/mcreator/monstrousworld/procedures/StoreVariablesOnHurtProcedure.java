package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StoreVariablesOnHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS)) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.DarknessTimer = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0;
						_vars.markSyncDirty();
					}
				}
				if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT)) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.WerewolfEffect = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT).getDuration() : 0;
						_vars.markSyncDirty();
					}
				}
				if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION)) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.WerewolfInfectionTimer = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0;
						_vars.markSyncDirty();
					}
				}
				if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL)) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.LunarPullTimer = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.LUNAR_PULL).getDuration() : 0;
						_vars.markSyncDirty();
					}
				}
				if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MonstrousWorldModMobEffects.TRANSFORM_COOLDOWN)) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.TransformCooldown = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRANSFORM_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRANSFORM_COOLDOWN).getDuration() : 0;
						_vars.markSyncDirty();
					}
				}
				if (entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT)) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.VampireInfection = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT)
								? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration()
								: 0;
						_vars.markSyncDirty();
					}
				}
				if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT)) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.ZombieInfection = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT)
								? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration()
								: 0;
						_vars.markSyncDirty();
					}
				}
				if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN)) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Trident_Countdown = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0;
						_vars.markSyncDirty();
					}
				}
				if (entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH)) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.MurkanusMarth = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH).getDuration() : 0;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}