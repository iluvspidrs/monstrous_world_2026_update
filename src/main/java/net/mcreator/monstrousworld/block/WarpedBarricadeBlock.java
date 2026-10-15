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

public class WarpedBarricadeBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public WarpedBarricadeBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_NYLIUM).sound(SoundType.STEM).strength(0.5f, 5f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(0, 1, 15, 9, 4, 16), box(9, 2, 15, 16, 5, 16), box(7, 7, 15, 16, 8, 16), box(0, 8, 15, 7, 10, 16), box(0, 11, 15, 10, 13, 16), box(10, 12, 15, 16, 15, 16));
				case EAST -> Shapes.or(box(0, 1, 0, 1, 4, 9), box(0, 2, 9, 1, 5, 16), box(0, 7, 7, 1, 8, 16), box(0, 8, 0, 1, 10, 7), box(0, 11, 0, 1, 13, 10), box(0, 12, 10, 1, 15, 16));
				case WEST -> Shapes.or(box(15, 1, 7, 16, 4, 16), box(15, 2, 0, 16, 5, 7), box(15, 7, 0, 16, 8, 9), box(15, 8, 9, 16, 10, 16), box(15, 11, 6, 16, 13, 16), box(15, 12, 0, 16, 15, 6));
				default -> Shapes.or(box(7, 1, 0, 16, 4, 1), box(0, 2, 0, 7, 5, 1), box(0, 7, 0, 9, 8, 1), box(9, 8, 0, 16, 10, 1), box(6, 11, 0, 16, 13, 1), box(0, 12, 0, 6, 15, 1));
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