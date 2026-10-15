package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockofShiningNetheriteBlock extends Block {
	public BlockofShiningNetheriteBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.METAL).strength(3f, 40f).requiresCorrectToolForDrops());
	}
}