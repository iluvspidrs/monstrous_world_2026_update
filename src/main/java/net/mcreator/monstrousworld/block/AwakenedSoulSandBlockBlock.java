package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.AwakenedSoulSandBlockEntityCollidesInTheBlockProcedure;

public class AwakenedSoulSandBlockBlock extends Block {
	public AwakenedSoulSandBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SOUL_SAND).strength(2f, 10f).noCollission().speedFactor(0.2f).jumpFactor(0.2f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, BlockEntity blockEntity, Entity breaker, ItemStack tool) {
		return Mth.randomBetweenInclusive(level.getRandom(), 2, 5);
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		AwakenedSoulSandBlockEntityCollidesInTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}