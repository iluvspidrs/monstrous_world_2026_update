package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class CreateCottonCandySwampmonsterProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double sugar_required = 0;
		double hintofinsanity_required = 0;
		double acidbottle_required = 0;
		double cursed_confectionery_human_required = 0;
		sugar_required = 1;
		hintofinsanity_required = 1;
		cursed_confectionery_human_required = 1;
		if (getAmountInGUISlot(entity, 3) <= 63) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack2 = new ItemStack(MonstrousWorldModItems.COTTON_CANDY_SWAMPMONSTER.get()).copy();
				_setstack2.setCount(getAmountInGUISlot(entity, 3) + 1);
				_menu.getSlots().get(3).set(_setstack2);
				_player.containerMenu.broadcastChanges();
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(0).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				sugar_required = 0;
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(0).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				hintofinsanity_required = 0;
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(0).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				cursed_confectionery_human_required = 0;
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR) {
				if (sugar_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(1).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					sugar_required = 0;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY.get()) {
				if (hintofinsanity_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(1).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					hintofinsanity_required = 0;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY.get()) {
				if (cursed_confectionery_human_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(1).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					cursed_confectionery_human_required = 0;
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.SUGAR) {
				if (sugar_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					sugar_required = 0;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY.get()) {
				if (hintofinsanity_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					hintofinsanity_required = 0;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY.get()) {
				if (cursed_confectionery_human_required == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
						_menu.getSlots().get(2).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					cursed_confectionery_human_required = 0;
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
}