package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class WillOTheWispOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (Math.random() <= (double) MonstrousWorldConfigConfiguration.ENCHANTMENT_CHANCE.get()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.MENTAL_FORTITUDE))) {
							if (!entityiterator.isPassenger()) {
								if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))
										|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:nonhuman_being")))) {
									if (!(BuiltInRegistries.ENTITY_TYPE.getKey(entityiterator.getType()).toString()).contains("goblin")) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
											if (!(entityiterator instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MonstrousWorldModMobEffects.ENCHANTED))) {
												if (!(entityiterator instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MonstrousWorldModMobEffects.CRAZED))) {
												if (entity instanceof LivingEntity _entity ? _entity.hasLineOfSight(entityiterator) : false) {
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.ENCHANTED, 2400, 0));
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
																		BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()),
																		BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
													});
												}
												}
											}
										}
									}
								}
								if (entityiterator instanceof ServerPlayer) {
									if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 2) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 10) {
											if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
													if (!(entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true)) {
														if (!(entityiterator instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MonstrousWorldModMobEffects.ENCHANTED))) {
															if (!(entityiterator instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MonstrousWorldModMobEffects.CRAZED))) {
																if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AMULET_OF_CLEAR_MIND.get()) {
																if (entity instanceof LivingEntity _entity ? _entity.hasLineOfSight(entityiterator) : false) {
																	if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 0) {
																		if (world instanceof ServerLevel _level) {
																			(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
																			});
																		}
																		if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																			_player.displayClientMessage(Component.literal("Your amulet protects you from enchantment..."), false);
																		if (entityiterator instanceof ServerPlayer _player) {
																			AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:you_have_no_power"));
																			if (_adv != null) {
																				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																				if (!_ap.isDone()) {
																					for (String criteria : _ap.getRemainingCriteria())
																						_player.getAdvancements().award(_adv, criteria);
																				}
																			}
																		}
																		if (world instanceof Level _level) {
																			if (!_level.isClientSide()) {
																				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
																			} else {
																				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
																			}
																		}
																	}
																	} else {
																		if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
																			_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.ENCHANTED, 2400, 0));
																		entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY() + 1), (entity.getZ())));
																		if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																			_player.displayClientMessage(Component.literal("You are enchanted! You enter a dreamlike state..."), false);
																		if (world instanceof Level _level) {
																			if (!_level.isClientSide()) {
																				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL,
																						1, 1);
																			} else {
																				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
																			}
																		}
																	}
																} else if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AMULET_OF_CLEAR_MIND.get()) {
																	if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).No_Defense == 0) {
																		if (world instanceof ServerLevel _level) {
																			(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
																			});
																		}
																		if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																			_player.displayClientMessage(Component.literal("Your amulet protects you from enchantment..."), false);
																		if (entityiterator instanceof ServerPlayer _player) {
																			AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:you_have_no_power"));
																			if (_adv != null) {
																				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																				if (!_ap.isDone()) {
																					for (String criteria : _ap.getRemainingCriteria())
																						_player.getAdvancements().award(_adv, criteria);
																				}
																			}
																		}
																		if (world instanceof Level _level) {
																			if (!_level.isClientSide()) {
																				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
																			} else {
																				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
																			}
																		}
																	} else {
																		if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
																			_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.ENCHANTED, 2400, 0));
																		entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY() + 1), (entity.getZ())));
																		if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																			_player.displayClientMessage(Component.literal("You are enchanted! You enter a dreamlike state..."), false);
																		if (world instanceof Level _level) {
																			if (!_level.isClientSide()) {
																				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL,
																						1, 1);
																			} else {
																				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
																			}
																		}
																	}
																} else {
																	if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.ENCHANTED, 2400, 0));
																	entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY() + 1), (entity.getZ())));
																	if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																		_player.displayClientMessage(Component.literal("You are enchanted! You enter a dreamlike state..."), false);
																	if (world instanceof Level _level) {
																		if (!_level.isClientSide()) {
																			_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1,
																					1);
																		} else {
																			_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
																		}
																	}
																}
															}
														}
													} else {
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
															if (entityiterator instanceof ServerPlayer _player) {
																AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:no_time_for_that"));
																if (_adv != null) {
																	AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																	if (!_ap.isDone()) {
																		for (String criteria : _ap.getRemainingCriteria())
																			_player.getAdvancements().award(_adv, criteria);
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
						}
					}
				}
			}
		}
	}
}