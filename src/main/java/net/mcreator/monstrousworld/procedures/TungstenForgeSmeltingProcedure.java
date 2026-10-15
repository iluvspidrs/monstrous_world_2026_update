package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class TungstenForgeSmeltingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double coal_required = 0;
		double iron_required = 0;
		TrollForgeItemCountProcedure.execute(world, x, y, z, entity);
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200 || getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
			if (getAmountInGUISlot(entity, 4) <= 60) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Coal") >= 2 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Raw Iron") >= 2) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(4).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.CAST_IRON_INGOT.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						CreateCastIronProcedure.execute(world, x, y, z, entity);
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.CAST_IRON_INGOT.get()) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200) {
								{
									int _value = 2;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
								{
									int _value = 9;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							} else {
								{
									int _value = 12;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							}
						}
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Raw Gold") >= 2 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Silver Dust") >= 2) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(4).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.ELECTRUM_INGOT.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						CreateElectrumProcedure.execute(world, x, y, z, entity);
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.ELECTRUM_INGOT.get()) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200) {
								{
									int _value = 3;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
								{
									int _value = 10;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							} else {
								{
									int _value = 13;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							}
						}
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Raw Copper") >= 3 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cassiterite") >= 1) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(4).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.BRONZE_INGOT.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						CreateBronzeProcedure.execute(world, x, y, z, entity);
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.BRONZE_INGOT.get()) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200) {
								{
									int _value = 4;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
								{
									int _value = 11;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							} else {
								{
									int _value = 14;
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
							}
						}
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Bronze") >= 2 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Raw Gold") >= 2) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.CORINTHIAN_BRONZE_INGOT.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							CreateCorinthianBronzeProcedure.execute(world, x, y, z, entity);
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu53 ? _menu53.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.CORINTHIAN_BRONZE_INGOT.get()) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
									{
										int _value = 6;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								} else {
									{
										int _value = 15;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								}
							}
						}
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Netherite Scrap") >= 2 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Tungsten Ingot") >= 2) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							CreateShiningNetheriteProcedure.execute(world, x, y, z, entity);
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_shining_accomplishment"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu67 ? _menu67.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
									{
										int _value = 7;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								} else {
									{
										int _value = 17;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								}
							}
						}
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Raw Tungsten") >= 4) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.TUNGSTEN_INGOT.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							CreateTungstenIngotsProcedure.execute(world, x, y, z, entity);
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu79 ? _menu79.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.TUNGSTEN_INGOT.get()) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
									{
										int _value = 5;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								} else {
									{
										int _value = 16;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								}
							}
						}
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Shining Netherite") >= 2 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Darkened Iron Ingot") >= 2) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHIMMERING_DARK_INGOT.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu89 ? _menu89.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
								CreateShimmeringDarknessProcedure.execute(world, x, y, z, entity);
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:harnessing_darkness"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu93 ? _menu93.getSlots().get(4).getItem() : ItemStack.EMPTY)
										.getItem() == MonstrousWorldModItems.SHIMMERING_DARK_INGOT.get()) {
									if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
										{
											int _value = 8;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
									} else {
										{
											int _value = 18;
											BlockPos _pos = BlockPos.containing(x, y, z);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
									}
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You are not yet skilled enough to make this alloy"), false);
								if (entity instanceof Player _player)
									_player.closeContainer();
							}
						}
					}
				}
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("lava", 1000);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack105 = new ItemStack(Items.BUCKET).copy();
				_setstack105.setCount(1);
				_menu.getSlots().get(5).set(_setstack105);
				_player.containerMenu.broadcastChanges();
			}
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(5).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.BLAZE_LAVA_BUCKET.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("blaze_lava", 1000);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			{
				int _value = 19;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack111 = new ItemStack(Blocks.AIR).copy();
				_setstack111.setCount(1);
				_menu.getSlots().get(5).set(_setstack111);
				_player.containerMenu.broadcastChanges();
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.crafter.fail")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.crafter.fail")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("Coal 0", 0);
				_blockEntity.getPersistentData().putDouble("Coal 1", 0);
				_blockEntity.getPersistentData().putDouble("Coal 2", 0);
				_blockEntity.getPersistentData().putDouble("Coal 3", 0);
				_blockEntity.getPersistentData().putDouble("Coal", 0);
				_blockEntity.getPersistentData().putDouble("Raw Iron 0", 0);
				_blockEntity.getPersistentData().putDouble("Raw Iron 1", 0);
				_blockEntity.getPersistentData().putDouble("Raw Iron 2", 0);
				_blockEntity.getPersistentData().putDouble("Raw Iron 3", 0);
				_blockEntity.getPersistentData().putDouble("Raw Iron", 0);
				_blockEntity.getPersistentData().putDouble("Cassiterite 3", 0);
				_blockEntity.getPersistentData().putDouble("Cassiterite 2", 0);
				_blockEntity.getPersistentData().putDouble("Cassiterite 1", 0);
				_blockEntity.getPersistentData().putDouble("Cassiterite 0", 0);
				_blockEntity.getPersistentData().putDouble("Cassiterite", 0);
				_blockEntity.getPersistentData().putDouble("Raw Copper 3", 0);
				_blockEntity.getPersistentData().putDouble("Raw Copper 2", 0);
				_blockEntity.getPersistentData().putDouble("Raw Copper 1", 0);
				_blockEntity.getPersistentData().putDouble("Raw Copper 0", 0);
				_blockEntity.getPersistentData().putDouble("Raw Copper", 0);
				_blockEntity.getPersistentData().putDouble("Raw Gold 0", 0);
				_blockEntity.getPersistentData().putDouble("Raw Gold 1", 0);
				_blockEntity.getPersistentData().putDouble("Raw Gold 2", 0);
				_blockEntity.getPersistentData().putDouble("Raw Gold 3", 0);
				_blockEntity.getPersistentData().putDouble("Raw Gold", 0);
				_blockEntity.getPersistentData().putDouble("Silver Dust 0", 0);
				_blockEntity.getPersistentData().putDouble("Silver Dust 1", 0);
				_blockEntity.getPersistentData().putDouble("Silver Dust 2", 0);
				_blockEntity.getPersistentData().putDouble("Silver Dust 3", 0);
				_blockEntity.getPersistentData().putDouble("Silver Dust", 0);
				_blockEntity.getPersistentData().putDouble("Raw Tungsten 0", 0);
				_blockEntity.getPersistentData().putDouble("Raw Tungsten 1", 0);
				_blockEntity.getPersistentData().putDouble("Raw Tungsten 2", 0);
				_blockEntity.getPersistentData().putDouble("Raw Tungsten 3", 0);
				_blockEntity.getPersistentData().putDouble("Raw Tungsten", 0);
				_blockEntity.getPersistentData().putDouble("Tungsten Ingot 0", 0);
				_blockEntity.getPersistentData().putDouble("Tungsten Ingot 1", 0);
				_blockEntity.getPersistentData().putDouble("Tungsten Ingot 2", 0);
				_blockEntity.getPersistentData().putDouble("Tungsten Ingot 3", 0);
				_blockEntity.getPersistentData().putDouble("Tungsten Ingot", 0);
				_blockEntity.getPersistentData().putDouble("Bronze 0", 0);
				_blockEntity.getPersistentData().putDouble("Bronze 1", 0);
				_blockEntity.getPersistentData().putDouble("Bronze 2", 0);
				_blockEntity.getPersistentData().putDouble("Bronze 3", 0);
				_blockEntity.getPersistentData().putDouble("Bronze", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Scrap 0", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Scrap 1", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Scrap 2", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Scrap 3", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Scrap", 0);
				_blockEntity.getPersistentData().putDouble("Darkened Iron Ingot 0", 0);
				_blockEntity.getPersistentData().putDouble("Darkened Iron Ingot 1", 0);
				_blockEntity.getPersistentData().putDouble("Darkened Iron Ingot 2", 0);
				_blockEntity.getPersistentData().putDouble("Darkened Iron Ingot 3", 0);
				_blockEntity.getPersistentData().putDouble("Darkened Iron Ingot", 0);
				_blockEntity.getPersistentData().putDouble("Shining Netherite 0", 0);
				_blockEntity.getPersistentData().putDouble("Shining Netherite 1", 0);
				_blockEntity.getPersistentData().putDouble("Shining Netherite 2", 0);
				_blockEntity.getPersistentData().putDouble("Shining Netherite 3", 0);
				_blockEntity.getPersistentData().putDouble("Shining Netherite", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}