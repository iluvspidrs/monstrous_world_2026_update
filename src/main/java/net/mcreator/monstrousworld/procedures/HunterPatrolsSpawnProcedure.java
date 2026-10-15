package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
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
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class HunterPatrolsSpawnProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity.level().dimension()) == Level.OVERWORLD) {
				if (entity instanceof ServerPlayer) {
					if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true)) {
						if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:hostile")))) {
							if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) <= entity.getY()) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -75) {
									if (Mth.nextInt(RandomSource.create(), 1, 100) == 1) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40)), z + 40), MobSpawnType.MOB_SUMMONED);
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
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x + 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 40), (int) z), z), MobSpawnType.MOB_SUMMONED);
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
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 40)), z - 40), MobSpawnType.MOB_SUMMONED);
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
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x - 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 40), (int) z), z), MobSpawnType.MOB_SUMMONED);
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
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -50) {
									if (Mth.nextInt(RandomSource.create(), 1, 200) == 1) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40)), z + 40), MobSpawnType.MOB_SUMMONED);
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
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x + 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 40), (int) z), z), MobSpawnType.MOB_SUMMONED);
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
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 40)), z - 40), MobSpawnType.MOB_SUMMONED);
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
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x - 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 40), (int) z), z), MobSpawnType.MOB_SUMMONED);
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
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
									if (Mth.nextInt(RandomSource.create(), 1, 300) == 1) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 40)), z + 40), MobSpawnType.MOB_SUMMONED);
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
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x + 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 40), (int) z), z), MobSpawnType.MOB_SUMMONED);
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
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 40)), z - 40), MobSpawnType.MOB_SUMMONED);
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
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
											if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
												for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level,
																BlockPos.containing(x - 40, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 40), (int) z), z), MobSpawnType.MOB_SUMMONED);
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
}