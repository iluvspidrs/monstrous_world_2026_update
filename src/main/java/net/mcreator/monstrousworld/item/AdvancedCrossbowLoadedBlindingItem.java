package net.mcreator.monstrousworld.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.procedures.PolishedCrossbowSilverBlindingLoadedRightclickedProcedure;

import java.util.List;

public class AdvancedCrossbowLoadedBlindingItem extends Item {
	public AdvancedCrossbowLoadedBlindingItem() {
		super(new Item.Properties().durability(500));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.CROSSBOW;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.monstrous_world.advanced_crossbow_loaded_blinding.description_0"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		PolishedCrossbowSilverBlindingLoadedRightclickedProcedure.execute(world, entity, ar.getObject());
		return ar;
	}
}