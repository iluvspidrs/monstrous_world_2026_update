package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class DarkBlueBricksStairsBlock extends StairBlock {
	public DarkBlueBricksStairsBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.POLISHED_DEEPSLATE).strength(2f, 20f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 20f;
	}
}