package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.entity.FeralVampireEntity;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class FeralVampireNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(FeralVampireEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(250 / 2d), e -> true).isEmpty())) {
			if (!world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("monstrous_world:is_spooky")))) {
				if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.VAMPIRE_SPAWN_CHANCE.get()) {
					return true;
				}
				return false;
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("monstrous_world:is_spooky")))) {
				if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.FERAL_VAMPIRE_SPAWN_CHANCE_SPOOKY.get()) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
}