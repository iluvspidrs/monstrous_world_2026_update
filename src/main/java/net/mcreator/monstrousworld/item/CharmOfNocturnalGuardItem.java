package net.mcreator.monstrousworld.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.procedures.CharmOfNocturnalGuardItemInInventoryTickProcedure;

public class CharmOfNocturnalGuardItem extends Item {
	public CharmOfNocturnalGuardItem() {
		super(new Item.Properties().durability(50));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		CharmOfNocturnalGuardItemInInventoryTickProcedure.execute(world, entity);
	}
}