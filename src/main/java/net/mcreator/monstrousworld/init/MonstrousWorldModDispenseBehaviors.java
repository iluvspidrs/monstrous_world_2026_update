/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;

@EventBusSubscriber
public class MonstrousWorldModDispenseBehaviors {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DispenserBlock.registerBehavior(MonstrousWorldModItems.PUMPKIN_BOAT.get(), new BoatDispenseItemBehavior(MonstrousWorldModBoatTypes.PUMPKIN_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(MonstrousWorldModItems.GHOSTLY_BOAT.get(), new BoatDispenseItemBehavior(MonstrousWorldModBoatTypes.GHOSTLY_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(MonstrousWorldModItems.EVIL_BOAT.get(), new BoatDispenseItemBehavior(MonstrousWorldModBoatTypes.EVIL_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(MonstrousWorldModItems.PALE_STALK_BOAT.get(), new BoatDispenseItemBehavior(MonstrousWorldModBoatTypes.PALE_STALK_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(MonstrousWorldModItems.MURKWOOD_BOAT.get(), new BoatDispenseItemBehavior(MonstrousWorldModBoatTypes.MURKWOOD_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(MonstrousWorldModItems.SANGUINUS_BOAT.get(), new BoatDispenseItemBehavior(MonstrousWorldModBoatTypes.SANGUINUS_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(MonstrousWorldModItems.DEATHLY_BOAT.get(), new BoatDispenseItemBehavior(MonstrousWorldModBoatTypes.DEATHLY_BOAT_TYPE.getValue()));
		});
	}
}