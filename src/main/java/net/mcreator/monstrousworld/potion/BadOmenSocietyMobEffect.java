package net.mcreator.monstrousworld.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class BadOmenSocietyMobEffect extends MobEffect {
	public BadOmenSocietyMobEffect() {
		super(MobEffectCategory.HARMFUL, -13421773);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("event.mob_effect.bad_omen")));
	}
}