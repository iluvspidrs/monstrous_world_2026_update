package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class AddLoreToBinderPage14Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_MISC
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack6 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack6.setCount(1);
					_menu.getSlots().get(1).set(_setstack6);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_WITCHERY
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack14 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack14.setCount(1);
					_menu.getSlots().get(2).set(_setstack14);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_GOBLIN
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack22 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack22.setCount(1);
					_menu.getSlots().get(3).set(_setstack22);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_TROLL
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack30 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack30.setCount(1);
					_menu.getSlots().get(4).set(_setstack30);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_SORCERY
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack38 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack38.setCount(1);
					_menu.getSlots().get(5).set(_setstack38);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.LORE_BINDER_MAD_SCIENCE.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack46 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack46.setCount(1);
					_menu.getSlots().get(6).set(_setstack46);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.LORE_BINDER_SWAMP_MONSTER.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack54 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu53 ? _menu53.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack54.setCount(1);
					_menu.getSlots().get(7).set(_setstack54);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_WEREWOLF
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu58 ? _menu58.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack62 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack62.setCount(1);
					_menu.getSlots().get(8).set(_setstack62);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_VAMPIRE
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(9).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack70 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack70.setCount(1);
					_menu.getSlots().get(9).set(_setstack70);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_HUNTER
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack78 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu77 ? _menu77.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack78.setCount(1);
					_menu.getSlots().get(10).set(_setstack78);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_DEMON
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu82 ? _menu82.getSlots().get(11).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack86 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack86.setCount(1);
					_menu.getSlots().get(11).set(_setstack86);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_CLOWN
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(12).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack94 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu93 ? _menu93.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack94.setCount(1);
					_menu.getSlots().get(12).set(_setstack94);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.LORE_BINDER_MANIAC
				.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(13).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack102 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu101 ? _menu101.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
					_setstack102.setCount(1);
					_menu.getSlots().get(13).set(_setstack102);
					_menu.getSlots().get(0).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
	}
}