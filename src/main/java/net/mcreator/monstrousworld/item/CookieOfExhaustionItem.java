package net.mcreator.monstrousworld.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.monstrousworld.procedures.CookieOfExhaustionPlayerFinishesUsingItemProcedure;

public class CookieOfExhaustionItem extends Item {
	public CookieOfExhaustionItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.NONE;
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 0;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		CookieOfExhaustionPlayerFinishesUsingItemProcedure.execute(world, entity);
		return retval;
	}
}