package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class RHCursedCandyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
			ItemStack _setstack0 = new ItemStack(Items.SUGAR).copy();
			_setstack0.setCount(1);
			_menu.getSlots().get(0).set(_setstack0);
			ItemStack _setstack1 = new ItemStack(MonstrousWorldModItems.A_HINT_OF_INSANITY.get()).copy();
			_setstack1.setCount(1);
			_menu.getSlots().get(1).set(_setstack1);
			ItemStack _setstack2 = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_ACID.get()).copy();
			_setstack2.setCount(1);
			_menu.getSlots().get(2).set(_setstack2);
			ItemStack _setstack3 = new ItemStack(MonstrousWorldModItems.CURSED_CANDY.get()).copy();
			_setstack3.setCount(1);
			_menu.getSlots().get(3).set(_setstack3);
			_player.containerMenu.broadcastChanges();
		}
	}
}