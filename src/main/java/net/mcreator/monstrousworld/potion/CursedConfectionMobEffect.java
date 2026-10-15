package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.procedures.CursedConfectionOnEffectActiveTickProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class CursedConfectionMobEffect extends MobEffect {
	public CursedConfectionMobEffect() {
		super(MobEffectCategory.HARMFUL, -26113);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.cursed_confection_0"), 0.1, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		CursedConfectionOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}