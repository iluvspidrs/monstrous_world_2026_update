package net.mcreator.monstrousworld.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.FastColor;
import net.minecraft.core.BlockPos;

public class GreenLightBulbBlock extends Block {
	public static final EnumProperty<DirectionProperty> DIRECTION = EnumProperty.create("direction", DirectionProperty.class);
	private static final VoxelShape SHAPE = Shapes.or(box(7, 0, 7, 9, 2, 9), box(6, 2, 6, 10, 3, 10), box(5, 3, 5, 11, 9, 11));

	public GreenLightBulbBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.GLASS).strength(1f, 10f).lightLevel(blockstate -> 10).noOcclusion().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(DIRECTION, DirectionProperty.UPRIGHT));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public Integer getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return FastColor.ARGB32.opaque(-16738048);
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(DIRECTION);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(DIRECTION, DirectionProperty.UPRIGHT);
	}

	public enum DirectionProperty implements StringRepresentable {
		UPRIGHT("upright"), INVERTED("inverted"), WEST("west"), EAST("east"), NORTH("north"), SOUTH("south");

		private final String name;

		private DirectionProperty(String name) {
			this.name = name;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
}