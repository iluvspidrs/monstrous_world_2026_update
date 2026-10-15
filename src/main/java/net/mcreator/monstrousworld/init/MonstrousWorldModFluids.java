/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.monstrousworld.fluid.AcidFluid;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class MonstrousWorldModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, MonstrousWorldMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> ACID = REGISTRY.register("acid", AcidFluid.Source::new);
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ACID = REGISTRY.register("flowing_acid", AcidFluid.Flowing::new);

	@EventBusSubscriber(Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(ACID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ACID.get(), RenderType.translucent());
		}
	}
}