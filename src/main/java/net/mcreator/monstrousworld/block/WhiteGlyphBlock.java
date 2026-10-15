package net.mcreator.monstrousworld.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.google.common.collect.ImmutableMap;

public class WhiteGlyphBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 20);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public WhiteGlyphBlock() {
		super(BlockBehaviour.Properties.of()
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sand.break")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sand.step")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sand.hit")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sand.fall"))))
				.strength(0.1f, 1f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).replaceable());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BLOCKSTATE, 0));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(BLOCKSTATE) == 1) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 2) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 3) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 4) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 5) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 6) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 7) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 8) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 9) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 10) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 11) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 12) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 13) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 14) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 15) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 16) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 17) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 18) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 19) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			} else if (state.getValue(BLOCKSTATE) == 20) {
				return switch (state.getValue(FACING)) {
					case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
					case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
					default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				};
			}
			return switch (state.getValue(FACING)) {
				case NORTH -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
				case EAST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
				case WEST -> box(1.5, 0.1, 1, 14.5, 0.15, 15);
				default -> box(1, 0.1, 1.5, 15, 0.15, 14.5);
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
	public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
		return ItemStack.EMPTY;
	}
}