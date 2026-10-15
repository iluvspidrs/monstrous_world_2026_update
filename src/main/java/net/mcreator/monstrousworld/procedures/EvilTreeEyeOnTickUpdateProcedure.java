package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.entity.EvilTreePassiveEntity;
import net.mcreator.monstrousworld.entity.EvilTreeHostileEntity;

public class EvilTreeEyeOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (!(!world.getEntitiesOfClass(EvilTreeHostileEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(6 / 2d), e -> true).isEmpty())) {
				if (!(!world.getEntitiesOfClass(EvilTreePassiveEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(6 / 2d), e -> true).isEmpty())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			}
		}
	}
}