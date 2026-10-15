package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;

public class AutumnMagicOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			entity.getPersistentData().putDouble("AutumnPlace", (Mth.nextInt(RandomSource.create(), 1, 50)));
			if (entity.getPersistentData().getDouble("AutumnPlace") == 1) {
				entity.getPersistentData().putDouble("XCoordA", (Mth.nextInt(RandomSource.create(), (int) (entity.getX() - 16), (int) (entity.getX() + 16))));
				entity.getPersistentData().putDouble("ZCoordA", (Mth.nextInt(RandomSource.create(), (int) (entity.getZ() - 16), (int) (entity.getZ() + 16))));
				entity.getPersistentData().putDouble("YCoordA", (Mth.nextInt(RandomSource.create(), (int) (entity.getY() - 16), (int) (entity.getY() + 16))));
				if (world.isEmptyBlock(BlockPos.containing(entity.getPersistentData().getDouble("XCoordA"), entity.getPersistentData().getDouble("YCoordA"), entity.getPersistentData().getDouble("ZCoordA")))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.AUTUMN_PLACEHOLDER.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("XCoordA") + 0.5, entity.getPersistentData().getDouble("YCoordA") + 0.5, entity.getPersistentData().getDouble("ZCoordA") + 0.5), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
	}
}