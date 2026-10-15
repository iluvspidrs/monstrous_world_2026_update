package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
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
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

import java.util.Comparator;

public class HypnosisOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MonstrousWorldModMobEffects.MENTAL_FORTITUDE))) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AMULET_OF_STRONG_WILL.get()
						&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your amulet breaks you from hypnosis!"), false);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:no_thanks"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					entity.getPersistentData().putString("hypnosis", "none");
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.HYPNOSIS);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.WEAKNESS);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AMULET_OF_STRONG_WILL.get()
						&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 0) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your amulet breaks you from hypnosis!"), false);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:no_thanks"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					entity.getPersistentData().putString("hypnosis", "none");
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.HYPNOSIS);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.WEAKNESS);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
					if (world instanceof ServerLevel _level) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
						});
					}
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 8, true, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 8, true, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 8, true, false));
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if ((entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("hypnosis"))) {
								if (!(entityiterator instanceof ServerPlayer)) {
									if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.HYPNOSIS).getDuration() : 0) > 1) {
										entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY() + 2), (entityiterator.getZ())));
										entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY() + 1), (entity.getZ())));
										entity.getPersistentData().putString("AngryAt", "none");
										if (entity instanceof Mob) {
											try {
												((Mob) entity).setTarget(null);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
										entityiterator.getPersistentData().putString("AngryAt", "none");
										if (entityiterator instanceof Mob) {
											try {
												((Mob) entityiterator).setTarget(null);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									}
									if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.HYPNOSIS).getDuration() : 0) == 100) {
										if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel <= 0)) {
											{
												Entity _ent = entityiterator;
												double _tx = (entity.getX());
												double _ty = (entity.getY());
												double _tz = (entity.getZ());
												_ent.teleportTo(_tx, _ty, _tz);
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLOOD_RECOVERY, 24000, 0, true, false));
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
												if (Math.random() < (double) MonstrousWorldConfigConfiguration.VAMPIRE_INFECTION_CHANCE.get()) {
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT, 72000, 0, true, false));
												}
											}
											if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
												if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
													if (!(entity instanceof LivingEntity _livEnt54 && _livEnt54.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT))) {
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT, 24000, 0, true, false));
													}
												}
											}
										}
									}
									if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.HYPNOSIS).getDuration() : 0) == 80) {
										if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel <= 0)) {
											{
												Entity _ent = entityiterator;
												double _tx = (entity.getX());
												double _ty = (entity.getY());
												double _tz = (entity.getZ());
												_ent.teleportTo(_tx, _ty, _tz);
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.ASH, x, y, z, 5, 3, 3, 3, 1);
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Bloodlevel = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel - 1;
												_vars.markSyncDirty();
											}
											if (!(entity instanceof ServerPlayer)) {
												entity.getPersistentData().putDouble("BloodLevel", (entity.getPersistentData().getDouble("BloodLevel") - 1));
											}
										}
									}
									if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.HYPNOSIS).getDuration() : 0) == 60) {
										if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel < 0)) {
											{
												Entity _ent = entityiterator;
												double _tx = (entity.getX());
												double _ty = (entity.getY());
												double _tz = (entity.getZ());
												_ent.teleportTo(_tx, _ty, _tz);
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Bloodlevel = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel - 1;
												_vars.markSyncDirty();
											}
											if (!(entity instanceof ServerPlayer)) {
												entity.getPersistentData().putDouble("BloodLevel", (entity.getPersistentData().getDouble("BloodLevel") - 1));
											}
										}
									}
									if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.HYPNOSIS).getDuration() : 0) == 40) {
										if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel <= 0)) {
											{
												Entity _ent = entityiterator;
												double _tx = (entity.getX());
												double _ty = (entity.getY());
												double _tz = (entity.getZ());
												_ent.teleportTo(_tx, _ty, _tz);
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Bloodlevel = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel - 1;
												_vars.markSyncDirty();
											}
											if (!(entity instanceof ServerPlayer)) {
												entity.getPersistentData().putDouble("BloodLevel", (entity.getPersistentData().getDouble("BloodLevel") - 1));
											}
										}
									}
									if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.HYPNOSIS).getDuration() : 0) == 20) {
										if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel <= 0)) {
											{
												Entity _ent = entityiterator;
												double _tx = (entity.getX());
												double _ty = (entity.getY());
												double _tz = (entity.getZ());
												_ent.teleportTo(_tx, _ty, _tz);
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Bloodlevel = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel - 1;
												_vars.markSyncDirty();
											}
											if (!(entity instanceof ServerPlayer)) {
												entity.getPersistentData().putDouble("BloodLevel", (entity.getPersistentData().getDouble("BloodLevel") - 1));
											}
										}
									}
									if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.HYPNOSIS).getDuration() : 0) == 1) {
										if (Mth.nextInt(RandomSource.create(), 1, 6) == 1) {
											if (entityiterator instanceof Mob) {
												try {
													((Mob) entityiterator).setTarget(null);
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You slap your hand over the bite on your neck..."), true);
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0));
											entity.getPersistentData().putString("hypnosis", "none");
											entity.getPersistentData().putString("AngryAt", "none");
											if (entity instanceof Mob) {
												try {
													((Mob) entity).setTarget(null);
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
											entityiterator.getPersistentData().putString("AngryAt", "none");
											if (entityiterator instanceof Mob) {
												try {
													((Mob) entityiterator).setTarget(null);
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										} else {
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 21, 0));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}