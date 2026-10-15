package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.MonstrousWorldMod;

public class DisappointmentMobEffect extends MobEffect {
	public DisappointmentMobEffect() {
		super(MobEffectCategory.HARMFUL, -10066330);
		this.addAttributeModifier(Attributes.LUCK, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.disappointment_0"), -1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}