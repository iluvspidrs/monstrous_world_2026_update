package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockOfSilverBlock extends Block {
	public BlockOfSilverBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.METAL).strength(2f, 20f).requiresCorrectToolForDrops());
	}
}