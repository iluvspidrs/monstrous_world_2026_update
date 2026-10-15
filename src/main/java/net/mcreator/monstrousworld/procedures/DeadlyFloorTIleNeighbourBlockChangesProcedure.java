package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class DeadlyFloorTIleNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (world.getBlockState(BlockPos.containing(x, y + 1, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1, z), Direction.DOWN)) {
				if (!world.getEntitiesOfClass(ServerPlayer.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(12 / 2d), e -> true).isEmpty()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z))) {
						{
							BlockPos _bp = BlockPos.containing(x + 1, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z))) {
						{
							BlockPos _bp = BlockPos.containing(x - 1, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z - 1))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z - 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 1))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z + 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z + 1))) {
						{
							BlockPos _bp = BlockPos.containing(x + 1, y + 1, z + 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z - 1))) {
						{
							BlockPos _bp = BlockPos.containing(x - 1, y + 1, z - 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z - 1))) {
						{
							BlockPos _bp = BlockPos.containing(x + 1, y + 1, z - 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z + 1))) {
						{
							BlockPos _bp = BlockPos.containing(x - 1, y + 1, z + 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 2, z);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 2, z))) {
						{
							BlockPos _bp = BlockPos.containing(x + 1, y + 2, z);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 2, z))) {
						{
							BlockPos _bp = BlockPos.containing(x - 1, y + 2, z);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y + 2, z - 1))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 2, z - 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 1))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 2, z + 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 2, z + 1))) {
						{
							BlockPos _bp = BlockPos.containing(x + 1, y + 2, z + 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 2, z - 1))) {
						{
							BlockPos _bp = BlockPos.containing(x - 1, y + 2, z - 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 2, z - 1))) {
						{
							BlockPos _bp = BlockPos.containing(x + 1, y + 2, z - 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 2, z + 1))) {
						{
							BlockPos _bp = BlockPos.containing(x - 1, y + 2, z + 1);
							BlockState _bs = MonstrousWorldModBlocks.TOXIC_GAS.get().defaultBlockState();
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
					}
				}
			}
		}
	}
}