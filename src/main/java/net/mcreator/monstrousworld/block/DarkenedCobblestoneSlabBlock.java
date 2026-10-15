package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.DarkenedBlockInfectPlayerProcedure;

public class DarkenedCobblestoneSlabBlock extends SlabBlock {
	public DarkenedCobblestoneSlabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).sound(SoundType.NETHER_ORE).strength(1f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		DarkenedBlockInfectPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}