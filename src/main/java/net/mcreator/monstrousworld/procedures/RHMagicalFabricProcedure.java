package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class RHMagicalFabricProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
			ItemStack _setstack1 = ItemStack.EMPTY.copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(0).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(MonstrousWorldModItems.QUARTZ_DUST.get()).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(1).set(_setstack2);
			ItemStack _setstack4 = ItemStack.EMPTY.copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(2).set(_setstack4);
			ItemStack _setstack5 = new ItemStack(MonstrousWorldModItems.QUARTZ_DUST.get()).copy();
			_setstack5.setCount(1);
			_menu.getSlots().get(3).set(_setstack5);
			ItemStack _setstack6 = new ItemStack(Blocks.BLACK_WOOL).copy();
			_setstack6.setCount(1);
			_menu.getSlots().get(4).set(_setstack6);
			ItemStack _setstack7 = new ItemStack(MonstrousWorldModItems.QUARTZ_DUST.get()).copy();
			_setstack7.setCount(1);
			_menu.getSlots().get(5).set(_setstack7);
			ItemStack _setstack9 = ItemStack.EMPTY.copy();
			_setstack9.setCount(1);
			_menu.getSlots().get(6).set(_setstack9);
			ItemStack _setstack10 = new ItemStack(MonstrousWorldModItems.QUARTZ_DUST.get()).copy();
			_setstack10.setCount(1);
			_menu.getSlots().get(7).set(_setstack10);
			ItemStack _setstack12 = ItemStack.EMPTY.copy();
			_setstack12.setCount(1);
			_menu.getSlots().get(8).set(_setstack12);
			ItemStack _setstack13 = new ItemStack(MonstrousWorldModBlocks.MAGICAL_FABRIC.get()).copy();
			_setstack13.setCount(1);
			_menu.getSlots().get(9).set(_setstack13);
			_player.containerMenu.broadcastChanges();
		}
	}
}