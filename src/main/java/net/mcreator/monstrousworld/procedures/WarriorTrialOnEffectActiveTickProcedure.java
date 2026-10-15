package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;

public class WarriorTrialOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WARRIOR_TRIAL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WARRIOR_TRIAL).getDuration() : 0) == 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Challenge failed"), true);
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("Kills");
					if (_so == null)
						_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
				}
			}
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (Mth.nextInt(RandomSource.create(), 1, 35) == 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
						if (Math.random() < 0.05) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.1) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_ZOMBIE.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.15) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.VENGEFUL_PUMPKIN.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.25) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_VAMPIRE.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.3) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_WEREWOLF.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.35) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_HUSK.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.45) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.BOGGED.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.55) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ENDERMAN.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.6) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.EVOKER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.65) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.7) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.75) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.STRAY.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.8) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ZOMBIE_VILLAGER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.85) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.EVIL_LEVITATING_SPIRIT.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.9) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.95) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_DROWNED.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.HUSK.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 5)), z + 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
						if (Math.random() < 0.05) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.1) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_ZOMBIE.get().spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.15) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.VENGEFUL_PUMPKIN.get().spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.25) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_VAMPIRE.get().spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.3) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_WEREWOLF.get().spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.35) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_HUSK.get().spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.45) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.BOGGED.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.55) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ENDERMAN.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.6) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.EVOKER.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.65) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.7) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.75) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.STRAY.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.8) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ZOMBIE_VILLAGER.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.85) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.EVIL_LEVITATING_SPIRIT.get().spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.9) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.95) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_DROWNED.get().spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.HUSK.spawn(_level, BlockPos.containing(x + 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
						if (Math.random() < 0.05) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.1) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_ZOMBIE.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.15) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.VENGEFUL_PUMPKIN.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.25) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_VAMPIRE.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.3) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_WEREWOLF.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.35) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_HUSK.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.45) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.BOGGED.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.55) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ENDERMAN.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.6) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.EVOKER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.65) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.7) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.75) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.STRAY.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.8) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ZOMBIE_VILLAGER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.85) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.EVIL_LEVITATING_SPIRIT.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.9) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.95) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_DROWNED.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.HUSK.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 5)), z - 5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
						if (Math.random() < 0.05) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.1) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_ZOMBIE.get().spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.15) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.VENGEFUL_PUMPKIN.get().spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.25) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_VAMPIRE.get().spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.3) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.FERAL_WEREWOLF.get().spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.35) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_HUSK.get().spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.45) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.BOGGED.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.55) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ENDERMAN.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.6) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.EVOKER.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.65) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.WITCH.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.7) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.75) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.STRAY.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.8) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ZOMBIE_VILLAGER.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.85) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.EVIL_LEVITATING_SPIRIT.get().spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.9) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else if (Math.random() < 0.95) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.ENHANCED_DROWNED.get().spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.HUSK.spawn(_level, BlockPos.containing(x - 5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 5), (int) z), z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
				}
			}
		}
	}
}