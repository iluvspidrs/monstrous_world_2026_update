package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.*;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (!(entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
				if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			}
			if (("" + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).contains("iron")) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
						|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2 || ("" + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("goblin")) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.IRON_POISONING, 200, 0));
					}
				}
			}
			if ((("" + BuiltInRegistries.ENTITY_TYPE.getKey(sourceentity.getType()).toString()).contains("silver") || ("" + BuiltInRegistries.ENTITY_TYPE.getKey(immediatesourceentity.getType()).toString()).contains("silver"))
					&& ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
							|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
							|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem)) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8
						|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType >= 4) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HOLY_DAMAGE, 200, 0));
				}
				if (entity.getPersistentData().getBoolean("vampire") == true || entity instanceof VampireNPCEntity || entity.getType().is(EntityTypeTags.UNDEAD)
						|| ("" + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("werewolf") || ("" + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("demon")) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HOLY_DAMAGE, 200, 0));
				}
			}
			if (sourceentity instanceof InfernalLightEntity) {
				entity.igniteForSeconds(3);
			}
			if (sourceentity instanceof GuardRobotEntity) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 495) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.setHealth((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 5);
				}
			}
			if (sourceentity instanceof FeralSwampmonsterEntity && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 6 && entity.isInWaterOrBubble()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.SINKING, 300, 0));
				entity.getPersistentData().putString("attacker", (sourceentity.getStringUUID()));
			}
			if (sourceentity instanceof VampireNPCEntity) {
				if ((entity.getPersistentData().getString("hypnosis")).equals(sourceentity.getStringUUID())) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				}
			}
			if ((sourceentity instanceof ServerPlayer || sourceentity instanceof Player) && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
				if (entity instanceof LivingEntity && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_DAGGER.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
					entity.getPersistentData().putBoolean("SwampPoisoned", true);
				}
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3 && entity.isInWaterOrBubble() && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:swamp_creature")))
						&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 6) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.SINKING, 500, 0));
				}
				if (sourceentity instanceof LivingEntity _livEnt52 && _livEnt52.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH)) {
					if (entity.isInWaterOrBubble() && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 6 && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:swamp_creature")))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.SINKING, 500, 0));
					}
				}
			}
			if (sourceentity instanceof MurkanusWormEntity) {
				if (entity instanceof ServerPlayer || entity instanceof Player) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHIEFTAN_HEADDRESS_HELMET.get())) {
							if (Math.random() >= 0.75) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Something burrows into your skin, and a sense of doom grows..."), false);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MURKANUS_MARTH_COUNTDOWN, Mth.nextInt(RandomSource.create(), 12000, 24000), 0, true, false));
								if (!sourceentity.level().isClientSide())
									sourceentity.discard();
							}
						}
					}
				}
			}
			if (sourceentity instanceof LivingEntity _livEnt65 && _livEnt65.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS) || (sourceentity.getPersistentData().getString("hypnosis")).equals(entity.getStringUUID())) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
			if (sourceentity instanceof HungryTreeEntity && entity instanceof DeathbloomEntityEntity) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
			if (sourceentity instanceof FeralWerewolfEntity) {
				if (entity instanceof Player || entity instanceof ServerPlayer) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
						if (!(sourceentity.getPersistentData().getString("AngryAt")).equals(entity.getStringUUID())) {
							if (event instanceof ICancellableEvent _cancellable) {
								_cancellable.setCanceled(true);
							}
						}
					}
				}
			}
			if (sourceentity instanceof FeralMountainTrollEntity) {
				if (entity instanceof Player || entity instanceof ServerPlayer) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
						if (!(sourceentity.getPersistentData().getString("AngryAt")).equals(entity.getStringUUID())) {
							if (event instanceof ICancellableEvent _cancellable) {
								_cancellable.setCanceled(true);
							}
						}
					}
				}
			}
			if (sourceentity instanceof AggressiveGuardEntity && entity instanceof AggressiveGuardEntity) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
			if (sourceentity instanceof AggressiveGuardEntity && entity instanceof SocietyGoonEntity) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
			if (sourceentity instanceof GiantSnakeEntity && entity instanceof LivingEntity) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.fox.bite")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.fox.bite")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
			}
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3 && entity instanceof LivingEntity) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.fox.bite")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.fox.bite")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
			}
			if (sourceentity instanceof MutantSerpentEntity) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.fox.bite")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.fox.bite")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
			}
			if (sourceentity instanceof MadScientistNPCEntity) {
				if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
					if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
						if (!(entity instanceof LivingEntity _livEnt97 && _livEnt97.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM))) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							entity.getPersistentData().putDouble("MutationType", 0);
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STRANGE_SERUM, 300, 0));
						}
					}
					if (entity instanceof Player || entity instanceof ServerPlayer) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
							if (!(entity instanceof LivingEntity _livEnt103 && _livEnt103.hasEffect(MonstrousWorldModMobEffects.STRANGE_SERUM))) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								entity.getPersistentData().putDouble("MutationType", (Mth.nextInt(RandomSource.create(), 1, 3)));
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STRANGE_SERUM, 300, 0));
							}
						}
					}
				}
			}
			if (sourceentity instanceof GuardRobotEntity) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 4));
			}
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10 || sourceentity instanceof DemonNPCEntity) {
				entity.igniteForSeconds(5);
			}
			if (sourceentity instanceof VengefulPumpkinEntity) {
				if (entity instanceof Player || entity instanceof ServerPlayer) {
					if (Math.random() < (double) MonstrousWorldConfigConfiguration.PUMPKINS_REVENGE_CHANCE.get()
							&& !world.getEntitiesOfClass(VengefulPumpkinEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(2 / 2d), e -> true).isEmpty()) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.PUMPKINS_REVENGE, Mth.nextInt(RandomSource.create(), 60000, 72000), 0));
					}
				}
			}
			if (sourceentity instanceof AcidBallProjectileEntity) {
				entity.getPersistentData().putBoolean("hit_by_acid_ball", true);
			}
			if (sourceentity instanceof LargePossessingEntityEntity) {
				if (entity instanceof Player || entity instanceof ServerPlayer) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
									if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHARM_OF_POSSESSION_IMMUNITY.get())
											&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHARM_OF_POSSESSION_IMMUNITY.get())) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
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
											Objective _so = _sc.getObjective("werewolf_handling");
											if (_so == null)
												_so = _sc.addObjective("werewolf_handling", ObjectiveCriteria.DUMMY, Component.literal("werewolf_handling"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("werewolf_digging");
											if (_so == null)
												_so = _sc.addObjective("werewolf_digging", ObjectiveCriteria.DUMMY, Component.literal("werewolf_digging"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("werewolf_knockback");
											if (_so == null)
												_so = _sc.addObjective("werewolf_knockback", ObjectiveCriteria.DUMMY, Component.literal("werewolf_knockback"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("werewolf_armor");
											if (_so == null)
												_so = _sc.addObjective("werewolf_armor", ObjectiveCriteria.DUMMY, Component.literal("werewolf_armor"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
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
										entity.getPersistentData().putDouble("lev_possessed", 0);
										entity.getPersistentData().putDouble("dark_possessed", 0);
										entity.getPersistentData().putDouble("insanity_timer", 0);
										MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed = true;
										MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.BeastForm = false;
											_vars.MonsterInfectable = false;
											_vars.Reputation_Static = true;
											_vars.markSyncDirty();
										}
										entity.getPersistentData().putBoolean("can_kill_maniac", true);
										entity.getPersistentData().putBoolean("Monstrous World Werewolf", false);
										entity.getPersistentData().putBoolean("Monstrous World Vampire", false);
										entity.getPersistentData().putBoolean("Monstrous World Zombie", false);
										entity.getPersistentData().putBoolean("Monstrous World Fly", false);
										entity.getPersistentData().putBoolean("Monstrous World Eye", false);
										entity.getPersistentData().putBoolean("Monstrous World Serpent", false);
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
										if (entity instanceof LivingEntity _entity) {
											_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_knockback"));
										}
										if (entity instanceof LivingEntity _entity) {
											_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfspeed"));
										}
										if (entity instanceof LivingEntity _entity) {
											_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfstrength"));
										}
										if (entity instanceof LivingEntity _entity) {
											_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("monstrous_world:flygravity"));
										}
										if (entity instanceof LivingEntity _entity) {
											_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
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
										if (entity instanceof LivingEntity _entity) {
											_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"));
										}
										if (entity instanceof LivingEntity _entity) {
											_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampiremovementspeed"));
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
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0, false, false));
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 220, 0, false, false));
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 0, false, false));
										if (!sourceentity.level().isClientSide())
											sourceentity.discard();
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_darkened_crown"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A75Incredible darkness surges through you...you are possessed!"), false);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									} else {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 0) {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Your charm protects you from possession!"), true);
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:i_cant_believe_that_worked"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHARM_OF_POSSESSION_IMMUNITY.get()) {
												if (world instanceof ServerLevel _level) {
													(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
													});
												}
											} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHARM_OF_POSSESSION_IMMUNITY.get()) {
												if (world instanceof ServerLevel _level) {
													(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
													});
												}
											}
										} else {
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy()));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy()));
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
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Possession = 3;
												_vars.FactionLevel = 6;
												_vars.Dark_Message_Timer = Mth.nextInt(RandomSource.create(), 20000, 24000);
												_vars.Reputation = -100;
												_vars.MonsterType = 0;
												_vars.MonsterType = 0;
												_vars.VampireInfection = 0;
												_vars.ZombieInfection = 0;
												_vars.BloodBar = -1;
												_vars.Bloodlevel = 12;
												_vars.Zombify = 0;
												_vars.More_Nightmares = 0;
												_vars.Slower_Movement = 0;
												_vars.No_Defense = 0;
												_vars.markSyncDirty();
											}
											entity.getPersistentData().putDouble("lev_possessed", 0);
											entity.getPersistentData().putDouble("dark_possessed", 0);
											entity.getPersistentData().putDouble("insanity_timer", 0);
											MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed = true;
											MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.BeastForm = false;
												_vars.MonsterInfectable = false;
												_vars.Reputation_Static = true;
												_vars.markSyncDirty();
											}
											entity.getPersistentData().putBoolean("can_kill_maniac", true);
											entity.getPersistentData().putBoolean("Monstrous World Werewolf", false);
											entity.getPersistentData().putBoolean("Monstrous World Vampire", false);
											entity.getPersistentData().putBoolean("Monstrous World Zombie", false);
											entity.getPersistentData().putBoolean("Monstrous World Fly", false);
											entity.getPersistentData().putBoolean("Monstrous World Eye", false);
											entity.getPersistentData().putBoolean("Monstrous World Serpent", false);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.DRY_EYE);
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.COLD_BLOODED);
											if (entity instanceof LivingEntity _entity) {
												_entity.getAttribute(Attributes.ATTACK_KNOCKBACK).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_knockback"));
											}
											if (entity instanceof LivingEntity _entity) {
												_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfspeed"));
											}
											if (entity instanceof LivingEntity _entity) {
												_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:feralwerewolfstrength"));
											}
											if (entity instanceof LivingEntity _entity) {
												_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("monstrous_world:flygravity"));
											}
											if (entity instanceof LivingEntity _entity) {
												_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:flyspeed"));
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
											if (entity instanceof LivingEntity _entity) {
												_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"));
											}
											if (entity instanceof LivingEntity _entity) {
												_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampiremovementspeed"));
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
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0, false, false));
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 220, 0, false, false));
											if (!sourceentity.level().isClientSide())
												sourceentity.discard();
											if (entity instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_darkened_crown"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\u00A75Incredible darkness surges through you...you are possessed!"), false);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
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
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if ((sourceentity.getDisplayName().getString()).contains("Zombie") || (sourceentity.getDisplayName().getString()).contains("Husk") || (sourceentity.getDisplayName().getString()).contains("Drowned")
						|| sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("c:zombies")))) {
					if (!(entity instanceof LivingEntity _livEnt259 && _livEnt259.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT)) && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true
							&& Math.random() <= entity.getPersistentData().getDouble("Infectability") && Math.random() < (double) MonstrousWorldConfigConfiguration.ZOMBIE_INFECTION_CHANCE.get()) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.ZombieInfection = 24000;
							_vars.markSyncDirty();
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT, 24000, 0, true, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cYou are bitten! Find the cure serum..."), false);
					}
				}
			}
		}
	}
}