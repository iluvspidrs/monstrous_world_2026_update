package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class SardonyxStoneOreBlock extends Block {
	public SardonyxStoneOreBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2f, 20f).requiresCorrectToolForDrops());
	}
}