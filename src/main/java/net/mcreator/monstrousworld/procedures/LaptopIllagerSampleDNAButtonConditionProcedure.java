package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class LaptopIllagerSampleDNAButtonConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Sample List")) {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "hasIllagerSample") == true) {
				return true;
			}
			return false;
		}
		return false;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}