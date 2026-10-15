package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class FollowerWerewolfOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity.getPersistentData().getString("Necklace")).equals("Lunar")) {
				if (world.dimensionType().moonPhase(world.dayTime()) == 0) {
					if (MonstrousWorldModVariables.TimeUntilNight < 0) {
						if (!(entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttribute(Attributes.MAX_HEALTH).hasModifier(ResourceLocation.parse("monstrous_world:werewolf_health_boost")))) {
							if (entity instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:werewolf_health_boost"), 100, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.MAX_HEALTH).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(modifier);
								}
							}
						}
					} else {
						if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttribute(Attributes.MAX_HEALTH).hasModifier(ResourceLocation.parse("monstrous_world:werewolf_health_boost"))) {
							if (entity instanceof LivingEntity _entity) {
								_entity.getAttribute(Attributes.MAX_HEALTH).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_health_boost"));
							}
						}
					}
				} else {
					if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttribute(Attributes.MAX_HEALTH).hasModifier(ResourceLocation.parse("monstrous_world:werewolf_health_boost"))) {
						if (entity instanceof LivingEntity _entity) {
							_entity.getAttribute(Attributes.MAX_HEALTH).removeModifier(ResourceLocation.parse("monstrous_world:werewolf_health_boost"));
						}
					}
				}
			}
			if ((entity.getPersistentData().getString("Necklace")).equals("Cleansing")) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WITHER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.UNHOLY_DAMAGE);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.HOLY_DAMAGE);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.INFESTED);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WEAKNESS);
			}
			if ((entity.getPersistentData().getString("Necklace")).equals("Attack")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 3));
			}
			if ((entity.getPersistentData().getString("Necklace")).equals("Shield")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 220, 2));
			}
			if ((entity.getPersistentData().getString("Necklace")).equals("Regeneration")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 1));
			}
		}
	}
}