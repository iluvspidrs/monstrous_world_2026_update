package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class InfernalIronOreBlock extends Block {
	public InfernalIronOreBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).sound(SoundType.NETHERRACK).strength(1f, 10f).requiresCorrectToolForDrops());
	}
}