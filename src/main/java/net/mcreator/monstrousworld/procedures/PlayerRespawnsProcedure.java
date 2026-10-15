package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerRespawnsProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.WebbedLevel = 0;
				_vars.markSyncDirty();
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.SCALE).removeModifier(ResourceLocation.parse("monstrous_world:webbed_scale"));
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.BeastForm = false;
				_vars.markSyncDirty();
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).DarknessTimer >= 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS, (int) entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).DarknessTimer, 0));
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.BeastForm = false;
					_vars.markSyncDirty();
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:zombie_movement_speed"), (-0.02), AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:zombie_oxygen_bonus"), 1024, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.OXYGEN_BONUS).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.OXYGEN_BONUS).addPermanentModifier(modifier);
					}
				}
				entity.getPersistentData().putDouble("helmetTimer", 500);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6
					&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 10
					&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 11) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.Bloodlevel = 12;
					_vars.markSyncDirty();
				}
			} else {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.Bloodlevel = -1;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 1 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 2) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.Possession = 0;
					_vars.markSyncDirty();
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:goblinsneak"), 0.1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.SNEAKING_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.SNEAKING_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:goblinspeed"), 0.05, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:goblinsneak4"), 0.1, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.SNEAKING_SPEED).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.SNEAKING_SPEED).addPermanentModifier(modifier);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:troll_attack_strength"), 5, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:troll_resistance"), 4, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:troll_knockback"), 1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:troll_mining_speed"), 1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MINING_EFFICIENCY).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MINING_EFFICIENCY).addPermanentModifier(modifier);
					}
				}
				entity.getPersistentData().putBoolean("can_kill_maniac", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterwatermovement"), 0.1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterswimspeed"), 0.1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsteroxygenbonus"), 1024, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.OXYGEN_BONUS).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.OXYGEN_BONUS).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonstersubmergedminingspeed"), 0.4, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterstrength2"), 4, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor2"), 4, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterswimspeed4"), 0.2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
							_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterunderwaterminingspeed4"), 0.2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor4"), 2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterswimspeed5"), 0.2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
							_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterunderwaterminingspeed5"), 0.2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor5"), 2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor6"), 2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed"), 0.02, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength"), 1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength_3"), 1, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_safe_fall"), 2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength_4"), 1, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed_4"), 0.01, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed_5"), 0.01, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
						}
					}
				}
				if (getEntityScore("werewolf_knockback", entity) == 1) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_knockback"), 1, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).addPermanentModifier(modifier);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
				entity.getPersistentData().putDouble("BloodBar", 20);
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.BloodBar = 20;
					_vars.markSyncDirty();
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength"), 3, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"), 0.5, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"), 15, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampiremovementspeed"), 0.02, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireoxygenbonus"), 1024, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.OXYGEN_BONUS).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.OXYGEN_BONUS).addTransientModifier(modifier);
					}
				}
				entity.getPersistentData().putBoolean("can_kill_maniac", true);
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
						if (getEntityScore("vampire_strike", entity) == 1) {
							if (entity instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampire_amulet_attack"), 1, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
						if (entity instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor3"), 5, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
							}
						}
						if (entity instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength3"), 2, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
						if (entity instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 3, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
							}
						}
						if (entity instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
							}
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:darkness_speed"), 0.05, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:darkness_armor"), 10, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:darkness_damage"), 4, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:darkness_knockback_resistance"), 2, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addPermanentModifier(modifier);
					}
				}
				entity.getPersistentData().putBoolean("can_kill_maniac", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.Disguised = false;
					_vars.markSyncDirty();
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_gravity"), (-0.04), AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_swim_speed"), (-0.06), AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_armor"), 10, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_no_burn"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
					if (!_entity.getAttribute(Attributes.BURNING_TIME).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.BURNING_TIME).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_safe_fall"), 1024, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addTransientModifier(modifier);
					}
				}
				entity.getPersistentData().putBoolean("can_kill_maniac", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.BeastForm = false;
					_vars.markSyncDirty();
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("monstrous_world:balloon_gravity"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:balloon_safe_fall"));
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_strength"), 4, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_resistance"), 4, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
					}
				}
				entity.getPersistentData().putBoolean("can_kill_maniac", true);
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_strength_2"), 2, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_armor_4"), 4, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_armor_6"), 4, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flyspeed"), 0.05, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flygravity"), (-0.04), AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"), 0, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flysafefall"), 1024, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
					}
				}
			}
			if (getEntityScore("Food Tolerance", entity) == 1) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flyspeed"), 0.05, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"), 0, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).addPermanentModifier(modifier);
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3 || getEntityScore("Serpent DNA", entity) == 1) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:serpentarmor"), 8, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:serpentattack"), 1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfspeed"), 0.02, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfstrength"), 1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
					}
				}
				if (getEntityScore("werewolf_knockback", entity) == 1) {
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_knockback"), 1, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).addPermanentModifier(modifier);
						}
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
				entity.getPersistentData().putBoolean("can_kill_maniac", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
				entity.getPersistentData().putBoolean("Monstrous World Witch", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
				entity.getPersistentData().putBoolean("Monstrous World Goblin", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
				entity.getPersistentData().putBoolean("Monstrous World Troll", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
				entity.getPersistentData().putBoolean("Monstrous World Sorcerer", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
				entity.getPersistentData().putBoolean("Monstrous World Mad Scientist", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
				entity.getPersistentData().putBoolean("Monstrous World Swamp Monster", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
				entity.getPersistentData().putBoolean("Monstrous World Werewolf", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
				entity.getPersistentData().putBoolean("Monstrous World Vampire", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
				entity.getPersistentData().putBoolean("Monstrous World Demon", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
				entity.getPersistentData().putBoolean("Monstrous World Evil Clown", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
				entity.getPersistentData().putBoolean("Monstrous World Maniac", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
				entity.getPersistentData().putBoolean("Monstrous World Zombie", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1) {
				entity.getPersistentData().putBoolean("Monstrous World Fly", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2) {
				entity.getPersistentData().putBoolean("Monstrous World Eye", true);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
				entity.getPersistentData().putBoolean("Monstrous World Serpent", true);
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