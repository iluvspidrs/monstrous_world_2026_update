package net.mcreator.monstrousworld.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.monstrousworld.procedures.CaptiveInfernalLightRightclickedOnBlockProcedure;

public class CaptiveInfernalLightItem extends Item {
	public CaptiveInfernalLightItem() {
		super(new Item.Properties().stacksTo(1).fireResistant());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		CaptiveInfernalLightRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}