package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.InfectedGoonEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;

public class GuardSpawnerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(AggressiveGuardEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(32 / 2d), e -> true).isEmpty())) {
			if (!(!world.getEntitiesOfClass(ServerPlayer.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(16 / 2d), e -> true).isEmpty())) {
				if (!(!world.getEntitiesOfClass(InfectedGoonEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(32 / 2d), e -> true).isEmpty())) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.AGGRESSIVE_GUARD.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 1, 1, 1, 1, 0.1);
				}
			}
		}
	}
}