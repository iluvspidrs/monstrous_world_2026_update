package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class DeadlyFloorTIleEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 2) {
				if (!((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == MonstrousWorldModBlocks.TOXIC_GAS.get())) {
					if (!((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == MonstrousWorldModBlocks.TOXIC_GAS.get())) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState(), 3);
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel < 3) {
				if (!((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == MonstrousWorldModBlocks.TOXIC_GAS.get())) {
					if (!((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == MonstrousWorldModBlocks.TOXIC_GAS.get())) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState(), 3);
					}
				}
			}
			if (!entity.isShiftKeyDown()) {
				if (!((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == MonstrousWorldModBlocks.TOXIC_GAS.get())) {
					if (!((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == MonstrousWorldModBlocks.TOXIC_GAS.get())) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState(), 3);
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState(), 3);
					}
				}
			}
		}
	}
}