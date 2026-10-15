package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class SilverBoltSinkingProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.SINKING, 200, 0));
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType >= 4 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7
					|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HOLY_DAMAGE, 200, 0));
			}
			if (entity.getPersistentData().getBoolean("vampire") == true || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:takes_holy_damage")))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HOLY_DAMAGE, 200, 0));
			}
			if (entity.getType().is(EntityTypeTags.UNDEAD)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HOLY_DAMAGE, 200, 0));
			}
		}
	}
}