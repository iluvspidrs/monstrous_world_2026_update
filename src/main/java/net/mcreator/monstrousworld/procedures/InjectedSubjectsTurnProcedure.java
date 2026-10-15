package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.MutantSerpentEntity;
import net.mcreator.monstrousworld.entity.MutantEyeEntity;
import net.mcreator.monstrousworld.entity.FlyMutantEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class InjectedSubjectsTurnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM) ? _livEnt.getEffect(MonstrousWorldModMobEffects.STRANGE_SERUM).getDuration() : 0) == 1) {
					if (entity.getPersistentData().getDouble("MutationType") == 1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FLY_MUTANT.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof FlyMutantEntity) {
									entityiterator.getPersistentData().putString("Owner", (entity.getPersistentData().getString("Owner")));
									entityiterator.setCustomName(Component.literal(("Placeholder's Assistant".replace("Placeholder", entity.getPersistentData().getString("Owner")))));
								}
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.toList()) {
								if (entityiterator instanceof ServerPlayer) {
									if ((entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("Owner"))) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
												if (getEntityScore("CreateFly", entityiterator) == 0) {
													{
														Entity _ent = entityiterator;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("CreateFly");
														if (_so == null)
															_so = _sc.addObjective("CreateFly", ObjectiveCriteria.DUMMY, Component.literal("CreateFly"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (getEntityScore("CreateFly", entityiterator) == 1) {
															if (getEntityScore("CreateEye", entityiterator) == 1) {
																if (getEntityScore("CreateSerpent", entityiterator) == 1) {
																	if (entityiterator instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:improving_the_gene_pool"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 4;
																		_vars.markSyncDirty();
																	}
																	if (world instanceof Level _level) {
																		if (!_level.isClientSide()) {
																			_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																		} else {
																			_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																		}
																	}
																	if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																		_player.displayClientMessage(Component.literal("You advance one level!"), true);
																}
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
						if (!entity.level().isClientSide())
							entity.discard();
					}
					if (entity.getPersistentData().getDouble("MutationType") == 2) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_EYE.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof MutantEyeEntity) {
									entityiterator.getPersistentData().putString("Owner", (entity.getPersistentData().getString("Owner")));
									entityiterator.setCustomName(Component.literal(("Placeholder's Assistant".replace("Placeholder", entity.getPersistentData().getString("Owner")))));
								}
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.toList()) {
								if (entityiterator instanceof ServerPlayer) {
									if ((entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("Owner"))) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
												if (getEntityScore("CreateEye", entityiterator) == 0) {
													{
														Entity _ent = entityiterator;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("CreateEye");
														if (_so == null)
															_so = _sc.addObjective("CreateEye", ObjectiveCriteria.DUMMY, Component.literal("CreateEye"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (getEntityScore("CreateFly", entityiterator) == 1) {
															if (getEntityScore("CreateEye", entityiterator) == 1) {
																if (getEntityScore("CreateSerpent", entityiterator) == 1) {
																	if (entityiterator instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:improving_the_gene_pool"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 4;
																		_vars.markSyncDirty();
																	}
																	if (world instanceof Level _level) {
																		if (!_level.isClientSide()) {
																			_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																		} else {
																			_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																		}
																	}
																	if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																		_player.displayClientMessage(Component.literal("You advance one level!"), true);
																}
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
						if (!entity.level().isClientSide())
							entity.discard();
					}
					if (entity.getPersistentData().getDouble("MutationType") == 3) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_SERPENT.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof MutantSerpentEntity) {
									entityiterator.getPersistentData().putString("Owner", (entity.getPersistentData().getString("Owner")));
									entityiterator.setCustomName(Component.literal(("Placeholder's Assistant".replace("Placeholder", entity.getPersistentData().getString("Owner")))));
								}
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.toList()) {
								if (entityiterator instanceof ServerPlayer) {
									if ((entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("Owner"))) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
												if (getEntityScore("CreateSerpent", entityiterator) == 0) {
													{
														Entity _ent = entityiterator;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("CreateSerpent");
														if (_so == null)
															_so = _sc.addObjective("CreateSerpent", ObjectiveCriteria.DUMMY, Component.literal("CreateSerpent"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (getEntityScore("CreateFly", entityiterator) == 1) {
															if (getEntityScore("CreateEye", entityiterator) == 1) {
																if (getEntityScore("CreateSerpent", entityiterator) == 1) {
																	if (entityiterator instanceof ServerPlayer _player) {
																		AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:improving_the_gene_pool"));
																		if (_adv != null) {
																			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																			if (!_ap.isDone()) {
																				for (String criteria : _ap.getRemainingCriteria())
																					_player.getAdvancements().award(_adv, criteria);
																			}
																		}
																	}
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.FactionLevel = 4;
																		_vars.markSyncDirty();
																	}
																	if (world instanceof Level _level) {
																		if (!_level.isClientSide()) {
																			_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																		} else {
																			_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																		}
																	}
																	if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																		_player.displayClientMessage(Component.literal("You advance one level!"), true);
																}
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
						if (!entity.level().isClientSide())
							entity.discard();
					}
					if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:mutants")))) {
						if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.STABILIZING_SERUM) ? _livEnt.getEffect(MonstrousWorldModMobEffects.STABILIZING_SERUM).getDuration() : 0) == 1) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.cure")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.cure")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (Math.random() >= 0.15) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							} else if (Math.random() >= 0.3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.WITCH_1.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							} else if (Math.random() >= 0.45) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							} else if (Math.random() >= 0.6) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SORCERER_NPC.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							} else if (Math.random() >= 0.75) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.WANDERING_TRADER.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (!entity.level().isClientSide())
								entity.discard();
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM) ? _livEnt.getEffect(MonstrousWorldModMobEffects.STRANGE_SERUM).getDuration() : 0) == 1) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
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