package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.LargePossessingEntityEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class DeepSequenceToLevel6Procedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("monstrous_world:the_deep"))) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Trident_Countdown >= 1) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Trident_Countdown = 0;
						_vars.markSyncDirty();
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0) >= 1) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN);
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
					if (MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed == false) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
							if (!(!world.getEntitiesOfClass(LargePossessingEntityEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(200 / 2d), e -> true).isEmpty())) {
								entity.getPersistentData().putDouble("DeepTimer", (entity.getPersistentData().getDouble("DeepTimer") + 1));
								if (entity.getPersistentData().getDouble("DeepTimer") == 800) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75You are ready..."), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 900) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75I have waited for you..."), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1000) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75They call me darkness and corruption, but I am something far greater"), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1100) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75When the gods died, I fell with them to this graveyard"), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1200) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75My shattered remains covered this realm, and I now have no form"), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1300) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75I birthed the ancient monsters of myth..."), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1400) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75Now my blood creates the monsters of today..."), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1500) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75...drawing straight from your imaginations"), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1600) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75To escape this limbo, I need a body"), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1700) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75We shall wear a crown of darkness"), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1800) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75And bear an aura of fear..."), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 1900) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A75I will be free!"), true);
								}
								if (entity.getPersistentData().getDouble("DeepTimer") == 2000) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.LARGE_POSSESSING_ENTITY.get().spawn(_level,
													BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40)) + 20, z + 20), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 20)) + 20, z + 20),
														BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 20)) + 20), (z + 20),
														BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.LARGE_POSSESSING_ENTITY.get().spawn(_level,
													BlockPos.containing(x + 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 20), (int) z) + 20, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x + 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 20)) + 20, z),
														BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound((x + 40), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 20)) + 20), z,
														BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.LARGE_POSSESSING_ENTITY.get().spawn(_level,
													BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 20)) + 20, z - 40), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 20)) + 20, z - 40),
														BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 20)) + 20), (z - 40),
														BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.LARGE_POSSESSING_ENTITY.get().spawn(_level,
													BlockPos.containing(x - 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 20), (int) z) + 20, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x - 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 20), (int) z) + 20, z),
														BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound((x - 40), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 20), (int) z) + 20), z,
														BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
								}
							} else {
								{
									final Vec3 _center = new Vec3(x, y, z);
									for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList()) {
										if (entityiterator instanceof LargePossessingEntityEntity) {
											if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
												_entity.setTarget(_ent);
										}
									}
								}
							}
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("DeepTimer", 0);
			}
		}
	}
}