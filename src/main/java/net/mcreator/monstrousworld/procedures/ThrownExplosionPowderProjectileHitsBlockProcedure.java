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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class ThrownExplosionPowderProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 8, Level.ExplosionInteraction.TNT);
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
					if (getEntityScore("Explosion Powders Used", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Explosion Powders Used");
							if (_so == null)
								_so = _sc.addObjective("Explosion Powders Used", ObjectiveCriteria.DUMMY, Component.literal("Explosion Powders Used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Explosion Powders Used", entity) + 1);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("Faction Points");
							if (_so == null)
								_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
						}
					}
				}
			}
			if (entity instanceof LivingEntity) {
				if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:witches")))) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:improves_reputation")))) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 10;
										_vars.markSyncDirty();
									}
									if (entityiterator instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your reputation improves!"), true);
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = -100;
												_vars.markSyncDirty();
											}
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = 100;
												_vars.markSyncDirty();
											}
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (entityiterator instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
										}
									});
								}
								if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
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
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = 100;
												_vars.markSyncDirty();
											}
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (entityiterator instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
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

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}