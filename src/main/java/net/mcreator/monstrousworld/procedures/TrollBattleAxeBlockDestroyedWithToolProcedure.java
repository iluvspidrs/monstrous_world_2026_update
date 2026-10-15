package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class TrollBattleAxeBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
				if (!entity.isShiftKeyDown()) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
					int horizontalRadiusSquare = (int) 2 - 1;
					int verticalRadiusSquare = (int) 40 - 1;
					int yIterationsSquare = verticalRadiusSquare;
					for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
						for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
							for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
								// Execute the desired statements within the square/cube
								if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
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
		}
	}
}