package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

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
import net.mcreator.monstrousworld.entity.*;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DespawningBoltProjectileHitsLivingEntityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (sourceentity instanceof IronBoltProjectileDespawningEntity) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType >= 4 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7
						|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HOLY_DAMAGE, 200, 0));
				}
				if (entity instanceof FeralWerewolfEntity || entity instanceof DireWerewolfEntity || entity instanceof FollowerWerewolfEntity || entity instanceof HumanWerewolfEntity) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HOLY_DAMAGE, 200, 0));
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.IRON_POISONING, 200, 0));
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
			if (sourceentity instanceof SilverBoltProjectileEntity || sourceentity instanceof SilverBoltParalysisProjectileEntity || sourceentity instanceof SilverBoltBlindingProjectileEntity
					|| sourceentity instanceof SilverBoltSinkingProjectileEntity || sourceentity instanceof SilverBoltVanishingProjectileEntity || sourceentity instanceof SilverThrowingKnifeProjectileEntity) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType >= 4 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7
						|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HOLY_DAMAGE, 200, 0));
				}
				if (entity instanceof FeralWerewolfEntity || entity instanceof DireWerewolfEntity || entity instanceof FollowerWerewolfEntity || entity instanceof HumanWerewolfEntity) {
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
			if (sourceentity instanceof IronBoltProjectileEntity || sourceentity instanceof IronThrowingKnifeProjectileEntity) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.IRON_POISONING, 200, 0));
				}
				if (entity instanceof GoblinVillagerEntity || entity instanceof FeralGoblinEntity) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.IRON_POISONING, 200, 0));
				}
			}
			if (sourceentity instanceof SilverBoltParalysisProjectileEntity || sourceentity instanceof SilverBoltBlindingProjectileEntity || sourceentity instanceof SilverBoltSinkingProjectileEntity
					|| sourceentity instanceof SilverBoltVanishingProjectileEntity) {
				if (!sourceentity.level().isClientSide())
					sourceentity.discard();
			}
		}
	}
}