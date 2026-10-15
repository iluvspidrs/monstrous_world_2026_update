package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class HunterPatrolsSpawnBlockPlacedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if ((sourceentity.level().dimension()) == Level.OVERWORLD) {
				if (sourceentity instanceof ServerPlayer) {
					if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true)) {
						if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) sourceentity.getX(), (int) sourceentity.getZ()) <= sourceentity.getY()) {
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -75) {
								if (Mth.nextInt(RandomSource.create(), 1, 150) == 1) {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40)), z + 40),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40))), (z + 40));
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x + 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 40), (int) z), z),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3((x + 40), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 40), (int) z)), z);
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 40)), z - 40),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 40))), (z - 40));
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x - 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 40), (int) z), z),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3((x - 40), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 40), (int) z)), z);
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
								}
							} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -50) {
								if (Mth.nextInt(RandomSource.create(), 1, 250) == 1) {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40)), z + 40),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40))), (z + 40));
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x + 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 40), (int) z), z),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3((x + 40), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 40), (int) z)), z);
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 40)), z - 40),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 40))), (z - 40));
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x - 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 40), (int) z), z),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3((x - 40), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 40), (int) z)), z);
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
								}
							} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
								if (Mth.nextInt(RandomSource.create(), 1, 350) == 1) {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40)), z + 40),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40))), (z + 40));
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x + 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 40), (int) z), z),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3((x + 40), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 40), (int) z)), z);
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 40)), z - 40),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 40))), (z - 40));
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
														}
													}
												}
											}
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
										if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
											for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x - 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 40), (int) z), z),
															MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												{
													final Vec3 _center = new Vec3((x - 40), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 40), (int) z)), z);
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HunterNPCEntity) {
															if (entityiterator instanceof HunterNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
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
		}
	}
}