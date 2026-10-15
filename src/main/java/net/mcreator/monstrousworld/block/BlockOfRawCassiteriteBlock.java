package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class BlockOfRawCassiteriteBlock extends Block {
	public BlockOfRawCassiteriteBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(2f, 30f).requiresCorrectToolForDrops());
	}
}