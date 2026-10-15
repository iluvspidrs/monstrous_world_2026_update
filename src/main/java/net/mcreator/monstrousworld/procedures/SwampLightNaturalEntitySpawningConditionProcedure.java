package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.monstrousworld.entity.SwampLightEntity;

public class SwampLightNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(SwampLightEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}