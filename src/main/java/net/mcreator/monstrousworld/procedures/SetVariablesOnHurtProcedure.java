package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SetVariablesOnHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.hurt")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie.hurt")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 1) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.HuntersGuild = false;
					_vars.DarknessInfectable = false;
					_vars.markSyncDirty();
				}
				entity.getPersistentData().putBoolean("Monstrous World Witch", true);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WITCH_EFFECT, 24000, 0, true, false));
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.DarknessTimer = 0;
					_vars.FactionLevel = 1;
					_vars.markSyncDirty();
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
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
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a mentor in a plains village or find a guidebook in Darkened Bookshelves to start your training..."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your step quickens as you become a goblin!"), false);
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
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.MonsterInfectable = false;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("Monstrous World Goblin", true);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.VampireInfection = 0;
						_vars.WerewolfInfectionTimer = 0;
						_vars.ZombieInfection = 0;
						_vars.Zombify = 0;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.GOBLIN_EFFECT, 24000, 0, true, false));
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
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
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_BOOTS) {
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
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_LEGGINGS) {
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
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_CHESTPLATE) {
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
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Items.IRON_HELMET) {
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
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a mentor in a forest settlement or find a guidebook in Darkened Bookshelves to start your training..."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Strength fills you as you as you become a troll!"), false);
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
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.MonsterInfectable = false;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("Monstrous World Troll", true);
					entity.getPersistentData().putBoolean("can_kill_maniac", true);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.VampireInfection = 0;
						_vars.WerewolfInfectionTimer = 0;
						_vars.ZombieInfection = 0;
						_vars.Zombify = 0;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
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
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a mentor in the mountains or find a guidebook in Darkened Bookshelves to start your training..."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Magic_Type = Mth.nextInt(RandomSource.create(), 1, 4);
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("Monstrous World Sorcerer", true);
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
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Tingling magic fills you...you can now do sorcery and rituals!"), false);
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a mentor in a taiga village or find a guidebook in Darkened Bookshelves to start your training..."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your intelligence surges, but madness follows..."), false);
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
					entity.getPersistentData().putBoolean("Monstrous World Mad Scientist", true);
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a mentor in a desert lab or find a guidebook in Darkened Bookshelves to start your training..."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You grow gills and fins and now need a watery environment..."), false);
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
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.MonsterInfectable = false;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("Monstrous World Swamp Monster", true);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.VampireInfection = 0;
						_vars.WerewolfInfectionTimer = 0;
						_vars.ZombieInfection = 0;
						_vars.Zombify = 0;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
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
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a mentor in a swamp village or find a guidebook in Darkened Bookshelves to start your training..."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.VampireInfection = 0;
						_vars.ZombieInfection = 0;
						_vars.WerewolfInfectionTimer = 0;
						_vars.Zombify = 0;
						_vars.MonsterInfectable = false;
						_vars.DarknessInfectable = false;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("Monstrous World Werewolf", true);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_EFFECT, 24000, 0, false, false));
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
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("A beast stirs within you..."), false);
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
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a mentor in a snowy Werewolf village or find a guidebook in Darkened Bookshelves to start your training..."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.MonsterType = 6;
						_vars.ZombieInfection = 0;
						_vars.VampireInfection = 0;
						_vars.WerewolfInfectionTimer = 0;
						_vars.Possession = 0;
						_vars.Zombify = 0;
						_vars.Bloodlevel = -1;
						_vars.BloodBar = 20;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putDouble("fear_countdown", 0);
					entity.getPersistentData().putDouble("insanity_timer", 0);
					entity.getPersistentData().putDouble("lev_possessed", 0);
					entity.getPersistentData().putDouble("dark_possessed", 0);
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
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.MonsterInfectable = false;
						_vars.DarknessInfectable = false;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("can_kill_maniac", true);
					entity.getPersistentData().putBoolean("Monstrous World Vampire", true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM, 24000, 0, true, false));
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
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a mentor in a dark forest manor or find a guidebook in Darkened Bookshelves to start your training..."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Dark_Message_Timer = Mth.nextInt(RandomSource.create(), 12000, 18000);
						_vars.DarknessInfectable = false;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("Monstrous World Darkness Wielder", true);
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
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Darkness floods you for a moment, but you don't change. What's happening? "), false);
					MonstrousWorldMod.queueServerWork(500, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75Can you hear me?"), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("A burning evil invades, morphing you into a true terror!"), false);
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
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.MonsterInfectable = false;
						_vars.DarknessInfectable = false;
						_vars.Reputation_Static = true;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("Monstrous World Demon", true);
					entity.getPersistentData().putBoolean("can_kill_maniac", true);
					entity.getPersistentData().putDouble("fear_countdown", 0);
					entity.getPersistentData().putDouble("lev_possessed", 0);
					entity.getPersistentData().putDouble("dark_possessed", 0);
					entity.getPersistentData().putDouble("insanity_timer", 0);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
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
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_no_burn"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
						if (!_entity.getAttribute(Attributes.BURNING_TIME).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.BURNING_TIME).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity) {
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_armor"), 10, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
						}
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
						AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:demon_safe_fall"), 1024, AttributeModifier.Operation.ADD_VALUE);
						if (!_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).hasModifier(modifier.id())) {
							_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).addPermanentModifier(modifier);
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, false, false));
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
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
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a mentor in a Nether Hall or find a guidebook in Darkened Bookshelves to start your progression..."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Laughter fills your head as insanity follows..."), false);
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
					entity.getPersistentData().putDouble("fear_countdown", 0);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
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
					entity.getPersistentData().putDouble("insanity_timer", 0);
					entity.getPersistentData().putDouble("fear_countdown", 0);
					entity.getPersistentData().putDouble("lev_possessed", 0);
					entity.getPersistentData().putDouble("dark_possessed", 0);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Reputation_Static = true;
						_vars.MonsterInfectable = false;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("Monstrous World Evil Clown", true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, false, false));
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Find a guidebook in a circus tent or find a guidebook in Darkened Bookshelves to start your progression...."), false);
					});
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("A violent rage fills you, and you want to kill..."), false);
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
					entity.getPersistentData().putDouble("fear_countdown", 0);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Reputation = -100;
						_vars.More_Nightmares = 0;
						_vars.Slower_Movement = 0;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putDouble("fear_countdown", 0);
					entity.getPersistentData().putDouble("insanity_timer", 0);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.DarknessInfectable = false;
						_vars.Reputation_Static = true;
						_vars.markSyncDirty();
					}
					entity.getPersistentData().putBoolean("can_kill_maniac", true);
					entity.getPersistentData().putBoolean("Monstrous World Maniac", true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, false, false));
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
					MonstrousWorldMod.queueServerWork(300, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Talk to a Demon to start your progression..."), false);
					});
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM) ? _livEnt.getEffect(MonstrousWorldModMobEffects.STRANGE_SERUM).getDuration() : 0) == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You suffer a horrifying mutation!"), false);
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is lost until you cure yourself..."), false);
				}
				if (!(entity.getPersistentData().getDouble("MutationType") >= 1)) {
					entity.getPersistentData().putDouble("MutationType", (Mth.nextInt(RandomSource.create(), 1, 3)));
				}
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.MonsterInfectable = false;
					_vars.DarknessInfectable = false;
					_vars.markSyncDirty();
				}
				MonstrousWorldMod.queueServerWork(1, () -> {
					if (entity.getPersistentData().getDouble("MutationType") == 1) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterType = 1;
							_vars.ZombieInfection = 0;
							_vars.WerewolfInfectionTimer = 0;
							_vars.VampireInfection = 0;
							_vars.Zombify = 0;
							_vars.markSyncDirty();
						}
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
							AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
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
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						entity.getPersistentData().putBoolean("Monstrous World Fly", true);
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
							if (entity instanceof ServerPlayer _player) {
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
					}
					if (entity.getPersistentData().getDouble("MutationType") == 2) {
						entity.getPersistentData().putDouble("fear_countdown", 0);
						entity.getPersistentData().putDouble("insanity_timer", 0);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterType = 2;
							_vars.ZombieInfection = 0;
							_vars.WerewolfInfectionTimer = 0;
							_vars.VampireInfection = 0;
							_vars.Zombify = 0;
							_vars.markSyncDirty();
						}
						entity.getPersistentData().putBoolean("Monstrous World Eye", true);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
					}
					if (entity.getPersistentData().getDouble("MutationType") == 3) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.MonsterType = 3;
							_vars.ZombieInfection = 0;
							_vars.WerewolfInfectionTimer = 0;
							_vars.VampireInfection = 0;
							_vars.Zombify = 0;
							_vars.markSyncDirty();
						}
						entity.getPersistentData().putBoolean("Monstrous World Serpent", true);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
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
				});
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0) == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cYou feel very strange as a growl emerges from your throat..."), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wolf.growl")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wolf.growl")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.MonsterType = 5;
					_vars.VampireInfection = 0;
					_vars.WerewolfInfectionTimer = 0;
					_vars.ZombieInfection = 0;
					_vars.Zombify = 0;
					_vars.markSyncDirty();
				}
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
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.WEREWOLF_EFFECT, 24000, 0, true, false));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
				entity.getPersistentData().putBoolean("Monstrous World Werewolf", true);
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.MonsterInfectable = false;
					_vars.DarknessInfectable = false;
					_vars.markSyncDirty();
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:every_hunters_worst_nightmare"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is lost until you cure yourself..."), false);
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.STABILIZING_SERUM) ? _livEnt.getEffect(MonstrousWorldModMobEffects.STABILIZING_SERUM).getDuration() : 0) == 1) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.MonsterType = 0;
					_vars.markSyncDirty();
				}
				entity.getPersistentData().putDouble("MutationType", 0);
				entity.getPersistentData().putDouble("DryEye", 0);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aYou are cured of your mutations!"), false);
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("monstrous_world:flygravity"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).removeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:flysafefall"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:serpentarmor"));
				}
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:serpentattack"));
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.DRY_EYE);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.COLD_BLOODED);
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.MonsterInfectable = true;
					_vars.markSyncDirty();
				}
				entity.getPersistentData().putBoolean("Monstrous World Fly", false);
				entity.getPersistentData().putBoolean("Monstrous World Eye", false);
				entity.getPersistentData().putBoolean("Monstrous World Serpent", false);
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your place in the Hunter's Guild is restored!"), false);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Reputation = 0;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).DarknessTimer == 0) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.DarknessInfectable = true;
							_vars.markSyncDirty();
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:ah_better"));
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
			MonstrousWorldMod.queueServerWork(2, () -> {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0) {
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
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
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
				}
			});
		}
	}
}