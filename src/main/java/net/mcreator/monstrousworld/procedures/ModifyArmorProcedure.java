package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class ModifyArmorProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:nuggets/electrum")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.ESSENCE_OF_ENCHANTMENT.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.HUNTER_BOOTS.get()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack8 = new ItemStack(MonstrousWorldModItems.HUNTER_MALACHITE_BOOTS.get()).copy();
								_setstack8.setCount(1);
								_menu.getSlots().get(8).set(_setstack8);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(8).getItem() : ItemStack.EMPTY)
									.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(4).remove(1);
								_menu.getSlots().get(5).remove(1);
								_menu.getSlots().get(6).remove(1);
								_menu.getSlots().get(7).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
		}
	}
}