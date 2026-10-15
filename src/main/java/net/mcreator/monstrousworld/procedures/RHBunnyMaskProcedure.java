package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class RHBunnyMaskProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(MonstrousWorldModItems.DRIED_SKIN.get()).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(0).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(Items.STRING).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(1).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(MonstrousWorldModItems.DRIED_SKIN.get()).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(2).set(_setstack2);
			ItemStack _setstack4 = ItemStack.EMPTY.copy();
			_setstack4.setCount(1);
			_menu.getSlots().get(3).set(_setstack4);
			ItemStack _setstack5 = new ItemStack(Blocks.YELLOW_TERRACOTTA).copy();
			_setstack5.setCount(1);
			_menu.getSlots().get(4).set(_setstack5);
			ItemStack _setstack7 = ItemStack.EMPTY.copy();
			_setstack7.setCount(1);
			_menu.getSlots().get(5).set(_setstack7);
			ItemStack _setstack9 = ItemStack.EMPTY.copy();
			_setstack9.setCount(1);
			_menu.getSlots().get(6).set(_setstack9);
			ItemStack _setstack11 = ItemStack.EMPTY.copy();
			_setstack11.setCount(1);
			_menu.getSlots().get(7).set(_setstack11);
			ItemStack _setstack13 = ItemStack.EMPTY.copy();
			_setstack13.setCount(1);
			_menu.getSlots().get(8).set(_setstack13);
			ItemStack _setstack14 = new ItemStack(MonstrousWorldModItems.BUNNY_MASK_HELMET.get()).copy();
			_setstack14.setCount(1);
			_menu.getSlots().get(9).set(_setstack14);
			_player.containerMenu.broadcastChanges();
		}
	}
}