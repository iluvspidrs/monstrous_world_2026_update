package net.mcreator.monstrousworld.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.RobotTableSectionEntityWalksOnTheBlockProcedure;

import com.google.common.collect.ImmutableMap;

public class RobotTableSectionBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 9);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public RobotTableSectionBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.CLAY).sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BLOCKSTATE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(BLOCKSTATE) == 1) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
					case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
					case WEST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
					default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
				};
			} else if (state.getValue(BLOCKSTATE) == 2) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
					case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
					case WEST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
					default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
				};
			} else if (state.getValue(BLOCKSTATE) == 3) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
					case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
					case WEST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
					default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
				};
			} else if (state.getValue(BLOCKSTATE) == 4) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(4, 7, 5, 12, 15, 12), box(4, 7, 4, 12, 15, 5));
					case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(4, 7, 4, 11, 15, 12), box(11, 7, 4, 12, 15, 12));
					case WEST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(5, 7, 4, 12, 15, 12), box(4, 7, 4, 5, 15, 12));
					default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(4, 7, 4, 12, 15, 11), box(4, 7, 11, 12, 15, 12));
				};
			} else if (state.getValue(BLOCKSTATE) == 5) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(5, 7, 0, 11, 13, 4), box(3, 7, 4, 13, 15, 16));
					case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(12, 7, 5, 16, 13, 11), box(0, 7, 3, 12, 15, 13));
					case WEST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(0, 7, 5, 4, 13, 11), box(4, 7, 3, 16, 15, 13));
					default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(5, 7, 12, 11, 13, 16), box(3, 7, 0, 13, 15, 12));
				};
			} else if (state.getValue(BLOCKSTATE) == 6) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(0, 7, 1, 16, 9, 3), box(0, 9, 2, 16, 11, 4), box(0, 7, 5, 16, 9, 7), box(0, 9, 6, 16, 11, 8), box(0, 7, 9, 16, 9, 11), box(0, 9, 10, 16, 11, 12),
							box(0, 7, 13, 16, 9, 15), box(0, 9, 14, 16, 11, 16));
					case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(13, 7, 0, 15, 9, 16), box(12, 9, 0, 14, 11, 16), box(9, 7, 0, 11, 9, 16), box(8, 9, 0, 10, 11, 16), box(5, 7, 0, 7, 9, 16), box(4, 9, 0, 6, 11, 16),
							box(1, 7, 0, 3, 9, 16), box(0, 9, 0, 2, 11, 16));
					case WEST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(1, 7, 0, 3, 9, 16), box(2, 9, 0, 4, 11, 16), box(5, 7, 0, 7, 9, 16), box(6, 9, 0, 8, 11, 16), box(9, 7, 0, 11, 9, 16), box(10, 9, 0, 12, 11, 16),
							box(13, 7, 0, 15, 9, 16), box(14, 9, 0, 16, 11, 16));
					default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(0, 7, 13, 16, 9, 15), box(0, 9, 12, 16, 11, 14), box(0, 7, 9, 16, 9, 11), box(0, 9, 8, 16, 11, 10), box(0, 7, 5, 16, 9, 7), box(0, 9, 4, 16, 11, 6),
							box(0, 7, 1, 16, 9, 3), box(0, 9, 0, 16, 11, 2));
				};
			} else if (state.getValue(BLOCKSTATE) == 7) {
				return switch (state.getValue(FACING)) {
					case NORTH ->
						Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(4, 7, 2, 12, 15, 5), box(3, 7, 5, 13, 16, 13), box(1, 11, 9, 3, 13, 11), box(13, 11, 9, 15, 13, 11), box(15, 10, 8, 16, 14, 12), box(0, 10, 8, 1, 14, 12));
					case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(11, 7, 4, 14, 15, 12), box(3, 7, 3, 11, 16, 13), box(5, 11, 1, 7, 13, 3), box(5, 11, 13, 7, 13, 15), box(4, 10, 15, 8, 14, 16), box(4, 10, 0, 8, 14, 1));
					case WEST ->
						Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(2, 7, 4, 5, 15, 12), box(5, 7, 3, 13, 16, 13), box(9, 11, 13, 11, 13, 15), box(9, 11, 1, 11, 13, 3), box(8, 10, 0, 12, 14, 1), box(8, 10, 15, 12, 14, 16));
					default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(4, 7, 11, 12, 15, 14), box(3, 7, 3, 13, 16, 11), box(13, 11, 5, 15, 13, 7), box(1, 11, 5, 3, 13, 7), box(0, 10, 4, 1, 14, 8), box(15, 10, 4, 16, 14, 8));
				};
			} else if (state.getValue(BLOCKSTATE) == 8) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(-1, 7, -1, 2, 13, 16), box(13, 7, -1, 16, 13, 16), box(2, 7, -1, 13, 15, 11), box(2, 7, 11, 13, 13, 17));
					case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(0, 7, -1, 17, 13, 2), box(0, 7, 13, 17, 13, 16), box(5, 7, 2, 17, 15, 13), box(-1, 7, 2, 5, 13, 13));
					case WEST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(-1, 7, 14, 16, 13, 17), box(-1, 7, 0, 16, 13, 3), box(-1, 7, 3, 11, 15, 14), box(11, 7, 3, 17, 13, 14));
					default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(14, 7, 0, 17, 13, 17), box(0, 7, 0, 3, 13, 17), box(3, 7, 5, 14, 15, 17), box(3, 7, -1, 14, 13, 5));
				};
			} else if (state.getValue(BLOCKSTATE) == 9) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(2, 7, 0, 7, 13, 16), box(9, 7, 0, 14, 13, 16));
					case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(0, 7, 2, 16, 13, 7), box(0, 7, 9, 16, 13, 14));
					case WEST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(0, 7, 9, 16, 13, 14), box(0, 7, 2, 16, 13, 7));
					default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16), box(9, 7, 0, 14, 13, 16), box(2, 7, 0, 7, 13, 16));
				};
			}
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
				case EAST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
				case WEST -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
				default -> Shapes.or(box(1, 0, 1, 15, 5, 15), box(0, 5, 0, 16, 7, 16));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(BLOCKSTATE, 0);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		RobotTableSectionEntityWalksOnTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}