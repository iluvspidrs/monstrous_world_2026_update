package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.entity.WillOTheWispEntity;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class WillOTheWispNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/shovel")))) {
			if (!(world instanceof Level _lvl2 && _lvl2.isDay())) {
				if (!(!world.getEntitiesOfClass(WillOTheWispEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(100 / 2d), e -> true).isEmpty())) {
					if (world.getBrightness(LightLayer.BLOCK, BlockPos.containing(x, y, z)) <= 7) {
						if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.WISP_SPAWN_CHANCE.get()) {
							return true;
						}
						return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}