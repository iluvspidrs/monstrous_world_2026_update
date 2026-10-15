package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.QuickmudEntityWalksOnTheBlockProcedure;
import net.mcreator.monstrousworld.procedures.QuickmudEntitySinksProcedure;

public class QuickmudBlock extends Block {
	public QuickmudBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.MUD).strength(1f, 40f));
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		QuickmudEntitySinksProcedure.execute(entity);
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		QuickmudEntityWalksOnTheBlockProcedure.execute(entity);
	}
}