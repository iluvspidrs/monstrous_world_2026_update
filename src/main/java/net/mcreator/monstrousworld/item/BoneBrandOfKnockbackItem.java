package net.mcreator.monstrousworld.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.monstrousworld.procedures.BoneBrandOfKnockbackRightclickedProcedure;

public class BoneBrandOfKnockbackItem extends Item {
	public BoneBrandOfKnockbackItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		BoneBrandOfKnockbackRightclickedProcedure.execute(world, entity, ar.getObject());
		return ar;
	}
}