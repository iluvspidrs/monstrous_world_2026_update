package net.mcreator.monstrousworld.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.TrollForgeTungstenOnBlockRightclickedProcedure;
import net.mcreator.monstrousworld.block.entity.TrollForgeTungstenBlockEntity;

import com.google.common.collect.ImmutableMap;

public class TrollForgeTungstenBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 19);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public TrollForgeTungstenBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).sound(SoundType.METAL).strength(1f, 40f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BLOCKSTATE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(BLOCKSTATE) == 1) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 2) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 3) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 4) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 5) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 6) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 7) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 8) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 9) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 10) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 11) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 12) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 13) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 14) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 15) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 16) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 17) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 18) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			} else if (state.getValue(BLOCKSTATE) == 19) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(0, 0, 0, 16, 14, 16);
					case EAST -> box(0, 0, 0, 16, 14, 16);
					case WEST -> box(0, 0, 0, 16, 14, 16);
					default -> box(0, 0, 0, 16, 14, 16);
				};
			}
			return switch (state.getValue(FACING)) {
				case NORTH -> box(0, 0, 0, 16, 14, 16);
				case EAST -> box(0, 0, 0, 16, 14, 16);
				case WEST -> box(0, 0, 0, 16, 14, 16);
				default -> box(0, 0, 0, 16, 14, 16);
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
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		TrollForgeTungstenOnBlockRightclickedProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new TrollForgeTungstenBlockEntity(pos, state);
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
			if (blockEntity instanceof TrollForgeTungstenBlockEntity be) {
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
		if (tileentity instanceof TrollForgeTungstenBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}