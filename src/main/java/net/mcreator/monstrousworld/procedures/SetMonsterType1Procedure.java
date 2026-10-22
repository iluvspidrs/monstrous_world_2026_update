package net.mcreator.monstrousworld.procedures;

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
import net.minecraft.tags.ItemTags;
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

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class SetMonsterType1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if ((StringArgumentType.getString(arguments, "monster_type")).equals("fly_mutant")) {
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterType = 1;
							_vars.ZombieInfection = 0;
							_vars.WerewolfInfectionTimer = 0;
							_vars.VampireInfection = 0;
							_vars.Zombify = 0;
							_vars.markSyncDirty();
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flyspeed"), 0.05, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flygravity"), (-0.04), AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
							if (!_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flysafefall"), 1024, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						entityiterator.getPersistentData().putBoolean("Monstrous World Fly", true);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = false;
							_vars.DarknessInfectable = false;
							_vars.markSyncDirty();
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:havent_you_seen"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is lost until you cure your mutation..."), false);
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
								}
							}
						}
					} else {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Player must be human for this command to work. Try /setmonstertype <player> none   or /setmonsterclass <player> 0   first before using command"), false);
					}
				}
				if ((StringArgumentType.getString(arguments, "monster_type")).equals("eye_mutant")) {
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is lost until you cure your mutation..."), false);
						}
						entityiterator.getPersistentData().putDouble("fear_countdown", 0);
						entityiterator.getPersistentData().putDouble("insanity_timer", 0);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterType = 2;
							_vars.ZombieInfection = 0;
							_vars.WerewolfInfectionTimer = 0;
							_vars.VampireInfection = 0;
							_vars.Zombify = 0;
							_vars.markSyncDirty();
						}
						entityiterator.getPersistentData().putBoolean("Monstrous World Eye", true);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = false;
							_vars.DarknessInfectable = false;
							_vars.markSyncDirty();
						}
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
								}
							}
						}
					} else {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Player must be human for this command to work. Try /setmonstertype <player> none   or /setmonsterclass <player> 0   first before using command"), false);
					}
				}
				if ((StringArgumentType.getString(arguments, "monster_type")).equals("serpent_mutant")) {
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is lost until you cure your mutation..."), false);
						}
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterType = 3;
							_vars.ZombieInfection = 0;
							_vars.WerewolfInfectionTimer = 0;
							_vars.VampireInfection = 0;
							_vars.Zombify = 0;
							_vars.markSyncDirty();
						}
						entityiterator.getPersistentData().putBoolean("Monstrous World Serpent", true);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = false;
							_vars.DarknessInfectable = false;
							_vars.markSyncDirty();
						}
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:serpentarmor"), 8, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:serpentattack"), 1, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
							}
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
							}
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						{
							Entity _entity = entityiterator;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
								}
							}
						}
					} else {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Player must be human for this command to work. Try /setmonstertype <player> none   or /setmonsterclass <player> 0   first before using command"), false);
					}
				}
				if ((StringArgumentType.getString(arguments, "monster_type")).equals("zombie")) {
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
						if (world instanceof Level)
							((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
						if (world instanceof Level)
							((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.ambient")), SoundSource.NEUTRAL, 1, 1, false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.VampireInfection = 0;
							_vars.WerewolfInfectionTimer = 0;
							_vars.Bloodlevel = -1;
							_vars.Possession = 0;
							_vars.MonsterType = 4;
							_vars.Reputation = -50;
							_vars.Zombify = 0;
							_vars.Slower_Movement = 0;
							_vars.More_Nightmares = 0;
							_vars.No_Defense = 0;
							_vars.markSyncDirty();
						}
						entityiterator.getPersistentData().putDouble("lev_possessed", 0);
						entityiterator.getPersistentData().putDouble("dark_possessed", 0);
						entityiterator.getPersistentData().putDouble("fear_countdown", 0);
						entityiterator.getPersistentData().putDouble("insanity_timer", 0);
						entityiterator.getPersistentData().putDouble("helmetTimer", 500);
						entityiterator.getPersistentData().putDouble("ReanimateOverlay", 300);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = false;
							_vars.DarknessInfectable = false;
							_vars.Reputation_Static = true;
							_vars.MonsterInfectable = false;
							_vars.markSyncDirty();
						}
						entityiterator.getPersistentData().putBoolean("Monstrous World Zombie", true);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.REANIMATED, 300, 0, false, false));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.HYPNOSIS);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ENCHANTED);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.CRAZED);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:zombie_movement_speed"), (-0.02), AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:zombie_oxygen_bonus"), 1024, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.OXYGEN_BONUS).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.OXYGEN_BONUS).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74You reanimate and rise as a zombie!"), false);
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is lost until you are cured..."), false);
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:every_hunters_worst_nightmare"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
								}
							}
						}
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								Entity _entity = entityiterator;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
								}
							}
						}
					} else {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Player must be human for this command to work. Try /setmonstertype <player> none   or /setmonsterclass <player> 0   first before using command"), false);
					}
				}
				if ((StringArgumentType.getString(arguments, "monster_type")).equals("infected_werewolf")) {
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cYou feel very strange as a growl emerges from your throat..."), false);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wolf.growl")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wolf.growl")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterType = 5;
							_vars.VampireInfection = 0;
							_vars.WerewolfInfectionTimer = 0;
							_vars.ZombieInfection = 0;
							_vars.Zombify = 0;
							_vars.markSyncDirty();
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfspeed"), 0.02, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfstrength"), 1, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_EFFECT, 24000, 0, true, false));
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
						entityiterator.getPersistentData().putBoolean("Monstrous World Werewolf", true);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = false;
							_vars.DarknessInfectable = false;
							_vars.markSyncDirty();
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:every_hunters_worst_nightmare"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is lost until you cure yourself..."), false);
						}
					} else {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Player must be human for this command to work. Try /setmonstertype <player> none   or /setmonsterclass <player> 0   first before using command"), false);
					}
				}
				if ((StringArgumentType.getString(arguments, "monster_type")).equals("infected_vampire")) {
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
						if (world instanceof Level)
							((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.ZombieInfection = 0;
							_vars.Possession = 0;
							_vars.Zombify = 0;
							_vars.MonsterType = 6;
							_vars.markSyncDirty();
						}
						entityiterator.getPersistentData().putDouble("fear_countdown", 0);
						entityiterator.getPersistentData().putDouble("lev_possessed", 0);
						entityiterator.getPersistentData().putDouble("dark_possessed", 0);
						entityiterator.getPersistentData().putDouble("insanity_timer", 0);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = false;
							_vars.DarknessInfectable = false;
							_vars.markSyncDirty();
						}
						entityiterator.getPersistentData().putBoolean("Monstrous World Vampire", true);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
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
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.HYPNOSIS);
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"), 0.5, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength"), 3, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampiremovementspeed"), 0.02, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireoxygenbonus"), 1024, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.OXYGEN_BONUS).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.OXYGEN_BONUS).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"), 15, AttributeModifier.Operation.ADD_VALUE);
							if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
								_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
							}
						}
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74The thirst has overtaken you..."), false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.BloodBar = 20;
							_vars.Bloodlevel = -1;
							_vars.markSyncDirty();
						}
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is lost until you cure yourself..."), false);
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:every_hunters_worst_nightmare"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					} else {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Player must be human for this command to work. Try /setmonstertype <player> none   or /setmonsterclass <player> 0   first before using command"), false);
					}
				}
				if ((StringArgumentType.getString(arguments, "monster_type")).equals("none")) {
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterType = 0;
							_vars.Reputation = 0;
							_vars.DarknessInfectable = true;
							_vars.MonsterInfectable = true;
							_vars.markSyncDirty();
						}
					}
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 7) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.FeralLevel = 0;
							_vars.markSyncDirty();
						}
						if (entityiterator instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfspeed"));
						}
						if (entityiterator instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfstrength"));
						}
						if (entityiterator instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_knockback"));
						}
						if (entityiterator instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_safe_fall"));
						}
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.LUNAR_PULL);
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT);
						entityiterator.getPersistentData().putBoolean("Monstrous World Werewolf", false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.BeastForm = false;
							_vars.MonsterInfectable = true;
							_vars.markSyncDirty();
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
							Entity _ent = entityiterator;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("vengeful_pumpkin");
							if (_so == null)
								_so = _sc.addObjective("vengeful_pumpkin", ObjectiveCriteria.DUMMY, Component.literal("vengeful_pumpkin"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
					}
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRISM);
						if (entityiterator instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"));
						}
						if (entityiterator instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength"));
						}
						if (entityiterator instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampiremovementspeed"));
						}
						if (entityiterator instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.OXYGEN_BONUS).removeModifier(ResourceLocation.parse("monstrous_world:vampireoxygenbonus"));
						}
						if (entityiterator instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"));
						}
						entityiterator.getPersistentData().putBoolean("Monstrous World Vampire", false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.BeastForm = false;
							_vars.MonsterInfectable = true;
							_vars.FeralLevel = 0;
							_vars.BloodBar = -1;
							_vars.Bloodlevel = 12;
							_vars.markSyncDirty();
						}
					}
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is restored!"), false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterInfectable = true;
							_vars.DarknessInfectable = true;
							_vars.Reputation = 0;
							_vars.markSyncDirty();
						}
					}
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.MonsterType = 0;
						_vars.MonsterInfectable = true;
						_vars.markSyncDirty();
					}
					entityiterator.getPersistentData().putBoolean("Monstrous World Zombie", false);
					entityiterator.getPersistentData().putBoolean("Monstrous World Fly", false);
					entityiterator.getPersistentData().putBoolean("Monstrous World Eye", false);
					entityiterator.getPersistentData().putBoolean("Monstrous World Serpent", false);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.DRY_EYE);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.COLD_BLOODED);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.NIGHT_VISION);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.EYE_EFFECT);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.SERPENT_EFFECT);
					if (entityiterator instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
					}
					if (entityiterator instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("monstrous_world:flygravity"));
					}
					if (entityiterator instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).removeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"));
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
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:zombie_movement_speed"));
					}
					if (entityiterator instanceof LivingEntity _entity) {
						_entity.getAttribute(Attributes.OXYGEN_BONUS).removeModifier(ResourceLocation.parse("monstrous_world:zombie_oxygen_bonus"));
					}
					{
						Entity _ent = entityiterator;
						Scoreboard _sc = _ent.level().getScoreboard();
						Objective _so = _sc.getObjective("feral_werewolf_kills");
						if (_so == null)
							_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
						_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
					}
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}