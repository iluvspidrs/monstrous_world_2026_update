package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class MossyGrungyStoneBlock extends Block {
	public MossyGrungyStoneBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.BASALT).strength(1f, 10f).requiresCorrectToolForDrops().friction(0.7f));
	}
}