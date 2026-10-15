package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
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
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.ArrayList;

public class UltimateTomeOfExorcismRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).DarknessInfectable == true && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 0
					&& !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MonstrousWorldModMobEffects.POSSESSED)) && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.POSSESSED_2))) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("This Tome cannot help you right now..."), true);
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3 || entity.getPersistentData().getDouble("lev_possessed") >= 1 || entity.getPersistentData().getDouble("dark_possessed") >= 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3) {
					MonstrousWorldMod.queueServerWork(1, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("The evil presence within is sent back to the abyss, though you remain connected..."), false);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						entity.getPersistentData().putDouble("lev_possessed", 0);
						entity.getPersistentData().putDouble("dark_possessed", 0);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Possession = 0;
							_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 100;
							_vars.FactionLevel = 5;
							_vars.Dark_Message_Timer = 21000;
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_purge"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_ultimate_exorcism"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.BLACKOUT);
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
						entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
						if (entity instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:darkness_speed"));
						}
						if (entity instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:darkness_armor"));
						}
						if (entity instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_damage"));
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
							}
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Night Vision");
							if (_so == null)
								_so = _sc.addObjective("Night Vision", ObjectiveCriteria.DUMMY, Component.literal("Night Vision"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Serpent DNA");
							if (_so == null)
								_so = _sc.addObjective("Serpent DNA", ObjectiveCriteria.DUMMY, Component.literal("Serpent DNA"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Food Tolerance");
							if (_so == null)
								_so = _sc.addObjective("Food Tolerance", ObjectiveCriteria.DUMMY, Component.literal("Food Tolerance"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed = false;
						MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Reputation_Static = false;
							_vars.markSyncDirty();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.MonsterInfectable = true;
								_vars.markSyncDirty();
							}
						}
					});
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("The evil entity flees from your body!"), false);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_purge"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Possession = 0;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putDouble("lev_possessed", 0);
					entity.getPersistentData().putDouble("dark_possessed", 0);
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Reputation_Static = false;
							_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 50;
							_vars.markSyncDirty();
						}
					} else {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Reputation = -50;
							_vars.markSyncDirty();
						}
					}
					MonstrousWorldMod.queueServerWork(1, () -> {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Reputation = 100;
								_vars.markSyncDirty();
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
						}
					});
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).DarknessInfectable == false || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == false) {
				SetScoresToZeroProcedure.execute(world, entity);
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.MonsterInfectable = true;
					_vars.Disguised = false;
					_vars.markSyncDirty();
				}
				entity.getPersistentData().putBoolean("Monstrous World Witch", false);
				entity.getPersistentData().putBoolean("Monstrous World Goblin", false);
				entity.getPersistentData().putBoolean("Monstrous World Troll", false);
				entity.getPersistentData().putBoolean("Monstrous World Sorcerer", false);
				entity.getPersistentData().putBoolean("Monstrous World Mad Scientist", false);
				entity.getPersistentData().putBoolean("Monstrous World Swamp Monster", false);
				entity.getPersistentData().putBoolean("Monstrous World Werewolf", false);
				entity.getPersistentData().putBoolean("Monstrous World Vampire", false);
				entity.getPersistentData().putBoolean("Monstrous World Darkness Wielder", false);
				entity.getPersistentData().putBoolean("Monstrous World Demon", false);
				entity.getPersistentData().putBoolean("Monstrous World Evil Clown", false);
				entity.getPersistentData().putBoolean("Monstrous World Maniac", false);
				entity.getPersistentData().putBoolean("Monstrous World Fly", false);
				entity.getPersistentData().putBoolean("Monstrous World Eye", false);
				entity.getPersistentData().putBoolean("Monstrous World Serpent", false);
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_purge"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_GLOW);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_CURE);
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:serpentarmor"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:serpentattack"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).removeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:zombie_movement_speed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.OXYGEN_BONUS).removeModifier(ResourceLocation.parse("monstrous_world:zombie_oxygen_bonus"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:flysafefall"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("monstrous_world:flygravity"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).removeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:serpentarmor"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:serpentattack"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:goblinspeed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.SNEAKING_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:goblinsneak"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.SNEAKING_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:goblinsneak4"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.OXYGEN_BONUS).removeModifier(ResourceLocation.parse("monstrous_world:vampireoxygenbonus"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampiremovementspeed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampire_amulet_attack"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor3"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength3"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterwatermovement"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.OXYGEN_BONUS).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsteroxygenbonus"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:swampmonstersubmergedminingspeed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterstrength2"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor2"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(NeoForgeMod.SWIM_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterswimspeed4"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterunderwaterminingspeed4"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor4"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor5"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterarmor6"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterunderwaterminingspeed5"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(NeoForgeMod.SWIM_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:swampmonsterswimspeed5"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed_4"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength_4"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength_3"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.JUMP_STRENGTH).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_jump_3"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed_5"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_knockback"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:feral_werewolf_speed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:feral_werewolf_strength"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_damage"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:darkness_speed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:darkness_armor"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:darkness_knockback_resistance"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:troll_attack_strength"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:troll_resistance"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(ResourceLocation.parse("monstrous_world:troll_knockback"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MINING_EFFICIENCY).removeModifier(ResourceLocation.parse("monstrous_world:troll_mining_speed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:demon_armor"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:demon_safe_fall"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("monstrous_world:demon_gravity"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(NeoForgeMod.SWIM_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:demon_swim_speed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.BURNING_TIME).removeModifier(ResourceLocation.parse("monstrous_world:demon_no_burn"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:maniac_strength"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:maniac_resistance"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:maniac_strength_2"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:maniac_strength_4"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:maniac_armor_4"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:maniac_armor_6"));
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRISM);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.GOBLIN_EFFECT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.WITCH_EFFECT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.SWAMPMONSTER_EFFECT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH_COUNTDOWN);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.BLACKOUT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_GLOW);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_CURE);
				entity.getPersistentData().putDouble("ChilledTimer", 0);
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("Night Vision");
					if (_so == null)
						_so = _sc.addObjective("Night Vision", ObjectiveCriteria.DUMMY, Component.literal("Night Vision"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
				}
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("Serpent DNA");
					if (_so == null)
						_so = _sc.addObjective("Serpent DNA", ObjectiveCriteria.DUMMY, Component.literal("Serpent DNA"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
				}
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("Food Tolerance");
					if (_so == null)
						_so = _sc.addObjective("Food Tolerance", ObjectiveCriteria.DUMMY, Component.literal("Food Tolerance"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
				}
				if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear"))))) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_locked")))) {
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_BOOTS.get()) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, ItemStack.EMPTY);
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
				if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear"))))) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_locked")))) {
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_LEGGINGS.get()) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, ItemStack.EMPTY);
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
				if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear"))))) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_locked")))) {
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_CHESTPLATE.get()) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, ItemStack.EMPTY);
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
				if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear"))))) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_locked")))) {
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_HELMET.get()) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, ItemStack.EMPTY);
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
				entity.getPersistentData().putDouble("MutationType", 0);
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 9) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("All darkness and monstrous conditions have been removed!"), false);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_purge"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
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
						Objective _so = _sc.getObjective("Night Vision");
						if (_so == null)
							_so = _sc.addObjective("Night Vision", ObjectiveCriteria.DUMMY, Component.literal("Night Vision"), ObjectiveCriteria.RenderType.INTEGER, true, null);
						_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
					}
					{
						Entity _ent = entity;
						Scoreboard _sc = _ent.level().getScoreboard();
						Objective _so = _sc.getObjective("Serpent DNA");
						if (_so == null)
							_so = _sc.addObjective("Serpent DNA", ObjectiveCriteria.DUMMY, Component.literal("Serpent DNA"), ObjectiveCriteria.RenderType.INTEGER, true, null);
						_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
					}
					{
						Entity _ent = entity;
						Scoreboard _sc = _ent.level().getScoreboard();
						Objective _so = _sc.getObjective("Food Tolerance");
						if (_so == null)
							_so = _sc.addObjective("Food Tolerance", ObjectiveCriteria.DUMMY, Component.literal("Food Tolerance"), ObjectiveCriteria.RenderType.INTEGER, true, null);
						_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
					}
					entity.getPersistentData().putDouble("MutationType", 0);
					entity.getPersistentData().putDouble("ChilledTimer", 0);
					MonstrousWorldModVariables.MapVariables.get(world).TeamResetTimer = 5;
					MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Magic_Type = 0;
						_vars.MonsterType = 0;
						_vars.MonsterClass = 0;
						_vars.FactionLevel = 0;
						_vars.VampireInfection = 0;
						_vars.ZombieInfection = 0;
						_vars.DarknessTimer = 0;
						_vars.Bloodlevel = 12;
						_vars.BloodBar = -1;
						_vars.Reputation = 0;
						_vars.MurkanusMarth = 0;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:serpentarmor"));
					}
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:serpentattack"));
					}
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
					}
					if (entity instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).removeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"));
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRISM);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WITCH_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.GOBLIN_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.SWAMPMONSTER_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH_COUNTDOWN);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_GLOW);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_CURE);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.DarknessInfectable = true;
						_vars.AssistantsAreOut = false;
						_vars.BeastForm = false;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
					if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 0) {
						if (MonstrousWorldConfigConfiguration.ENABLE_NIGHTMARE_MODE.get() == true) {
							MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World = 1;
							MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:shame_shame"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							for (Entity entityiterator : new ArrayList<>(world.players())) {
								MonstrousWorldMod.queueServerWork(200, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Someone has rejected my dark gift..."), false);
								});
								MonstrousWorldMod.queueServerWork(400, () -> {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75I unleash greater horrors upon you all!"), false);
									if (!(world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ()))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
										{
											BlockPos _bp = BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ());
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									}
									if (!(world.getBlockState(BlockPos.containing(entityiterator.getX() + 1, entityiterator.getY() - 1, entityiterator.getZ()))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
										{
											BlockPos _bp = BlockPos.containing(entityiterator.getX() + 1, entityiterator.getY() - 1, entityiterator.getZ());
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									}
									if (!(world.getBlockState(BlockPos.containing(entityiterator.getX() - 1, entityiterator.getY() - 1, entityiterator.getZ()))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
										{
											BlockPos _bp = BlockPos.containing(entityiterator.getX() - 1, entityiterator.getY() - 1, entityiterator.getZ());
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									}
									if (!(world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() - 1))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
										{
											BlockPos _bp = BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() - 1);
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									}
									if (!(world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() + 1))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
										{
											BlockPos _bp = BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() + 1);
											BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
											BlockState _bso = world.getBlockState(_bp);
											for (Property<?> _propertyOld : _bso.getProperties()) {
												Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
												if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
													try {
														_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
													} catch (Exception e) {
													}
											}
											world.setBlock(_bp, _bs, 3);
										}
									}
									MonstrousWorldMod.queueServerWork(80, () -> {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.EvilFaction = 1;
											_vars.markSyncDirty();
										}
									});
								});
							}
						}
					}
				} else {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel <= 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("All darkness and monstrous conditions have been removed!"), false);
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
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
							Objective _so = _sc.getObjective("Night Vision");
							if (_so == null)
								_so = _sc.addObjective("Night Vision", ObjectiveCriteria.DUMMY, Component.literal("Night Vision"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Serpent DNA");
							if (_so == null)
								_so = _sc.addObjective("Serpent DNA", ObjectiveCriteria.DUMMY, Component.literal("Serpent DNA"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Food Tolerance");
							if (_so == null)
								_so = _sc.addObjective("Food Tolerance", ObjectiveCriteria.DUMMY, Component.literal("Food Tolerance"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						entity.getPersistentData().putDouble("ChilledTimer", 0);
						MonstrousWorldModVariables.MapVariables.get(world).TeamResetTimer = 5;
						MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
						entity.getPersistentData().putDouble("MutationType", 0);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Bloodlevel = 12;
							_vars.BloodBar = -1;
							_vars.MonsterType = 0;
							_vars.MonsterClass = 0;
							_vars.FactionLevel = 0;
							_vars.VampireInfection = 0;
							_vars.ZombieInfection = 0;
							_vars.DarknessTimer = 0;
							_vars.Reputation = 0;
							_vars.DarknessInfectable = true;
							_vars.MonsterInfectable = true;
							_vars.AssistantsAreOut = false;
							_vars.BeastForm = false;
							_vars.markSyncDirty();
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRISM);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_GLOW);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.UNDEAD_CURE);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WITCH_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.GOBLIN_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.BLACKOUT);
						if (entity instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:serpentarmor"));
						}
						if (entity instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:serpentattack"));
						}
						if (entity instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
						}
						if (entity instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).removeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"));
						}
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
						entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
						if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear"))))) {
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_locked")))) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear"))))) {
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_locked")))) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear"))))) {
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_locked")))) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear"))))) {
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_locked")))) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 0) {
							if (MonstrousWorldConfigConfiguration.ENABLE_NIGHTMARE_MODE.get() == true) {
								MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World = 1;
								MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:shame_shame"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								for (Entity entityiterator : new ArrayList<>(world.players())) {
									MonstrousWorldMod.queueServerWork(200, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entityiterator instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A75Someone has rejected my dark gift..."), false);
									});
									MonstrousWorldMod.queueServerWork(400, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entityiterator instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A75I unleash greater horrors upon you all!"), false);
										if (!(world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ()))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
											{
												BlockPos _bp = BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ());
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if (!(world.getBlockState(BlockPos.containing(entityiterator.getX() + 1, entityiterator.getY() - 1, entityiterator.getZ()))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
											{
												BlockPos _bp = BlockPos.containing(entityiterator.getX() + 1, entityiterator.getY() - 1, entityiterator.getZ());
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if (!(world.getBlockState(BlockPos.containing(entityiterator.getX() - 1, entityiterator.getY() - 1, entityiterator.getZ()))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
											{
												BlockPos _bp = BlockPos.containing(entityiterator.getX() - 1, entityiterator.getY() - 1, entityiterator.getZ());
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if (!(world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() - 1))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
											{
												BlockPos _bp = BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() - 1);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if (!(world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() + 1))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
											{
												BlockPos _bp = BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ() + 1);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										MonstrousWorldMod.queueServerWork(80, () -> {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.EvilFaction = 1;
												_vars.markSyncDirty();
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