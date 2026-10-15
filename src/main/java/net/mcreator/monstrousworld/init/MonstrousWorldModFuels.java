/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class MonstrousWorldModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_PUMPKIN_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_PUMPKIN_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_PLANKS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_FENCE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_SLAB.get().asItem())
			event.setBurnTime(150);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_STAIRS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_PRESSURE_PLATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_FENCE_GATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_BUTTON.get().asItem())
			event.setBurnTime(100);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_TRAPDOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PUMPKIN_DOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_GHOSTLY_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_GHOSTLY_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_PLANKS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_SLAB.get().asItem())
			event.setBurnTime(150);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_STAIRS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_FENCE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_FENCE_GATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_TRAPDOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_BUTTON.get().asItem())
			event.setBurnTime(100);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_PRESSURE_PLATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.GHOSTLY_DOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_STRIPPED_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_STRIPPED_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MOSSY_EVIL_TREE_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_PLANKS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_FENCE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_STAIRS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_FENCE_GATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_TRAPDOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_PRESSURE_PLATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_SLAB.get().asItem())
			event.setBurnTime(150);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.EVIL_TREE_BUTTON.get().asItem())
			event.setBurnTime(100);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_DEATHLY_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_DEATHLY_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_WOOD_PLANKS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_WOOD_FENCE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_WOOD_SLAB.get().asItem())
			event.setBurnTime(150);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_WOOD_STAIRS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_WOOD_PRESSURE_PLATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_WOOD_FENCE_GATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_BUTTON.get().asItem())
			event.setBurnTime(100);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_WOOD_TRAPDOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.DEATHLY_WOOD_DOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_SANGUINE_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_SANGUINE_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_WOOD_PLANKS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_WOOD_FENCE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_WOOD_SLAB.get().asItem())
			event.setBurnTime(150);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_WOOD_STAIRS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_WOOD_PRESSURE_PLATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_WOOD_FENCE_GATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_BUTTON.get().asItem())
			event.setBurnTime(100);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_WOOD_TRAPDOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.SANGUINE_WOOD_DOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_MURKWOOD_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.STRIPPED_MURKWOOD_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_PLANKS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_FENCE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_SLAB.get().asItem())
			event.setBurnTime(150);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_STAIRS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_PRESSURE_PLATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_FENCE_GATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_BUTTON.get().asItem())
			event.setBurnTime(100);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_TRAPDOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.MURKWOOD_DOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_STRIPPED_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_STRIPPED_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_PLANKS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_FENCE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_SLAB.get().asItem())
			event.setBurnTime(150);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_STAIRS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_PRESSURE_PLATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_FENCE_GATE.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_BUTTON.get().asItem())
			event.setBurnTime(100);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_TRAPDOOR.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == MonstrousWorldModBlocks.PALE_STALK_DOOR.get().asItem())
			event.setBurnTime(300);
	}
}