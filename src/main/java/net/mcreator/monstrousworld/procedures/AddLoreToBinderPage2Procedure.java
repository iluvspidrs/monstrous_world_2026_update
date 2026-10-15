package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class AddLoreToBinderPage2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:witchery_intel")))) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TOME_OF_WITCHERY
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack7 = new ItemStack(MonstrousWorldModItems.TOME_OF_WITCHERY.get()).copy();
				_setstack7.setCount(1);
				_menu.getSlots().get(1).set(_setstack7);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.A_GUIDE_TO_MAGICKAL_PLANTS.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack11 = new ItemStack(MonstrousWorldModItems.A_GUIDE_TO_MAGICKAL_PLANTS.get()).copy();
				_setstack11.setCount(1);
				_menu.getSlots().get(2).set(_setstack11);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOOKISH_POWDER_RECIPE
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack15 = new ItemStack(MonstrousWorldModItems.BOOKISH_POWDER_RECIPE.get()).copy();
				_setstack15.setCount(1);
				_menu.getSlots().get(3).set(_setstack15);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.OBSTRUCTION_POWDER_RECIPE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack19 = new ItemStack(MonstrousWorldModItems.OBSTRUCTION_POWDER_RECIPE.get()).copy();
				_setstack19.setCount(1);
				_menu.getSlots().get(10).set(_setstack19);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FROGIFY_POWDER_RECIPE
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack23 = new ItemStack(MonstrousWorldModItems.FROGIFY_POWDER_RECIPE.get()).copy();
				_setstack23.setCount(1);
				_menu.getSlots().get(7).set(_setstack23);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SINKING_POWDER_RECIPE
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack27 = new ItemStack(MonstrousWorldModItems.SINKING_POWDER_RECIPE.get()).copy();
				_setstack27.setCount(1);
				_menu.getSlots().get(13).set(_setstack27);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SPIRIT_POWDER_RECIPE
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack31 = new ItemStack(MonstrousWorldModItems.SPIRIT_POWDER_RECIPE.get()).copy();
				_setstack31.setCount(1);
				_menu.getSlots().get(14).set(_setstack31);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.WEREWOLF_CURE_POWDER_RECIPE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack35 = new ItemStack(MonstrousWorldModItems.WEREWOLF_CURE_POWDER_RECIPE.get()).copy();
				_setstack35.setCount(1);
				_menu.getSlots().get(16).set(_setstack35);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.VAMPIRE_CURE_POWDER_RECIPE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack39 = new ItemStack(MonstrousWorldModItems.VAMPIRE_CURE_POWDER_RECIPE.get()).copy();
				_setstack39.setCount(1);
				_menu.getSlots().get(8).set(_setstack39);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.UNDEATH_CURE_POWDER_RECIPE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack43 = new ItemStack(MonstrousWorldModItems.UNDEATH_CURE_POWDER_RECIPE.get()).copy();
				_setstack43.setCount(1);
				_menu.getSlots().get(17).set(_setstack43);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.PARALYSIS_POWDER_RECIPE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack47 = new ItemStack(MonstrousWorldModItems.PARALYSIS_POWDER_RECIPE.get()).copy();
				_setstack47.setCount(1);
				_menu.getSlots().get(11).set(_setstack47);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.EXPLOSION_POWDER_RECIPE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack51 = new ItemStack(MonstrousWorldModItems.EXPLOSION_POWDER_RECIPE.get()).copy();
				_setstack51.setCount(1);
				_menu.getSlots().get(5).set(_setstack51);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu52 ? _menu52.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.MIDAS_CURSE_POWDER_RECIPE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack55 = new ItemStack(MonstrousWorldModItems.MIDAS_CURSE_POWDER_RECIPE.get()).copy();
				_setstack55.setCount(1);
				_menu.getSlots().get(9).set(_setstack55);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_POWDER_RECIPE
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack59 = new ItemStack(MonstrousWorldModItems.PUMPKIN_POWDER_RECIPE.get()).copy();
				_setstack59.setCount(1);
				_menu.getSlots().get(12).set(_setstack59);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FLIGHT_POWDER_RECIPE
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack63 = new ItemStack(MonstrousWorldModItems.FLIGHT_POWDER_RECIPE.get()).copy();
				_setstack63.setCount(1);
				_menu.getSlots().get(6).set(_setstack63);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.CHICKENIFY_POWDER_RECIPE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack67 = new ItemStack(MonstrousWorldModItems.CHICKENIFY_POWDER_RECIPE.get()).copy();
				_setstack67.setCount(1);
				_menu.getSlots().get(4).set(_setstack67);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.VANISHING_POWDER_RECIPE.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack71 = new ItemStack(MonstrousWorldModItems.VANISHING_POWDER_RECIPE.get()).copy();
				_setstack71.setCount(1);
				_menu.getSlots().get(15).set(_setstack71);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.GLOWING_PUMPKIN_TREES_NOTE_ITEM.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack75 = new ItemStack(MonstrousWorldModItems.GLOWING_PUMPKIN_TREES_NOTE_ITEM.get()).copy();
				_setstack75.setCount(1);
				_menu.getSlots().get(18).set(_setstack75);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}