package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class WerewolfInfectionOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(getEntityGameType(entity) == GameType.CREATIVE) && !(getEntityGameType(entity) == GameType.SPECTATOR)) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0) == 1) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
				}
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
			}
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_INFECTION,
						(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0) + 1, 0));
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}