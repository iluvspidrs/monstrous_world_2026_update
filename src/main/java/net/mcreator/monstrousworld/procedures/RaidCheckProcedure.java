package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.RaidEntity;
import net.mcreator.monstrousworld.entity.MonsterVillageMarkerEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class RaidCheckProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double raider_count = 0;
		double goblin_count = 0;
		double werewolf_count = 0;
		double vampire_count = 0;
		double troll_count = 0;
		double swampmonster_count = 0;
		double witch_count = 0;
		double lab_count = 0;
		double monster_count = 0;
		if (!world.isClientSide()) {
			if (entity instanceof MonsterVillageMarkerEntity) {
				if (entity.tickCount % 20 == 0) {
					if (MonstrousWorldConfigConfiguration.ENABLE_SOCIETY_RAIDS.get() == true) {
						if (!(raider_count >= 1)) {
							raider_count = 0;
						}
						if (!(monster_count >= 1)) {
							monster_count = 0;
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(300 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.toList()) {
								if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:monster_being")))) {
									monster_count = monster_count + 1;
								}
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof RaidEntity) {
									if (entity.getPersistentData().getDouble("raiders_left") < (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
										entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
									}
									if (entity.getPersistentData().getDouble("raiders_left") > (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.setHealth((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
									}
								}
							}
						}
						if (!(entity.getPersistentData().getDouble("wave") >= 1)) {
							if (monster_count >= 1) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList()) {
										if (entityiterator instanceof ServerPlayer) {
											if (entityiterator instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(MonstrousWorldModMobEffects.BAD_OMEN_SOCIETY)) {
												entity.getPersistentData().putDouble("raiders_left", 12);
												entity.getPersistentData().putDouble("wave", 1);
												entity.getPersistentData().putDouble("direction", (Mth.nextInt(RandomSource.create(), 1, 4)));
												if (entityiterator instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Wave 1"), false);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")),
																SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL,
																1, 1, false);
													}
												}
												if (entity.getPersistentData().getDouble("direction") == 1) {
													for (int _i1 = 0; _i1 < 12; _i1++) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = MonstrousWorldModEntities.AGGRESSIVE_GUARD.get().spawn(_level,
																	BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)), z + 60), MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setDeltaMovement(0, 0, 0);
															}
														}
													}
												}
												if (entity.getPersistentData().getDouble("direction") == 2) {
													for (int _i1 = 0; _i1 < 12; _i1++) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = MonstrousWorldModEntities.AGGRESSIVE_GUARD.get().spawn(_level,
																	BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)), z - 60), MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setDeltaMovement(0, 0, 0);
															}
														}
													}
												}
												if (entity.getPersistentData().getDouble("direction") == 3) {
													for (int _i1 = 0; _i1 < 12; _i1++) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = MonstrousWorldModEntities.AGGRESSIVE_GUARD.get().spawn(_level,
																	BlockPos.containing(x - 60, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)), z), MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setDeltaMovement(0, 0, 0);
															}
														}
													}
												}
												if (entity.getPersistentData().getDouble("direction") == 4) {
													for (int _i1 = 0; _i1 < 12; _i1++) {
														if (world instanceof ServerLevel _level) {
															Entity entityToSpawn = MonstrousWorldModEntities.AGGRESSIVE_GUARD.get().spawn(_level,
																	BlockPos.containing(x + 60, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)), z), MobSpawnType.MOB_SUMMONED);
															if (entityToSpawn != null) {
																entityToSpawn.setDeltaMovement(0, 0, 0);
															}
														}
													}
												}
												if (entityiterator instanceof LivingEntity _entity)
													_entity.removeEffect(MonstrousWorldModMobEffects.BAD_OMEN_SOCIETY);
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.Raid_Fighters = entity.getPersistentData().getDouble("raiders_left");
													_vars.markSyncDirty();
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.RAID.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 0.25, entity.getZ()), MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
											}
										}
									}
								}
							}
						} else if (entity.getPersistentData().getDouble("wave") == 5) {
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (entity.getPersistentData().getDouble("raiders_left") == 0) {
									entity.getPersistentData().putDouble("wave", 0);
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream()
												.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
											if (entityiterator instanceof ServerPlayer) {
												if (entityiterator instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Victory!"), false);
												if (entityiterator instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:hero_of_the_monster_village"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HERO_OF_THE_VILLAGE, 72000, 0));
												if (world instanceof ServerLevel _level)
													_level.addFreshEntity(new ExperienceOrb(_level, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1000));
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.Raid_Fighters = 0;
													_vars.markSyncDirty();
												}
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
													if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.FactionLevel = 5;
															_vars.markSyncDirty();
														}
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																		BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")),
																		SoundSource.NEUTRAL, 1, 1, false);
															}
														}
														if (entityiterator instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("You advance a level!"), false);
														if (entityiterator instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:fierce_protector"));
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
											}
										}
									}
								}
							});
						} else if (entity.getPersistentData().getDouble("wave") >= 1 && entity.getPersistentData().getDouble("wave") <= 4) {
							if (entity.getPersistentData().getDouble("raiders_left") == 0 && entity.getPersistentData().getDouble("next_wave_time") == 0) {
								entity.getPersistentData().putDouble("next_wave_time", (world.dayTime() + 100));
							}
							if (entity.getPersistentData().getDouble("next_wave_time") != 0 && world.dayTime() >= entity.getPersistentData().getDouble("next_wave_time")) {
								entity.getPersistentData().putDouble("next_wave_time", 0);
								entity.getPersistentData().putDouble("wave", (entity.getPersistentData().getDouble("wave") + 1));
								entity.getPersistentData().putDouble("direction", (Mth.nextInt(RandomSource.create(), 1, 4)));
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.RAID.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 0.25, entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
								{
									final Vec3 _center = new Vec3(x, y, z);
									for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList()) {
										if (entityiterator instanceof ServerPlayer) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")),
															SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1,
															false);
												}
											}
											if (entityiterator instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("A new wave approaches!"), false);
										}
									}
								}
								if (entity.getPersistentData().getDouble("direction") == 1) {
									for (int _i1 = 0; _i1 < 12; _i1++) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.AGGRESSIVE_GUARD.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)), z + 60),
													MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
									}
								}
								if (entity.getPersistentData().getDouble("direction") == 2) {
									for (int _i1 = 0; _i1 < 12; _i1++) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.AGGRESSIVE_GUARD.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)), z - 60),
													MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
									}
								}
								if (entity.getPersistentData().getDouble("direction") == 3) {
									for (int _i1 = 0; _i1 < 12; _i1++) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.AGGRESSIVE_GUARD.get().spawn(_level, BlockPos.containing(x - 60, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)), z),
													MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
									}
								}
								if (entity.getPersistentData().getDouble("direction") == 4) {
									for (int _i1 = 0; _i1 < 12; _i1++) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.AGGRESSIVE_GUARD.get().spawn(_level, BlockPos.containing(x + 60, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)), z),
													MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
									}
								}
							}
						}
						if (entity.getPersistentData().getDouble("wave") >= 1) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(400 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof AggressiveGuardEntity) {
										raider_count = raider_count + 1;
									}
									if (entityiterator instanceof ServerPlayer) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Raid_Fighters = entity.getPersistentData().getDouble("raiders_left");
											_vars.markSyncDirty();
										}
									}
								}
							}
						}
						entity.getPersistentData().putDouble("raiders_left", raider_count);
						if (raider_count >= 1) {
							if (monster_count == 0) {
								if (entity.getPersistentData().getDouble("wave") >= 1) {
									entity.getPersistentData().putDouble("wave", 0);
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream()
												.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
											if (entityiterator instanceof ServerPlayer) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.Raid_Fighters = 0;
													_vars.markSyncDirty();
												}
												if (entityiterator instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Village defeated"), false);
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
}