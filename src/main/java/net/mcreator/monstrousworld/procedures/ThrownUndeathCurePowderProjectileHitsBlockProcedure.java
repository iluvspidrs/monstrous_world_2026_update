package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.EnhancedZombieEntity;
import net.mcreator.monstrousworld.entity.EnhancedHuskEntity;
import net.mcreator.monstrousworld.entity.EnhancedDrownedEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class ThrownUndeathCurePowderProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/summon area_effect_cloud ~ ~ ~ {Particle:happy_villager,Potion:17,Color:6192150,Radius:4,Duration:60}");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof ZombieVillager || entity instanceof Zombie || entity instanceof Drowned || entity instanceof Husk || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4 || entity instanceof Zoglin
					|| entity instanceof ZombifiedPiglin || entity instanceof ZombieHorse || entity instanceof EnhancedZombieEntity || entity instanceof EnhancedDrownedEntity || entity instanceof EnhancedHuskEntity || entity instanceof Drowned) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (getEntityScore("UndeathCureThrower", entityiterator) >= 1) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 10;
										_vars.markSyncDirty();
									}
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your reputation improves!"), true);
									if (entityiterator instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:good_samaritan"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = -100;
												_vars.markSyncDirty();
											}
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = 100;
												_vars.markSyncDirty();
											}
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (entityiterator instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
										}
									});
								}
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
									if (getEntityScore("BrewedUndeathCure", entityiterator) == 1) {
										if (getEntityScore("UndeathCureThrower", entityiterator) >= 1) {
											if (getEntityScore("Undeath Cure Powders Used", entityiterator) == 0) {
												{
													Entity _ent = entityiterator;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Undeath Cure Powders Used");
													if (_so == null)
														_so = _sc.addObjective("Undeath Cure Powders Used", ObjectiveCriteria.DUMMY, Component.literal("Undeath Cure Powders Used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Undeath Cure Powders Used", entityiterator) + 1);
												}
												{
													Entity _ent = entityiterator;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Faction Points");
													if (_so == null)
														_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entityiterator) + 1);
												}
												MonstrousWorldMod.queueServerWork(1, () -> {
													if (getEntityScore("Faction Points", entityiterator) >= 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 2;
															_vars.markSyncDirty();
														}
														if (entityiterator instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), true);
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
														}
													}
												});
											}
										}
									}
								}
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof ZombieVillager) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof Zoglin) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.HOGLIN.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof Zombie || entityiterator instanceof Drowned || entityiterator instanceof Husk || entityiterator instanceof EnhancedZombieEntity || entityiterator instanceof EnhancedHuskEntity
							|| entityiterator instanceof EnhancedDrownedEntity) {
						if (!(entityiterator instanceof ZombieVillager)) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
							if (Math.random() >= 0.25) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							} else if (Math.random() >= 0.5) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.WITCH_1.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							} else if (Math.random() >= 0.75) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SORCERER_NPC.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
						}
					}
					if (entityiterator instanceof ZombieHorse) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.HORSE.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
					if (entityiterator instanceof ZombifiedPiglin) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.PIGLIN.spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
					if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							MonstrousWorldModVariables.MapVariables.get(world).TeamResetTimer = 5;
							MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.MonsterType = 0;
								_vars.Bloodlevel = 12;
								_vars.markSyncDirty();
							}
							if (entityiterator instanceof LivingEntity _entity)
								_entity.setHealth((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 1);
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:zombie_movement_speed"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.OXYGEN_BONUS).removeModifier(ResourceLocation.parse("monstrous_world:zombie_oxygen_bonus"));
							}
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_GLOW);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_CURE);
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You are no longer a zombie!"), false);
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:undeath_cure"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							entityiterator.getPersistentData().putBoolean("Monstrous World Zombie", false);
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is restored!"), false);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.DarknessInfectable = true;
									_vars.MonsterInfectable = true;
									_vars.Reputation_Static = false;
									_vars.Reputation = 0;
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = -100;
											_vars.markSyncDirty();
										}
									}
									if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = 100;
											_vars.markSyncDirty();
										}
									}
									if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
									if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
									}
								});
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.DarknessInfectable = true;
									_vars.MonsterInfectable = true;
									_vars.Reputation_Static = false;
									_vars.Reputation = 0;
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = -100;
											_vars.markSyncDirty();
										}
									}
									if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = 100;
											_vars.markSyncDirty();
										}
									}
									if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
									if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
									}
								});
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4
									|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9
									|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterInfectable = true;
									_vars.markSyncDirty();
								}
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 12) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation_Static = false;
										_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 50;
										_vars.markSyncDirty();
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = -100;
												_vars.markSyncDirty();
											}
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = 100;
												_vars.markSyncDirty();
											}
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (entityiterator instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
										}
									});
								}
							}
						}
					}
				}
			}
		}
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}