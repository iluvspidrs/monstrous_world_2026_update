package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
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
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RightClickItemsProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double witchery_faction_allowed = 0;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_tomes")))) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) >= 2) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
							if (!(getEntityGameType(entity) == GameType.CREATIVE) && !(getEntityGameType(entity) == GameType.SPECTATOR)) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:faction_tomes")))) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_WITCHERY.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_WITCH_FACTION.get() == true) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessTimer = 0;
												_vars.MonsterClass = 1;
												_vars.FactionLevel = 1;
												_vars.markSyncDirty();
											}
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WITCH_EFFECT, 24000, 0, true, false));
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You gain earthly magic and can now do witchcraft!"), false);
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_witch_is_in"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_WITCHERY.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_WITCHERY.get()).copy();
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
											}
											entity.getPersistentData().putBoolean("Monstrous World Witch", true);
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.HuntersGuild = false;
												_vars.DarknessInfectable = false;
												_vars.markSyncDirty();
											}
											MonstrousWorldMod.queueServerWork(300, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Find a mentor in a witch village or find a guidebook in Darkened Bookshelves if you lose your Guidebook..."), false);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction is disabled in the config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_GOBLIN.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_GOBLIN_FACTION.get() == true) {
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.GOBLIN_EFFECT, 24000, 0, true, false));
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.MonsterClass = 2;
												_vars.FactionLevel = 1;
												_vars.VampireInfection = 0;
												_vars.WerewolfInfectionTimer = 0;
												_vars.ZombieInfection = 0;
												_vars.Zombify = 0;
												_vars.DarknessTimer = 0;
												_vars.markSyncDirty();
											}
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:tricksters_and_treasure"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Your step quickens as you become a goblin!"), false);
											entity.getPersistentData().putBoolean("Monstrous World Goblin", true);
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessInfectable = false;
												_vars.MonsterInfectable = false;
												_vars.HuntersGuild = false;
												_vars.markSyncDirty();
											}
											if (entity instanceof LivingEntity _entity) {
												AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:goblinspeed"), 0.05, AttributeModifier.Operation.ADD_VALUE);
												if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
													_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
												}
											}
											if (entity instanceof LivingEntity _entity) {
												AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:goblinsneak"), 0.01, AttributeModifier.Operation.ADD_VALUE);
												if (!_entity.getAttribute(Attributes.SNEAKING_SPEED).hasModifier(modifier.id())) {
													_entity.getAttribute(Attributes.SNEAKING_SPEED).addPermanentModifier(modifier);
												}
											}
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
											if (entity instanceof LivingEntity _entity) {
												_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
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
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_GOBLIN.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_THE_GOBLIN.get()).copy();
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
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
											if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS) {
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.IRON_POISONING, 200, 0));
												{
													Entity _entity = entity;
													if (_entity instanceof Player _player) {
														_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
														_player.getInventory().setChanged();
													} else if (_entity instanceof LivingEntity _living) {
														_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
													}
												}
											}
											if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.IRON_LEGGINGS) {
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.IRON_POISONING, 200, 0));
												{
													Entity _entity = entity;
													if (_entity instanceof Player _player) {
														_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
														_player.getInventory().setChanged();
													} else if (_entity instanceof LivingEntity _living) {
														_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
													}
												}
											}
											if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Items.IRON_CHESTPLATE) {
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.IRON_POISONING, 200, 0));
												{
													Entity _entity = entity;
													if (_entity instanceof Player _player) {
														_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
														_player.getInventory().setChanged();
													} else if (_entity instanceof LivingEntity _living) {
														_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
													}
												}
											}
											if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Items.IRON_HELMET) {
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.IRON_POISONING, 200, 0));
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
											MonstrousWorldMod.queueServerWork(300, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Find a mentor in a forest settlement or find a guidebook in Darkened Bookshelves if you lose your Guidebook..."), false);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction is disabled in the config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_TROLL.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_TROLL_FACTION.get() == true) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessTimer = 0;
												_vars.markSyncDirty();
											}
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.MonsterClass = 3;
												_vars.FactionLevel = 1;
												_vars.Zombify = 0;
												_vars.HuntersGuild = false;
												_vars.MonsterInfectable = false;
												_vars.DarknessInfectable = false;
												_vars.markSyncDirty();
											}
											entity.getPersistentData().putBoolean("Monstrous World Troll", true);
											entity.getPersistentData().putBoolean("can_kill_maniac", true);
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
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
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
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_crushing_burder"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_TROLL.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_THE_TROLL.get()).copy();
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
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
											MonstrousWorldMod.queueServerWork(300, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Find a mentor in a mountain village or find a guidebook in Darkened Bookshelves if you lose your Guidebook..."), false);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction is disabled in the config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_SORCERY.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_SORCERER_FACTION.get() == true) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessTimer = 0;
												_vars.MonsterClass = 4;
												_vars.FactionLevel = 1;
												_vars.Magic_Type = Mth.nextInt(RandomSource.create(), 1, 4);
												_vars.markSyncDirty();
											}
											entity.getPersistentData().putBoolean("Monstrous World Sorcerer", true);
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.HuntersGuild = false;
												_vars.DarknessInfectable = false;
												_vars.markSyncDirty();
											}
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:envied_by_all"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_SORCERY.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_SORCERY.get()).copy();
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											MonstrousWorldMod.queueServerWork(300, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Find a mentor in a taiga village or find a guidebook in Darkened Bookshelves if you lose your Guidebook..."), false);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_MAD_SCIENCE.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_MAD_SCIENTIST_FACTION.get() == true) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessTimer = 0;
												_vars.markSyncDirty();
											}
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.MonsterClass = 5;
												_vars.FactionLevel = 1;
												_vars.HuntersGuild = false;
												_vars.DarknessInfectable = false;
												_vars.markSyncDirty();
											}
											entity.getPersistentData().putBoolean("Monstrous World Mad Scientist", true);
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:road_to_madness"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_MAD_SCIENCE.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_MAD_SCIENCE.get()).copy();
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Your intelligence surges, but madness follows..."), false);
											MonstrousWorldMod.queueServerWork(300, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Find a mentor in a desert lab or find a guidebook in Darkened Bookshelves if you lose your Guidebook..."), false);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_SWAMP.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_SWAMP_MONSTER_FACTION.get() == true) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessTimer = 0;
												_vars.markSyncDirty();
											}
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.MonsterClass = 6;
												_vars.DarknessTimer = 0;
												_vars.FactionLevel = 1;
												_vars.VampireInfection = 0;
												_vars.WerewolfInfectionTimer = 0;
												_vars.ZombieInfection = 0;
												_vars.Zombify = 0;
												_vars.HuntersGuild = false;
												_vars.DarknessInfectable = false;
												_vars.MonsterInfectable = false;
												_vars.markSyncDirty();
											}
											entity.getPersistentData().putBoolean("Monstrous World Swamp Monster", true);
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
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
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
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:making_a_splash"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You grow gills and fins and now need a humid environment..."), false);
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_SWAMP.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_THE_SWAMP.get()).copy();
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
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
											MonstrousWorldMod.queueServerWork(300, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Find a Chieftan in a swamp village or find a guidebook in Darkened Bookshelves if you lose your Guidebook..."), false);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_MOON.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_WEREWOLF_FACTION.get() == true) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessTimer = 0;
												_vars.markSyncDirty();
											}
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.MonsterClass = 7;
												_vars.FactionLevel = 1;
												_vars.ZombieInfection = 0;
												_vars.VampireInfection = 0;
												_vars.Zombify = 0;
												_vars.markSyncDirty();
											}
											entity.getPersistentData().putBoolean("Monstrous World Werewolf", true);
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.HuntersGuild = false;
												_vars.DarknessInfectable = false;
												_vars.MonsterInfectable = false;
												_vars.markSyncDirty();
											}
											if (entity instanceof LivingEntity _entity) {
												AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_speed"), 0.02, AttributeModifier.Operation.ADD_VALUE);
												if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
													_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
												}
											}
											if (entity instanceof LivingEntity _entity) {
												AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_strength"), 1, AttributeModifier.Operation.ADD_VALUE);
												if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
													_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
												}
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_EFFECT, 24000, 0, true, false));
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
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
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:supreme_beast"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_MOON.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_THE_MOON.get()).copy();
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
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
											MonstrousWorldMod.queueServerWork(300, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Find a mentor in a snowy taiga village or find a guidebook in Darkened Bookshelves if you lose your Guidebook..."), false);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_BLOODLUST.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_VAMPIRE_FACTION.get() == true) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessTimer = 0;
												_vars.MonsterClass = 8;
												_vars.FactionLevel = 1;
												_vars.MonsterType = 6;
												_vars.ZombieInfection = 0;
												_vars.VampireInfection = 0;
												_vars.WerewolfInfectionTimer = 0;
												_vars.Possession = 0;
												_vars.BloodBar = 20;
												_vars.Bloodlevel = -1;
												_vars.Zombify = 0;
												_vars.markSyncDirty();
											}
											entity.getPersistentData().putDouble("fear_countdown", 0);
											entity.getPersistentData().putDouble("insanity_timer", 0);
											entity.getPersistentData().putDouble("lev_possessed", 0);
											entity.getPersistentData().putDouble("dark_possessed", 0);
											entity.getPersistentData().putBoolean("Monstrous World Vampire", true);
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.HuntersGuild = false;
												_vars.DarknessInfectable = false;
												_vars.MonsterInfectable = false;
												_vars.markSyncDirty();
											}
											entity.getPersistentData().putBoolean("can_kill_maniac", true);
											if (entity instanceof LivingEntity _entity) {
												AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"), 0.5, AttributeModifier.Operation.ADD_VALUE);
												if (!_entity.getAttribute(Attributes.ATTACK_SPEED).hasModifier(modifier.id())) {
													_entity.getAttribute(Attributes.ATTACK_SPEED).addPermanentModifier(modifier);
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
													_entity.getAttribute(Attributes.OXYGEN_BONUS).addPermanentModifier(modifier);
												}
											}
											if (entity instanceof LivingEntity _entity) {
												AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength"), 3, AttributeModifier.Operation.ADD_VALUE);
												if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
													_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
												}
											}
											if (entity instanceof LivingEntity _entity) {
												AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"), 15, AttributeModifier.Operation.ADD_VALUE);
												if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
													_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
												}
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM, 24000, 0, true, false));
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
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
												_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("A strange thirst grows..."), false);
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:sanguine_craving"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_BLOODLUST.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_BLOODLUST.get()).copy();
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
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
											MonstrousWorldMod.queueServerWork(300, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Find a mentor in a dark forest manor or find a guidebook in Darkened Bookshelves if you lose your Guidebook..."), false);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_DARKNESS.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_DARKNESS_FACTION.get() == true) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.DarknessTimer = 0;
												_vars.MonsterClass = 9;
												_vars.FactionLevel = 1;
												_vars.Dark_Message_Timer = Mth.nextInt(RandomSource.create(), 12000, 18000);
												_vars.HuntersGuild = false;
												_vars.DarknessInfectable = false;
												_vars.markSyncDirty();
											}
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_darkness_calls"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player) {
												ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_DARKNESS.get());
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											MonstrousWorldMod.queueServerWork(100, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Darkness floods you for a moment, but nothing happens. What's going on?"), false);
											});
											MonstrousWorldMod.queueServerWork(300, () -> {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("\u00A75Can you hear me? "), true);
											});
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_INFERNAL_POWER.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_DEMON_FACTION.get() == true) {
											if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == true) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.DarknessTimer = 0;
													_vars.MonsterClass = 10;
													_vars.FactionLevel = 1;
													_vars.Bloodlevel = -1;
													_vars.Reputation = -100;
													_vars.Zombify = 0;
													_vars.More_Nightmares = 0;
													_vars.Slower_Movement = 0;
													_vars.markSyncDirty();
												}
												entity.getPersistentData().putDouble("fear_countdown", 0);
												entity.getPersistentData().putDouble("insanity_timer", 0);
												entity.getPersistentData().putDouble("lev_possessed", 0);
												entity.getPersistentData().putDouble("dark_possessed", 0);
												entity.getPersistentData().putBoolean("Monstrous World Demon", true);
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.HuntersGuild = false;
													_vars.MonsterInfectable = false;
													_vars.DarknessInfectable = false;
													_vars.Reputation_Static = true;
													_vars.markSyncDirty();
												}
												entity.getPersistentData().putBoolean("can_kill_maniac", true);
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:an_unholy_beginning"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:an_infernal_tome"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:true_evil"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof Player _player) {
													ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_INFERNAL_POWER.get());
													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_INFERNAL_POWER.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
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
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
												if (entity instanceof LivingEntity _entity) {
													AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_safe_fall"), 1024, AttributeModifier.Operation.ADD_VALUE);
													if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
														_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
													}
												}
												if (entity instanceof LivingEntity _entity) {
													AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_gravity"), (-0.04), AttributeModifier.Operation.ADD_VALUE);
													if (!_entity.getAttribute(Attributes.GRAVITY).hasModifier(modifier.id())) {
														_entity.getAttribute(Attributes.GRAVITY).addPermanentModifier(modifier);
													}
												}
												if (entity instanceof LivingEntity _entity) {
													AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_armor"), 10, AttributeModifier.Operation.ADD_VALUE);
													if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
														_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
													}
												}
												if (entity instanceof LivingEntity _entity) {
													AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_swim_speed"), (-0.06), AttributeModifier.Operation.ADD_VALUE);
													if (!_entity.getAttribute(NeoForgeMod.SWIM_SPEED).hasModifier(modifier.id())) {
														_entity.getAttribute(NeoForgeMod.SWIM_SPEED).addPermanentModifier(modifier);
													}
												}
												if (entity instanceof LivingEntity _entity) {
													AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_no_burn"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
													if (!_entity.getAttribute(Attributes.BURNING_TIME).hasModifier(modifier.id())) {
														_entity.getAttribute(Attributes.BURNING_TIME).addPermanentModifier(modifier);
													}
												}
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
													_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, false, false));
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
											} else {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_FUN_AND_GAMES.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_CLOWN_FACTION.get() == true) {
											if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == true) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.DarknessTimer = 0;
													_vars.markSyncDirty();
												}
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.Bloodlevel = -1;
													_vars.MonsterClass = 11;
													_vars.FactionLevel = 1;
													_vars.Reputation = -100;
													_vars.Zombify = 0;
													_vars.More_Nightmares = 0;
													_vars.Slower_Movement = 0;
													_vars.markSyncDirty();
												}
												entity.getPersistentData().putDouble("fear_countdown", 0);
												entity.getPersistentData().putDouble("insanity_timer", 0);
												entity.getPersistentData().putDouble("lev_possessed", 0);
												entity.getPersistentData().putDouble("dark_possessed", 0);
												entity.getPersistentData().putBoolean("Monstrous World Evil Clown", true);
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.HuntersGuild = false;
													_vars.DarknessInfectable = false;
													_vars.MonsterInfectable = false;
													_vars.Reputation_Static = true;
													_vars.markSyncDirty();
												}
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
													_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, false, false));
												if (entity instanceof Player _player) {
													ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_FUN_AND_GAMES.get());
													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_FUN_AND_GAMES.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:no_laughing_matter"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_guide_for_fun_and_games"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:true_evil"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
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
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											} else {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
										}
									}
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ENCHANTED_TOME_OF_VIOLENCE.get()) {
										if (MonstrousWorldConfigConfiguration.ALLOW_MANIAC_FACTION.get() == true) {
											if (MonstrousWorldConfigConfiguration.ALLOW_EVIL_FACTION.get() == true) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.DarknessTimer = 0;
													_vars.MonsterClass = 12;
													_vars.FactionLevel = 1;
													_vars.Reputation = -100;
													_vars.Zombify = 0;
													_vars.More_Nightmares = 0;
													_vars.Slower_Movement = 0;
													_vars.markSyncDirty();
												}
												entity.getPersistentData().putDouble("fear_countdown", 0);
												entity.getPersistentData().putDouble("insanity_timer", 0);
												entity.getPersistentData().putBoolean("Monstrous World Maniac", true);
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.HuntersGuild = false;
													_vars.DarknessInfectable = false;
													_vars.Reputation_Static = true;
													_vars.markSyncDirty();
												}
												entity.getPersistentData().putBoolean("can_kill_maniac", true);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS);
												if (entity instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, false, false));
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:time_to_kill"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:murder_101"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:true_evil"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entity instanceof Player _player) {
													ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_VIOLENCE.get());
													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
												}
												if (entity instanceof Player _player) {
													ItemStack _setstack = new ItemStack(MonstrousWorldModItems.TOME_OF_VIOLENCE.get()).copy();
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											} else {
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This faction has been disabled in the Monstrous World config"), false);
										}
									}
									if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
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
									}
									if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
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
									}
									if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
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
									}
									if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_gear")))) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
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
									}
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This book does not work in this game mode"), true);
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You must be human to use this"), true);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You already have a faction"), true);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You must be infected by Mysterious Darkness to use this"), true);
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}