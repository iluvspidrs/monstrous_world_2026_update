package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.ChannelerSparkEntity;

import java.util.Comparator;

public class ChannelerSparkOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				if (!(!world.getEntitiesOfClass(ChannelerSparkEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, (y - 1), z)).inflate(1 / 2d), e -> true).isEmpty())) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.CHANNELER_SPARK.get().spawn(_level, BlockPos.containing(x, y - 1, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					{
						final Vec3 _center = new Vec3(x, (y - 1), z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							entityiterator.getPersistentData().putString("RobotType", (entity.getPersistentData().getString("RobotType")));
						}
					}
				}
			}
		}
	}
}