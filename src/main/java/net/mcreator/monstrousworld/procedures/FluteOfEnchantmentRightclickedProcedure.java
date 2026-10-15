package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class FluteOfEnchantmentRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.flute")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.flute")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.NOTE, x, y, z, 5, 1, 1, 1, 0.1);
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) || entityiterator.getPersistentData().getDouble("Confused") >= 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CRAZED, 1200, 0));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 5));
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.ENCHANTED);
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:deadly_trickery"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
										_vars.markSyncDirty();
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = -100;
												_vars.markSyncDirty();
											}
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
										}
									});
								}
								if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:hostile")))) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
										_vars.markSyncDirty();
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your reputation improves..."), true);
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = 100;
												_vars.markSyncDirty();
											}
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
										}
									});
								}
							}
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You are not yet skilled enough to use this"), true);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You can't seem to use this instrument..."), true);
			}
		}
	}
}