package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class PumpkinStairsBlock extends StairBlock {
	public PumpkinStairsBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).sound(SoundType.WOOD).strength(1f, 10f));
	}

	@Override
	public float getExplosionResistance() {
		return 10f;
	}
}