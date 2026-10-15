package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class DarkPurpleBricksWallBlock extends WallBlock {
	public DarkPurpleBricksWallBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).sound(SoundType.POLISHED_DEEPSLATE).strength(2f, 20f).requiresCorrectToolForDrops().forceSolidOn());
	}
}