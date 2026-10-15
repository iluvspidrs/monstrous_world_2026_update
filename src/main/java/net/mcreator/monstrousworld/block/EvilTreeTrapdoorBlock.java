package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class EvilTreeTrapdoorBlock extends TrapDoorBlock {
	public EvilTreeTrapdoorBlock() {
		super(BlockSetType.WARPED, BlockBehaviour.Properties.of().sound(SoundType.STEM).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
	}
}