package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SanguineWoodPressurePlateBlock extends PressurePlateBlock {
	public SanguineWoodPressurePlateBlock() {
		super(BlockSetType.IRON, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).sound(SoundType.WOOD).strength(0.5f, 5f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn());
	}

	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}

	@Override
	public int getSignal(BlockState blockstate, BlockGetter blockAccess, BlockPos pos, Direction direction) {
		return 15;
	}

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return true;
	}
}