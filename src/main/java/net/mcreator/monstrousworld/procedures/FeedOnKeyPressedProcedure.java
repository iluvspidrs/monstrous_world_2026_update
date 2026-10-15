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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.*;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class FeedOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if ((entityiterator.getPersistentData().getString("hypnosis")).equals(entity.getStringUUID())) {
							if ((entity.getPersistentData().getString("victim")).equals(entityiterator.getStringUUID())) {
								if (!(entity.getPersistentData().getDouble("biteCooldown") >= 1)) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar < 20) {
										entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())));
										{
											Entity _ent = entity;
											double _tx = (entityiterator.getX());
											double _ty = (entityiterator.getY());
											double _tz = (entityiterator.getZ());
											_ent.teleportTo(_tx, _ty, _tz);
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 0));
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLOOD_RECOVERY, 24000, 0));
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar + 1;
											_vars.markSyncDirty();
										}
										entityiterator.getPersistentData().putDouble("BloodLevel", (entityiterator.getPersistentData().getDouble("BloodLevel") - 1));
										entity.getPersistentData().putDouble("biteCooldown", 20);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.VictimBloodLevel = entityiterator.getPersistentData().getDouble("BloodLevel");
											_vars.markSyncDirty();
										}
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (Math.random() <= 0.25) {
												entityiterator.getPersistentData().putDouble("BloodLevel", (entityiterator.getPersistentData().getDouble("BloodLevel") - entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel));
											}
										});
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
											if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human"))) || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0
													|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4
													|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9
													|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
													if (getEntityScore("ordinary_blood", entity) == 0) {
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("ordinary_blood");
															if (_so == null)
																_so = _sc.addObjective("ordinary_blood", ObjectiveCriteria.DUMMY, Component.literal("ordinary_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
														}
														{
															Entity _ent = entity;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("Faction Points");
															if (_so == null)
																_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
														}
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
															if (getEntityScore("Faction Points", entity) >= 5) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 2;
																	_vars.markSyncDirty();
																}
																if (world instanceof Level _level) {
																	if (!_level.isClientSide()) {
																		_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																	} else {
																		_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																	}
																}
																{
																	Entity _ent = entity;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
																}
																if (entity instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("You advance a level!"), false);
																if (entity instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sample_pack"));
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
											if (entityiterator instanceof FeralGoblinEntity || entityiterator instanceof GoblinVillagerEntity || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0));
												if (getEntityScore("goblin_blood", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("goblin_blood");
														if (_so == null)
															_so = _sc.addObjective("goblin_blood", ObjectiveCriteria.DUMMY, Component.literal("goblin_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
														if (getEntityScore("Faction Points", entity) >= 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.FactionLevel = 2;
																_vars.markSyncDirty();
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You advance a level!"), false);
															if (entity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sample_pack"));
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
											if (entityiterator instanceof TrollNPCEntity || entityiterator instanceof FeralMountainTrollEntity || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 1));
												if (getEntityScore("troll_blood", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("troll_blood");
														if (_so == null)
															_so = _sc.addObjective("troll_blood", ObjectiveCriteria.DUMMY, Component.literal("troll_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
														if (getEntityScore("Faction Points", entity) >= 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.FactionLevel = 2;
																_vars.markSyncDirty();
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You advance a level!"), false);
															if (entity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sample_pack"));
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
											if (entityiterator instanceof SwampmonsterVillagerEntity || entityiterator instanceof SwampmonsterChieftanEntity || entityiterator instanceof FeralSwampmonsterEntity
													|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2400, 1));
												if (getEntityScore("swampmonster_blood", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("swampmonster_blood");
														if (_so == null)
															_so = _sc.addObjective("swampmonster_blood", ObjectiveCriteria.DUMMY, Component.literal("swampmonster_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
														if (getEntityScore("Faction Points", entity) >= 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.FactionLevel = 2;
																_vars.markSyncDirty();
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You advance a level!"), false);
															if (entity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sample_pack"));
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
											if (entityiterator instanceof FeralWerewolfEntity || entityiterator instanceof HumanWerewolfEntity || entityiterator instanceof FollowerWerewolfEntity
													|| entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 1));
												if (getEntityScore("werewolf_blood", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("werewolf_blood");
														if (_so == null)
															_so = _sc.addObjective("werewolf_blood", ObjectiveCriteria.DUMMY, Component.literal("werewolf_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
														if (getEntityScore("Faction Points", entity) >= 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.FactionLevel = 2;
																_vars.markSyncDirty();
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You advance a level!"), false);
															if (entity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sample_pack"));
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
											if (entityiterator instanceof MutantEyeEntity || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2) {
												if (getEntityScore("eye_blood", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("eye_blood");
														if (_so == null)
															_so = _sc.addObjective("eye_blood", ObjectiveCriteria.DUMMY, Component.literal("eye_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
														if (getEntityScore("Faction Points", entity) >= 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.FactionLevel = 2;
																_vars.markSyncDirty();
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You advance a level!"), false);
															if (entity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sample_pack"));
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
											if (entityiterator instanceof MutantSerpentEntity || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2400, 1));
												if (getEntityScore("serpent_blood", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("serpent_blood");
														if (_so == null)
															_so = _sc.addObjective("serpent_blood", ObjectiveCriteria.DUMMY, Component.literal("serpent_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
														if (getEntityScore("Faction Points", entity) >= 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.FactionLevel = 2;
																_vars.markSyncDirty();
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You advance a level!"), false);
															if (entity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sample_pack"));
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
											if (entityiterator instanceof FlyMutantEntity || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1) {
												if (getEntityScore("fly_blood", entity) == 0) {
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("fly_blood");
														if (_so == null)
															_so = _sc.addObjective("fly_blood", ObjectiveCriteria.DUMMY, Component.literal("fly_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
													}
													{
														Entity _ent = entity;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
														if (getEntityScore("Faction Points", entity) >= 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.FactionLevel = 2;
																_vars.markSyncDirty();
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																Entity _ent = entity;
																Scoreboard _sc = _ent.level().getScoreboard();
																Objective _so = _sc.getObjective("Faction Points");
																if (_so == null)
																	_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("You advance a level!"), false);
															if (entity instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sample_pack"));
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
								if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar < 20) {
										if (!(entityiterator instanceof LivingEntity _livEnt116 && _livEnt116.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT))) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT, 24000, 0, true, false));
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
												_vars.markSyncDirty();
											}
											MonstrousWorldMod.queueServerWork(1, () -> {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.Reputation = -100;
														_vars.markSyncDirty();
													}
												}
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
												}
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
													if (entity instanceof LivingEntity _entity)
														_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
												}
											});
										}
										if (entityiterator.getPersistentData().getDouble("vampireInfection") >= 23960 && entityiterator.getPersistentData().getDouble("vampireInfection") <= 24000) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel < 6) {
													if (Math.random() > 0.9) {
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Your thirst grows stronger..."), false);
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FeralLevel = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel + 1;
															_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
															_vars.markSyncDirty();
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