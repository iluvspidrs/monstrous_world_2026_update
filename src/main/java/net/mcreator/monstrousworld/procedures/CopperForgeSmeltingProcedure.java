package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class CopperForgeSmeltingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double coal_required = 0;
		double iron_required = 0;
		if (!world.isClientSide()) {
			TrollForgeItemCountProcedure.execute(world, x, y, z, entity);
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200) {
				if (getAmountInGUISlot(entity, 4) <= 60) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Coal") >= 2 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Raw Iron") >= 2) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.CAST_IRON_INGOT.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							CreateCastIronProcedure.execute(world, x, y, z, entity);
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:casting_call"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.CAST_IRON_INGOT.get()) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200) {
									{
										int _value = 2;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								} else {
									{
										int _value = 5;
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
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.ELECTRUM_INGOT.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							CreateElectrumProcedure.execute(world, x, y, z, entity);
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.ELECTRUM_INGOT.get()) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200) {
									{
										int _value = 3;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								} else {
									{
										int _value = 6;
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
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.BRONZE_INGOT.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							CreateBronzeProcedure.execute(world, x, y, z, entity);
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get(4).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.BRONZE_INGOT.get()) {
								if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200) {
									{
										int _value = 4;
										BlockPos _pos = BlockPos.containing(x, y, z);
										BlockState _bs = world.getBlockState(_pos);
										if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
											world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
									}
								} else {
									{
										int _value = 7;
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
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET) {
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
					ItemStack _setstack45 = new ItemStack(Items.BUCKET).copy();
					_setstack45.setCount(1);
					_menu.getSlots().get(5).set(_setstack45);
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
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
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