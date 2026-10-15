/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.function.Supplier;

public class MonstrousWorldModBoatTypes {
	public static final EnumProxy<Boat.Type> PUMPKIN_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "monstrous_world:pumpkin_boat", MonstrousWorldModItems.PUMPKIN_BOAT, (Supplier<Item>) () -> Items.AIR,
			(Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> GHOSTLY_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "monstrous_world:ghostly_boat", MonstrousWorldModItems.GHOSTLY_BOAT, (Supplier<Item>) () -> Items.AIR,
			(Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> EVIL_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "monstrous_world:evil_boat", MonstrousWorldModItems.EVIL_BOAT, (Supplier<Item>) () -> Items.AIR,
			(Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> PALE_STALK_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "monstrous_world:pale_stalk_boat", MonstrousWorldModItems.PALE_STALK_BOAT,
			(Supplier<Item>) () -> Items.AIR, (Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> MURKWOOD_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "monstrous_world:murkwood_boat", MonstrousWorldModItems.MURKWOOD_BOAT, (Supplier<Item>) () -> Items.AIR,
			(Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> SANGUINUS_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "monstrous_world:sanguinus_boat", MonstrousWorldModItems.SANGUINUS_BOAT, (Supplier<Item>) () -> Items.AIR,
			(Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> DEATHLY_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "monstrous_world:deathly_boat", MonstrousWorldModItems.DEATHLY_BOAT, (Supplier<Item>) () -> Items.AIR,
			(Supplier<Item>) () -> Items.STICK, false);
}