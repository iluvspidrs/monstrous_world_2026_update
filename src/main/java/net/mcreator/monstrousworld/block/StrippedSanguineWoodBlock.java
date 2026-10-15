package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class StrippedSanguineWoodBlock extends Block {
	public StrippedSanguineWoodBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).sound(SoundType.WOOD).strength(1f, 10f));
	}
}