package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class HungerAggressionLevel6Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestWitch1 = null;
		Entity NearestPlayer = null;
		Entity Shademarker = null;
		Entity NearestPillager = null;
		Entity NearestVindicator = null;
		Entity NearestHunter = null;
		Entity NearestBrain = null;
		Entity NearestAggressiveGuard = null;
		Entity TargetEntity = null;
		Entity NearestVillager = null;
		Entity NearestEvoker = null;
		Entity NearestSorcerer = null;
		Entity NearestMadScientist = null;
		Entity NearestGoon = null;
		Entity NearestWanderingTrader = null;
		Entity NearestHunterPatrol = null;
		NearestPlayer = findEntityInWorldRange(world, ServerPlayer.class, x, y, z, 48);
		NearestGoon = findEntityInWorldRange(world, SocietyGoonEntity.class, x, y, z, 48);
		NearestAggressiveGuard = findEntityInWorldRange(world, AggressiveGuardEntity.class, x, y, z, 48);
		NearestVillager = findEntityInWorldRange(world, Villager.class, x, y, z, 48);
		NearestWanderingTrader = findEntityInWorldRange(world, WanderingTrader.class, x, y, z, 48);
		NearestPillager = findEntityInWorldRange(world, Pillager.class, x, y, z, 48);
		NearestHunter = findEntityInWorldRange(world, HunterNPCEntity.class, x, y, z, 48);
		NearestHunterPatrol = findEntityInWorldRange(world, HunterPatrolNPCEntity.class, x, y, z, 48);
		if (!world.isClientSide()) {
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer < -18000) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 1, 1, 1, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FALLING_OBSIDIAN_TEAR, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 1, 1, 1, 0);
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
						}
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
						}
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
						}
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
						}
						if (!(entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(MonstrousWorldModMobEffects.BLACKOUT))) {
							if (NearestGoon != null) {
								if (NearestGoon instanceof SocietyGoonEntity) {
									if (!(NearestGoon.getPersistentData().getBoolean("vampire") == true)) {
										{
											Entity _ent = entity;
											double _tx = (NearestGoon.getX());
											double _ty = (NearestGoon.getY());
											double _tz = (NearestGoon.getZ());
											_ent.teleportTo(_tx, _ty, _tz);
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLACKOUT, 180, 0, true, false));
									}
								}
							}
							if (NearestAggressiveGuard != null) {
								if (NearestAggressiveGuard instanceof AggressiveGuardEntity) {
									if (!(NearestAggressiveGuard.getPersistentData().getBoolean("vampire") == true)) {
										{
											Entity _ent = entity;
											double _tx = (NearestAggressiveGuard.getX());
											double _ty = (NearestAggressiveGuard.getY());
											double _tz = (NearestAggressiveGuard.getZ());
											_ent.teleportTo(_tx, _ty, _tz);
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLACKOUT, 180, 0, true, false));
									}
								}
							}
							if (NearestHunter != null) {
								if (NearestHunter instanceof HunterNPCEntity) {
									if (!(NearestHunter.getPersistentData().getBoolean("vampire") == true)) {
										{
											Entity _ent = entity;
											double _tx = (NearestHunter.getX());
											double _ty = (NearestHunter.getY());
											double _tz = (NearestHunter.getZ());
											_ent.teleportTo(_tx, _ty, _tz);
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLACKOUT, 180, 0, true, false));
									}
								}
							}
							if (NearestHunterPatrol != null) {
								if (NearestHunterPatrol instanceof HunterPatrolNPCEntity) {
									if (!(NearestHunterPatrol.getPersistentData().getBoolean("vampire") == true)) {
										{
											Entity _ent = entity;
											double _tx = (NearestHunterPatrol.getX());
											double _ty = (NearestHunterPatrol.getY());
											double _tz = (NearestHunterPatrol.getZ());
											_ent.teleportTo(_tx, _ty, _tz);
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLACKOUT, 180, 0, true, false));
									}
								}
							}
							if (NearestVillager != null) {
								if (NearestVillager instanceof Villager) {
									if (!(NearestVillager.getPersistentData().getBoolean("vampire") == true)) {
										{
											Entity _ent = entity;
											double _tx = (NearestVillager.getX());
											double _ty = (NearestVillager.getY());
											double _tz = (NearestVillager.getZ());
											_ent.teleportTo(_tx, _ty, _tz);
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLACKOUT, 180, 0, true, false));
									}
								}
							}
							if (NearestPillager != null) {
								if (NearestPillager instanceof Pillager) {
									if (!(NearestPillager.getPersistentData().getBoolean("vampire") == true)) {
										{
											Entity _ent = entity;
											double _tx = (NearestPillager.getX());
											double _ty = (NearestPillager.getY());
											double _tz = (NearestPillager.getZ());
											_ent.teleportTo(_tx, _ty, _tz);
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLACKOUT, 180, 0, true, false));
									}
								}
							}
						}
					}
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.BLACKOUT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.BLACKOUT).getDuration() : 0) == 179) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof LivingEntity) {
									if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
										if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:monster_being")))) {
											if (!(entityiterator.getPersistentData().getBoolean("vampire") == true)) {
												if (entity instanceof Player _player)
													_player.closeContainer();
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("/playsound entity.ender_dragon.growl master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
													}
												}
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 9));
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 3));
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 9));
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 1));
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 4));
												MonstrousWorldMod.queueServerWork(40, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 40, 1, 1, 1, 0);
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												});
												MonstrousWorldMod.queueServerWork(45, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 40, 1, 1, 1, 0);
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												});
												MonstrousWorldMod.queueServerWork(55, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 40, 1, 1, 1, 0);
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												});
												MonstrousWorldMod.queueServerWork(60, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 40, 1, 1, 1, 0);
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												});
												MonstrousWorldMod.queueServerWork(65, () -> {
													if (world instanceof ServerLevel _level)
														_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 40, 1, 1, 1, 0);
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.phantom.bite")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												});
												MonstrousWorldMod.queueServerWork(70, () -> {
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Blocks.SKELETON_SKULL));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Items.BONE));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Items.BONE));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(Items.BONE));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 200);
													if (entity instanceof LivingEntity _entity)
														_entity.removeEffect(MonstrousWorldModMobEffects.ENTITY_HUNGER);
													if (entity instanceof Player _player)
														_player.getFoodData().setFoodLevel(20);
													if (entity instanceof Player _player)
														_player.getFoodData().setSaturation(20);
													if (entity instanceof ServerPlayer _player) {
														AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_horrifying_appetite"));
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
														_vars.Dark_Message_Timer = Mth.nextInt(RandomSource.create(), 24000, 36000);
														_vars.markSyncDirty();
													}
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
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}