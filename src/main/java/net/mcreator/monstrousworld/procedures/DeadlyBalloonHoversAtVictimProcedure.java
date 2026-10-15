package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.DeadlyBalloonEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class DeadlyBalloonHoversAtVictimProcedure {
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
			if (sourceentity instanceof DeadlyBalloonEntity) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
						sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 20);
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MonstrousWorldModItems.STRANGE_RESIDUE.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3 && entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10
										&& entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4 && entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 1
										&& entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 2 && entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 3) {
									entityiterator.getPersistentData().putDouble("AttackType", (Mth.nextInt(RandomSource.create(), 1, 2)));
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entityiterator.getPersistentData().getDouble("AttackType") == 1) {
											if (entityiterator instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Sugary acid covers you and burns!"), false);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.burn")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CURSED_CONFECTION, 200, 0));
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 240, 0));
										}
										if (entityiterator.getPersistentData().getDouble("AttackType") == 2) {
											if (entityiterator instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("Popcorn sticks to you!"), false);
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.INFESTED, 2400, 2400));
										}
									});
								}
							}
						}
					} else {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
					}
				} else {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				}
			}
		}
	}
}