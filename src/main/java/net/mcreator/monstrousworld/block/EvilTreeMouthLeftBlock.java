package net.mcreator.monstrousworld.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
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
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.EvilTreeEyeOnTickUpdateProcedure;

import com.google.common.collect.ImmutableMap;

public class EvilTreeMouthLeftBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public EvilTreeMouthLeftBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STEM).strength(-1, 3600000).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(0, 0, 0, 16, 1, 16), box(0, 1, 0, 1, 16, 16), box(1, 1, 0, 16, 3, 1), box(1, 1, 15, 16, 16, 16), box(1, 14, 0, 16, 16, 1), box(1, 10, 0, 2, 14, 1), box(1, 3, 0, 2, 7, 1), box(2, 3, 0, 4, 5, 1),
						box(15, 3, 0, 16, 5, 1), box(10, 3, 0, 11, 5, 1), box(5, 3, 0, 6, 5, 1), box(2, 12, 0, 4, 14, 1), box(15, 12, 0, 16, 14, 1), box(10, 12, 0, 11, 14, 1), box(5, 12, 0, 6, 14, 1), box(12, 13, 0, 14, 14, 1),
						box(7, 13, 0, 9, 14, 1), box(12, 3, 0, 14, 4, 1), box(7, 3, 0, 9, 4, 1));
				case EAST -> Shapes.or(box(0, 0, 0, 16, 1, 16), box(0, 1, 0, 16, 16, 1), box(15, 1, 1, 16, 3, 16), box(0, 1, 1, 1, 16, 16), box(15, 14, 1, 16, 16, 16), box(15, 10, 1, 16, 14, 2), box(15, 3, 1, 16, 7, 2), box(15, 3, 2, 16, 5, 4),
						box(15, 3, 15, 16, 5, 16), box(15, 3, 10, 16, 5, 11), box(15, 3, 5, 16, 5, 6), box(15, 12, 2, 16, 14, 4), box(15, 12, 15, 16, 14, 16), box(15, 12, 10, 16, 14, 11), box(15, 12, 5, 16, 14, 6), box(15, 13, 12, 16, 14, 14),
						box(15, 13, 7, 16, 14, 9), box(15, 3, 12, 16, 4, 14), box(15, 3, 7, 16, 4, 9));
				case WEST -> Shapes.or(box(0, 0, 0, 16, 1, 16), box(0, 1, 15, 16, 16, 16), box(0, 1, 0, 1, 3, 15), box(15, 1, 0, 16, 16, 15), box(0, 14, 0, 1, 16, 15), box(0, 10, 14, 1, 14, 15), box(0, 3, 14, 1, 7, 15), box(0, 3, 12, 1, 5, 14),
						box(0, 3, 0, 1, 5, 1), box(0, 3, 5, 1, 5, 6), box(0, 3, 10, 1, 5, 11), box(0, 12, 12, 1, 14, 14), box(0, 12, 0, 1, 14, 1), box(0, 12, 5, 1, 14, 6), box(0, 12, 10, 1, 14, 11), box(0, 13, 2, 1, 14, 4), box(0, 13, 7, 1, 14, 9),
						box(0, 3, 2, 1, 4, 4), box(0, 3, 7, 1, 4, 9));
				default -> Shapes.or(box(0, 0, 0, 16, 1, 16), box(15, 1, 0, 16, 16, 16), box(0, 1, 15, 15, 3, 16), box(0, 1, 0, 15, 16, 1), box(0, 14, 15, 15, 16, 16), box(14, 10, 15, 15, 14, 16), box(14, 3, 15, 15, 7, 16), box(12, 3, 15, 14, 5, 16),
						box(0, 3, 15, 1, 5, 16), box(5, 3, 15, 6, 5, 16), box(10, 3, 15, 11, 5, 16), box(12, 12, 15, 14, 14, 16), box(0, 12, 15, 1, 14, 16), box(5, 12, 15, 6, 14, 16), box(10, 12, 15, 11, 14, 16), box(2, 13, 15, 4, 14, 16),
						box(7, 13, 15, 9, 14, 16), box(2, 3, 15, 4, 4, 16), box(7, 3, 15, 9, 4, 16));
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

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 20);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		EvilTreeEyeOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		world.scheduleTick(pos, this, 20);
	}
}