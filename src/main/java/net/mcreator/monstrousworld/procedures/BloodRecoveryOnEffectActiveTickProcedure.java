package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class BloodRecoveryOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player)) {
			if (!(entity instanceof ServerPlayer)) {
				if (entity.getPersistentData().getDouble("BloodLevel") <= 0) {
					if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MonstrousWorldModMobEffects.VAMPIRISM))) {
						entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 200);
					}
				}
				if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
					if (entity.getPersistentData().getDouble("BloodLevel") >= 1) {
						if (entity.getPersistentData().getDouble("BloodLevel") < 12) {
							if (Math.random() > 0.999) {
								entity.getPersistentData().putDouble("BloodLevel", (entity.getPersistentData().getDouble("BloodLevel") + 1));
							}
						}
					}
				} else {
					if (entity.getPersistentData().getDouble("BloodLevel") >= 1) {
						if (entity.getPersistentData().getDouble("BloodLevel") < 12) {
							if (Math.random() > 0.999) {
								entity.getPersistentData().putDouble("BloodLevel", (entity.getPersistentData().getDouble("BloodLevel") + 1));
							}
						}
					}
				}
				if (entity.getPersistentData().getDouble("BloodLevel") == 1 || entity.getPersistentData().getDouble("BloodLevel") == 2) {
					if (entity.getPersistentData().getDouble("BloodLevel") < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 3));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 1));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 220, 0));
					}
				}
				if (entity.getPersistentData().getDouble("BloodLevel") == 3 || entity.getPersistentData().getDouble("BloodLevel") == 4) {
					if (entity.getPersistentData().getDouble("BloodLevel") < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 3));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 1));
					}
				}
				if (entity.getPersistentData().getDouble("BloodLevel") == 5 || entity.getPersistentData().getDouble("BloodLevel") == 6) {
					if (entity.getPersistentData().getDouble("BloodLevel") < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 2));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 1));
					}
				}
				if (entity.getPersistentData().getDouble("BloodLevel") == 7 || entity.getPersistentData().getDouble("BloodLevel") == 8) {
					if (entity.getPersistentData().getDouble("BloodLevel") < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 1));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 0));
					}
				}
				if (entity.getPersistentData().getDouble("BloodLevel") == 9 || entity.getPersistentData().getDouble("BloodLevel") == 10) {
					if (entity.getPersistentData().getDouble("BloodLevel") < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 0));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 0));
					}
				}
				if (entity instanceof Animal) {
					if (entity.getPersistentData().getDouble("BloodLevel") <= 0) {
						entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 200);
					}
				}
				if (entity.getPersistentData().getDouble("BloodLevel") == 12) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.BLOOD_RECOVERY);
				}
			}
		}
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 0) {
							entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 200);
						} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel < 12 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel >= 1) {
							if (Math.random() > 0.999) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Bloodlevel = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel + 1;
									_vars.markSyncDirty();
								}
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 9 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 10) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 0));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 0));
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 7 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 8) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 1));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 0));
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 5 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 6) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 2));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 1));
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 3 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 4) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 3));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 1));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 220, 0));
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 1 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 2) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 3));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 1));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 220, 0));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0));
						}
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.BLOOD_RECOVERY);
					}
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.BLOOD_RECOVERY);
				}
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.BLOOD_RECOVERY);
			}
		}
	}
}