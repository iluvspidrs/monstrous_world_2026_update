package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.EnemyPlaceholderEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class EnemyPlaceholderDespawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof EnemyPlaceholderEntity) {
				MonstrousWorldMod.queueServerWork(15, () -> {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.TRICKED)) {
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Evil Spirit")) {
									if (Math.random() < 0.5) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.EVIL_DARKNESS_SPIRIT.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
											}
										}
									} else {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.EVIL_LEVITATING_SPIRIT.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
											}
										}
									}
									if (entityiterator instanceof LivingEntity _entity)
										_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
									entityiterator.getPersistentData().putString("Enemy_Type", "None");
									if (!entity.level().isClientSide())
										entity.discard();
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Zombie")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									if (!entity.level().isClientSide())
										entity.discard();
									MonstrousWorldMod.queueServerWork(4, () -> {
										entityiterator.getPersistentData().putString("Enemy_Type", "None");
										if (entityiterator instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
									});
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Spider")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									if (!entity.level().isClientSide())
										entity.discard();
									MonstrousWorldMod.queueServerWork(4, () -> {
										entityiterator.getPersistentData().putString("Enemy_Type", "None");
										if (entityiterator instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
									});
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Vengeful Pumpkin")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.VENGEFUL_PUMPKIN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									if (!entity.level().isClientSide())
										entity.discard();
									MonstrousWorldMod.queueServerWork(4, () -> {
										entityiterator.getPersistentData().putString("Enemy_Type", "None");
										if (entityiterator instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
									});
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Vampire")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.FERAL_VAMPIRE.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									if (entityiterator instanceof LivingEntity _entity)
										_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
									entityiterator.getPersistentData().putString("Enemy_Type", "None");
									if (!entity.level().isClientSide())
										entity.discard();
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Werewolf")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.FERAL_WEREWOLF.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									if (entityiterator instanceof LivingEntity _entity)
										_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
									entityiterator.getPersistentData().putString("Enemy_Type", "None");
									if (!entity.level().isClientSide())
										entity.discard();
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Maniac")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MANIAC.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									if (entityiterator instanceof LivingEntity _entity)
										_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
									entityiterator.getPersistentData().putString("Enemy_Type", "None");
									if (!entity.level().isClientSide())
										entity.discard();
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Feral Mountain Troll")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.FERAL_MOUNTAIN_TROLL.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									if (entityiterator instanceof LivingEntity _entity)
										_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
									entityiterator.getPersistentData().putString("Enemy_Type", "None");
									if (!entity.level().isClientSide())
										entity.discard();
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Dire Werewolf")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.DIRE_WEREWOLF.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									if (entityiterator instanceof LivingEntity _entity)
										_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
									entityiterator.getPersistentData().putString("Enemy_Type", "None");
									if (!entity.level().isClientSide())
										entity.discard();
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Society Goon")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									MonstrousWorldMod.queueServerWork(4, () -> {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
										entityiterator.getPersistentData().putString("Enemy_Type", "None");
										if (!entity.level().isClientSide())
											entity.discard();
									});
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Dreadful Watchers")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.DREADFUL_WATCHER.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									MonstrousWorldMod.queueServerWork(4, () -> {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
										entityiterator.getPersistentData().putString("Enemy_Type", "None");
										if (!entity.level().isClientSide())
											entity.discard();
									});
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Snake")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.GIANT_SNAKE.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									MonstrousWorldMod.queueServerWork(4, () -> {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
										entityiterator.getPersistentData().putString("Enemy_Type", "None");
										if (!entity.level().isClientSide())
											entity.discard();
									});
								}
								if ((entityiterator.getPersistentData().getString("Enemy_Type")).equals("Clown")) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.EVIL_CLOWN_1.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									MonstrousWorldMod.queueServerWork(4, () -> {
										if (entityiterator instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.TRICKED);
										entityiterator.getPersistentData().putString("Enemy_Type", "None");
										if (!entity.level().isClientSide())
											entity.discard();
									});
								}
							}
						}
					}
				});
				MonstrousWorldMod.queueServerWork(20, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
				});
			}
		}
	}
}