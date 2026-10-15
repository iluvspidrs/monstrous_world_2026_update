package net.mcreator.monstrousworld.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.procedures.ScheduleTickUpdateDarkenedSeedProcedure;
import net.mcreator.monstrousworld.procedures.NetherHallSeedOnTickUpdateProcedure;

public class NetherHallSeedBlock extends Block {
	public NetherHallSeedBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.NETHERRACK).strength(0.5f, 5f).randomTicks());
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		ScheduleTickUpdateDarkenedSeedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		NetherHallSeedOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}