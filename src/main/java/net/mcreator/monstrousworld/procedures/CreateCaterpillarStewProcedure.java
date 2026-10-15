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

public class CreateCaterpillarStewProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double swamp_wort = 0;
		double slug = 0;
		double caterpillar = 0;
		if (!world.isClientSide()) {
			swamp_wort = 1;
			caterpillar = 4;
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MUD_BOWL.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(0).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (getAmountInGUISlot(entity, 6) <= 63) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						ItemStack _setstack6 = new ItemStack(MonstrousWorldModItems.CATERPILLAR_STEW.get()).copy();
						_setstack6.setCount(getAmountInGUISlot(entity, 6) + 1);
						_menu.getSlots().get(6).set(_setstack6);
						_player.containerMenu.broadcastChanges();
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bubble_column.upwards_ambient")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bubble_column.upwards_ambient")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_WORT
							.get()) {
						if (swamp_wort == 1 && getAmountInGUISlot(entity, 1) >= swamp_wort) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							swamp_wort = swamp_wort - 1;
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DREADMOTH_CATERPILLAR.get()) {
						if (getAmountInGUISlot(entity, 1) >= caterpillar) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(4);
								_player.containerMenu.broadcastChanges();
							}
							caterpillar = caterpillar - 4;
						} else if (getAmountInGUISlot(entity, 1) == 3) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(3);
								_player.containerMenu.broadcastChanges();
							}
							caterpillar = caterpillar - 3;
						} else if (getAmountInGUISlot(entity, 1) == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(2);
								_player.containerMenu.broadcastChanges();
							}
							caterpillar = caterpillar - 2;
						} else if (getAmountInGUISlot(entity, 1) == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							caterpillar = caterpillar - 1;
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SWAMP_WORT.get()) {
						if (swamp_wort == 1 && getAmountInGUISlot(entity, 2) >= swamp_wort) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							swamp_wort = swamp_wort - 1;
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(2).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DREADMOTH_CATERPILLAR.get()) {
						if (caterpillar >= 1) {
							if (getAmountInGUISlot(entity, 2) >= caterpillar) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(2).remove((int) caterpillar);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = 0;
							} else if (getAmountInGUISlot(entity, 2) == 3) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(2).remove(3);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 3;
							} else if (getAmountInGUISlot(entity, 2) == 2) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(2).remove(2);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 2;
							} else if (getAmountInGUISlot(entity, 2) == 1) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(2).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 1;
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SWAMP_WORT.get()) {
						if (swamp_wort == 1 && getAmountInGUISlot(entity, 3) >= swamp_wort) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(3).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							swamp_wort = swamp_wort - 1;
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DREADMOTH_CATERPILLAR.get()) {
						if (caterpillar >= 1) {
							if (getAmountInGUISlot(entity, 3) >= caterpillar) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(3).remove((int) caterpillar);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = 0;
							} else if (getAmountInGUISlot(entity, 3) == 3) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(3).remove(3);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 3;
							} else if (getAmountInGUISlot(entity, 3) == 2) {
								caterpillar = caterpillar - 2;
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(3).remove(2);
									_player.containerMenu.broadcastChanges();
								}
							} else if (getAmountInGUISlot(entity, 3) == 1) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(3).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 1;
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(4).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SWAMP_WORT.get()) {
						if (swamp_wort == 1 && getAmountInGUISlot(entity, 4) >= swamp_wort) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(4).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							swamp_wort = swamp_wort - 1;
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(4).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DREADMOTH_CATERPILLAR.get()) {
						if (caterpillar >= 1) {
							if (getAmountInGUISlot(entity, 4) >= caterpillar) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(4).remove((int) caterpillar);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = 0;
							} else if (getAmountInGUISlot(entity, 4) == 3) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(4).remove(3);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 3;
							} else if (getAmountInGUISlot(entity, 4) == 2) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(4).remove(2);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 2;
							} else if (getAmountInGUISlot(entity, 4) == 1) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(4).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 1;
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SWAMP_WORT.get()) {
						if (swamp_wort == 1 && getAmountInGUISlot(entity, 5) >= swamp_wort) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(5).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							swamp_wort = swamp_wort - 1;
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DREADMOTH_CATERPILLAR.get()) {
						if (caterpillar >= 1) {
							if (getAmountInGUISlot(entity, 5) >= caterpillar) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(5).remove((int) caterpillar);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = 0;
							} else if (getAmountInGUISlot(entity, 5) == 3) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(5).remove(3);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 3;
							} else if (getAmountInGUISlot(entity, 5) == 2) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(5).remove(2);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 2;
							} else if (getAmountInGUISlot(entity, 5) == 1) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								caterpillar = caterpillar - 1;
							}
						}
					}
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Caterpillar 5", 0);
					_blockEntity.getPersistentData().putDouble("Caterpillar 4", 0);
					_blockEntity.getPersistentData().putDouble("Caterpillar 3", 0);
					_blockEntity.getPersistentData().putDouble("Caterpillar 2", 0);
					_blockEntity.getPersistentData().putDouble("Caterpillar 1", 0);
					_blockEntity.getPersistentData().putDouble("Caterpillar", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Wort", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Wort 1", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Wort 2", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Wort 3", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Wort 4", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Wort 5", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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
}