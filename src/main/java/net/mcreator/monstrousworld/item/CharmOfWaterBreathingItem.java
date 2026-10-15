package net.mcreator.monstrousworld.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.procedures.CharmOfWaterBreathingItemInInventoryTickProcedure;

public class CharmOfWaterBreathingItem extends Item {
	public CharmOfWaterBreathingItem() {
		super(new Item.Properties().durability(50));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		CharmOfWaterBreathingItemInInventoryTickProcedure.execute(world, entity);
	}
}