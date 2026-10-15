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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.google.common.collect.ImmutableMap;

public class SwampLanternBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 2);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public SwampLanternBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).sound(SoundType.LANTERN).strength(1f, 10f).lightLevel(blockstate -> 10).noOcclusion().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BLOCKSTATE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(BLOCKSTATE) == 1) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(6, 0, 6, 10, 1, 10), box(7, 1, 7, 9, 6, 9));
					case EAST -> Shapes.or(box(6, 0, 6, 10, 1, 10), box(7, 1, 7, 9, 6, 9));
					case WEST -> Shapes.or(box(6, 0, 6, 10, 1, 10), box(7, 1, 7, 9, 6, 9));
					default -> Shapes.or(box(6, 0, 6, 10, 1, 10), box(7, 1, 7, 9, 6, 9));
				};
			} else if (state.getValue(BLOCKSTATE) == 2) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(6, 6, 15, 10, 10, 16), box(7, 7, 10, 9, 9, 15));
					case EAST -> Shapes.or(box(0, 6, 6, 1, 10, 10), box(1, 7, 7, 6, 9, 9));
					case WEST -> Shapes.or(box(15, 6, 6, 16, 10, 10), box(10, 7, 7, 15, 9, 9));
					default -> Shapes.or(box(6, 6, 0, 10, 10, 1), box(7, 7, 1, 9, 9, 6));
				};
			}
			return switch (state.getValue(FACING)) {
				case NORTH -> box(5, 0, 5, 11, 9, 11);
				case EAST -> box(5, 0, 5, 11, 9, 11);
				case WEST -> box(5, 0, 5, 11, 9, 11);
				default -> box(5, 0, 5, 11, 9, 11);
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
}