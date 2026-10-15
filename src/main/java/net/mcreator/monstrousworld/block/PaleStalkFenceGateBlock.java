package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class PaleStalkFenceGateBlock extends FenceGateBlock {
	public PaleStalkFenceGateBlock() {
		super(WoodType.OAK, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.STEM).strength(1f, 10f).forceSolidOn());
	}
}