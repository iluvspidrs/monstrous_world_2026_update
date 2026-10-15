package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.ItemStack;

public class ModifiedIronPickaxeRoseToolInHandTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (Math.random() >= 0.999) {
			if (itemstack.getDamageValue() != itemstack.getMaxDamage()) {
				itemstack.setDamageValue(itemstack.getDamageValue() - 1);
			}
		}
	}
}