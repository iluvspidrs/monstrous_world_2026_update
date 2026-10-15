package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.DoorBlock;

public class PaleStalkDoorBlock extends DoorBlock {
	public PaleStalkDoorBlock() {
		super(BlockSetType.STONE, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.STEM).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}
}