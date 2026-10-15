package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.SwampLightEntity;

public class SwampmonsterEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
			if (!(getEntityGameType(entity) == GameType.CREATIVE) && !(getEntityGameType(entity) == GameType.SPECTATOR)) {
				if (entity.isInWaterOrBubble()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 220, 0));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0));
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.WITHER);
				}
				if (!world.getEntitiesOfClass(Guardian.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(40 / 2d), e -> true).isEmpty()) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel <= 4) {
						if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.WEAKNESS))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 3000, 2));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("The forces of this temple fear you and drain your strength..."), false);
						}
					}
				}
				if (!world.getEntitiesOfClass(SwampLightEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(32 / 2d), e -> true).isEmpty()) {
					if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MonstrousWorldModMobEffects.DESSICATION)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.DESSICATION,
									(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESSICATION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESSICATION).getDuration() : 0) + 2, 0));
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESSICATION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESSICATION).getDuration() : 0) == 1) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 220, 0));
				}
				if (!world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_jungle")))
						&& !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:has_closer_water_fog")))
						&& !world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:allows_surface_slime_spawns")))) {
					if (!entity.isInWaterRainOrBubble()) {
						if (!(entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MonstrousWorldModMobEffects.MEDLEY_COUNTDOWN))) {
							if (!(entity.getPersistentData().getBoolean("DessicationImmune") == true)) {
								if (!(entity instanceof LivingEntity _livEnt22 && _livEnt22.hasEffect(MonstrousWorldModMobEffects.DESSICATION))) {
									if (!(entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MobEffects.WITHER))) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.DESSICATION, 6000, 0));
									} else {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.DESSICATION, 40, 0));
									}
								}
							} else {
								if (!((entity.level().dimension()) == Level.NETHER)) {
									if (entity instanceof LivingEntity _entity)
										_entity.removeEffect(MonstrousWorldModMobEffects.DESSICATION);
								} else {
									if (!(entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(MonstrousWorldModMobEffects.DESSICATION))) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.DESSICATION, 6000, 0));
									}
								}
							}
						} else {
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.DESSICATION);
						}
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.DESSICATION);
					}
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.DESSICATION);
				}
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.DESSICATION);
			}
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