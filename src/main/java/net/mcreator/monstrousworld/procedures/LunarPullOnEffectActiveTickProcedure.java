package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class LunarPullOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
				if (world.dimensionType().moonPhase(world.dayTime()) == 0 && world.dayTime() % 24000 >= 13000) {
					if ((entity.level().dimension()) == Level.OVERWORLD) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.LUNAR_PULL, 100, 0));
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.LUNAR_PULL, 100, 0));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.LUNAR_PULL).getDuration() : 0) == 1) {
					MonstrousWorldMod.queueServerWork(1, () -> {
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
						entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 220, 1));
					if (entity instanceof Player _player)
						_player.getFoodData().setSaturation(0);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel < 4) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 220, 1));
					if (entity instanceof Player _player)
						_player.getFoodData().setSaturation(0);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 220, 0));
						if (entity instanceof Player _player)
							_player.getFoodData().setSaturation(0);
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 220, 2));
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel <= 2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 220, 2));
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 220, 2));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2));
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.DAMAGE_BOOST);
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_monster_calls"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.LUNAR_PULL).getDuration() : 0) == 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 7) {
						if (entity.getPersistentData().getDouble("pearl_strength") == 1) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 0) {
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("feral_werewolf_kills");
									if (_so == null)
										_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(51);
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Using the Lunar Pearl has strengthened your inner beast! Extreme hunger now makes you transform!"), false);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 1;
									_vars.markSyncDirty();
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 1) {
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("feral_werewolf_kills");
									if (_so == null)
										_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(151);
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Using the Lunar Pearl has strengthened your inner beast! You begin to sometimes transform when attacked!"), false);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 2;
									_vars.markSyncDirty();
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 2) {
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("feral_werewolf_kills");
									if (_so == null)
										_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(301);
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Using the Lunar Pearl has strengthened your inner beast! Eating anything besides meat makes you transform!"), false);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 3;
									_vars.markSyncDirty();
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 3) {
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("feral_werewolf_kills");
									if (_so == null)
										_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(501);
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("The Lunar Pearl has strengthened your inner beast further. You transform more often when attacked!"), false);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 4;
									_vars.markSyncDirty();
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 4) {
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("feral_werewolf_kills");
									if (_so == null)
										_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(751);
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("The Lunar Pearl has strengthened your inner beast further. You find yourself in beast form more than ever!"), false);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 5;
									_vars.markSyncDirty();
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 5) {
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("feral_werewolf_kills");
									if (_so == null)
										_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1101);
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("The Lunar Pearl has strengthened your inner beast further. Your transformations grow very frequent..."), false);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FeralLevel = 6;
									_vars.markSyncDirty();
								}
							}
							entity.getPersistentData().putDouble("pearl_strength", 0);
						}
						entity.getPersistentData().putDouble("pearl_strength", 0);
					}
					entity.getPersistentData().putDouble("pearl_strength", 0);
				}
			}
		}
	}
}