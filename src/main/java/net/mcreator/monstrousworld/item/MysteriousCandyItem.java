package net.mcreator.monstrousworld.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.monstrousworld.procedures.MysteriousCandyPlayerFinishesUsingItemProcedure;

public class MysteriousCandyItem extends Item {
	public MysteriousCandyItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		MysteriousCandyPlayerFinishesUsingItemProcedure.execute(world, x, y, z, entity);
		return retval;
	}
}