package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.Witch1Entity;
import net.mcreator.monstrousworld.entity.SorcererNPCEntity;

public class VampirismEntityOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestShadeMarker = null;
		Entity NearestVillager = null;
		Entity NearestSorcerer = null;
		Entity NearestSocietyGuard = null;
		Entity NearestIllager = null;
		Entity NearestPlayer = null;
		Entity NearestWW = null;
		Entity NearestHunter = null;
		Entity NearestSocietyPatrol = null;
		Entity NearestHunterPatrol = null;
		Entity NearestWanderingTrader = null;
		Entity TargetedEntity = null;
		Entity TargetEntity = null;
		if (!world.isClientSide()) {
			if (!world.getLevelData().isRaining()) {
				if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
					if (world instanceof Level _lvl3 && _lvl3.isDay()) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 1));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 1));
						entity.igniteForSeconds(3);
					}
				}
			}
			if (!(entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(ResourceLocation.parse("monstrous_world:vampirespeed")))) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirespeed"), 0.1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
			}
			if (!(entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttribute(Attributes.MAX_HEALTH).hasModifier(ResourceLocation.parse("monstrous_world:vampirehealth")))) {
				if (entity instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirehealth"), 0.1, AttributeModifier.Operation.ADD_VALUE);
					if (!_entity.getAttribute(Attributes.MAX_HEALTH).hasModifier(modifier.id())) {
						_entity.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(modifier);
					}
				}
			}
			if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("vampire")) {
				if (entity.getPersistentData().getBoolean("vampire") == true) {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY) ? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY).getDuration() : 0) < 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY, 24000, 0, true, false));
					}
				}
			}
			if (entity instanceof Witch1Entity) {
				if ((entity instanceof Witch1Entity _datEntL16 && _datEntL16.getEntityData().get(Witch1Entity.DATA_Vampire)) == false) {
					if (entity instanceof Witch1Entity _datEntSetL)
						_datEntSetL.getEntityData().set(Witch1Entity.DATA_Vampire, true);
				}
			}
			if (entity instanceof SorcererNPCEntity) {
				if ((entity instanceof SorcererNPCEntity _datEntL19 && _datEntL19.getEntityData().get(SorcererNPCEntity.DATA_Vampire)) == false) {
					if (entity instanceof SorcererNPCEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SorcererNPCEntity.DATA_Vampire, true);
				}
			}
		}
	}
}