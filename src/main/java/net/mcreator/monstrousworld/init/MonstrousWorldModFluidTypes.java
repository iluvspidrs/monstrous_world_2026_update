/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.monstrousworld.fluid.types.AcidFluidType;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class MonstrousWorldModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, MonstrousWorldMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> ACID_TYPE = REGISTRY.register("acid", AcidFluidType::new);
}