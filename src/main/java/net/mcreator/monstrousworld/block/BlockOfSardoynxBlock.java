package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.BlockOfSardoynxEntityWalksOnTheBlockProcedure;

public class BlockOfSardoynxBlock extends Block {
	public BlockOfSardoynxBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2f, 20f).requiresCorrectToolForDrops());
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		BlockOfSardoynxEntityWalksOnTheBlockProcedure.execute(world, entity);
	}
}