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

public class EvilTreeEyeBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public EvilTreeEyeBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.STEM).strength(-1, 3600000).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(0, 0, 0, 16, 3, 1), box(0, 13, 0, 16, 15, 1), box(14, 3, 0, 16, 13, 1), box(0, 3, 0, 2, 13, 1), box(2, 10, 0, 4, 13, 1), box(7, 3, 0, 9, 6, 1), box(12, 10, 0, 14, 13, 1), box(9, 11, 0, 10, 13, 1),
						box(13, 3, 0, 14, 7, 1), box(2, 3, 0, 3, 7, 1), box(6, 11, 0, 7, 13, 1), box(0, 0, 15, 16, 15, 16), box(0, 15, 0, 16, 16, 16));
				case EAST -> Shapes.or(box(15, 0, 0, 16, 3, 16), box(15, 13, 0, 16, 15, 16), box(15, 3, 14, 16, 13, 16), box(15, 3, 0, 16, 13, 2), box(15, 10, 2, 16, 13, 4), box(15, 3, 7, 16, 6, 9), box(15, 10, 12, 16, 13, 14),
						box(15, 11, 9, 16, 13, 10), box(15, 3, 13, 16, 7, 14), box(15, 3, 2, 16, 7, 3), box(15, 11, 6, 16, 13, 7), box(0, 0, 0, 1, 15, 16), box(0, 15, 0, 16, 16, 16));
				case WEST -> Shapes.or(box(0, 0, 0, 1, 3, 16), box(0, 13, 0, 1, 15, 16), box(0, 3, 0, 1, 13, 2), box(0, 3, 14, 1, 13, 16), box(0, 10, 12, 1, 13, 14), box(0, 3, 7, 1, 6, 9), box(0, 10, 2, 1, 13, 4), box(0, 11, 6, 1, 13, 7),
						box(0, 3, 2, 1, 7, 3), box(0, 3, 13, 1, 7, 14), box(0, 11, 9, 1, 13, 10), box(15, 0, 0, 16, 15, 16), box(0, 15, 0, 16, 16, 16));
				default -> Shapes.or(box(0, 0, 15, 16, 3, 16), box(0, 13, 15, 16, 15, 16), box(0, 3, 15, 2, 13, 16), box(14, 3, 15, 16, 13, 16), box(12, 10, 15, 14, 13, 16), box(7, 3, 15, 9, 6, 16), box(2, 10, 15, 4, 13, 16),
						box(6, 11, 15, 7, 13, 16), box(2, 3, 15, 3, 7, 16), box(13, 3, 15, 14, 7, 16), box(9, 11, 15, 10, 13, 16), box(0, 0, 0, 16, 15, 1), box(0, 15, 0, 16, 16, 16));
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