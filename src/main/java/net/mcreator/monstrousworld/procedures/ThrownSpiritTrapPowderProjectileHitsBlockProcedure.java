package net.mcreator.monstrousworld.procedures;

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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.EvilLevitatingSpiritEntity;
import net.mcreator.monstrousworld.entity.EvilDarknessSpiritEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class ThrownSpiritTrapPowderProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = MonstrousWorldModEntities.EVIL_DARKNESS_SPIRIT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
			for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = MonstrousWorldModEntities.EVIL_LEVITATING_SPIRIT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(80 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
								if (getEntityScore("SpiritTrapThrower", entityiterator) >= 1) {
									if (getEntityScore("BrewedSpirit", entityiterator) == 1) {
										if (getEntityScore("Spirit Trap Powders Used", entityiterator) == 0) {
											{
												Entity _ent = entityiterator;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("Spirit Trap Powders Used");
												if (_so == null)
													_so = _sc.addObjective("Spirit Trap Powders Used", ObjectiveCriteria.DUMMY, Component.literal("Spirit Trap Powders Used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Spirit Trap Powders Used", entityiterator) + 1);
											}
											{
												Entity _ent = entityiterator;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("Faction Points");
												if (_so == null)
													_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entityiterator) + 1);
											}
											MonstrousWorldMod.queueServerWork(1, () -> {
												if (getEntityScore("Faction Points", entityiterator) >= 3) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 2;
														_vars.markSyncDirty();
													}
													if (entityiterator instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You advance a level!"), true);
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
														}
													}
													{
														Entity _ent = entityiterator;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
													}
												}
											});
										}
									}
								}
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof EvilDarknessSpiritEntity || entityiterator instanceof EvilLevitatingSpiritEntity) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.SINKING, 2400, 0));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2400, 7));
					}
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