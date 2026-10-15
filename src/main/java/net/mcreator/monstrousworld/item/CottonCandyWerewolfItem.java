package net.mcreator.monstrousworld.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CottonCandyWerewolfItem extends Item {
	public CottonCandyWerewolfItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationModifier(0.3f).build()));
	}
}