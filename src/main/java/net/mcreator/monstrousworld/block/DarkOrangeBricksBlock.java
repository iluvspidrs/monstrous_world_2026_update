package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class DarkOrangeBricksBlock extends Block {
	public DarkOrangeBricksBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).sound(SoundType.POLISHED_DEEPSLATE).strength(2f, 20f).requiresCorrectToolForDrops());
	}
}