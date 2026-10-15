package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.DemonNPCEntity;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class DemonSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
			if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.DEMON_SPAWN_CHANCE.get()) {
				if (!(!world.getEntitiesOfClass(DemonNPCEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(120 / 2d), e -> true).isEmpty())) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
}