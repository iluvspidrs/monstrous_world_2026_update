package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class DarkenedStoneSpreadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (Math.random() >= 0.9) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("PlusOrMinus", (Mth.nextInt(RandomSource.create(), -1, 1)));
						_blockEntity.getPersistentData().putDouble("ZPlusOrMinus", (Mth.nextInt(RandomSource.create(), -1, 1)));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
						.is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))) {
					if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))
							&& !(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
									.is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))
							&& !(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
									.is(BlockTags.create(ResourceLocation.parse("minecraft:walls")))) {
						if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
								.is(BlockTags.create(ResourceLocation.parse("c:sandstone/blocks")))) {
							if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
									.is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
								world.setBlock(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus")),
										MonstrousWorldModBlocks.ACTIVE_DARKENED_SANDSTONE.get().defaultBlockState(), 3);
								ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
							} else {
								ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
							}
						} else {
							if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
									.is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
								world.setBlock(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus")),
										MonstrousWorldModBlocks.ACTIVE_DARKENED_STONE.get().defaultBlockState(), 3);
								ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
							} else {
								ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))) {
						{
							BlockPos _bp = BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"));
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_COBBLESTONE_STAIRS.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))) {
						{
							BlockPos _bp = BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"));
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_COBBLESTONE_SLAB.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("minecraft:walls")))) {
						{
							BlockPos _bp = BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"));
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_COBBLESTONE_WALL.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
						.is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/shovel")))) {
					if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("c:sands")))) {
						if (!("" + BuiltInRegistries.BLOCK
								.getKey((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus")))).getBlock())
								.toString()).contains("snow")) {
							if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
									.is(BlockTags.create(ResourceLocation.parse("c:gravels")))) {
								if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
										.is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									world.setBlock(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus")),
											MonstrousWorldModBlocks.ACTIVE_DARKENED_DIRT.get().defaultBlockState(), 3);
									ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
								} else {
									ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
								}
							}
						}
					}
				}
				if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
						.is(BlockTags.create(ResourceLocation.parse("c:gravels")))) {
					if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
						world.setBlock(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus")),
								MonstrousWorldModBlocks.ACTIVE_DARKENED_GRAVEL.get().defaultBlockState(), 3);
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					} else {
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
						.is(BlockTags.create(ResourceLocation.parse("c:sands")))) {
					if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
						world.setBlock(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus")),
								MonstrousWorldModBlocks.ACTIVE_DARKENED_SAND.get().defaultBlockState(), 3);
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					} else {
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
						.is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/axe")))) {
					if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
						if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
								.is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
							{
								BlockPos _bp = BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"));
								BlockState _bs = MonstrousWorldModBlocks.ACTIVE_DARKENED_LOG.get().defaultBlockState();
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
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						} else {
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						}
					}
					if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("minecraft:planks")))) {
						world.setBlock(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus")),
								MonstrousWorldModBlocks.DARKENED_PLANKS.get().defaultBlockState(), 3);
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))) {
						{
							BlockPos _bp = BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"));
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_SLAB.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))) {
						{
							BlockPos _bp = BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"));
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_STAIRS.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("minecraft:fences")))) {
						{
							BlockPos _bp = BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"));
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_FENCE.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("c:fence_gates")))) {
						{
							BlockPos _bp = BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"));
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_FENCE_GATE.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
						.is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))) {
					if (!(world.getBlockState(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus"))))
							.is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
						world.setBlock(BlockPos.containing(x - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PlusOrMinus"), y, z - getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ZPlusOrMinus")),
								MonstrousWorldModBlocks.ACTIVE_DARKENED_LEAVES.get().defaultBlockState(), 3);
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					} else {
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
				}
			}
			if (world.getBlockFloorHeight(BlockPos.containing(x, y, z)) > 0) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))) {
					if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))
							&& !(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))
							&& !(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:walls")))) {
						if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("c:sandstone/blocks")))) {
							if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
								world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_SANDSTONE.get().defaultBlockState(), 3);
								ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
							} else {
								ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
							}
						} else {
							if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
								world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_STONE.get().defaultBlockState(), 3);
								ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
							} else {
								ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_COBBLESTONE_STAIRS.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_COBBLESTONE_SLAB.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:walls")))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_COBBLESTONE_WALL.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/shovel")))) {
					if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("c:sands")))) {
						if (!("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()).toString()).contains("snow")) {
							if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("c:gravels")))) {
								if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
									world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_DIRT.get().defaultBlockState(), 3);
									ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
								} else {
									ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
								}
							}
						} else {
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						}
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.GRAVEL) {
					if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_GRAVEL.get().defaultBlockState(), 3);
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					} else {
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("c:sands")))) {
					if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_SAND.get().defaultBlockState(), 3);
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					} else {
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/axe")))) {
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
						if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
							{
								BlockPos _bp = BlockPos.containing(x, y + 1, z);
								BlockState _bs = MonstrousWorldModBlocks.ACTIVE_DARKENED_LOG.get().defaultBlockState();
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
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						} else {
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:planks")))) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DARKENED_PLANKS.get().defaultBlockState(), 3);
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:slabs")))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_SLAB.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs")))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_STAIRS.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:fences")))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_FENCE.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("c:fence_gates")))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_PLANKS_FENCE_GATE.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("monstrous_world:barricades")))) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = MonstrousWorldModBlocks.DARKENED_BARRICADE.get().defaultBlockState();
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
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))) {
					if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
						world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.ACTIVE_DARKENED_LEAVES.get().defaultBlockState(), 3);
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					} else {
						ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:saplings")))) {
					if (!(world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:darkness_immune")))) {
						if (Math.random() < 0.2) {
							world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.PUMPKIN_SAPLING.get().defaultBlockState(), 3);
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						} else if (Math.random() < 0.4) {
							world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DEATHLY_SAPLING.get().defaultBlockState(), 3);
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						} else if (Math.random() < 0.6) {
							world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.SANGUINE_SAPLING.get().defaultBlockState(), 3);
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						} else if (Math.random() < 0.8) {
							world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.MURKWOOD_SAPLING.get().defaultBlockState(), 3);
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						} else {
							world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.GHOSTLY_SAPLING.get().defaultBlockState(), 3);
							ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
						}
					}
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.POPPY) {
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.WITHER_ROSE.defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SHORT_GRASS || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.FERN) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.FINGER_GRASS.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.TALL_GRASS || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.LARGE_FERN) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.FINGER_GRASS.get().defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 2, z), MonstrousWorldModBlocks.FINGER_GRASS.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BLUE_ORCHID) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.SLIME_BLOSSOM.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.RED_TULIP || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.ORANGE_TULIP
						|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.WHITE_TULIP || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.PINK_TULIP) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.LUNAR_BLOOM.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CORNFLOWER) {
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.DEAD_BUSH.defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SUGAR_CANE || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.PEONY
						|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.ROSE_BUSH || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SUNFLOWER) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.VILE_LATTICE.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.LILY_OF_THE_VALLEY) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.BLOOD_BULB.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.OXEYE_DAISY) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.DEATHCATCHER.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AZURE_BLUET) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.PUMPESS_BLOOM.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.ALLIUM) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.INSANOSUS.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BROWN_MUSHROOM) {
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.WARPED_FUNGUS.defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.RED_MUSHROOM) {
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.CRIMSON_FUNGUS.defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.DANDELION) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.SOULFLOWER.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BAMBOO_SAPLING || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BAMBOO) {
					world.setBlock(BlockPos.containing(x, y + 1, z), MonstrousWorldModBlocks.FIRECANE_STALK.get().defaultBlockState(), 3);
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VINE) {
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = MonstrousWorldModBlocks.GHOSTLY_LICHEN.get().defaultBlockState();
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
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("neoforge:pumpkin_traps")))) {
					world.destroyBlock(BlockPos.containing(x, y + 1, z), false);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.VENGEFUL_PUMPKIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				} else {
					ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
				}
			} else {
				ActiveToFullyDarkenedBlocksProcedure.execute(world, x, y, z);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}