package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class PaleStalkFenceBlock extends FenceBlock {
	public PaleStalkFenceBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.STEM).strength(1f, 10f).forceSolidOn());
	}
}