package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.StrongDarkChargeProjectileEntity;
import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.entity.InfectedGoonEntity;
import net.mcreator.monstrousworld.entity.DarkChargeProjectileEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class DarkChargeProjectileProjectileHitsLivingEntityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
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
			if (sourceentity instanceof DarkChargeProjectileEntity || sourceentity instanceof StrongDarkChargeProjectileEntity) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
					if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:darkness_immune")))) {
						if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
							if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS))) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS, 24000, 0, false, false));
								if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
													_vars.markSyncDirty();
												}
												if (entityiterator instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
												MonstrousWorldMod.queueServerWork(1, () -> {
													if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Reputation = -100;
															_vars.markSyncDirty();
														}
													}
												});
											}
										}
									}
								}
								if (entity instanceof SocietyGoonEntity || entity instanceof AggressiveGuardEntity) {
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
												if (entityiterator instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:spreading_the_fun"));
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
				if (entity instanceof Player || entity instanceof ServerPlayer) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).DarknessInfectable == true) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.DarknessTimer = Mth.nextInt(RandomSource.create(), 72000, 96000);
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You feel a strange darkness within you..."), false);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.RECENT_INFECTION, 200, 0, false, false));
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.DarknessInfectable = false;
							_vars.markSyncDirty();
						}
						if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.EvilFaction = Mth.nextInt(RandomSource.create(), 1, 2);
								_vars.markSyncDirty();
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
										_vars.markSyncDirty();
									}
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = -100;
												_vars.markSyncDirty();
											}
										}
									});
								}
							}
						}
					}
				}
				if (entity instanceof SocietyGoonEntity || entity instanceof AggressiveGuardEntity) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = MonstrousWorldModEntities.INFECTED_GOON.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(entity.getYRot());
							entityToSpawn.setYBodyRot(entity.getYRot());
							entityToSpawn.setYHeadRot(entity.getYRot());
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
									{
										Entity _ent = entityiterator;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("society_infected");
										if (_so == null)
											_so = _sc.addObjective("society_infected", ObjectiveCriteria.DUMMY, Component.literal("society_infected"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("society_infected", entityiterator) + 1);
									}
									if (getEntityScore("society_infected", entityiterator) >= 5) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.FactionLevel = 3;
											_vars.markSyncDirty();
										}
										{
											Entity _ent = entityiterator;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("society_infected");
											if (_so == null)
												_so = _sc.addObjective("society_infected", ObjectiveCriteria.DUMMY, Component.literal("society_infected"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entityiterator instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A75You grow closer to me and give me hope..."), false);
									}
								}
							}
						}
					}
					MonstrousWorldMod.queueServerWork(1, () -> {
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof InfectedGoonEntity) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS, 24000, 0));
								}
							}
						}
					});
					if (!entity.level().isClientSide())
						entity.discard();
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