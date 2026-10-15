package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;

public class SwampmonsterVillagerOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWaterOrBubble()) {
			if (!(entity.getPersistentData().getBoolean("inWater") == true)) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:swampvillagerwatermovement"), 3, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).addPermanentModifier(modifier);
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 0));
				entity.getPersistentData().putBoolean("inWater", true);
			} else {
				entity.getPersistentData().putBoolean("inWater", false);
				if (entity instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.WATER_MOVEMENT_EFFICIENCY).removeModifier(ResourceLocation.parse("monstrous_world:swampvillagerwatermovement"));
				}
			}
		}
	}
}