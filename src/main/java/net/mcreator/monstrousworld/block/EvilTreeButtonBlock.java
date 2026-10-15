package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class EvilTreeButtonBlock extends ButtonBlock {
	public EvilTreeButtonBlock() {
		super(BlockSetType.STONE, 20, BlockBehaviour.Properties.of().sound(SoundType.STEM).strength(1f, 10f));
	}
}