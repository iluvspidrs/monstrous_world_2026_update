package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;

public class HunterVillageMarkerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (Math.random() > 0.95) {
				if (!(!world.getEntitiesOfClass(HunterNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(200 / 2d), e -> true).isEmpty())) {
					if (!(!world.getEntitiesOfClass(HunterPatrolNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(200 / 2d), e -> true).isEmpty())) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.HUNTER_NPC.get().spawn(_level, BlockPos.containing(x, y + 2, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
			}
		}
	}
}