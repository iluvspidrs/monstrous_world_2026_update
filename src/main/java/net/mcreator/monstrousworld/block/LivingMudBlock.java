package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class LivingMudBlock extends Block {
	public LivingMudBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.MUD).strength(1f, 20f));
	}
}