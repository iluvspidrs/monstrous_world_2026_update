package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetFactionLevel1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (DoubleArgumentType.getDouble(arguments, "faction_level") == 1 || DoubleArgumentType.getDouble(arguments, "faction_level") == 2 || DoubleArgumentType.getDouble(arguments, "faction_level") == 3
						|| DoubleArgumentType.getDouble(arguments, "faction_level") == 4 || DoubleArgumentType.getDouble(arguments, "faction_level") == 5 || DoubleArgumentType.getDouble(arguments, "faction_level") == 6) {
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.FactionLevel = DoubleArgumentType.getDouble(arguments, "faction_level");
							_vars.markSyncDirty();
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 && entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _ent = entityiterator;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("werewolf_ability");
								if (_so == null)
									_so = _sc.addObjective("werewolf_ability", ObjectiveCriteria.DUMMY, Component.literal("werewolf_ability"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
							}
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Possession = 3;
								_vars.FactionLevel = 6;
								_vars.Dark_Message_Timer = Mth.nextInt(RandomSource.create(), 20000, 24000);
								_vars.Reputation = -100;
								_vars.MonsterType = 0;
								_vars.Zombify = 0;
								_vars.ZombieInfection = 0;
								_vars.VampireInfection = 0;
								_vars.MonsterType = 0;
								_vars.BloodBar = -1;
								_vars.Bloodlevel = 12;
								_vars.More_Nightmares = 0;
								_vars.Slower_Movement = 0;
								_vars.No_Defense = 0;
								_vars.markSyncDirty();
							}
							entityiterator.getPersistentData().putDouble("lev_possessed", 0);
							entityiterator.getPersistentData().putDouble("dark_possessed", 0);
							entityiterator.getPersistentData().putDouble("insanity_timer", 0);
							MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed = true;
							MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.BeastForm = false;
								_vars.MonsterInfectable = false;
								_vars.Reputation_Static = true;
								_vars.markSyncDirty();
							}
							entityiterator.getPersistentData().putBoolean("can_kill_maniac", true);
							entityiterator.getPersistentData().putBoolean("Monstrous World Werewolf", false);
							entityiterator.getPersistentData().putBoolean("Monstrous World Vampire", false);
							entityiterator.getPersistentData().putBoolean("Monstrous World Zombie", false);
							entityiterator.getPersistentData().putBoolean("Monstrous World Fly", false);
							entityiterator.getPersistentData().putBoolean("Monstrous World Eye", false);
							entityiterator.getPersistentData().putBoolean("Monstrous World Serpent", false);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_knockback"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfspeed"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:darkness_speed"), 0.05, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
								}
							}
							if (entityiterator instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:darkness_armor"), 10, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
								}
							}
							if (entityiterator instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:darkness_damage"), 4, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
								}
							}
							if (entityiterator instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:darkness_knockback_resistance"), 2, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addPermanentModifier(modifier);
								}
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0, false, false));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 220, 0, false, false));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 0, false, false));
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_darkened_crown"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A75Incredible darkness surges through you...you are possessed!"), false);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfstrength"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("monstrous_world:flygravity"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:flysafefall"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:serpentarmor"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:serpentattack"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampiremovementspeed"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.OXYGEN_BONUS).removeModifier(ResourceLocation.parse("monstrous_world:vampireoxygenbonus"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"));
							}
						} else {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Possession = 0;
								_vars.markSyncDirty();
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:darkness_speed"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:darkness_armor"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_damage"));
							}
							if (entityiterator instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_knockback_resistance"));
							}
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER);
							if (entityiterator instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.BLACKOUT);
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_HELMET.get()) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
									}
								}
							}
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:goblinsneak4"), 0.1, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.SNEAKING_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.SNEAKING_SPEED).addPermanentModifier(modifier);
									}
								}
							}
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterstrength2"), 4, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor2"), 4, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterswimspeed4"), 0.2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterunderwaterminingspeed4"), 0.2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor4"), 2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterswimspeed5"), 0.2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterunderwaterminingspeed5"), 0.2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor5"), 2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor6"), 2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
							}
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength_3"), 1, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_jump_3"), 0.3, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.JUMP_STRENGTH).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.JUMP_STRENGTH).addPermanentModifier(modifier);
									}
								}
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength_4"), 1, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed_4"), 0.01, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
									}
								}
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_jump_5"), 0.03, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.JUMP_STRENGTH).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.JUMP_STRENGTH).addPermanentModifier(modifier);
									}
								}
							}
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
								if (getEntityScore("vampire_strike", entityiterator) == 1) {
									if (entityiterator instanceof LivingEntity _entity) {
										AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampire_amulet_attack"), 1, AttributeModifier.Operation.ADD_VALUE);
										if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
											_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
										}
									}
								}
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor3"), 5, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength3"), 2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"), 3, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"), 2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
							}
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
							if (entityiterator instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_strength"), 4, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
								}
							}
							if (entityiterator instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_resistance"), 4, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
								}
							}
							entityiterator.getPersistentData().putBoolean("can_kill_maniac", true);
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_strength_2"), 2, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_armor_4"), 4, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
							}
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_armor_6"), 4, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
							}
						}
					} else {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This player does not have a faction"), false);
					}
				} else {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Not a valid faction number"), false);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
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