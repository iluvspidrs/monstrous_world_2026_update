package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class AddLoreToBinderPage3Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("monstrous_world:goblin_intel")))) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TOME_OF_THE_GOBLIN
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack7 = new ItemStack(MonstrousWorldModItems.TOME_OF_THE_GOBLIN.get()).copy();
				_setstack7.setCount(1);
				_menu.getSlots().get(1).set(_setstack7);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PRECIOUS_STONES_AND_YOU
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack11 = new ItemStack(MonstrousWorldModItems.PRECIOUS_STONES_AND_YOU.get()).copy();
				_setstack11.setCount(1);
				_menu.getSlots().get(2).set(_setstack11);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HUNTERS_WARNING
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack15 = new ItemStack(MonstrousWorldModItems.A_HUNTERS_WARNING.get()).copy();
				_setstack15.setCount(1);
				_menu.getSlots().get(3).set(_setstack15);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.HUNTER_MISSION_FOR_GOBLIN.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack19 = new ItemStack(MonstrousWorldModItems.HUNTER_MISSION_FOR_GOBLIN.get()).copy();
				_setstack19.setCount(1);
				_menu.getSlots().get(4).set(_setstack19);
				_player.containerMenu.broadcastChanges();
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FRESH_COOKIES
				.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(0).set(ItemStack.EMPTY);
				ItemStack _setstack23 = new ItemStack(MonstrousWorldModItems.FRESH_COOKIES.get()).copy();
				_setstack23.setCount(1);
				_menu.getSlots().get(5).set(_setstack23);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}