package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockOfBronzeBlock extends Block {
	public BlockOfBronzeBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.METAL).strength(2f, 30f).requiresCorrectToolForDrops());
	}
}