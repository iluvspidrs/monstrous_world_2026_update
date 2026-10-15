package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.DoorBlock;

public class EvilTreeDoorBlock extends DoorBlock {
	public EvilTreeDoorBlock() {
		super(BlockSetType.WARPED, BlockBehaviour.Properties.of().sound(SoundType.STEM).strength(1f, 10f));
	}
}