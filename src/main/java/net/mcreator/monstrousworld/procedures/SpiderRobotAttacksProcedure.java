package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.mcreator.monstrousworld.entity.SpiderRobotActiveEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class SpiderRobotAttacksProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity) {
				if (sourceentity instanceof SpiderRobotActiveEntity) {
					if ((sourceentity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("MidasCurse")) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MIDAS_CURSE, 100, 0));
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (getEntityScore("MidasCurse", sourceentity) == 0) {
								if (sourceentity instanceof SpiderRobotActiveEntity _datEntSetS)
									_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "None");
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (sourceentity instanceof TamableAnimal _tamIsTamedBy && entityiterator instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
												if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 5;
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
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
													if (getEntityScore("MidasCurse", entityiterator) == 0) {
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entityiterator) + 1);
														}
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("MidasCurse");
															if (_so == null)
																_so = _sc.addObjective("MidasCurse", ObjectiveCriteria.DUMMY, Component.literal("MidasCurse"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
														}
														MonstrousWorldMod.queueServerWork(1, () -> {
															if (getEntityScore("Faction Points", entityiterator) >= 3) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 5;
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
												if (getEntityScore("MidasCurse", entityiterator) >= 1) {
													if (getEntityScore("Vanishing", entityiterator) >= 1) {
														if (getEntityScore("Sinking", entityiterator) >= 1) {
															if (getEntityScore("Frogify", entityiterator) >= 1) {
																if (getEntityScore("Chickenify", entityiterator) >= 1) {
																	if (getEntityScore("Paralysis", entityiterator) >= 1) {
																		if (entityiterator instanceof ServerPlayer _player) {
																			AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pick_your_poison"));
																			if (_adv != null) {
																				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																				if (!_ap.isDone()) {
																					for (String criteria : _ap.getRemainingCriteria())
																						_player.getAdvancements().award(_adv, criteria);
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
									}
								}
							}
							{
								Entity _ent = sourceentity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("MidasCurse");
								if (_so == null)
									_so = _sc.addObjective("MidasCurse", ObjectiveCriteria.DUMMY, Component.literal("MidasCurse"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("MidasCurse", sourceentity) - 1);
							}
							sourceentity.getPersistentData().putDouble("MidasCurse", (sourceentity.getPersistentData().getDouble("MidasCurse") - 1));
						});
					} else if ((sourceentity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Sinking")) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.SINKING, 100, 0));
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (getEntityScore("Sinking", sourceentity) == 0) {
								if (sourceentity instanceof SpiderRobotActiveEntity _datEntSetS)
									_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "None");
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (sourceentity instanceof TamableAnimal _tamIsTamedBy && entityiterator instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
												if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 5;
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
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
													if (getEntityScore("Sinking", entityiterator) == 0) {
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entityiterator) + 1);
														}
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Sinking");
															if (_so == null)
																_so = _sc.addObjective("Sinking", ObjectiveCriteria.DUMMY, Component.literal("Sinking"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
														}
														MonstrousWorldMod.queueServerWork(1, () -> {
															if (getEntityScore("Faction Points", entityiterator) >= 3) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 5;
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
												if (getEntityScore("MidasCurse", entityiterator) >= 1) {
													if (getEntityScore("Vanishing", entityiterator) >= 1) {
														if (getEntityScore("Sinking", entityiterator) >= 1) {
															if (getEntityScore("Frogify", entityiterator) >= 1) {
																if (getEntityScore("Chickenify", entityiterator) >= 1) {
																	if (getEntityScore("Paralysis", entityiterator) >= 1) {
																		if (entityiterator instanceof ServerPlayer _player) {
																			AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pick_your_poison"));
																			if (_adv != null) {
																				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																				if (!_ap.isDone()) {
																					for (String criteria : _ap.getRemainingCriteria())
																						_player.getAdvancements().award(_adv, criteria);
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
									}
								}
							}
							{
								Entity _ent = sourceentity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Sinking");
								if (_so == null)
									_so = _sc.addObjective("Sinking", ObjectiveCriteria.DUMMY, Component.literal("Sinking"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Sinking", sourceentity) - 1);
							}
						});
					} else if ((sourceentity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Vanishing")) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 4));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 100, 4));
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (getEntityScore("Vanishing", sourceentity) == 0) {
								if (sourceentity instanceof SpiderRobotActiveEntity _datEntSetS)
									_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "None");
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (sourceentity instanceof TamableAnimal _tamIsTamedBy && entityiterator instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
												if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 5;
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
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
													if (getEntityScore("Vanishing", entityiterator) == 0) {
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entityiterator) + 1);
														}
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Vanishing");
															if (_so == null)
																_so = _sc.addObjective("Vanishing", ObjectiveCriteria.DUMMY, Component.literal("Vanishing"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
														}
														MonstrousWorldMod.queueServerWork(1, () -> {
															if (getEntityScore("Faction Points", entityiterator) >= 3) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 5;
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
												if (getEntityScore("MidasCurse", entityiterator) >= 1) {
													if (getEntityScore("Vanishing", entityiterator) >= 1) {
														if (getEntityScore("Sinking", entityiterator) >= 1) {
															if (getEntityScore("Frogify", entityiterator) >= 1) {
																if (getEntityScore("Chickenify", entityiterator) >= 1) {
																	if (getEntityScore("Paralysis", entityiterator) >= 1) {
																		if (entityiterator instanceof ServerPlayer _player) {
																			AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pick_your_poison"));
																			if (_adv != null) {
																				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																				if (!_ap.isDone()) {
																					for (String criteria : _ap.getRemainingCriteria())
																						_player.getAdvancements().award(_adv, criteria);
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
									}
								}
							}
							{
								Entity _ent = sourceentity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Vanishing");
								if (_so == null)
									_so = _sc.addObjective("Vanishing", ObjectiveCriteria.DUMMY, Component.literal("Vanishing"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Vanishing", sourceentity) - 1);
							}
						});
					} else if ((sourceentity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Paralysis")) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 7));
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (getEntityScore("Paralysis", sourceentity) == 0) {
								if (sourceentity instanceof SpiderRobotActiveEntity _datEntSetS)
									_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "None");
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (sourceentity instanceof TamableAnimal _tamIsTamedBy && entityiterator instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
												if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 5;
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
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
													if (getEntityScore("Paralysis", entityiterator) == 0) {
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entityiterator) + 1);
														}
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Paralysis");
															if (_so == null)
																_so = _sc.addObjective("Paralysis", ObjectiveCriteria.DUMMY, Component.literal("Paralysis"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
														}
														MonstrousWorldMod.queueServerWork(1, () -> {
															if (getEntityScore("Faction Points", entityiterator) >= 3) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 5;
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
												if (getEntityScore("MidasCurse", entityiterator) >= 1) {
													if (getEntityScore("Vanishing", entityiterator) >= 1) {
														if (getEntityScore("Sinking", entityiterator) >= 1) {
															if (getEntityScore("Frogify", entityiterator) >= 1) {
																if (getEntityScore("Chickenify", entityiterator) >= 1) {
																	if (getEntityScore("Paralysis", entityiterator) >= 1) {
																		if (entityiterator instanceof ServerPlayer _player) {
																			AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pick_your_poison"));
																			if (_adv != null) {
																				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																				if (!_ap.isDone()) {
																					for (String criteria : _ap.getRemainingCriteria())
																						_player.getAdvancements().award(_adv, criteria);
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
									}
								}
							}
							{
								Entity _ent = sourceentity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Paralysis");
								if (_so == null)
									_so = _sc.addObjective("Paralysis", ObjectiveCriteria.DUMMY, Component.literal("Paralysis"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Paralysis", sourceentity) - 1);
							}
						});
					} else if ((sourceentity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Chickenify")) {
						if (!(entity instanceof ServerPlayer)) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < 200) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.CHICKEN.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
								if (!entity.level().isClientSide())
									entity.discard();
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (getEntityScore("Chickenify", sourceentity) == 0) {
										if (sourceentity instanceof SpiderRobotActiveEntity _datEntSetS)
											_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "None");
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
													if (sourceentity instanceof TamableAnimal _tamIsTamedBy && entityiterator instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
														if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 5;
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
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
															if (getEntityScore("Chickenify", entityiterator) == 0) {
																{
																	Entity _ent = entityiterator;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entityiterator) + 1);
																}
																{
																	Entity _ent = entityiterator;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Chickenify");
																	if (_so == null)
																		_so = _sc.addObjective("Chickenify", ObjectiveCriteria.DUMMY, Component.literal("Chickenify"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																MonstrousWorldMod.queueServerWork(1, () -> {
																	if (getEntityScore("Faction Points", entityiterator) >= 3) {
																		{
																			MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																			_vars.FactionLevel = 5;
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
														if (getEntityScore("MidasCurse", entityiterator) >= 1) {
															if (getEntityScore("Vanishing", entityiterator) >= 1) {
																if (getEntityScore("Sinking", entityiterator) >= 1) {
																	if (getEntityScore("Frogify", entityiterator) >= 1) {
																		if (getEntityScore("Chickenify", entityiterator) >= 1) {
																			if (getEntityScore("Paralysis", entityiterator) >= 1) {
																				if (entityiterator instanceof ServerPlayer _player) {
																					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pick_your_poison"));
																					if (_adv != null) {
																						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																						if (!_ap.isDone()) {
																							for (String criteria : _ap.getRemainingCriteria())
																								_player.getAdvancements().award(_adv, criteria);
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
											}
										}
									}
									{
										Entity _ent = sourceentity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Chickenify");
										if (_so == null)
											_so = _sc.addObjective("Chickenify", ObjectiveCriteria.DUMMY, Component.literal("Chickenify"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Chickenify", sourceentity) - 1);
									}
								});
							}
						}
					} else if ((sourceentity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Frogify")) {
						if (!(entity instanceof ServerPlayer)) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < 200) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.FROG.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
								if (!entity.level().isClientSide())
									entity.discard();
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (getEntityScore("Frogify", sourceentity) == 0) {
										if (sourceentity instanceof SpiderRobotActiveEntity _datEntSetS)
											_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "None");
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof ServerPlayer || entityiterator instanceof Player) {
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
													if (sourceentity instanceof TamableAnimal _tamIsTamedBy && entityiterator instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
														if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 5;
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
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
															if (getEntityScore("Frogify", entityiterator) == 0) {
																{
																	Entity _ent = entityiterator;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entityiterator) + 1);
																}
																{
																	Entity _ent = entityiterator;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Frogify");
																	if (_so == null)
																		_so = _sc.addObjective("Frogify", ObjectiveCriteria.DUMMY, Component.literal("Frogify"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
																}
																MonstrousWorldMod.queueServerWork(1, () -> {
																	if (getEntityScore("Faction Points", entityiterator) >= 3) {
																		{
																			MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																			_vars.FactionLevel = 5;
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
													if (getEntityScore("MidasCurse", entityiterator) >= 1) {
														if (getEntityScore("Vanishing", entityiterator) >= 1) {
															if (getEntityScore("Sinking", entityiterator) >= 1) {
																if (getEntityScore("Frogify", entityiterator) >= 1) {
																	if (getEntityScore("Chickenify", entityiterator) >= 1) {
																		if (getEntityScore("Paralysis", entityiterator) >= 1) {
																			if (entityiterator instanceof ServerPlayer _player) {
																				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pick_your_poison"));
																				if (_adv != null) {
																					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																					if (!_ap.isDone()) {
																						for (String criteria : _ap.getRemainingCriteria())
																							_player.getAdvancements().award(_adv, criteria);
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
										}
									}
									{
										Entity _ent = sourceentity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Frogify");
										if (_so == null)
											_so = _sc.addObjective("Frogify", ObjectiveCriteria.DUMMY, Component.literal("Frogify"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Frogify", sourceentity) - 1);
									}
								});
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