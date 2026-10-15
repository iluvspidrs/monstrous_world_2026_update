package net.mcreator.monstrousworld.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.procedures.SinkingActiveTickConditionProcedure;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class SinkingMobEffect extends MobEffect {
	public SinkingMobEffect() {
		super(MobEffectCategory.HARMFUL, -13434829);
		this.addAttributeModifier(Attributes.STEP_HEIGHT, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.sinking_0"), -0.3, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath(MonstrousWorldMod.MODID, "effect.sinking_1"), -0.3, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		SinkingActiveTickConditionProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}