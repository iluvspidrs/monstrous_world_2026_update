package net.mcreator.monstrousworld.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CottonCandyVampireItem extends Item {
	public CottonCandyVampireItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationModifier(0.3f).build()));
	}
}