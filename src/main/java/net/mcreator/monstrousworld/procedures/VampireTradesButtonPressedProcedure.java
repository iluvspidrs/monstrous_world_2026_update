package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class VampireTradesButtonPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Vampire To Vampire")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SARDONYX.get()) {
				if (getAmountInGUISlot(entity, 1) < 64) {
					if (getAmountInGUISlot(entity, 1) == 0 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(1).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack8 = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()).copy();
							_setstack8.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack8);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT) {
				if (getAmountInGUISlot(entity, 2) >= 8) {
					if (getAmountInGUISlot(entity, 3) == 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(8);
							ItemStack _setstack15 = new ItemStack(MonstrousWorldModItems.AMULET_OF_RESERVE.get()).copy();
							_setstack15.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack15);
							_player.containerMenu.broadcastChanges();
						}
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
}