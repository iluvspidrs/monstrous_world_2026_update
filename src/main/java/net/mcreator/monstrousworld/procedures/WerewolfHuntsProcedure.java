package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.entity.InfectedGoonEntity;
import net.mcreator.monstrousworld.entity.FollowerWerewolfEntity;
import net.mcreator.monstrousworld.entity.DireWerewolfEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WerewolfHuntsProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
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
		Entity EntityOwner = null;
		EntityOwner = sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null;
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity && sourceentity instanceof ServerPlayer) {
				if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.LUNAR_PULL).getDuration() : 0) >= 1) {
					if ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
						if (sourceentity instanceof Player _player)
							_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 2);
						if (sourceentity instanceof LivingEntity _entity)
							_entity.setHealth((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 2);
					}
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HasArtifact == false) {
							{
								Entity _ent = sourceentity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("feral_werewolf_kills");
								if (_so == null)
									_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("feral_werewolf_kills", sourceentity) + 1);
							}
							if (getEntityScore("feral_werewolf_kills", sourceentity) >= 50 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 0) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 1;
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
									_vars.markSyncDirty();
								}
								sourceentity.getPersistentData().putDouble("feral_werewolf_message_1", (world.dayTime() + 200));
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = -100;
										_vars.markSyncDirty();
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
								}
							}
							if (getEntityScore("feral_werewolf_kills", sourceentity) >= 150 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 1) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 2;
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
									_vars.markSyncDirty();
								}
								sourceentity.getPersistentData().putDouble("feral_werewolf_message_2", (world.dayTime() + 200));
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = -100;
										_vars.markSyncDirty();
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
								}
							}
							if (getEntityScore("feral_werewolf_kills", sourceentity) >= 300 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 2) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 3;
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 15;
									_vars.markSyncDirty();
								}
								sourceentity.getPersistentData().putDouble("feral_werewolf_message_3", (world.dayTime() + 200));
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = -100;
										_vars.markSyncDirty();
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
								}
							}
							if (getEntityScore("feral_werewolf_kills", sourceentity) >= 500 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 3) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 4;
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 15;
									_vars.markSyncDirty();
								}
								sourceentity.getPersistentData().putDouble("feral_werewolf_message_4", (world.dayTime() + 200));
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = -100;
										_vars.markSyncDirty();
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
								}
							}
							if (getEntityScore("feral_werewolf_kills", sourceentity) >= 750 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 4) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 5;
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 20;
									_vars.markSyncDirty();
								}
								sourceentity.getPersistentData().putDouble("feral_werewolf_message_5", (world.dayTime() + 200));
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = -100;
										_vars.markSyncDirty();
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
								}
							}
							if (getEntityScore("feral_werewolf_kills", sourceentity) >= 1100 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 5) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 6;
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 20;
									_vars.markSyncDirty();
								}
								sourceentity.getPersistentData().putDouble("feral_werewolf_message_6", (world.dayTime() + 200));
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = -100;
										_vars.markSyncDirty();
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
								}
							}
						} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HasArtifact == true) {
							if (Math.random() > 0.99) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.HasArtifact = false;
									_vars.markSyncDirty();
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your protective bracelet has broken..."), false);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
									_vars.markSyncDirty();
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = -100;
										_vars.markSyncDirty();
									}
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
								}
							}
						}
					}
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
							{
								Entity _ent = sourceentity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Kills");
								if (_so == null)
									_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Kills", sourceentity) + 1);
							}
							if (getEntityScore("Kills", sourceentity) >= 30) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FactionLevel = 2;
									_vars.markSyncDirty();
								}
								sourceentity.getPersistentData().putDouble("werewolf_message_2", (world.dayTime() + 200));
								sourceentity.getPersistentData().putDouble("werewolf_keybind_message", (world.dayTime() + 300));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									Entity _ent = sourceentity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Kills");
									if (_so == null)
										_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You advance a level!"), true);
							}
						}
					}
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							if (entity instanceof AggressiveGuardEntity || entity instanceof SocietyGoonEntity || entity instanceof InfectedGoonEntity) {
								{
									Entity _ent = sourceentity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Kills");
									if (_so == null)
										_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Kills", sourceentity) + 1);
								}
								if (getEntityScore("Kills", sourceentity) >= 10) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 3;
										_vars.markSyncDirty();
									}
									if (sourceentity instanceof LivingEntity _entity) {
										AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength_3"), 1, AttributeModifier.Operation.ADD_VALUE);
										if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
											_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
										}
									}
									if (sourceentity instanceof LivingEntity _entity) {
										AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_safe_fall"), 2, AttributeModifier.Operation.ADD_VALUE);
										if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
											_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
										}
									}
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:respect_must_be_earned"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You advance a level!"), true);
									{
										Entity _ent = sourceentity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Kills");
										if (_so == null)
											_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
								}
							}
						}
					}
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
							if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.LUNAR_PULL).getDuration() : 0) >= 1) {
								if (Math.random() >= 0.9) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(MonstrousWorldModItems.ALPHA_CLAW.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
							}
						}
					}
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
							if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.LUNAR_PULL).getDuration() : 0) >= 1) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 300) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 6;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = sourceentity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Kills");
										if (_so == null)
											_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You advance a level!"), true);
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:unlimited_beast"));
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
			if (entity instanceof DireWerewolfEntity && sourceentity instanceof ServerPlayer) {
				if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.LUNAR_PULL).getDuration() : 0) >= 1) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.FactionLevel = 5;
								_vars.markSyncDirty();
							}
							{
								Entity _ent = sourceentity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Kills");
								if (_so == null)
									_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You advance a level!"), true);
							if (sourceentity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:territorial"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed_5"), 0.05, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
								}
							}
						}
					}
				}
			}
			if (entity instanceof DireWerewolfEntity && sourceentity instanceof FollowerWerewolfEntity) {
				if ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
					if ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = (sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
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
						{
							Entity _ent = (sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null);
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Kills");
							if (_so == null)
								_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						if ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You advance a level!"), true);
						if ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:territorial"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed_5"), 0.05, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
							}
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 300 && sourceentity instanceof FollowerWerewolfEntity) {
				if (EntityOwner.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
					if (EntityOwner.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = EntityOwner.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.FactionLevel = 6;
							_vars.markSyncDirty();
						}
						{
							Entity _ent = EntityOwner;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Kills");
							if (_so == null)
								_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
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