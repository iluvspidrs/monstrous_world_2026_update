package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.DeathlyLeavesHarvestConditionProcedure;

public class DeathlyLeavesBlock extends LeavesBlock {
	public DeathlyLeavesBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).sound(SoundType.AZALEA_LEAVES).strength(0.2f, 10f).noOcclusion().isSuffocating((bs, br, bp) -> false).isViewBlocking((bs, br, bp) -> false));
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		return super.canHarvestBlock(state, world, pos, player) && DeathlyLeavesHarvestConditionProcedure.execute(player.level(), pos.getX(), pos.getY(), pos.getZ(), player);
	}
}