package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class AddLoreToBinderPage12Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TOME_OF_FUN_AND_GAMES
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack5 = new ItemStack(MonstrousWorldModItems.TOME_OF_FUN_AND_GAMES.get()).copy();
				_setstack5.setCount(1);
				_menu.getSlots().get(1).set(_setstack5);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.A_HUNTERS_WARNING_CIRCUS_TENTS_ITEM.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack11 = new ItemStack(MonstrousWorldModItems.A_HUNTERS_WARNING_CIRCUS_TENTS_ITEM.get()).copy();
				_setstack11.setCount(1);
				_menu.getSlots().get(2).set(_setstack11);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}