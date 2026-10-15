package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.Witch1Entity;
import net.mcreator.monstrousworld.entity.SorcererNPCEntity;
import net.mcreator.monstrousworld.entity.FeralVampireEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class FollowersReturnToCollectorProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
				if (world.dayTime() % 24000 == 23999) {
					if (getEntityScore("Assignments Out", entity) >= 1) {
						for (int _i1 = 0; _i1 < getEntityScore("Assignments Out", entity) * Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if (Math.random() < 0.1) {
							for (int _i1 = 0; _i1 < 3; _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_GOBLIN_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						} else if (Math.random() < 0.2) {
							for (int _i1 = 0; _i1 < 3; _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_TROLL_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						} else if (Math.random() < 0.4) {
							for (int _i1 = 0; _i1 < 3; _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_SERPENT_MUTANT_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						} else if (Math.random() < 0.5) {
							for (int _i1 = 0; _i1 < 3; _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_EYE_MUTANT_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						} else if (Math.random() < 0.6) {
							for (int _i1 = 0; _i1 < 3; _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_FLY_MUTANT_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						} else if (world.dimensionType().moonPhase(world.dayTime()) == 0) {
							for (int _i1 = 0; _i1 < 3; _i1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.BOTTLE_OF_WEREWOLF_BLOOD.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
						for (int _i1 = 0; _i1 < getEntityScore("Assignments Out", entity); _i1++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.BLOODLETTER.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 1) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.MAD_SCIENTIST_NPC.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 2) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 3) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.WITCH_1.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 4) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SORCERER_NPC.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 8) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.WANDERING_TRADER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 9) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 10) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_VAMPIRE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 11) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 12) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.VINDICATOR.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 13) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.EVOKER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 14) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ILLUSIONER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						if (getEntityScore("Assignment 1 Type", entity) == 15) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
						MonstrousWorldMod.queueServerWork(1, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
										entityiterator.getPersistentData().putBoolean("vampire", true);
										entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
										entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
										entityiterator.getPersistentData().putString("Reserve", "true");
										entityiterator.getPersistentData().putString("Assignment", "1");
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your follower returns with collected blood!"), true);
										entityiterator.getPersistentData().putDouble("vampireInfection", 1);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY, 24000, 0, true, false));
									}
									if (entityiterator instanceof FeralVampireEntity) {
										entityiterator.getPersistentData().putBoolean("vampire", true);
										entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
										entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
										entityiterator.getPersistentData().putString("Reserve", "true");
										entityiterator.getPersistentData().putString("Assignment", "1");
										entityiterator.getPersistentData().putBoolean("Follower", true);
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your follower returns with collected blood!"), true);
									}
									if ((entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
										entityiterator.getPersistentData().putDouble("vampireInfection", 1);
										if (getEntityScore("Vampire Skin 1", entity) == 1) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 1);
											if (entityiterator instanceof Witch1Entity _datEntSetI)
												_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 1);
											if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
												_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 1);
										}
										if (getEntityScore("Vampire Skin 1", entity) == 2) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 2);
											if (entityiterator instanceof Witch1Entity _datEntSetI)
												_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 2);
											if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
												_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 2);
										}
										if (getEntityScore("Vampire Skin 1", entity) == 3) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 3);
											if (entityiterator instanceof Witch1Entity _datEntSetI)
												_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 3);
											if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
												_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 3);
										}
										if (getEntityScore("Vampire Skin 1", entity) == 4) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 4);
											if (entityiterator instanceof Witch1Entity _datEntSetI)
												_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 4);
											if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
												_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 4);
										}
										if (getEntityScore("Vampire Skin 1", entity) == 5) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 5);
											if (entityiterator instanceof Witch1Entity _datEntSetI)
												_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 5);
											if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
												_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 5);
										}
										if (getEntityScore("Vampire Skin 1", entity) == 6) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 6);
											if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
												_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 6);
										}
										if (getEntityScore("Vampire Skin 1", entity) == 7) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 7);
											if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
												_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 7);
										}
										if (getEntityScore("Vampire Skin 1", entity) == 8) {
											if (entityiterator instanceof FeralVampireEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 8);
											if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
												_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 8);
										}
										if (getEntityScore("Vampire Skin 1", entity) == 9) {
											if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
												_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 9);
										}
									}
								}
							}
						});
						MonstrousWorldMod.queueServerWork(2, () -> {
							if (getEntityScore("Assignment 2 Type", entity) == 1) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.MAD_SCIENTIST_NPC.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 2) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.WITCH_1.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 4) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SORCERER_NPC.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 8) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.WANDERING_TRADER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 9) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 10) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.FERAL_VAMPIRE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 11) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 12) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.VINDICATOR.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 13) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.EVOKER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 14) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.ILLUSIONER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 2 Type", entity) == 15) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
						});
						MonstrousWorldMod.queueServerWork(3, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator != null) {
										if (entityiterator instanceof LivingEntity) {
											if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
												if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
													entityiterator.getPersistentData().putBoolean("vampire", true);
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
													if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY, 24000, 0, true, false));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Reserve", "true");
													entityiterator.getPersistentData().putString("Assignment", "2");
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your follower returns with collected blood!"), true);
													if ((entityiterator.getPersistentData().getString("Assignment")).equals("2")) {
														entityiterator.getPersistentData().putDouble("vampireInfection", 1);
														if (getEntityScore("Vampire Skin 2", entity) == 1) {
															if (entityiterator instanceof Witch1Entity _datEntSetI)
																_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 1);
															if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 1);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 2) {
															if (entityiterator instanceof Witch1Entity _datEntSetI)
																_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 2);
															if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 2);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 3) {
															if (entityiterator instanceof Witch1Entity _datEntSetI)
																_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 3);
															if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 3);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 4) {
															if (entityiterator instanceof Witch1Entity _datEntSetI)
																_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 4);
															if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 4);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 5) {
															if (entityiterator instanceof Witch1Entity _datEntSetI)
																_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 5);
															if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 5);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 6) {
															if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 6);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 7) {
															if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 7);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 8) {
															if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 8);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 9) {
															if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
																_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 9);
														}
													}
												}
											}
											if (entityiterator instanceof FeralVampireEntity) {
												if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
													entityiterator.getPersistentData().putBoolean("vampire", true);
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Reserve", "true");
													entityiterator.getPersistentData().putString("Assignment", "2");
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your follower returns with collected blood!"), true);
													if ((entityiterator.getPersistentData().getString("Assignment")).equals("2")) {
														if (getEntityScore("Vampire Skin 2", entity) == 1) {
															if (entityiterator instanceof FeralVampireEntity _datEntSetI)
																_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 1);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 2) {
															if (entityiterator instanceof FeralVampireEntity _datEntSetI)
																_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 2);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 3) {
															if (entityiterator instanceof FeralVampireEntity _datEntSetI)
																_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 3);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 4) {
															if (entityiterator instanceof FeralVampireEntity _datEntSetI)
																_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 4);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 5) {
															if (entityiterator instanceof FeralVampireEntity _datEntSetI)
																_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 5);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 6) {
															if (entityiterator instanceof FeralVampireEntity _datEntSetI)
																_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 6);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 7) {
															if (entityiterator instanceof FeralVampireEntity _datEntSetI)
																_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 7);
														}
														if (getEntityScore("Vampire Skin 2", entity) == 8) {
															if (entityiterator instanceof FeralVampireEntity _datEntSetI)
																_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 8);
														}
													}
												}
											}
										}
									}
								}
							}
						});
						MonstrousWorldMod.queueServerWork(4, () -> {
							if (getEntityScore("Assignment 3 Type", entity) == 1) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.MAD_SCIENTIST_NPC.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 2) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.WITCH_1.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 4) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.SORCERER_NPC.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 8) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.WANDERING_TRADER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 9) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 10) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.FERAL_VAMPIRE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 11) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 12) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.VINDICATOR.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 13) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.EVOKER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 14) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.ILLUSIONER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
							if (getEntityScore("Assignment 3 Type", entity) == 15) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
						});
						MonstrousWorldMod.queueServerWork(5, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator != null) {
										if (entityiterator instanceof LivingEntity) {
											if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
												if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
													if (!(entityiterator.getPersistentData().getString("Assignment")).equals("2")) {
														entityiterator.getPersistentData().putBoolean("vampire", true);
														entityiterator.getPersistentData().putDouble("vampireInfection", 1);
														entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
														if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY, 24000, 0, true, false));
														entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
														entityiterator.getPersistentData().putString("Reserve", "true");
														entityiterator.getPersistentData().putString("Assignment", "3");
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Your follower returns with collected blood!"), true);
													}
												}
											}
											if (entityiterator instanceof FeralVampireEntity) {
												if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
													if (!(entityiterator.getPersistentData().getString("Assignment")).equals("2")) {
														entityiterator.getPersistentData().putBoolean("vampire", true);
														entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
														entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
														entityiterator.getPersistentData().putString("Reserve", "true");
														entityiterator.getPersistentData().putString("Assignment", "3");
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Your follower returns with collected blood!"), true);
													}
												}
											}
											if ((entityiterator.getPersistentData().getString("Assignment")).equals("3")) {
												if (getEntityScore("Vampire Skin 3", entity) == 1) {
													if (entityiterator instanceof FeralVampireEntity _datEntSetI)
														_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 1);
													if (entityiterator instanceof Witch1Entity _datEntSetI)
														_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 1);
													if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
														_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 1);
												}
												if (getEntityScore("Vampire Skin 3", entity) == 2) {
													if (entityiterator instanceof FeralVampireEntity _datEntSetI)
														_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 2);
													if (entityiterator instanceof Witch1Entity _datEntSetI)
														_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 2);
													if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
														_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 2);
												}
												if (getEntityScore("Vampire Skin 3", entity) == 3) {
													if (entityiterator instanceof FeralVampireEntity _datEntSetI)
														_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 3);
													if (entityiterator instanceof Witch1Entity _datEntSetI)
														_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 3);
													if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
														_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 3);
												}
												if (getEntityScore("Vampire Skin 3", entity) == 4) {
													if (entityiterator instanceof FeralVampireEntity _datEntSetI)
														_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 4);
													if (entityiterator instanceof Witch1Entity _datEntSetI)
														_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 4);
													if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
														_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 4);
												}
												if (getEntityScore("Vampire Skin 3", entity) == 5) {
													if (entityiterator instanceof FeralVampireEntity _datEntSetI)
														_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 5);
													if (entityiterator instanceof Witch1Entity _datEntSetI)
														_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, 5);
													if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
														_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 5);
												}
												if (getEntityScore("Vampire Skin 3", entity) == 6) {
													if (entityiterator instanceof FeralVampireEntity _datEntSetI)
														_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 6);
													if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
														_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 6);
												}
												if (getEntityScore("Vampire Skin 3", entity) == 7) {
													if (entityiterator instanceof FeralVampireEntity _datEntSetI)
														_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 7);
													if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
														_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 7);
												}
												if (getEntityScore("Vampire Skin 3", entity) == 8) {
													if (entityiterator instanceof FeralVampireEntity _datEntSetI)
														_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, 8);
													if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
														_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 8);
												}
												if (getEntityScore("Vampire Skin 3", entity) == 9) {
													if (entityiterator instanceof SorcererNPCEntity _datEntSetI)
														_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, 9);
												}
											}
										}
									}
								}
							}
						});
					}
					MonstrousWorldMod.queueServerWork(7, () -> {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.AssistantsAreOut = false;
							_vars.markSyncDirty();
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Assignments Out");
							if (_so == null)
								_so = _sc.addObjective("Assignments Out", ObjectiveCriteria.DUMMY, Component.literal("Assignments Out"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Assignment 1 Type");
							if (_so == null)
								_so = _sc.addObjective("Assignment 1 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 1 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Assignment 2 Type");
							if (_so == null)
								_so = _sc.addObjective("Assignment 2 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 2 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Assignment 3 Type");
							if (_so == null)
								_so = _sc.addObjective("Assignment 3 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 3 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Vampire Skin 1");
							if (_so == null)
								_so = _sc.addObjective("Vampire Skin 1", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 1"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Vampire Skin 2");
							if (_so == null)
								_so = _sc.addObjective("Vampire Skin 2", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 2"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Vampire Skin 3");
							if (_so == null)
								_so = _sc.addObjective("Vampire Skin 3", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 3"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Vampire Type 3");
							if (_so == null)
								_so = _sc.addObjective("Vampire Type 3", ObjectiveCriteria.DUMMY, Component.literal("Vampire Type 3"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Vampire Type 2");
							if (_so == null)
								_so = _sc.addObjective("Vampire Type 2", ObjectiveCriteria.DUMMY, Component.literal("Vampire Type 2"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Vampire Type 1");
							if (_so == null)
								_so = _sc.addObjective("Vampire Type 1", ObjectiveCriteria.DUMMY, Component.literal("Vampire Type 1"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
					});
				}
			}
		}
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}