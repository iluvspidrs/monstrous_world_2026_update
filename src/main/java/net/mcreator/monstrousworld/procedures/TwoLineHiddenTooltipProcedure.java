package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class TwoLineHiddenTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, Minecraft.getInstance().level, event.getItemStack(), event.getToolTip());
	}

	public static void execute(LevelAccessor world, ItemStack itemstack, List<Component> tooltip) {
		execute(null, world, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("monstrous_world:nightmare_items")))) {
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("monstrous_world:two_line_tooltips")))) {
				if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 0) {
					tooltip.remove(0);
					tooltip.add(0, Component.literal("???"));
					tooltip.remove(1);
					tooltip.add(1, Component.literal("???"));
				}
			}
		}
	}
}