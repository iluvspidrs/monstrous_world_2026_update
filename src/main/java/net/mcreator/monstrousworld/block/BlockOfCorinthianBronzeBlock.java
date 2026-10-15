package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockOfCorinthianBronzeBlock extends Block {
	public BlockOfCorinthianBronzeBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).sound(SoundType.METAL).strength(2f, 30f).requiresCorrectToolForDrops());
	}
}