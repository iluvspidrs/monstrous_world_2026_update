package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class AddLoreToBinderPage7Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TOME_OF_THE_SWAMP
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack4 = new ItemStack(MonstrousWorldModItems.TOME_OF_THE_SWAMP.get()).copy();
				_setstack4.setCount(1);
				_menu.getSlots().get(1).set(_setstack4);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DEATHBLOOM_INSTRUCTIONS
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack10 = new ItemStack(MonstrousWorldModItems.DEATHBLOOM_INSTRUCTIONS.get()).copy();
				_setstack10.setCount(1);
				_menu.getSlots().get(2).set(_setstack10);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EXPLORER_LOG_PART_1
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack16 = new ItemStack(MonstrousWorldModItems.EXPLORER_LOG_PART_1.get()).copy();
				_setstack16.setCount(1);
				_menu.getSlots().get(3).set(_setstack16);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.EXPLORER_LOG_PART_2
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack22 = new ItemStack(MonstrousWorldModItems.EXPLORER_LOG_PART_2.get()).copy();
				_setstack22.setCount(1);
				_menu.getSlots().get(4).set(_setstack22);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTERS_WARNING_SWAMP
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack28 = new ItemStack(MonstrousWorldModItems.HUNTERS_WARNING_SWAMP.get()).copy();
				_setstack28.setCount(1);
				_menu.getSlots().get(5).set(_setstack28);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.THE_EYELET_NOTE
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack34 = new ItemStack(MonstrousWorldModItems.THE_EYELET_NOTE.get()).copy();
				_setstack34.setCount(1);
				_menu.getSlots().get(6).set(_setstack34);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.INTERROGATION
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack40 = new ItemStack(MonstrousWorldModItems.INTERROGATION.get()).copy();
				_setstack40.setCount(1);
				_menu.getSlots().get(7).set(_setstack40);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MURKANUS_MARTH_NOTE
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack46 = new ItemStack(MonstrousWorldModItems.MURKANUS_MARTH_NOTE.get()).copy();
				_setstack46.setCount(1);
				_menu.getSlots().get(8).set(_setstack46);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SLUG_SOUP_RECIPE
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack52 = new ItemStack(MonstrousWorldModItems.SLUG_SOUP_RECIPE.get()).copy();
				_setstack52.setCount(1);
				_menu.getSlots().get(9).set(_setstack52);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.CATERPILLAR_STEW_RECIPE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack58 = new ItemStack(MonstrousWorldModItems.CATERPILLAR_STEW_RECIPE.get()).copy();
				_setstack58.setCount(1);
				_menu.getSlots().get(10).set(_setstack58);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MURKY_MEDLEY_RECIPE
				.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				ItemStack _setstack64 = new ItemStack(MonstrousWorldModItems.MURKY_MEDLEY_RECIPE.get()).copy();
				_setstack64.setCount(1);
				_menu.getSlots().get(11).set(_setstack64);
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}