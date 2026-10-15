package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

import java.util.Comparator;

public class DreadfulWatcherOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestPlayer = null;
		NearestPlayer = findEntityInWorldRange(world, ServerPlayer.class, x, y, z, 64);
		if (!world.isClientSide()) {
			if (NearestPlayer instanceof Player || NearestPlayer instanceof ServerPlayer) {
				if (!(getEntityGameType(NearestPlayer) == GameType.CREATIVE)) {
					if (!(getEntityGameType(NearestPlayer) == GameType.SPECTATOR)) {
						if (NearestPlayer instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MonstrousWorldModMobEffects.INSANITY)) {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().moveTo((NearestPlayer.getX()), (NearestPlayer.getY()), (NearestPlayer.getZ()), 0.2);
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass <= 9) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 220, 0));
								if (Math.random() <= (double) MonstrousWorldConfigConfiguration.INSANITY_CHANCE.get()) {
									if (entityiterator.getPersistentData().getDouble("insanity_timer") == 0) {
										entityiterator.getPersistentData().putDouble("insanity_timer", (Mth.nextInt(RandomSource.create(), 24000, 36000)));
										if (entityiterator instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A75Paranoia grips you, and you are now terrified of the dark..."), true);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.INSANITY, (int) entityiterator.getPersistentData().getDouble("insanity_timer"), 0));
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
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