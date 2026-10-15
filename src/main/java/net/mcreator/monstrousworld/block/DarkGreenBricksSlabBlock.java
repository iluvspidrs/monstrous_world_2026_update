package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class DarkGreenBricksSlabBlock extends SlabBlock {
	public DarkGreenBricksSlabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.POLISHED_DEEPSLATE).strength(2f, 20f).requiresCorrectToolForDrops());
	}
}