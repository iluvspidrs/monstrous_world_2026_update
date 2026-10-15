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

public class WidePumpkinLanternBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public WidePumpkinLanternBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1f, 10f).lightLevel(blockstate -> 9).noOcclusion().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(3, 1, 3, 13, 2, 4), box(12, 2, 3, 13, 8, 4), box(3, 2, 3, 4, 8, 4), box(4, 7, 3, 12, 8, 4), box(11, 3, 3, 12, 7, 4), box(4, 3, 3, 5, 7, 4), box(7, 5, 3, 9, 7, 4),
						box(5, 4, 3, 11, 5, 4), box(3, 1, 4, 4, 8, 13), box(12, 1, 4, 13, 8, 13), box(4, 1, 12, 12, 8, 13), box(4, 7, 4, 12, 8, 12), box(5, 8, 5, 11, 9, 11), box(7, 8, 8, 9, 11, 9));
				case EAST -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(12, 1, 3, 13, 2, 13), box(12, 2, 12, 13, 8, 13), box(12, 2, 3, 13, 8, 4), box(12, 7, 4, 13, 8, 12), box(12, 3, 11, 13, 7, 12), box(12, 3, 4, 13, 7, 5), box(12, 5, 7, 13, 7, 9),
						box(12, 4, 5, 13, 5, 11), box(3, 1, 3, 12, 8, 4), box(3, 1, 12, 12, 8, 13), box(3, 1, 4, 4, 8, 12), box(4, 7, 4, 12, 8, 12), box(5, 8, 5, 11, 9, 11), box(7, 8, 7, 8, 11, 9));
				case WEST -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(3, 1, 3, 4, 2, 13), box(3, 2, 3, 4, 8, 4), box(3, 2, 12, 4, 8, 13), box(3, 7, 4, 4, 8, 12), box(3, 3, 4, 4, 7, 5), box(3, 3, 11, 4, 7, 12), box(3, 5, 7, 4, 7, 9),
						box(3, 4, 5, 4, 5, 11), box(4, 1, 12, 13, 8, 13), box(4, 1, 3, 13, 8, 4), box(12, 1, 4, 13, 8, 12), box(4, 7, 4, 12, 8, 12), box(5, 8, 5, 11, 9, 11), box(8, 8, 7, 9, 11, 9));
				default -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(3, 1, 12, 13, 2, 13), box(3, 2, 12, 4, 8, 13), box(12, 2, 12, 13, 8, 13), box(4, 7, 12, 12, 8, 13), box(4, 3, 12, 5, 7, 13), box(11, 3, 12, 12, 7, 13), box(7, 5, 12, 9, 7, 13),
						box(5, 4, 12, 11, 5, 13), box(12, 1, 3, 13, 8, 12), box(3, 1, 3, 4, 8, 12), box(4, 1, 3, 12, 8, 4), box(4, 7, 4, 12, 8, 12), box(5, 8, 5, 11, 9, 11), box(7, 8, 7, 9, 11, 8));
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