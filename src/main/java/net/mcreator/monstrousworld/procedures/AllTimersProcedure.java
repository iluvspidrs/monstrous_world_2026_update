package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AllTimersProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getPersistentData().getDouble("gui_open") >= 1) {
				entity.getPersistentData().putDouble("gui_open", (entity.getPersistentData().getDouble("gui_open") - 1));
			}
			if (entity.getPersistentData().getDouble("KeybindCooldown") >= 1) {
				entity.getPersistentData().putDouble("KeybindCooldown", (entity.getPersistentData().getDouble("KeybindCooldown") - 1));
			}
			if (entity.getPersistentData().getDouble("ChilledTimer") >= 1) {
				entity.getPersistentData().putDouble("ChilledTimer", (entity.getPersistentData().getDouble("ChilledTimer") - 1));
			}
			if (entity.getPersistentData().getDouble("WarmTimer") >= 1) {
				entity.getPersistentData().putDouble("WarmTimer", (entity.getPersistentData().getDouble("WarmTimer") - 1));
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Cooldown >= 1) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.Cooldown = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Cooldown - 1;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel == 0) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 200);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel <= 5) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer >= 1) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Dark_Message_Timer = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer - 1;
						_vars.markSyncDirty();
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.Dark_Message_Timer = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer - 1;
					_vars.markSyncDirty();
				}
			}
			if (entity.getPersistentData().getDouble("HypnosisCooldown") >= 1) {
				entity.getPersistentData().putDouble("HypnosisCooldown", (entity.getPersistentData().getDouble("HypnosisCooldown") - 1));
			}
			if (entity.getPersistentData().getDouble("ChainsawTimer") >= 1) {
				entity.getPersistentData().putDouble("ChainsawTimer", (entity.getPersistentData().getDouble("HypnosisCooldown") - 1));
			}
			if (entity.getPersistentData().getDouble("Cooldown_Spell") >= 1) {
				entity.getPersistentData().putDouble("Cooldown_Spell", (entity.getPersistentData().getDouble("Cooldown_Spell") - 1));
			}
			if (entity.getPersistentData().getDouble("Cooldown") >= 1) {
				entity.getPersistentData().putDouble("Cooldown", (entity.getPersistentData().getDouble("Cooldown") - 1));
			}
			if (entity.getPersistentData().getDouble("biteCooldown") >= 1) {
				entity.getPersistentData().putDouble("biteCooldown", (entity.getPersistentData().getDouble("biteCooldown") - 1));
			}
			if (entity.getPersistentData().getDouble("Nightmare") >= 1) {
				entity.getPersistentData().putDouble("Nightmare", (entity.getPersistentData().getDouble("Nightmare") - 1));
			}
			if (entity.getPersistentData().getDouble("biteCooldown") == 0) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.VictimBloodLevel = 0;
					_vars.markSyncDirty();
				}
			}
			if ((entity.getDirection()) == Direction.NORTH) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.PlayerFace = 1;
					_vars.markSyncDirty();
				}
			} else if ((entity.getDirection()) == Direction.WEST) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.PlayerFace = 2;
					_vars.markSyncDirty();
				}
			} else if ((entity.getDirection()) == Direction.SOUTH) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.PlayerFace = 3;
					_vars.markSyncDirty();
				}
			} else {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.PlayerFace = 4;
					_vars.markSyncDirty();
				}
			}
			if (getEntityScore("ObstructionThrower", entity) >= 1) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("ObstructionThrower");
					if (_so == null)
						_so = _sc.addObjective("ObstructionThrower", ObjectiveCriteria.DUMMY, Component.literal("ObstructionThrower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("ObstructionThrower", entity) - 1);
				}
			}
			if (getEntityScore("FrogifyThrower", entity) >= 1) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("FrogifyThrower");
					if (_so == null)
						_so = _sc.addObjective("FrogifyThrower", ObjectiveCriteria.DUMMY, Component.literal("FrogifyThrower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("FrogifyThrower", entity) - 1);
				}
			}
			if (getEntityScore("SinkingThrower", entity) >= 1) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("SinkingThrower");
					if (_so == null)
						_so = _sc.addObjective("SinkingThrower", ObjectiveCriteria.DUMMY, Component.literal("SinkingThrower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("SinkingThrower", entity) - 1);
				}
			}
			if (getEntityScore("SpiritTrapThrower", entity) >= 1) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("SpiritTrapThrower");
					if (_so == null)
						_so = _sc.addObjective("SpiritTrapThrower", ObjectiveCriteria.DUMMY, Component.literal("SpiritTrapThrower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("SpiritTrapThrower", entity) - 1);
				}
			}
			if (getEntityScore("ParalysisThrower", entity) >= 1) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("ParalysisThrower");
					if (_so == null)
						_so = _sc.addObjective("ParalysisThrower", ObjectiveCriteria.DUMMY, Component.literal("ParalysisThrower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("ParalysisThrower", entity) - 1);
				}
			}
			if (getEntityScore("WerewolfCureThrower", entity) >= 1) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("WerewolfCureThrower");
					if (_so == null)
						_so = _sc.addObjective("WerewolfCureThrower", ObjectiveCriteria.DUMMY, Component.literal("WerewolfCureThrower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("WerewolfCureThrower", entity) - 1);
				}
			}
			if (getEntityScore("VampireCureThrower", entity) >= 1) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("VampireCureThrower");
					if (_so == null)
						_so = _sc.addObjective("VampireCureThrower", ObjectiveCriteria.DUMMY, Component.literal("VampireCureThrower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("VampireCureThrower", entity) - 1);
				}
			}
			if (getEntityScore("UndeathCureThrower", entity) >= 1) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("UndeathCureThrower");
					if (_so == null)
						_so = _sc.addObjective("UndeathCureThrower", ObjectiveCriteria.DUMMY, Component.literal("UndeathCureThrower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("UndeathCureThrower", entity) - 1);
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