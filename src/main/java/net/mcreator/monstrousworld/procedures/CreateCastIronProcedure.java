package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class CreateCastIronProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double coal_required = 0;
		double iron_required = 0;
		if (!world.isClientSide()) {
			coal_required = 2;
			iron_required = 2;
			if (getAmountInGUISlot(entity, 4) <= 60) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack3 = new ItemStack(MonstrousWorldModItems.CAST_IRON_INGOT.get()).copy();
					_setstack3.setCount(getAmountInGUISlot(entity, 4) + 4);
					_menu.getSlots().get(4).set(_setstack3);
					_player.containerMenu.broadcastChanges();
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") >= 200) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("lava", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lava") - 200));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") >= 200) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("blaze_lava", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blaze_lava") - 200));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.COAL) {
					if (getAmountInGUISlot(entity, 0) < coal_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						coal_required = coal_required - 1;
					} else {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						coal_required = 0;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_IRON
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
					if (getAmountInGUISlot(entity, 0) < iron_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						iron_required = iron_required - 1;
					} else {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						iron_required = 0;
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.COAL) {
					if (getAmountInGUISlot(entity, 1) == 1) {
						if (getAmountInGUISlot(entity, 1) <= coal_required) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							coal_required = coal_required - 1;
						}
					} else {
						if (coal_required == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							coal_required = coal_required - 1;
						}
						if (coal_required == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(2);
								_player.containerMenu.broadcastChanges();
							}
							coal_required = coal_required - 2;
						}
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_IRON
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
					if (getAmountInGUISlot(entity, 1) == 1) {
						if (getAmountInGUISlot(entity, 1) <= iron_required) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							iron_required = iron_required - 1;
						}
					} else {
						if (iron_required == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							iron_required = iron_required - 1;
						}
						if (iron_required == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(2);
								_player.containerMenu.broadcastChanges();
							}
							iron_required = iron_required - 2;
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.COAL) {
					if (getAmountInGUISlot(entity, 2) == 1) {
						if (getAmountInGUISlot(entity, 2) <= coal_required) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							coal_required = coal_required - 1;
						}
					} else {
						if (coal_required == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							coal_required = coal_required - 1;
						}
						if (coal_required == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(2);
								_player.containerMenu.broadcastChanges();
							}
							coal_required = coal_required - 2;
						}
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_IRON
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
					if (getAmountInGUISlot(entity, 2) == 1) {
						if (getAmountInGUISlot(entity, 2) <= iron_required) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							iron_required = iron_required - 1;
						}
					} else {
						if (iron_required == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							iron_required = iron_required - 1;
						}
						if (iron_required == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(2);
								_player.containerMenu.broadcastChanges();
							}
							iron_required = iron_required - 2;
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu55 ? _menu55.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.COAL) {
					if (getAmountInGUISlot(entity, 3) == 1) {
						if (getAmountInGUISlot(entity, 3) <= coal_required) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(3).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							coal_required = coal_required - 1;
						}
					} else {
						if (coal_required == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(3).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							coal_required = coal_required - 1;
						}
						if (coal_required == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(3).remove(2);
								_player.containerMenu.broadcastChanges();
							}
							coal_required = coal_required - 2;
						}
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_IRON
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
					if (getAmountInGUISlot(entity, 3) == 1) {
						if (getAmountInGUISlot(entity, 3) <= iron_required) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(3).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							iron_required = iron_required - 1;
						}
					} else {
						if (iron_required == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(3).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							iron_required = iron_required - 1;
						}
						if (iron_required == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(3).remove(2);
								_player.containerMenu.broadcastChanges();
							}
							iron_required = iron_required - 2;
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.FactionLevel = 2;
						_vars.markSyncDirty();
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You advance a level!"), true);
				}
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}