package net.mcreator.monstrousworld.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class RedLightBulbCeilingBlock extends Block {
	private static final VoxelShape SHAPE = Shapes.or(box(6, 13, 6, 10, 14, 10), box(5, 7, 5, 11, 13, 11), box(7, 14, 7, 9, 16, 9));

	public RedLightBulbCeilingBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.GLASS).strength(1f, 10f).lightLevel(blockstate -> 10).noOcclusion().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}
}