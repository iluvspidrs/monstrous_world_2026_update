package net.mcreator.monstrousworld.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.procedures.UncookedStrangeSerum3FlaskRightclickedProcedure;

import java.util.List;

public class StrangeFlaskUncooked3Item extends Item {
	public StrangeFlaskUncooked3Item() {
		super(new Item.Properties());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.monstrous_world.strange_flask_uncooked_3.description_0"));
		list.add(Component.translatable("item.monstrous_world.strange_flask_uncooked_3.description_1"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		UncookedStrangeSerum3FlaskRightclickedProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}