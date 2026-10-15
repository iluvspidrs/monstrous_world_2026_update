/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.monstrousworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.MonstrousWorldMod;

public class MonstrousWorldModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, MonstrousWorldMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> ALARM_BEEPING = REGISTRY.register("alarm_beeping", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("monstrous_world", "alarm_beeping")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MAN_SCREAMING = REGISTRY.register("man_screaming", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("monstrous_world", "man_screaming")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CLOWN_HORN = REGISTRY.register("clown_horn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("monstrous_world", "clown_horn")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SPARK = REGISTRY.register("spark", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("monstrous_world", "spark")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HUMMING_MACHINERY = REGISTRY.register("humming_machinery", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("monstrous_world", "humming_machinery")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHAINSAW_REV = REGISTRY.register("chainsaw_rev", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("monstrous_world", "chainsaw_rev")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NERVOUS_HEARTBEAT = REGISTRY.register("nervous_heartbeat", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("monstrous_world", "nervous_heartbeat")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TERRIFIED_HEARTBEAT = REGISTRY.register("terrified_heartbeat", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("monstrous_world", "terrified_heartbeat")));
}