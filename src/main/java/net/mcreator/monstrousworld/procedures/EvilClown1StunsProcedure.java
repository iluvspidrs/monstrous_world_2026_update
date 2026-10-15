package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.EvilClown1Entity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EvilClown1StunsProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (sourceentity instanceof EvilClown1Entity) {
				if (Math.random() > 0.8) {
					if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:monster_being")))) {
						if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:dark_faction")))) {
							if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION))) {
								if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MonstrousWorldModMobEffects.MENTAL_FORTITUDE))) {
									if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.CONFUSION))) {
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.fall")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.fall")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0));
										});
									}
									if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.CONFUSION)) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CURSED_CONFECTION, 2400, 0));
									}
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10
							&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 1
							&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 2 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 3) {
						if (!(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MonstrousWorldModMobEffects.MENTAL_FORTITUDE))) {
							if (!(entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION))) {
								if (!(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.CONFUSION))) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.fall")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.fall")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0));
									});
								}
								if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.CONFUSION)) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CURSED_CONFECTION, 2400, 0));
								}
							}
						}
					}
				}
			}
		}
	}
}