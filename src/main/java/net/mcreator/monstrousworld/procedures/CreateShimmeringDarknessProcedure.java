package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class CreateShimmeringDarknessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double netherite_required = 0;
		double tungsten_required = 0;
		double shining_required = 0;
		double darkened_required = 0;
		double bronze_required = 0;
		shining_required = 2;
		darkened_required = 2;
		if (getAmountInGUISlot(entity, 4) <= 60) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack2 = new ItemStack(MonstrousWorldModItems.SHIMMERING_DARK_INGOT.get()).copy();
				_setstack2.setCount(getAmountInGUISlot(entity, 4) + 4);
				_menu.getSlots().get(4).set(_setstack2);
				_player.containerMenu.broadcastChanges();
			}
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
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty_lava")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if (getAmountInGUISlot(entity, 0) < shining_required) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					shining_required = shining_required - 1;
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(2);
						_player.containerMenu.broadcastChanges();
					}
					shining_required = 0;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT.get()) {
				if (getAmountInGUISlot(entity, 0) < darkened_required) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					darkened_required = darkened_required - 1;
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(0).remove(2);
						_player.containerMenu.broadcastChanges();
					}
					darkened_required = 0;
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if (getAmountInGUISlot(entity, 1) == 1) {
					if (getAmountInGUISlot(entity, 1) <= shining_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						shining_required = shining_required - 1;
					}
				} else {
					if (shining_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						shining_required = shining_required - 1;
					}
					if (shining_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						shining_required = shining_required - 2;
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT.get()) {
				if (getAmountInGUISlot(entity, 1) == 1) {
					if (getAmountInGUISlot(entity, 1) <= darkened_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						darkened_required = darkened_required - 1;
					}
				} else {
					if (darkened_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						darkened_required = darkened_required - 1;
					}
					if (darkened_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(1).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						darkened_required = darkened_required - 2;
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if (getAmountInGUISlot(entity, 2) == 1) {
					if (getAmountInGUISlot(entity, 2) <= shining_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						shining_required = shining_required - 1;
					}
				} else {
					if (shining_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						shining_required = shining_required - 1;
					}
					if (shining_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						shining_required = shining_required - 2;
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT.get()) {
				if (getAmountInGUISlot(entity, 2) == 1) {
					if (getAmountInGUISlot(entity, 2) <= darkened_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						darkened_required = darkened_required - 1;
					}
				} else {
					if (darkened_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						darkened_required = darkened_required - 1;
					}
					if (darkened_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						darkened_required = darkened_required - 2;
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(3).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if (getAmountInGUISlot(entity, 3) == 1) {
					if (getAmountInGUISlot(entity, 3) <= shining_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						shining_required = shining_required - 1;
					}
				} else {
					if (shining_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						shining_required = shining_required - 1;
					}
					if (shining_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						shining_required = shining_required - 2;
					}
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(3).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT.get()) {
				if (getAmountInGUISlot(entity, 3) == 1) {
					if (getAmountInGUISlot(entity, 3) <= darkened_required) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						darkened_required = darkened_required - 1;
					}
				} else {
					if (darkened_required == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						darkened_required = darkened_required - 1;
					}
					if (darkened_required == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(2);
							_player.containerMenu.broadcastChanges();
						}
						darkened_required = darkened_required - 2;
					}
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