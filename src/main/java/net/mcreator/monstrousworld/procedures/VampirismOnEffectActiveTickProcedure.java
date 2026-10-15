package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class VampirismOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestShadeMarker = null;
		Entity NearestVillager = null;
		Entity NearestSorcerer = null;
		Entity NearestSocietyGuard = null;
		Entity NearestIllager = null;
		Entity NearestPlayer = null;
		Entity NearestWW = null;
		Entity NearestHunter = null;
		Entity NearestSocietyPatrol = null;
		Entity NearestHunterPatrol = null;
		Entity NearestWanderingTrader = null;
		Entity TargetedEntity = null;
		Entity TargetEntity = null;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VAMPIRE_CLOAK_CHESTPLATE.get()
					&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VAMPIRE_CLOAK_HELMET.get()) {
				if (world instanceof Level _lvl5 && _lvl5.isDay()) {
					if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						if (!world.getLevelData().isRaining()) {
							if (entity.getPersistentData().getDouble("SunProtection") >= 1) {
								entity.getPersistentData().putDouble("SunProtection", (entity.getPersistentData().getDouble("SunProtection") - 1));
							}
						} else {
							if (entity.getPersistentData().getDouble("SunProtection") < 300) {
								entity.getPersistentData().putDouble("SunProtection", (entity.getPersistentData().getDouble("SunProtection") + 1));
							}
						}
					} else {
						if (entity.getPersistentData().getDouble("SunProtection") < 300) {
							entity.getPersistentData().putDouble("SunProtection", (entity.getPersistentData().getDouble("SunProtection") + 1));
						}
					}
				} else {
					if (entity.getPersistentData().getDouble("SunProtection") < 300) {
						entity.getPersistentData().putDouble("SunProtection", (entity.getPersistentData().getDouble("SunProtection") + 1));
					}
				}
			} else {
				entity.getPersistentData().putDouble("SunProtection", 0);
			}
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
					if (!(getEntityGameType(entity) == GameType.CREATIVE) && !(getEntityGameType(entity) == GameType.SPECTATOR)) {
						if (entity instanceof Player _player)
							_player.getFoodData().setFoodLevel(20);
						if (!world.getLevelData().isRaining()) {
							if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
								if (world instanceof Level _lvl28 && _lvl28.isDay()) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 1));
									if (entity.getPersistentData().getDouble("SunProtection") == 0) {
										MonstrousWorldMod.queueServerWork(10, () -> {
											if (!world.getLevelData().isRaining()) {
												if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
													if (world instanceof Level _lvl33 && _lvl33.isDay()) {
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 1));
														if (entity.getPersistentData().getDouble("SunProtection") == 0) {
															if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 1));
															entity.igniteForSeconds(3);
														}
													}
												}
											}
										});
									}
								}
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
								if (entity instanceof Player _player)
									_player.getFoodData().setSaturation(10);
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0));
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
								if (getEntityScore("vampire_slow", entity) == 1) {
									if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
										if (!entity.onGround()) {
											if (!entity.isInWater()) {
												if (!entity.isInLava()) {
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 0));
												}
											}
										}
									}
								}
								if (getEntityScore("vampire_sneak", entity) == 1) {
									if (entity.isShiftKeyDown()) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 0));
									}
								}
								if (getEntityScore("vampire_lunar", entity) == 1) {
									if (!(world instanceof Level _lvl51 && _lvl51.isDay())) {
										if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0));
										}
									}
								}
								if (getEntityScore("vampire_water", entity) == 1) {
									if (entity.isInWater()) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 20, 0));
									}
								}
							}
						}
					}
				}
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

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}