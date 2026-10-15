package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.HumanWerewolfEntity;
import net.mcreator.monstrousworld.entity.FollowerWerewolfEntity;

import javax.annotation.Nullable;

import java.util.UUID;
import java.util.Comparator;

@EventBusSubscriber
public class WerewolfNPCsFullMoonProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		String UUID = "";
		if (!world.isClientSide()) {
			if (entity instanceof HumanWerewolfEntity) {
				if (world.dimensionType().moonPhase(world.dayTime()) == 0 && MonstrousWorldModVariables.TimeUntilNight < 0) {
					if ((entity instanceof HumanWerewolfEntity _datEntI ? _datEntI.getEntityData().get(HumanWerewolfEntity.DATA_Skin) : 0) == 1) {
						entity.getPersistentData().putDouble("HumanWerewolf", 1);
					}
					if ((entity instanceof HumanWerewolfEntity _datEntI ? _datEntI.getEntityData().get(HumanWerewolfEntity.DATA_Skin) : 0) == 2) {
						entity.getPersistentData().putDouble("HumanWerewolf", 2);
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.FOLLOWER_WEREWOLF.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof FollowerWerewolfEntity) {
								entityiterator.getPersistentData().putDouble("HumanWerewolf", (entity.getPersistentData().getDouble("HumanWerewolf")));
								entityiterator.getPersistentData().putString("Owner", (entity.getPersistentData().getString("Owner")));
								entityiterator.getPersistentData().putString("NoSoul", (entity.getPersistentData().getString("NoSoul")));
								entityiterator.getPersistentData().putString("UUID", (entity.getStringUUID()));
								Entity _ent24 = entityiterator;
								if (!(_ent24 instanceof Player) && !_ent24.level().isClientSide())
									_ent24.setUUID(entity.getUUID());
							}
						}
					}
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
			if (entity instanceof FollowerWerewolfEntity) {
				if (world.dimensionType().moonPhase(world.dayTime()) != 0 || MonstrousWorldModVariables.TimeUntilNight > 0) {
					if (!(entity.getPersistentData().getBoolean("Angry") == true)) {
						if (entity.getPersistentData().getDouble("HumanWerewolf") == 1) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.HUMAN_WEREWOLF.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof HumanWerewolfEntity) {
										if (entityiterator instanceof HumanWerewolfEntity _datEntSetI)
											_datEntSetI.getEntityData().set(HumanWerewolfEntity.DATA_Skin, 1);
										entityiterator.getPersistentData().putString("Owner", (entity.getPersistentData().getString("Owner")));
										entityiterator.getPersistentData().putString("NoSoul", (entity.getPersistentData().getString("NoSoul")));
										Entity _ent45 = entityiterator;
										if (!(_ent45 instanceof Player) && !_ent45.level().isClientSide())
											_ent45.setUUID(entity.getUUID());
									}
								}
							}
							if (!entity.level().isClientSide())
								entity.discard();
						}
						if (entity.getPersistentData().getDouble("HumanWerewolf") == 2) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.HUMAN_WEREWOLF.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof HumanWerewolfEntity) {
										if (entityiterator instanceof HumanWerewolfEntity _datEntSetI)
											_datEntSetI.getEntityData().set(HumanWerewolfEntity.DATA_Skin, 2);
										entityiterator.getPersistentData().putString("Owner", (entity.getPersistentData().getString("Owner")));
										entityiterator.getPersistentData().putString("NoSoul", (entity.getPersistentData().getString("NoSoul")));
										Entity _ent63 = entityiterator;
										if (!(_ent63 instanceof Player) && !_ent63.level().isClientSide())
											_ent63.setUUID(entity.getUUID());
									}
								}
							}
							if (!entity.level().isClientSide())
								entity.discard();
						}
					}
				}
			}
		}
	}
}