package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.DarkenedBlockInfectPlayerProcedure;

public class DarkenedPlanksStairsBlock extends StairBlock {
	public DarkenedPlanksStairsBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_HYPHAE).sound(SoundType.STEM).strength(1f, 10f));
	}

	@Override
	public float getExplosionResistance() {
		return 10f;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		DarkenedBlockInfectPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}