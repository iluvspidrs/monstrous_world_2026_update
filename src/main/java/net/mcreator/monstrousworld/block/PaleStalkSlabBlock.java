package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class PaleStalkSlabBlock extends SlabBlock {
	public PaleStalkSlabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.STEM).strength(1f, 10f));
	}
}