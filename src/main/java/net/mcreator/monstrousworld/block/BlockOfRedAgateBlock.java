package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.BlockOfRedAgateEntityWalksOnTheBlockProcedure;

public class BlockOfRedAgateBlock extends Block {
	public BlockOfRedAgateBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(1f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		BlockOfRedAgateEntityWalksOnTheBlockProcedure.execute(world, entity);
	}
}