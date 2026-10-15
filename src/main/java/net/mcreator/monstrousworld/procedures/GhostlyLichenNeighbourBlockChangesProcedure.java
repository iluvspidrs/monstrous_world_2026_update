package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GhostlyLichenNeighbourBlockChangesProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == MonstrousWorldModBlocks.GHOSTLY_LICHEN.get() && (getBlockDirection(world, BlockPos.containing(x, y, z - 1))) == Direction.NORTH) {
			world.destroyBlock(BlockPos.containing(x, y, z - 1), false);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == MonstrousWorldModBlocks.GHOSTLY_LICHEN.get() && (getBlockDirection(world, BlockPos.containing(x, y, z + 1))) == Direction.SOUTH) {
			world.destroyBlock(BlockPos.containing(x, y, z + 1), false);
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == MonstrousWorldModBlocks.GHOSTLY_LICHEN.get() && (getBlockDirection(world, BlockPos.containing(x + 1, y, z))) == Direction.EAST) {
			world.destroyBlock(BlockPos.containing(x + 1, y, z), false);
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == MonstrousWorldModBlocks.GHOSTLY_LICHEN.get() && (getBlockDirection(world, BlockPos.containing(x - 1, y, z))) == Direction.WEST) {
			world.destroyBlock(BlockPos.containing(x - 1, y, z), false);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == MonstrousWorldModBlocks.BLOODY_LICHEN.get() && (getBlockDirection(world, BlockPos.containing(x, y, z - 1))) == Direction.NORTH) {
			world.destroyBlock(BlockPos.containing(x, y, z - 1), false);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == MonstrousWorldModBlocks.BLOODY_LICHEN.get() && (getBlockDirection(world, BlockPos.containing(x, y, z + 1))) == Direction.SOUTH) {
			world.destroyBlock(BlockPos.containing(x, y, z + 1), false);
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == MonstrousWorldModBlocks.BLOODY_LICHEN.get() && (getBlockDirection(world, BlockPos.containing(x + 1, y, z))) == Direction.EAST) {
			world.destroyBlock(BlockPos.containing(x + 1, y, z), false);
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == MonstrousWorldModBlocks.BLOODY_LICHEN.get() && (getBlockDirection(world, BlockPos.containing(x - 1, y, z))) == Direction.WEST) {
			world.destroyBlock(BlockPos.containing(x - 1, y, z), false);
		}
	}

	private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos);
		Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (property != null && blockState.getValue(property) instanceof Direction direction)
			return direction;
		else if (blockState.hasProperty(BlockStateProperties.AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
		else if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}
}