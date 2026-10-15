package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;

public class HunterPatrolNPCNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(HunterPatrolNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(400 / 2d), e -> true).isEmpty())) {
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				return true;
			}
			return false;
		}
		return false;
	}
}