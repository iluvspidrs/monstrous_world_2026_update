package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockOfShimmeringDarknessBlock extends Block {
	public BlockOfShimmeringDarknessBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).sound(SoundType.METAL).strength(2f, 10f).requiresCorrectToolForDrops());
	}
}