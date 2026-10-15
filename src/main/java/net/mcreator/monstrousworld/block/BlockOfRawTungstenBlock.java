package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockOfRawTungstenBlock extends Block {
	public BlockOfRawTungstenBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.METAL).strength(2f, 45f).requiresCorrectToolForDrops());
	}
}