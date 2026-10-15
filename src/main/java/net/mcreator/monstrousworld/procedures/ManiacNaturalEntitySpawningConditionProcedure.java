package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.ManiacEntity;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class ManiacNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
			if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
				if (!(!world.getEntitiesOfClass(ManiacEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty())) {
					if (!world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("monstrous_world:is_spooky")))) {
						if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.MANIAC_SPAWN_CHANCE.get()) {
							return true;
						}
						return false;
					}
					if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("monstrous_world:is_spooky")))) {
						if (Mth.nextDouble(RandomSource.create(), 0, 100) < (double) MonstrousWorldConfigConfiguration.MANIAC_SPAWN_CHANCE_SPOOKY.get()) {
							return true;
						}
						return false;
					}
				}
				return false;
			}
			return false;
		}
		return false;
	}
}