package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class MuddyCobblestoneBlock extends Block {
	public MuddyCobblestoneBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(1f, 20f).requiresCorrectToolForDrops());
	}
}