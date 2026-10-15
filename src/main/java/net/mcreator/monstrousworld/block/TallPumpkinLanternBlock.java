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

public class TallPumpkinLanternBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public TallPumpkinLanternBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1f, 10f).lightLevel(blockstate -> 9).noOcclusion().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(3, 1, 3, 13, 3, 4), box(12, 3, 3, 13, 10, 4), box(3, 3, 3, 4, 10, 4), box(4, 9, 3, 12, 10, 4), box(11, 4, 3, 12, 9, 4), box(4, 4, 3, 5, 9, 4), box(7, 6, 3, 9, 9, 4),
						box(5, 5, 3, 11, 6, 4), box(3, 1, 4, 4, 10, 13), box(12, 1, 4, 13, 10, 13), box(4, 1, 12, 12, 10, 13), box(4, 9, 4, 12, 10, 12), box(5, 10, 5, 11, 11, 11), box(7, 10, 7, 9, 13, 8));
				case EAST -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(12, 1, 3, 13, 3, 13), box(12, 3, 12, 13, 10, 13), box(12, 3, 3, 13, 10, 4), box(12, 9, 4, 13, 10, 12), box(12, 4, 11, 13, 9, 12), box(12, 4, 4, 13, 9, 5), box(12, 6, 7, 13, 9, 9),
						box(12, 5, 5, 13, 6, 11), box(3, 1, 3, 12, 10, 4), box(3, 1, 12, 12, 10, 13), box(3, 1, 4, 4, 10, 12), box(4, 9, 4, 12, 10, 12), box(5, 10, 5, 11, 11, 11), box(8, 10, 7, 9, 13, 9));
				case WEST -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(3, 1, 3, 4, 3, 13), box(3, 3, 3, 4, 10, 4), box(3, 3, 12, 4, 10, 13), box(3, 9, 4, 4, 10, 12), box(3, 4, 4, 4, 9, 5), box(3, 4, 11, 4, 9, 12), box(3, 6, 7, 4, 9, 9),
						box(3, 5, 5, 4, 6, 11), box(4, 1, 12, 13, 10, 13), box(4, 1, 3, 13, 10, 4), box(12, 1, 4, 13, 10, 12), box(4, 9, 4, 12, 10, 12), box(5, 10, 5, 11, 11, 11), box(7, 10, 7, 8, 13, 9));
				default -> Shapes.or(box(4, 0, 4, 12, 1, 12), box(3, 1, 12, 13, 3, 13), box(3, 3, 12, 4, 10, 13), box(12, 3, 12, 13, 10, 13), box(4, 9, 12, 12, 10, 13), box(4, 4, 12, 5, 9, 13), box(11, 4, 12, 12, 9, 13), box(7, 6, 12, 9, 9, 13),
						box(5, 5, 12, 11, 6, 13), box(12, 1, 3, 13, 10, 12), box(3, 1, 3, 4, 10, 12), box(4, 1, 3, 12, 10, 4), box(4, 9, 4, 12, 10, 12), box(5, 10, 5, 11, 11, 11), box(7, 10, 8, 9, 13, 9));
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