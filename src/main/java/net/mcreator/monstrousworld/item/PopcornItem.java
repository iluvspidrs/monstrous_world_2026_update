package net.mcreator.monstrousworld.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class PopcornItem extends Item {
	public PopcornItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).build()));
	}
}