package net.mcreator.monstrousworld.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.google.common.collect.ImmutableMap;

public class TallYellowPumpkinBlockBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public TallYellowPumpkinBlockBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).strength(0.3f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(3, 1, 3, 13, 10, 4), box(3, 1, 4, 4, 10, 13), box(12, 1, 4, 13, 10, 13), box(4, 1, 12, 12, 10, 13), box(4, 9, 4, 12, 10, 12), box(5, 10, 5, 11, 11, 11), box(7, 10, 7, 9, 13, 8));
				case EAST -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(12, 1, 3, 13, 10, 13), box(3, 1, 3, 12, 10, 4), box(3, 1, 12, 12, 10, 13), box(3, 1, 4, 4, 10, 12), box(4, 9, 4, 12, 10, 12), box(5, 10, 5, 11, 11, 11), box(8, 10, 7, 9, 13, 9));
				case WEST -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(3, 1, 3, 4, 10, 13), box(4, 1, 12, 13, 10, 13), box(4, 1, 3, 13, 10, 4), box(12, 1, 4, 13, 10, 12), box(4, 9, 4, 12, 10, 12), box(5, 10, 5, 11, 11, 11), box(7, 10, 7, 8, 13, 9));
				default -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(3, 1, 12, 13, 10, 13), box(12, 1, 3, 13, 10, 12), box(3, 1, 3, 4, 10, 12), box(4, 1, 3, 12, 10, 4), box(4, 9, 4, 12, 10, 12), box(5, 10, 5, 11, 11, 11), box(7, 10, 8, 9, 13, 9));
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
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}