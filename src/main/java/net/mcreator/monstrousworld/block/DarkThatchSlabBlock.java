package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class DarkThatchSlabBlock extends SlabBlock {
	public DarkThatchSlabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_HYPHAE).sound(SoundType.CROP).strength(1f, 10f));
	}
}