package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class OvergrownMudBricksBlock extends Block {
	public OvergrownMudBricksBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.MUD_BRICKS).strength(1.5f, 3f).requiresCorrectToolForDrops());
	}
}