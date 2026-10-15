package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HarvestCornProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CORN_CROP_TOP_2.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CORN_CROP_3.get()) {
				for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 4); _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.CORN_COB.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CORN_CROP_TOP_2.get()) {
				world.destroyBlock(BlockPos.containing(x, y - 1, z), false);
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CORN_CROP_3.get()) {
				world.destroyBlock(BlockPos.containing(x, y + 1, z), false);
			}
		}
	}
}