package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class RemoveGoblinFactionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("Monstrous World Goblin", false);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.GOBLIN_EFFECT);
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:goblinspeed"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.SNEAKING_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:goblinsneak"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.SNEAKING_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:goblinsneak4"));
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("nether_gems_mined");
			if (_so == null)
				_so = _sc.addObjective("nether_gems_mined", ObjectiveCriteria.DUMMY, Component.literal("nether_gems_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("moonstone_mined");
			if (_so == null)
				_so = _sc.addObjective("moonstone_mined", ObjectiveCriteria.DUMMY, Component.literal("moonstone_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("tigers_eye_mined");
			if (_so == null)
				_so = _sc.addObjective("tigers_eye_mined", ObjectiveCriteria.DUMMY, Component.literal("tigers_eye_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("green_agate_mined");
			if (_so == null)
				_so = _sc.addObjective("green_agate_mined", ObjectiveCriteria.DUMMY, Component.literal("green_agate_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("blue_agate_mined");
			if (_so == null)
				_so = _sc.addObjective("blue_agate_mined", ObjectiveCriteria.DUMMY, Component.literal("blue_agate_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("pale_agate_mined");
			if (_so == null)
				_so = _sc.addObjective("pale_agate_mined", ObjectiveCriteria.DUMMY, Component.literal("pale_agate_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("red_agate_mined");
			if (_so == null)
				_so = _sc.addObjective("red_agate_mined", ObjectiveCriteria.DUMMY, Component.literal("red_agate_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("black_onyx_mined");
			if (_so == null)
				_so = _sc.addObjective("black_onyx_mined", ObjectiveCriteria.DUMMY, Component.literal("black_onyx_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("red_onyx_mined");
			if (_so == null)
				_so = _sc.addObjective("red_onyx_mined", ObjectiveCriteria.DUMMY, Component.literal("red_onyx_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("clear_quartz_mined");
			if (_so == null)
				_so = _sc.addObjective("clear_quartz_mined", ObjectiveCriteria.DUMMY, Component.literal("clear_quartz_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("rose_quartz_mined");
			if (_so == null)
				_so = _sc.addObjective("rose_quartz_mined", ObjectiveCriteria.DUMMY, Component.literal("rose_quartz_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("swamp_crystal_mined");
			if (_so == null)
				_so = _sc.addObjective("swamp_crystal_mined", ObjectiveCriteria.DUMMY, Component.literal("swamp_crystal_mined"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("create_goblin_follower");
			if (_so == null)
				_so = _sc.addObjective("create_goblin_follower", ObjectiveCriteria.DUMMY, Component.literal("create_goblin_follower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("kidnap_number");
			if (_so == null)
				_so = _sc.addObjective("kidnap_number", ObjectiveCriteria.DUMMY, Component.literal("kidnap_number"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
	}
}