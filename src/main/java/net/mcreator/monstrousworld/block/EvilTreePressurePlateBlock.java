package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class EvilTreePressurePlateBlock extends PressurePlateBlock {
	public EvilTreePressurePlateBlock() {
		super(BlockSetType.IRON, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.STEM).strength(1f, 10f).forceSolidOn());
	}
}