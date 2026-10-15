package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class DarkRedBricksBlock extends Block {
	public DarkRedBricksBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_HYPHAE).sound(SoundType.POLISHED_DEEPSLATE).strength(2f, 20f).requiresCorrectToolForDrops());
	}
}