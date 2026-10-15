package net.mcreator.monstrousworld.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.monstrousworld.procedures.UncookedCureSerumFlaskRightclickedProcedure;

public class CureFlaskUncookedItem extends Item {
	public CureFlaskUncookedItem() {
		super(new Item.Properties());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		UncookedCureSerumFlaskRightclickedProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}