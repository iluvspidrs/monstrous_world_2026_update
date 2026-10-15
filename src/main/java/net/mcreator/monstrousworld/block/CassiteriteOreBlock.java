package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class CassiteriteOreBlock extends Block {
	public CassiteriteOreBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.CLAY).strength(2f, 30f).requiresCorrectToolForDrops());
	}
}