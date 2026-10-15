package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;

public class EasyMiningOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			entity.getPersistentData().putDouble("OrePlace", (Mth.nextInt(RandomSource.create(), 1, 30)));
			if (entity.getPersistentData().getDouble("OrePlace") == 1) {
				entity.getPersistentData().putDouble("XCoordO", (Mth.nextInt(RandomSource.create(), (int) (entity.getX() - 16), (int) (entity.getX() + 16))));
				entity.getPersistentData().putDouble("ZCoordO", (Mth.nextInt(RandomSource.create(), (int) (entity.getZ() - 16), (int) (entity.getZ() + 16))));
				entity.getPersistentData().putDouble("YCoordO", (Mth.nextInt(RandomSource.create(), (int) (entity.getY() - 16), (int) (entity.getY() + 16))));
				if (world.isEmptyBlock(BlockPos.containing(entity.getPersistentData().getDouble("XCoordO"), entity.getPersistentData().getDouble("YCoordO"), entity.getPersistentData().getDouble("ZCoordO")))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.ORE_PLACEHOLDER.get().spawn(_level,
								BlockPos.containing(entity.getPersistentData().getDouble("XCoordO") + 0.5, entity.getPersistentData().getDouble("YCoordO"), entity.getPersistentData().getDouble("ZCoordO") + 0.5), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
	}
}