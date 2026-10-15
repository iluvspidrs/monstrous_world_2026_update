package net.mcreator.monstrousworld.item.inventory;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

import net.mcreator.monstrousworld.world.inventory.OpenLoreBinder12Menu;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import javax.annotation.Nonnull;

@EventBusSubscriber
public class LoreBinderClownInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == MonstrousWorldModItems.LORE_BINDER_CLOWN.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof OpenLoreBinder12Menu)
				player.closeContainer();
		}
	}

	public LoreBinderClownInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 3);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 1;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != MonstrousWorldModItems.LORE_BINDER_CLOWN.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}