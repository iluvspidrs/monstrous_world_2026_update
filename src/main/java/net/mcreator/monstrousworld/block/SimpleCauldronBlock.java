package net.mcreator.monstrousworld.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.SimpleCauldronOnTickUpdateProcedure;
import net.mcreator.monstrousworld.procedures.SimpleCauldronOnBlockRightclickedProcedure;
import net.mcreator.monstrousworld.block.entity.SimpleCauldronBlockEntity;

import com.google.common.collect.ImmutableMap;

public class SimpleCauldronBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 16);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public SimpleCauldronBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.METAL).strength(1f, 20f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BLOCKSTATE, 0).setValue(WATERLOGGED, false));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(BLOCKSTATE) == 1) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 2) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 3) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 4) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 5) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 6) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 7) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 8) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 9) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 10) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 11) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 12) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 13) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 14) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 15) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			} else if (state.getValue(BLOCKSTATE) == 16) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(2, 0, 2, 14, 8, 14);
					case EAST -> box(2, 0, 2, 14, 8, 14);
					case WEST -> box(2, 0, 2, 14, 8, 14);
					default -> box(2, 0, 2, 14, 8, 14);
				};
			}
			return switch (state.getValue(FACING)) {
				case NORTH -> box(2, 0, 2, 14, 8, 14);
				case EAST -> box(2, 0, 2, 14, 8, 14);
				case WEST -> box(2, 0, 2, 14, 8, 14);
				default -> box(2, 0, 2, 14, 8, 14);
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return propagatesSkylightDown(state, worldIn, pos) ? 0 : 1;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(BLOCKSTATE, 0).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		SimpleCauldronOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		SimpleCauldronOnBlockRightclickedProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SimpleCauldronBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof SimpleCauldronBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof SimpleCauldronBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}