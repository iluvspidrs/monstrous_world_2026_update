package net.mcreator.monstrousworld.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.monstrousworld.init.MonstrousWorldModFluids;

public class AcidItem extends BucketItem {
	public AcidItem() {
		super(MonstrousWorldModFluids.ACID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}