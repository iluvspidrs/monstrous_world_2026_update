package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class GhostlyFenceBlock extends FenceBlock {
	public GhostlyFenceBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.STEM).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).forceSolidOn());
	}
}