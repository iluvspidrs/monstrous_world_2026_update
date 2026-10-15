package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class RHBloodFocusProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(MonstrousWorldModItems.BLACK_ONYX.get()).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(0).set(_setstack0);
			ItemStack _setstack2 = ItemStack.EMPTY.copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(1).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(MonstrousWorldModItems.BLACK_ONYX.get()).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(2).set(_setstack3);
			ItemStack _setstack4 = new ItemStack(MonstrousWorldModItems.BLACK_ONYX.get()).copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(3).set(_setstack4);
			ItemStack _setstack5 = new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_MOONSTONE.get()).copy();
			_setstack5.setCount(1);
			_menu.getSlots().get(4).set(_setstack5);
			ItemStack _setstack6 = new ItemStack(MonstrousWorldModItems.BLACK_ONYX.get()).copy();
			_setstack6.setCount(1);
			_menu.getSlots().get(5).set(_setstack6);
			ItemStack _setstack8 = ItemStack.EMPTY.copy();
			_setstack8.setCount(1);
			_menu.getSlots().get(6).set(_setstack8);
			ItemStack _setstack9 = new ItemStack(MonstrousWorldModBlocks.BLOCK_OF_SARDOYNX.get()).copy();
			_setstack9.setCount(1);
			_menu.getSlots().get(7).set(_setstack9);
			ItemStack _setstack11 = ItemStack.EMPTY.copy();
			_setstack11.setCount(1);
			_menu.getSlots().get(8).set(_setstack11);
			ItemStack _setstack12 = new ItemStack(MonstrousWorldModBlocks.BLOOD_FOCUS.get()).copy();
			_setstack12.setCount(1);
			_menu.getSlots().get(9).set(_setstack12);
			_player.containerMenu.broadcastChanges();
		}
	}
}