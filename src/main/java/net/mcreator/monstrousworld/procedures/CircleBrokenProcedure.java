package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CircleBrokenProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:ritual_circle")))) {
				if ((world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 2, y, z), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 2, y, z), false);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x, y, z + 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x, y, z - 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 2, y, z + 1))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 2, y, z + 1), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 2, y, z - 1), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 2, y, z + 1), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 2, y, z - 1), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 1, y, z + 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 1, y, z + 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 1, y, z - 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 1, y, z - 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 3, y, z), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 3, y, z), false);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z + 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x, y, z + 3), false);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z - 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x, y, z - 3), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 3, y, z + 1), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 3, y, z - 1), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 3, y, z - 1))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 3, y, z - 1), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 3, y, z + 1))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 3, y, z + 1), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 3, y, z + 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 3, y, z - 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 3, y, z - 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 3, y, z - 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 3, y, z + 2))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 3, y, z + 2), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 1, y, z + 3), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 1, y, z + 3), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 1, y, z - 3), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 1, y, z - 3), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 2, y, z + 3), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 2, y, z + 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 2, y, z + 3), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 2, y, z - 3), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 2, y, z - 3))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 2, y, z - 3), false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.WHITE_SKULL_BRICKS.get()) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x, y + 1, z), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 1, y + 1, z), false);
				}
				if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x + 1, y - 1, z), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 1, y + 1, z), false);
				}
				if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
					world.destroyBlock(BlockPos.containing(x - 1, y - 1, z), false);
				}
			}
		}
	}
}