package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class DarkRedBricksWallBlock extends WallBlock {
	public DarkRedBricksWallBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_HYPHAE).sound(SoundType.POLISHED_DEEPSLATE).strength(2f, 20f).requiresCorrectToolForDrops().forceSolidOn());
	}
}