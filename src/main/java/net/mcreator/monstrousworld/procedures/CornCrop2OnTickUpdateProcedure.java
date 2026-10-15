package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class CornCrop2OnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (Math.random() < 0.33) {
				if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
					MonstrousWorldMod.queueServerWork(1, () -> {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.CORN_CROP_TOP.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					});
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CORN_CROP_TOP.get()) {
					MonstrousWorldMod.queueServerWork(1, () -> {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.CORN_CROP_TOP_1.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					});
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CORN_CROP_TOP_1.get()) {
					MonstrousWorldMod.queueServerWork(1, () -> {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.CORN_CROP_TOP_2.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = MonstrousWorldModBlocks.CORN_CROP_3.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					});
				}
			}
		}
	}
}