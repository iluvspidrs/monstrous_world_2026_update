package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class Possessed2ActiveTickConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!world.isClientSide()) {
			sx = Mth.nextInt(RandomSource.create(), -6, 6);
			for (int _i1 = 0; _i1 < 6; _i1++) {
				sy = Mth.nextInt(RandomSource.create(), -6, 6);
				for (int _i2 = 0; _i2 < 6; _i2++) {
					sz = Mth.nextInt(RandomSource.create(), -6, 6);
					for (int _i3 = 0; _i3 < 6; _i3++) {
						if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getLightEmission(world, BlockPos.containing(x + sx, y + sy, z + sz)) >= 4) {
							if ((BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock()).toString()).contains("torch")
									|| (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock()).toString()).contains("lantern")
									|| (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock()).toString()).contains("glowstone")
									|| (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock()).toString()).contains("campfire")
									|| (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock()).toString()).contains("light")
									|| (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock()).toString()).contains("bulb")
									|| (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock()).toString()).contains("lamp")
									|| (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock()).toString()).contains("candle")) {
								{
									BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + sx, y + sy, z + sz), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
						sz = sz + 1;
					}
					sy = 0;
				}
				sx = sx + 1;
			}
			if ((double) MonstrousWorldConfigConfiguration.POSSESSION_CHANCE.get() == 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.POSSESSED_2);
				entity.getPersistentData().putDouble("dark_possessed", 0);
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Possession = 0;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}