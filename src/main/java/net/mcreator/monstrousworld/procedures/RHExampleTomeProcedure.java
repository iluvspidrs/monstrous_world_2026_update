package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class RHExampleTomeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(MonstrousWorldModItems.RICH_INK.get()).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(0).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(Items.BOOK).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(1).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(MonstrousWorldModItems.ANOINTMENT_OIL.get()).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(2).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(Items.FEATHER).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(3).set(_setstack3);
			ItemStack _setstack4 = new ItemStack(MonstrousWorldModItems.TOME_OF_WEALTH.get()).copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(4).set(_setstack4);
			_player.containerMenu.broadcastChanges();
		}
	}
}