package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.VengefulPumpkinEntity;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class PumpkinsRevengeActiveTickConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double sxr = 0;
		double szr = 0;
		double szrn = 0;
		double sxrn = 0;
		double sxrp = 0;
		double szrp = 0;
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MonstrousWorldModMobEffects.PUMPKINS_REVENGE)) {
				sx = Mth.nextInt(RandomSource.create(), -6, 6);
				for (int _i1 = 0; _i1 < 6; _i1++) {
					sy = 0;
					for (int _i2 = 0; _i2 < 6; _i2++) {
						sz = Mth.nextInt(RandomSource.create(), -6, 6);
						for (int _i3 = 0; _i3 < 6; _i3++) {
							if ((world.getBlockState(BlockPos.containing(x + sx, y + 0, z + sz))).is(BlockTags.create(ResourceLocation.parse("neoforge:pumpkin_traps")))) {
								world.destroyBlock(BlockPos.containing(x + sx, y + sy, z + sz), false);
								if (!(!world.getEntitiesOfClass(VengefulPumpkinEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(1 / 2d), e -> true).isEmpty())) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.VENGEFUL_PUMPKIN.get().spawn(_level, BlockPos.containing(x + sx, y + sy, z + sz), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
								}
							}
							sz = sz + 1;
						}
						sy = 0;
					}
					sx = sx + 1;
				}
			}
			if ((double) MonstrousWorldConfigConfiguration.PUMPKINS_REVENGE_CHANCE.get() == 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.PUMPKINS_REVENGE);
			}
		}
	}
}