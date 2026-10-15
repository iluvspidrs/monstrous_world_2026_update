package net.mcreator.monstrousworld.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class PurifiedPaleAgateItem extends Item {
	public PurifiedPaleAgateItem() {
		super(new Item.Properties());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}