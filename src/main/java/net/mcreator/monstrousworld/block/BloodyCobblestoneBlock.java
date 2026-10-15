package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BloodyCobblestoneBlock extends Block {
	public BloodyCobblestoneBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_HYPHAE).sound(SoundType.BASALT).strength(1f, 20f).requiresCorrectToolForDrops());
	}
}