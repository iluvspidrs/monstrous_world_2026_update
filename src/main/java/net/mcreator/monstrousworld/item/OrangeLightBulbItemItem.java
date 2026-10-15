package net.mcreator.monstrousworld.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.monstrousworld.procedures.OrangeLightBulbItemRighclickedOnBlockProcedure;

public class OrangeLightBulbItemItem extends Item {
	public OrangeLightBulbItemItem() {
		super(new Item.Properties());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		OrangeLightBulbItemRighclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}