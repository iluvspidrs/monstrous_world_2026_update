package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class RenderTooltipsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if (itemstack.getItem() == MonstrousWorldModItems.STRANGE_SERUM_FLASK.get()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MutationType") == 1) {
				tooltip.add(1, Component.literal("Fly Mutation"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MutationType") == 2) {
				tooltip.add(1, Component.literal("Eye Mutation"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("MutationType") == 3) {
				tooltip.add(1, Component.literal("Serpent Mutation"));
			}
		}
		if ((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()).contains("dagger") || (BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString()).contains("knife")) {
			tooltip.add(1, Component.literal("Right-clicking with item will free you from spider webbing"));
		}
		if (itemstack.getItem() == MonstrousWorldModItems.CURSED_CONFECTIONERY.get() || itemstack.getItem() == MonstrousWorldModItems.ENSLAVED_SOUL.get() || itemstack.getItem() == MonstrousWorldModItems.ENSLAVED_WICKED_SOUL.get()) {
			tooltip.add(1, Component.literal(("Type: placeholder".replace("placeholder", itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Type")))));
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("monstrous_world:darkness_defense")))) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 1) {
				tooltip.add(3, Component.literal("\u00A74Your curse prevents this from working"));
			}
		}
		if (itemstack.getItem() == Items.GLASS_BOTTLE) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
				tooltip.add(1, Component.literal("Shift-click to collect venom from yourself"));
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2) {
				tooltip.add(1, Component.literal("Shift-click to collect Dreadful Tears from yourself"));
			}
		}
	}
}