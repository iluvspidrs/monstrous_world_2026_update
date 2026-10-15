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

public class CoffinTopBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public CoffinTopBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BLOCKSTATE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(BLOCKSTATE) == 1) {
				return switch (state.getValue(FACING)) {
					case NORTH -> Shapes.or(box(0, 0, 0, 1, 16, 16), box(15, 0, 0, 16, 16, 16), box(0, 0, 15, 16, 16, 16), box(0, 15, 0, 16, 16, 16));
					case EAST -> Shapes.or(box(0, 0, 0, 16, 16, 1), box(0, 0, 15, 16, 16, 16), box(0, 0, 0, 1, 16, 16), box(0, 15, 0, 16, 16, 16));
					case WEST -> Shapes.or(box(0, 0, 15, 16, 16, 16), box(0, 0, 0, 16, 16, 1), box(15, 0, 0, 16, 16, 16), box(0, 15, 0, 16, 16, 16));
					default -> Shapes.or(box(15, 0, 0, 16, 16, 16), box(0, 0, 0, 1, 16, 16), box(0, 0, 0, 16, 16, 1), box(0, 15, 0, 16, 16, 16));
				};
			}
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(0, 0, 0, 1, 16, 16), box(15, 0, 0, 16, 16, 16), box(0, 0, 15, 16, 16, 16), box(0, 15, 0, 16, 16, 16), box(0, 0, 0, 16, 16, 1));
				case EAST -> Shapes.or(box(0, 0, 0, 16, 16, 1), box(0, 0, 15, 16, 16, 16), box(0, 0, 0, 1, 16, 16), box(0, 15, 0, 16, 16, 16), box(15, 0, 0, 16, 16, 16));
				case WEST -> Shapes.or(box(0, 0, 15, 16, 16, 16), box(0, 0, 0, 16, 16, 1), box(15, 0, 0, 16, 16, 16), box(0, 15, 0, 16, 16, 16), box(0, 0, 0, 1, 16, 16));
				default -> Shapes.or(box(15, 0, 0, 16, 16, 16), box(0, 0, 0, 1, 16, 16), box(0, 0, 0, 16, 16, 1), box(0, 15, 0, 16, 16, 16), box(0, 0, 15, 16, 16, 16));
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