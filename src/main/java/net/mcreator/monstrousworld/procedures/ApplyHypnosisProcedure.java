package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
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
import net.mcreator.monstrousworld.entity.VampireNPCEntity;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.entity.FeralVampireEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ApplyHypnosisProcedure {
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
			if (sourceentity.getPersistentData().getBoolean("vampire") == true || sourceentity instanceof FeralVampireEntity || sourceentity instanceof VampireNPCEntity) {
				if (entity instanceof ServerPlayer) {
					if (Math.random() < 0.8) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).VampireInfection == 0) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 10) {
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
													if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MonstrousWorldModMobEffects.MENTAL_FORTITUDE))) {
														if (Math.random() < entity.getPersistentData().getDouble("Infectability")) {
															if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS))) {
																if (sourceentity.getPersistentData().getDouble("Hypnosis Boost") == 1) {
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 220, 0));
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 0));
																	if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 7));
																	if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 240, 3));
																	if (sourceentity instanceof Mob) {
																		try {
																			((Mob) sourceentity).setTarget(null);
																		} catch (Exception e) {
																			e.printStackTrace();
																		}
																	}
																	if (entity instanceof Player _player && !_player.level().isClientSide())
																		_player.displayClientMessage(Component.literal("You fall under hypnosis..."), true);
																	sourceentity.getPersistentData().putString("AngryAt", "none");
																	entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
																	if (world instanceof Level _level) {
																		if (!_level.isClientSide()) {
																			_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
																		} else {
																			_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
																		}
																	}
																} else if (sourceentity.getPersistentData().getDouble("Hypnosis Boost") == 2) {
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 240, 0));
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 240, 0));
																	if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 240, 7));
																	if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 280, 3));
																	if (sourceentity instanceof Mob) {
																		try {
																			((Mob) sourceentity).setTarget(null);
																		} catch (Exception e) {
																			e.printStackTrace();
																		}
																	}
																	if (entity instanceof Player _player && !_player.level().isClientSide())
																		_player.displayClientMessage(Component.literal("You fall under hypnosis..."), true);
																	sourceentity.getPersistentData().putString("AngryAt", "none");
																	entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
																	if (world instanceof Level _level) {
																		if (!_level.isClientSide()) {
																			_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
																		} else {
																			_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
																		}
																	}
																} else if (sourceentity.getPersistentData().getDouble("Hypnosis Boost") == 3) {
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 260, 0));
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 260, 0));
																	if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 260, 7));
																	if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 3));
																	if (sourceentity instanceof Mob) {
																		try {
																			((Mob) sourceentity).setTarget(null);
																		} catch (Exception e) {
																			e.printStackTrace();
																		}
																	}
																	if (entity instanceof Player _player && !_player.level().isClientSide())
																		_player.displayClientMessage(Component.literal("You fall under hypnosis..."), true);
																	sourceentity.getPersistentData().putString("AngryAt", "none");
																	entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
																	if (world instanceof Level _level) {
																		if (!_level.isClientSide()) {
																			_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
																		} else {
																			_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
																		}
																	}
																} else {
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 180, 0));
																	if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																		_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 180, 7));
																	entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
																	sourceentity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
																	if (sourceentity instanceof Mob) {
																		try {
																			((Mob) sourceentity).setTarget(null);
																		} catch (Exception e) {
																			e.printStackTrace();
																		}
																	}
																	if (entity instanceof Player _player && !_player.level().isClientSide())
																		_player.displayClientMessage(Component.literal("You fall under hypnosis..."), true);
																	sourceentity.getPersistentData().putString("AngryAt", "none");
																	entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
																	if (world instanceof Level _level) {
																		if (!_level.isClientSide()) {
																			_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
																		} else {
																			_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
																		}
																	}
																}
															}
														}
													}
												} else {
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
														if (entity instanceof ServerPlayer _player) {
															AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:vicious_rivalry"));
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
				} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
					if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
						if (!(sourceentity.getPersistentData().getString("AngryAt")).equals(entity.getDisplayName().getString())) {
							if (!(entity instanceof LivingEntity _livEnt56 && _livEnt56.isSleeping())) {
								if (!(entity instanceof LivingEntity _livEnt57 && _livEnt57.hasEffect(MonstrousWorldModMobEffects.MENTAL_FORTITUDE))) {
									if (!(entity instanceof LivingEntity _livEnt58 && _livEnt58.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS))) {
										if (entity.getPersistentData().getDouble("vampireInfection") == 0) {
											if (entity instanceof HunterNPCEntity || entity instanceof HunterPatrolNPCEntity) {
												if (Math.random() < 0.1) {
													if (sourceentity.getPersistentData().getDouble("Hypnosis Boost") == 1) {
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 220, 0));
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 0));
														if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 240, 3));
														if (sourceentity instanceof Mob) {
															try {
																((Mob) sourceentity).setTarget(null);
															} catch (Exception e) {
																e.printStackTrace();
															}
														}
														sourceentity.getPersistentData().putString("AngryAt", "none");
														entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
													} else if (sourceentity.getPersistentData().getDouble("Hypnosis Boost") == 2) {
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 240, 0));
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 240, 0));
														if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 280, 3));
														if (sourceentity instanceof Mob) {
															try {
																((Mob) sourceentity).setTarget(null);
															} catch (Exception e) {
																e.printStackTrace();
															}
														}
														sourceentity.getPersistentData().putString("AngryAt", "none");
														entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
													} else if (sourceentity.getPersistentData().getDouble("Hypnosis Boost") == 3) {
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 260, 0));
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 260, 0));
														if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 3));
														if (sourceentity instanceof Mob) {
															try {
																((Mob) sourceentity).setTarget(null);
															} catch (Exception e) {
																e.printStackTrace();
															}
														}
														sourceentity.getPersistentData().putString("AngryAt", "none");
														entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
													} else {
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 180, 0));
														if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 180, 7));
														if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 3));
														entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
														sourceentity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
														if (sourceentity instanceof Mob) {
															try {
																((Mob) sourceentity).setTarget(null);
															} catch (Exception e) {
																e.printStackTrace();
															}
														}
														sourceentity.getPersistentData().putString("AngryAt", "none");
														entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
															}
														}
													}
												}
											} else {
												if (sourceentity.getPersistentData().getDouble("Hypnosis Boost") == 1) {
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 220, 0));
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 0));
													if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 240, 3));
													if (sourceentity instanceof Mob) {
														try {
															((Mob) sourceentity).setTarget(null);
														} catch (Exception e) {
															e.printStackTrace();
														}
													}
													sourceentity.getPersistentData().putString("AngryAt", "none");
													entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												} else if (sourceentity.getPersistentData().getDouble("Hypnosis Boost") == 2) {
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 240, 0));
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 240, 0));
													if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 280, 3));
													if (sourceentity instanceof Mob) {
														try {
															((Mob) sourceentity).setTarget(null);
														} catch (Exception e) {
															e.printStackTrace();
														}
													}
													sourceentity.getPersistentData().putString("AngryAt", "none");
													entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												} else if (sourceentity.getPersistentData().getDouble("Hypnosis Boost") == 3) {
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 260, 0));
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 260, 0));
													if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 3));
													if (sourceentity instanceof Mob) {
														try {
															((Mob) sourceentity).setTarget(null);
														} catch (Exception e) {
															e.printStackTrace();
														}
													}
													sourceentity.getPersistentData().putString("AngryAt", "none");
													entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												} else {
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.HYPNOSIS, 180, 0));
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 180, 7));
													if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 3));
													entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
													sourceentity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
													if (sourceentity instanceof Mob) {
														try {
															((Mob) sourceentity).setTarget(null);
														} catch (Exception e) {
															e.printStackTrace();
														}
													}
													sourceentity.getPersistentData().putString("AngryAt", "none");
													entity.getPersistentData().putString("hypnosis", (sourceentity.getStringUUID()));
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							entity.getPersistentData().putString("hypnosis", "none");
						}
					}
				}
			}
		}
	}
}