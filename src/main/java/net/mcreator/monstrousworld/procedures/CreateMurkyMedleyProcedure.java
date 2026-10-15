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
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class CreateMurkyMedleyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double swamp_wort = 0;
		double slug = 0;
		double caterpillar = 0;
		double swamp_essence = 0;
		double salmon = 0;
		double swamp_essence_dust = 0;
		double pond_scum = 0;
		if (!world.isClientSide()) {
			swamp_wort = 1;
			swamp_essence = 1;
			salmon = 1;
			swamp_essence_dust = 1;
			pond_scum = 1;
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MUD_BOWL.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(0).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (getAmountInGUISlot(entity, 6) <= 63) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						ItemStack _setstack6 = new ItemStack(MonstrousWorldModItems.MURKY_MEDLEY.get()).copy();
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
							.getItem() == MonstrousWorldModBlocks.POND_SCUM.get().asItem()) {
						if (pond_scum == 1 && getAmountInGUISlot(entity, 1) >= pond_scum) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							pond_scum = pond_scum - 1;
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE.get()) {
						if (swamp_essence == 1 && getAmountInGUISlot(entity, 1) >= swamp_essence) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							swamp_essence = swamp_essence - 1;
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE_DUST.get()) {
						if (swamp_essence_dust == 1 && getAmountInGUISlot(entity, 1) >= swamp_essence_dust) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							swamp_essence_dust = swamp_essence_dust - 1;
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.SALMON) {
						if (salmon == 1 && getAmountInGUISlot(entity, 1) >= salmon) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(1).remove(1);
								_player.containerMenu.broadcastChanges();
							}
							salmon = salmon - 1;
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_WORT
						.get()) {
					if (swamp_wort == 1 && getAmountInGUISlot(entity, 2) >= swamp_wort) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_wort = swamp_wort - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModBlocks.POND_SCUM.get().asItem()) {
					if (pond_scum == 1 && getAmountInGUISlot(entity, 2) >= pond_scum) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						pond_scum = pond_scum - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE.get()) {
					if (swamp_essence == 1 && getAmountInGUISlot(entity, 2) >= swamp_essence) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_essence = swamp_essence - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE_DUST.get()) {
					if (swamp_essence_dust == 1 && getAmountInGUISlot(entity, 2) >= swamp_essence_dust) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_essence_dust = swamp_essence_dust - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.SALMON) {
					if (salmon == 1 && getAmountInGUISlot(entity, 2) >= salmon) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						salmon = salmon - 1;
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_WORT
						.get()) {
					if (swamp_wort == 1 && getAmountInGUISlot(entity, 3) >= swamp_wort) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_wort = swamp_wort - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu52 ? _menu52.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModBlocks.POND_SCUM.get().asItem()) {
					if (pond_scum == 1 && getAmountInGUISlot(entity, 3) >= pond_scum) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						pond_scum = pond_scum - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE.get()) {
					if (swamp_essence == 1 && getAmountInGUISlot(entity, 3) >= swamp_essence) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_essence = swamp_essence - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE_DUST.get()) {
					if (swamp_essence_dust == 1 && getAmountInGUISlot(entity, 3) >= swamp_essence_dust) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_essence_dust = swamp_essence_dust - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.SALMON) {
					if (salmon == 1 && getAmountInGUISlot(entity, 3) >= salmon) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(3).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						salmon = salmon - 1;
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_WORT
						.get()) {
					if (swamp_wort == 1 && getAmountInGUISlot(entity, 4) >= swamp_wort) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_wort = swamp_wort - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(4).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModBlocks.POND_SCUM.get().asItem()) {
					if (pond_scum == 1 && getAmountInGUISlot(entity, 4) >= pond_scum) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						pond_scum = pond_scum - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(4).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE.get()) {
					if (swamp_essence == 1 && getAmountInGUISlot(entity, 4) >= swamp_essence) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_essence = swamp_essence - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(4).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE_DUST.get()) {
					if (swamp_essence_dust == 1 && getAmountInGUISlot(entity, 4) >= swamp_essence_dust) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_essence_dust = swamp_essence_dust - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu84 ? _menu84.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.SALMON) {
					if (salmon == 1 && getAmountInGUISlot(entity, 4) >= salmon) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						salmon = salmon - 1;
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_WORT
						.get()) {
					if (swamp_wort == 1 && getAmountInGUISlot(entity, 5) >= swamp_wort) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_wort = swamp_wort - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModBlocks.POND_SCUM.get().asItem()) {
					if (pond_scum == 1 && getAmountInGUISlot(entity, 5) >= pond_scum) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						pond_scum = pond_scum - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE.get()) {
					if (swamp_essence == 1 && getAmountInGUISlot(entity, 5) >= swamp_essence) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_essence = swamp_essence - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE_DUST.get()) {
					if (swamp_essence_dust == 1 && getAmountInGUISlot(entity, 5) >= swamp_essence_dust) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						swamp_essence_dust = swamp_essence_dust - 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu104 ? _menu104.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Items.SALMON) {
					if (salmon == 1 && getAmountInGUISlot(entity, 5) >= salmon) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						salmon = salmon - 1;
					}
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Swamp Essence 5", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence 4", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence 3", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence 2", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence 1", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence Dust", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence Dust 1", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence Dust 2", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence Dust 3", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence Dust 4", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Essence Dust 5", 0);
					_blockEntity.getPersistentData().putDouble("Salmon 5", 0);
					_blockEntity.getPersistentData().putDouble("Salmon 4", 0);
					_blockEntity.getPersistentData().putDouble("Salmon 3", 0);
					_blockEntity.getPersistentData().putDouble("Salmon 2", 0);
					_blockEntity.getPersistentData().putDouble("Salmon 1", 0);
					_blockEntity.getPersistentData().putDouble("Salmon", 0);
					_blockEntity.getPersistentData().putDouble("Pond Scum", 0);
					_blockEntity.getPersistentData().putDouble("Pond Scum 1", 0);
					_blockEntity.getPersistentData().putDouble("Pond Scum 2", 0);
					_blockEntity.getPersistentData().putDouble("Swamp Wort", 0);
					_blockEntity.getPersistentData().putDouble("Pond Scum 3", 0);
					_blockEntity.getPersistentData().putDouble("Pond Scum 4", 0);
					_blockEntity.getPersistentData().putDouble("Pond Scum 5", 0);
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