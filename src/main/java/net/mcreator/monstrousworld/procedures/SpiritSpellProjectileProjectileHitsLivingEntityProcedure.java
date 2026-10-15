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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class SpiritSpellProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 4) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:backfire"));
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
			if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("spirit")) {
				if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("stalker")) {
					if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("possessing")) {
						if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("ghost")) {
							if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("wraith")) {
								if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("poltergeist")) {
									if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("soul")) {
										if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("phantom")) {
											if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("specter")) {
												if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("shade")) {
													if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("spook")) {
														if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("apparition")) {
															if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MAGICALLY_POSSESSED, 200, 0, false, false));
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.ambient")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.ambient")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																final Vec3 _center = new Vec3(x, y, z);
																for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream()
																		.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
																	if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
																		if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
																			if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 4) {
																				if (entityiterator instanceof ServerPlayer _player) {
																					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:elemental_magic"));
																					if (_adv != null) {
																						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																						if (!_ap.isDone()) {
																							for (String criteria : _ap.getRemainingCriteria())
																								_player.getAdvancements().award(_adv, criteria);
																						}
																					}
																				}
																				{
																					Entity _ent = entityiterator;
																					Scoreboard _sc = _ent.level().getScoreboard();
																					Objective _so = _sc.getObjective("spells_used");
																					if (_so == null)
																						_so = _sc.addObjective("spells_used", ObjectiveCriteria.DUMMY, Component.literal("spells_used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("spells_used", entityiterator) + 1);
																				}
																				MonstrousWorldMod.queueServerWork(20, () -> {
																					if (getEntityScore("spells_used", entityiterator) == 30) {
																						if (world instanceof Level _level) {
																							if (!_level.isClientSide()) {
																								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")),
																										SoundSource.NEUTRAL, 1, 1);
																							} else {
																								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																							}
																						}
																						{
																							Entity _ent = entityiterator;
																							Scoreboard _sc = _ent.level().getScoreboard();
																							Objective _so = _sc.getObjective("spells_used");
																							if (_so == null)
																								_so = _sc.addObjective("spells_used", ObjectiveCriteria.DUMMY, Component.literal("spells_used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
																						}
																						{
																							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																							_vars.FactionLevel = 2;
																							_vars.markSyncDirty();
																						}
																						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																							_player.displayClientMessage(Component.literal("You advance a level!"), false);
																					}
																				});
																			}
																		}
																		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
																			{
																				MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																				_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
																				_vars.markSyncDirty();
																			}
																			if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																				_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
																			MonstrousWorldMod.queueServerWork(1, () -> {
																				MonstrousWorldMod.queueServerWork(1, () -> {
																					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
																						{
																							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																							_vars.Reputation = -100;
																							_vars.markSyncDirty();
																						}
																					}
																					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
																						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
																							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
																					}
																				});
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
									}
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