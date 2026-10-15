package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class TrollWarHammerBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))) {
				if (!entity.isShiftKeyDown()) {
					int horizontalRadiusSquare = (int) 2 - 1;
					int verticalRadiusSquare = (int) 2 - 1;
					int yIterationsSquare = verticalRadiusSquare;
					for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
						for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
							for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
								// Execute the desired statements within the square/cube
								if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))) {
									{
										BlockPos _pos = BlockPos.containing(x + xi, y + i, z + zi);
										Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xi, y + i, z + zi), null);
										world.destroyBlock(_pos, false);
									}
								}
							}
						}
					}
				}
			}
			if (!entity.isShiftKeyDown()) {
				int horizontalRadiusSquare = (int) 2 - 1;
				int verticalRadiusSquare = (int) 2 - 1;
				int yIterationsSquare = verticalRadiusSquare;
				for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
					for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
						for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
							// Execute the desired statements within the square/cube
							if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.TUNGSTEN_ORE.get()) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x + xi, y + i, z + zi, new ItemStack(MonstrousWorldModItems.RAW_TUNGSTEN.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								world.setBlock(BlockPos.containing(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
							}
						}
					}
				}
			}
		}
	}
}