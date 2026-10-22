package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class SetMonsterClass1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (!(StringArgumentType.getString(arguments, "monster_class")).equals("none")) {
					if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.HuntersGuild = false;
								_vars.DarknessInfectable = false;
								_vars.markSyncDirty();
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("witch")) {
								entityiterator.getPersistentData().putBoolean("Monstrous World Witch", true);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WITCH_EFFECT, 24000, 0, true, false));
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = 1;
									_vars.DarknessTimer = 0;
									_vars.FactionLevel = 1;
									_vars.markSyncDirty();
								}
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You gain earthly magic and can now do witchcraft!"), false);
									if (entityiterator instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_witch_is_in"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									MonstrousWorldMod.queueServerWork(300, () -> {
										if (entityiterator instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Find a mentor in a plains village or find a guidebook in Darkened Bookshelves to start your training..."), false);
									});
								}
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("goblin")) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your step quickens as you become a goblin!"), false);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:tricksters_and_treasure"));
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
									_vars.MonsterInfectable = false;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("Monstrous World Goblin", true);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = 2;
									_vars.FactionLevel = 1;
									_vars.VampireInfection = 0;
									_vars.WerewolfInfectionTimer = 0;
									_vars.ZombieInfection = 0;
									_vars.Zombify = 0;
									_vars.markSyncDirty();
								}
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.GOBLIN_EFFECT, 24000, 0, true, false));
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:goblinspeed"), 0.05, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:goblinsneak"), 0.01, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.SNEAKING_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.SNEAKING_SPEED).addPermanentModifier(modifier);
									}
								}
								if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS) {
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
								if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_LEGGINGS) {
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
								if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_CHESTPLATE) {
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
								if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_HELMET) {
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
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Find a mentor in a forest settlement or find a guidebook in Darkened Bookshelves to start your training..."), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("troll")) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Strength fills you as you as you become a troll!"), false);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_crushing_burder"));
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
									_vars.MonsterInfectable = false;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("Monstrous World Troll", true);
								entityiterator.getPersistentData().putBoolean("can_kill_maniac", true);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = 3;
									_vars.FactionLevel = 1;
									_vars.VampireInfection = 0;
									_vars.WerewolfInfectionTimer = 0;
									_vars.ZombieInfection = 0;
									_vars.Zombify = 0;
									_vars.markSyncDirty();
								}
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:troll_attack_strength"), 5, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:troll_resistance"), 4, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:troll_knockback"), 1, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:troll_mining_speed"), 1, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.MINING_EFFICIENCY).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.MINING_EFFICIENCY).addPermanentModifier(modifier);
									}
								}
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Find a mentor in the mountains or find a guidebook in Darkened Bookshelves to start your training..."), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("sorcerer")) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Magic_Type = Mth.nextInt(RandomSource.create(), 1, 4);
									_vars.MonsterClass = 4;
									_vars.FactionLevel = 1;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("Monstrous World Sorcerer", true);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:envied_by_all"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Tingling magic fills you...you can now do sorcery and rituals!"), false);
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Find a mentor in a taiga village or find a guidebook in Darkened Bookshelves to start your training..."), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("mad_scientist")) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = 5;
									_vars.FactionLevel = 1;
									_vars.markSyncDirty();
								}
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your intelligence surges, but madness follows..."), false);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:road_to_madness"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								entityiterator.getPersistentData().putBoolean("Monstrous World Mad Scientist", true);
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Find a mentor in a desert lab or find a guidebook in Darkened Bookshelves to start your training..."), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("swamp_monster")) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You grow gills and fins and now need a watery environment..."), false);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_a_splash"));
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
									_vars.MonsterInfectable = false;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("Monstrous World Swamp Monster", true);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = 6;
									_vars.FactionLevel = 1;
									_vars.VampireInfection = 0;
									_vars.WerewolfInfectionTimer = 0;
									_vars.ZombieInfection = 0;
									_vars.Zombify = 0;
									_vars.markSyncDirty();
								}
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterwatermovement"), 0.1, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsterswimspeed"), 0.1, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonsteroxygenbonus"), 1024, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.OXYGEN_BONUS).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.OXYGEN_BONUS).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampmonstersubmergedminingspeed"), 0.4, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.SUBMERGED_MINING_SPEED).addPermanentModifier(modifier);
									}
								}
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Find a mentor in a swamp village or find a guidebook in Darkened Bookshelves to start your training..."), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("werewolf")) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.VampireInfection = 0;
									_vars.MonsterClass = 7;
									_vars.FactionLevel = 1;
									_vars.ZombieInfection = 0;
									_vars.WerewolfInfectionTimer = 0;
									_vars.Zombify = 0;
									_vars.MonsterInfectable = false;
									_vars.DarknessInfectable = false;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("Monstrous World Werewolf", true);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_EFFECT, 24000, 0, false, false));
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed"), 0.02, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength"), 1, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("A beast stirs within you..."), false);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:supreme_beast"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Find a mentor in a snowy Werewolf village or find a guidebook in Darkened Bookshelves to start your training..."), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("vampire")) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = 8;
									_vars.FactionLevel = 1;
									_vars.ZombieInfection = 0;
									_vars.VampireInfection = 0;
									_vars.WerewolfInfectionTimer = 0;
									_vars.Possession = 0;
									_vars.Zombify = 0;
									_vars.Bloodlevel = -1;
									_vars.BloodBar = 20;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putDouble("fear_countdown", 0);
								entityiterator.getPersistentData().putDouble("insanity_timer", 0);
								entityiterator.getPersistentData().putDouble("lev_possessed", 0);
								entityiterator.getPersistentData().putDouble("dark_possessed", 0);
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("A strange thirst grows..."), false);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sanguine_craving"));
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
									_vars.MonsterInfectable = false;
									_vars.DarknessInfectable = false;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("can_kill_maniac", true);
								entityiterator.getPersistentData().putBoolean("Monstrous World Vampire", true);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM, 24000, 0, true, false));
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"), 0.5, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
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
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength"), 3, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"), 15, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Find a mentor in a dark forest manor or find a guidebook in Darkened Bookshelves to start your training..."), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("darkness_wielder")) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Dark_Message_Timer = Mth.nextInt(RandomSource.create(), 12000, 18000);
									_vars.MonsterClass = 9;
									_vars.FactionLevel = 1;
									_vars.DarknessInfectable = false;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("Monstrous World Darkness Wielder", true);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_darkness_calls"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Darkness floods you for a moment, but you don't change. What's happening? "), false);
								MonstrousWorldMod.queueServerWork(500, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Can you hear me?"), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("demon")) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("A burning evil invades, morphing you into a true terror!"), false);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:an_unholy_beginning"));
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
									_vars.MonsterInfectable = false;
									_vars.DarknessInfectable = false;
									_vars.Reputation_Static = true;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("Monstrous World Demon", true);
								entityiterator.getPersistentData().putBoolean("can_kill_maniac", true);
								entityiterator.getPersistentData().putDouble("fear_countdown", 0);
								entityiterator.getPersistentData().putDouble("lev_possessed", 0);
								entityiterator.getPersistentData().putDouble("dark_possessed", 0);
								entityiterator.getPersistentData().putDouble("insanity_timer", 0);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = 10;
									_vars.FactionLevel = 1;
									_vars.Bloodlevel = -1;
									_vars.Possession = 0;
									_vars.ZombieInfection = 0;
									_vars.WerewolfInfectionTimer = 0;
									_vars.VampireInfection = 0;
									_vars.Reputation = -100;
									_vars.Zombify = 0;
									_vars.More_Nightmares = 0;
									_vars.Slower_Movement = 0;
									_vars.markSyncDirty();
								}
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_no_burn"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
									if (!_entity.getAttribute(Attributes.BURNING_TIME).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.BURNING_TIME).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_armor"), 10, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_gravity"), (-0.04), AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_swim_speed"), (-0.06), AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_safe_fall"), 1024, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
									}
								}
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, false, false));
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
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
								{
									Entity _entity = entityiterator;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
									}
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
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Find a mentor in a Nether Hall or find a guidebook in Darkened Bookshelves to start your progression..."), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("evil_clown")) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Laughter fills your head as insanity follows..."), false);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:no_laughing_matter"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								entityiterator.getPersistentData().putDouble("fear_countdown", 0);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = 11;
									_vars.FactionLevel = 1;
									_vars.Bloodlevel = -1;
									_vars.ZombieInfection = 0;
									_vars.WerewolfInfectionTimer = 0;
									_vars.VampireInfection = 0;
									_vars.Reputation = -100;
									_vars.Zombify = 0;
									_vars.More_Nightmares = 0;
									_vars.Slower_Movement = 0;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putDouble("insanity_timer", 0);
								entityiterator.getPersistentData().putDouble("fear_countdown", 0);
								entityiterator.getPersistentData().putDouble("lev_possessed", 0);
								entityiterator.getPersistentData().putDouble("dark_possessed", 0);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation_Static = true;
									_vars.MonsterInfectable = false;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("Monstrous World Evil Clown", true);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, false, false));
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Find a guidebook in a circus tent or find a guidebook in Darkened Bookshelves to start your progression...."), false);
								});
							}
							if ((StringArgumentType.getString(arguments, "monster_class")).equals("maniac")) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("A violent rage fills you, and you want to kill..."), false);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:time_to_kill"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								entityiterator.getPersistentData().putDouble("fear_countdown", 0);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.MonsterClass = 12;
									_vars.FactionLevel = 1;
									_vars.Reputation = -100;
									_vars.More_Nightmares = 0;
									_vars.Slower_Movement = 0;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putDouble("fear_countdown", 0);
								entityiterator.getPersistentData().putDouble("insanity_timer", 0);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.DarknessInfectable = false;
									_vars.Reputation_Static = true;
									_vars.markSyncDirty();
								}
								entityiterator.getPersistentData().putBoolean("can_kill_maniac", true);
								entityiterator.getPersistentData().putBoolean("Monstrous World Maniac", true);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, false, false));
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
								MonstrousWorldMod.queueServerWork(300, () -> {
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Talk to a Demon to start your progression..."), false);
								});
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(
											Component.literal("Player must be human and without a monster faction for this command to work. Try /setmonstertype <player> none   or /setmonsterclass <player> none   first before using command"), false);
							}
						} else {
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(
										Component.literal("Player must be human and without a monster faction for this command to work. Try /setmonstertype <player> none   or /setmonsterclass <player> none   first before using command"), false);
						}
					} else {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal("Player must be human and without a monster faction for this command to work. Try /setmonstertype <player> none   or /setmonsterclass <player> none   first before using command"), false);
					}
				}
				if ((StringArgumentType.getString(arguments, "monster_class")).equals("none")) {
					RemoveWitchFactionProcedure.execute(world, x, y, z, entity);
					RemoveGoblinFactionProcedure.execute(entity);
					RemoveTrollFactionProcedure.execute(world, x, y, z, entity);
					RemoveSorcererFactionProcedure.execute(world, x, y, z, entity);
					RemoveMadScientistFactionProcedure.execute(world, x, y, z, entity);
					RemoveSwampmonsterFactionProcedure.execute(world, x, y, z, entity);
					RemoveWerewolfFactionProcedure.execute(entity);
					RemoveVampireFactionProcedure.execute(world, x, y, z, entity);
					RemoveDarknessWielderFactionProcedure.execute(world, entity);
					RemoveDemonFactionProcedure.execute(world, entity);
					RemoveEvilClownFactionProcedure.execute(world, entity);
					RemoveManiacFactionProcedure.execute(world, entity);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}