package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class SetScoresToZeroProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
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
				Objective _so = _sc.getObjective("Faction Points");
				if (_so == null)
					_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("BrewSuccess");
				if (_so == null)
					_so = _sc.addObjective("BrewSuccess", ObjectiveCriteria.DUMMY, Component.literal("BrewSuccess"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("BrewedObstruction");
				if (_so == null)
					_so = _sc.addObjective("BrewedObstruction", ObjectiveCriteria.DUMMY, Component.literal("BrewedObstruction"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("BrewedFrogify");
				if (_so == null)
					_so = _sc.addObjective("BrewedFrogify", ObjectiveCriteria.DUMMY, Component.literal("BrewedFrogify"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("BrewedSpirits");
				if (_so == null)
					_so = _sc.addObjective("BrewedSpirits", ObjectiveCriteria.DUMMY, Component.literal("BrewedSpirits"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("BrewedSinking");
				if (_so == null)
					_so = _sc.addObjective("BrewedSinking", ObjectiveCriteria.DUMMY, Component.literal("BrewedSinking"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("BrewedParalysis");
				if (_so == null)
					_so = _sc.addObjective("BrewedParalysis", ObjectiveCriteria.DUMMY, Component.literal("BrewedParalysis"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("BrewedWerewolfCure");
				if (_so == null)
					_so = _sc.addObjective("BrewedWerewolfCure", ObjectiveCriteria.DUMMY, Component.literal("BrewedWerewolfCure"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("BrewedVampireCure");
				if (_so == null)
					_so = _sc.addObjective("BrewedVampireCure", ObjectiveCriteria.DUMMY, Component.literal("BrewedVampireCure"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("BrewedUndeathCure");
				if (_so == null)
					_so = _sc.addObjective("BrewedUndeathCure", ObjectiveCriteria.DUMMY, Component.literal("BrewedUndeathCure"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Obstruction Powders Used");
				if (_so == null)
					_so = _sc.addObjective("Obstruction Powders Used", ObjectiveCriteria.DUMMY, Component.literal("Obstruction Powders Used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Frogify Powders Used");
				if (_so == null)
					_so = _sc.addObjective("Frogify Powders Used", ObjectiveCriteria.DUMMY, Component.literal("Frogify Powders Used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Sinking Powders Used");
				if (_so == null)
					_so = _sc.addObjective("Sinking Powders Used", ObjectiveCriteria.DUMMY, Component.literal("Sinking Powders Used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Paralyze Powders Used");
				if (_so == null)
					_so = _sc.addObjective("Paralyze Powders Used", ObjectiveCriteria.DUMMY, Component.literal("Paralyze Powders Used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Werewolf Cure Powders Used");
				if (_so == null)
					_so = _sc.addObjective("Werewolf Cure Powders Used", ObjectiveCriteria.DUMMY, Component.literal("Werewolf Cure Powders Used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Spirit Trap Powders Used");
				if (_so == null)
					_so = _sc.addObjective("Spirit Trap Powders Used", ObjectiveCriteria.DUMMY, Component.literal("Spirit Trap Powders Used"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Wealth Tome Created");
				if (_so == null)
					_so = _sc.addObjective("Wealth Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Wealth Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Binding Tome Created");
				if (_so == null)
					_so = _sc.addObjective("Binding Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Binding Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Rest Tome Created");
				if (_so == null)
					_so = _sc.addObjective("Rest Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Rest Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("True Death Tome Created");
				if (_so == null)
					_so = _sc.addObjective("True Death Tome Created", ObjectiveCriteria.DUMMY, Component.literal("True Death Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Exorcism Tome Created");
				if (_so == null)
					_so = _sc.addObjective("Exorcism Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Exorcism Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Shield Tome Created");
				if (_so == null)
					_so = _sc.addObjective("Shield Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Shield Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Speed Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Speed Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Speed Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Projectile Protection Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Projectile Protection Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Projectile Protection Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Nocturnal Guard Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Nocturnal Guard Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Nocturnal Guard Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Strength Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Strength Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Strength Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Luck Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Luck Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Luck Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Water Breathing Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Water Breathing Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Water Breathing Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Fire Resistance Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Fire Resistance Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Fire Resistance Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Cleansing Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Cleansing Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Cleansing Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Thorns Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Thorns Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Thorns Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Healing Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Healing Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Healing Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Possession Immunity Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Possession Immunity Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Possession Immunity Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Dark Charm Created");
				if (_so == null)
					_so = _sc.addObjective("Dark Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Dark Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Has Familiar");
				if (_so == null)
					_so = _sc.addObjective("Has Familiar", ObjectiveCriteria.DUMMY, Component.literal("Has Familiar"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Can Fly");
				if (_so == null)
					_so = _sc.addObjective("Can Fly", ObjectiveCriteria.DUMMY, Component.literal("Can Fly"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Laptops Crafted");
				if (_so == null)
					_so = _sc.addObjective("Laptops Crafted", ObjectiveCriteria.DUMMY, Component.literal("Laptops Crafted"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Fly Thumbs Created");
				if (_so == null)
					_so = _sc.addObjective("Fly Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Fly Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Serpent Thumbs Created");
				if (_so == null)
					_so = _sc.addObjective("Serpent Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Serpent Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Dreadful Watcher Thumbs Created");
				if (_so == null)
					_so = _sc.addObjective("Dreadful Watcher Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Dreadful Watcher Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Illager Thumbs Created");
				if (_so == null)
					_so = _sc.addObjective("Illager Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Illager Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Spider Thumbs Created");
				if (_so == null)
					_so = _sc.addObjective("Spider Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Spider Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("CreateFly");
				if (_so == null)
					_so = _sc.addObjective("CreateFly", ObjectiveCriteria.DUMMY, Component.literal("CreateFly"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("CreateSerpent");
				if (_so == null)
					_so = _sc.addObjective("CreateSerpent", ObjectiveCriteria.DUMMY, Component.literal("CreateSerpent"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("CreateEye");
				if (_so == null)
					_so = _sc.addObjective("CreateEye", ObjectiveCriteria.DUMMY, Component.literal("CreateEye"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Frogify");
				if (_so == null)
					_so = _sc.addObjective("Frogify", ObjectiveCriteria.DUMMY, Component.literal("Frogify"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Vanishing");
				if (_so == null)
					_so = _sc.addObjective("Vanishing", ObjectiveCriteria.DUMMY, Component.literal("Vanishing"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Paralysis");
				if (_so == null)
					_so = _sc.addObjective("Paralysis", ObjectiveCriteria.DUMMY, Component.literal("Paralysis"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Sinking");
				if (_so == null)
					_so = _sc.addObjective("Sinking", ObjectiveCriteria.DUMMY, Component.literal("Sinking"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("MidasCurse");
				if (_so == null)
					_so = _sc.addObjective("MidasCurse", ObjectiveCriteria.DUMMY, Component.literal("MidasCurse"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Chickenify");
				if (_so == null)
					_so = _sc.addObjective("Chickenify", ObjectiveCriteria.DUMMY, Component.literal("Chickenify"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Food Tolerance");
				if (_so == null)
					_so = _sc.addObjective("Food Tolerance", ObjectiveCriteria.DUMMY, Component.literal("Food Tolerance"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Night Vision");
				if (_so == null)
					_so = _sc.addObjective("Night Vision", ObjectiveCriteria.DUMMY, Component.literal("Night Vision"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Amulet Placed");
				if (_so == null)
					_so = _sc.addObjective("Amulet Placed", ObjectiveCriteria.DUMMY, Component.literal("Amulet Placed"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Amulet of Following Created");
				if (_so == null)
					_so = _sc.addObjective("Amulet of Following Created", ObjectiveCriteria.DUMMY, Component.literal("Amulet of Following Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
				Objective _so = _sc.getObjective("Vampire Type 3");
				if (_so == null)
					_so = _sc.addObjective("Vampire Type 3", ObjectiveCriteria.DUMMY, Component.literal("Vampire Type 3"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("Has Follower");
				if (_so == null)
					_so = _sc.addObjective("Has Follower", ObjectiveCriteria.DUMMY, Component.literal("Has Follower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("vampire_strike");
				if (_so == null)
					_so = _sc.addObjective("vampire_strike", ObjectiveCriteria.DUMMY, Component.literal("vampire_strike"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("vampire_lunar");
				if (_so == null)
					_so = _sc.addObjective("vampire_lunar", ObjectiveCriteria.DUMMY, Component.literal("vampire_lunar"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("vampire_water");
				if (_so == null)
					_so = _sc.addObjective("vampire_water", ObjectiveCriteria.DUMMY, Component.literal("vampire_water"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("vampire_slow");
				if (_so == null)
					_so = _sc.addObjective("vampire_slow", ObjectiveCriteria.DUMMY, Component.literal("vampire_slow"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("vampire_levitate");
				if (_so == null)
					_so = _sc.addObjective("vampire_levitate", ObjectiveCriteria.DUMMY, Component.literal("vampire_levitate"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("ordinary_blood");
				if (_so == null)
					_so = _sc.addObjective("ordinary_blood", ObjectiveCriteria.DUMMY, Component.literal("ordinary_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("goblin_blood");
				if (_so == null)
					_so = _sc.addObjective("goblin_blood", ObjectiveCriteria.DUMMY, Component.literal("goblin_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("troll_blood");
				if (_so == null)
					_so = _sc.addObjective("troll_blood", ObjectiveCriteria.DUMMY, Component.literal("troll_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("swampmonster_blood");
				if (_so == null)
					_so = _sc.addObjective("swampmonster_blood", ObjectiveCriteria.DUMMY, Component.literal("swampmonster_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("werewolf_blood");
				if (_so == null)
					_so = _sc.addObjective("werewolf_blood", ObjectiveCriteria.DUMMY, Component.literal("werewolf_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("eye_blood");
				if (_so == null)
					_so = _sc.addObjective("eye_blood", ObjectiveCriteria.DUMMY, Component.literal("eye_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("serpent_blood");
				if (_so == null)
					_so = _sc.addObjective("serpent_blood", ObjectiveCriteria.DUMMY, Component.literal("serpent_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("fly_blood");
				if (_so == null)
					_so = _sc.addObjective("fly_blood", ObjectiveCriteria.DUMMY, Component.literal("fly_blood"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("bat_unlocked");
				if (_so == null)
					_so = _sc.addObjective("bat_unlocked", ObjectiveCriteria.DUMMY, Component.literal("bat_unlocked"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
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
				Objective _so = _sc.getObjective("Kills");
				if (_so == null)
					_so = _sc.addObjective("Kills", ObjectiveCriteria.DUMMY, Component.literal("Kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
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
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("feral_werewolf_kills");
				if (_so == null)
					_so = _sc.addObjective("feral_werewolf_kills", ObjectiveCriteria.DUMMY, Component.literal("feral_werewolf_kills"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("pack_members");
				if (_so == null)
					_so = _sc.addObjective("pack_members", ObjectiveCriteria.DUMMY, Component.literal("pack_members"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("werewolf_ability");
				if (_so == null)
					_so = _sc.addObjective("werewolf_ability", ObjectiveCriteria.DUMMY, Component.literal("werewolf_ability"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("society_infected");
				if (_so == null)
					_so = _sc.addObjective("society_infected", ObjectiveCriteria.DUMMY, Component.literal("society_infected"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("blaze_powder_ritual");
				if (_so == null)
					_so = _sc.addObjective("blaze_powder_ritual", ObjectiveCriteria.DUMMY, Component.literal("blaze_powder_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("healing_ritual");
				if (_so == null)
					_so = _sc.addObjective("healing_ritual", ObjectiveCriteria.DUMMY, Component.literal("healing_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("luck_ritual");
				if (_so == null)
					_so = _sc.addObjective("luck_ritual", ObjectiveCriteria.DUMMY, Component.literal("luck_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("exorcism_ritual");
				if (_so == null)
					_so = _sc.addObjective("exorcism_ritual", ObjectiveCriteria.DUMMY, Component.literal("exorcism_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("moon_dust_ritual");
				if (_so == null)
					_so = _sc.addObjective("moon_dust_ritual", ObjectiveCriteria.DUMMY, Component.literal("moon_dust_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("resistance_ritual");
				if (_so == null)
					_so = _sc.addObjective("resistance_ritual", ObjectiveCriteria.DUMMY, Component.literal("resistance_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("lycan_cure_ritual");
				if (_so == null)
					_so = _sc.addObjective("lycan_cure_ritual", ObjectiveCriteria.DUMMY, Component.literal("lycan_cure_ritual"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("created_witchery_tome");
				if (_so == null)
					_so = _sc.addObjective("created_witchery_tome", ObjectiveCriteria.DUMMY, Component.literal("created_witchery_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("created_goblin_tome");
				if (_so == null)
					_so = _sc.addObjective("created_goblin_tome", ObjectiveCriteria.DUMMY, Component.literal("created_goblin_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("created_troll_tome");
				if (_so == null)
					_so = _sc.addObjective("created_troll_tome", ObjectiveCriteria.DUMMY, Component.literal("created_troll_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("created_sorcery_tome");
				if (_so == null)
					_so = _sc.addObjective("created_sorcery_tome", ObjectiveCriteria.DUMMY, Component.literal("created_sorcery_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("created_mad_scientist_tome");
				if (_so == null)
					_so = _sc.addObjective("created_mad_scientist_tome", ObjectiveCriteria.DUMMY, Component.literal("created_mad_scientist_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("created_swamp_tome");
				if (_so == null)
					_so = _sc.addObjective("created_swamp_tome", ObjectiveCriteria.DUMMY, Component.literal("created_swamp_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("created_werewolf_tome");
				if (_so == null)
					_so = _sc.addObjective("created_werewolf_tome", ObjectiveCriteria.DUMMY, Component.literal("created_werewolf_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("created_vampire_tome");
				if (_so == null)
					_so = _sc.addObjective("created_vampire_tome", ObjectiveCriteria.DUMMY, Component.literal("created_vampire_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("created_darkness_tome");
				if (_so == null)
					_so = _sc.addObjective("created_darkness_tome", ObjectiveCriteria.DUMMY, Component.literal("created_darkness_tome"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("master_wand_created");
				if (_so == null)
					_so = _sc.addObjective("master_wand_created", ObjectiveCriteria.DUMMY, Component.literal("master_wand_created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("cotton_candy_human");
				if (_so == null)
					_so = _sc.addObjective("cotton_candy_human", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_human"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("cotton_candy_villager");
				if (_so == null)
					_so = _sc.addObjective("cotton_candy_villager", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_villager"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("cotton_candy_illager");
				if (_so == null)
					_so = _sc.addObjective("cotton_candy_illager", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_illager"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("cotton_candy_goblin");
				if (_so == null)
					_so = _sc.addObjective("cotton_candy_goblin", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_goblin"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("cotton_candy_troll");
				if (_so == null)
					_so = _sc.addObjective("cotton_candy_troll", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_troll"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("cotton_candy_swampmonster");
				if (_so == null)
					_so = _sc.addObjective("cotton_candy_swampmonster", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_swampmonster"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("cotton_candy_vampire");
				if (_so == null)
					_so = _sc.addObjective("cotton_candy_vampire", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_vampire"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("cotton_candy_werewolf");
				if (_so == null)
					_so = _sc.addObjective("cotton_candy_werewolf", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_werewolf"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("cotton_candy_magical");
				if (_so == null)
					_so = _sc.addObjective("cotton_candy_magical", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_magical"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("crafted_nether_altar");
				if (_so == null)
					_so = _sc.addObjective("crafted_nether_altar", ObjectiveCriteria.DUMMY, Component.literal("crafted_nether_altar"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("witch_contract");
				if (_so == null)
					_so = _sc.addObjective("witch_contract", ObjectiveCriteria.DUMMY, Component.literal("witch_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("goblin_contract");
				if (_so == null)
					_so = _sc.addObjective("goblin_contract", ObjectiveCriteria.DUMMY, Component.literal("goblin_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("troll_contract");
				if (_so == null)
					_so = _sc.addObjective("troll_contract", ObjectiveCriteria.DUMMY, Component.literal("troll_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("sorcerer_contract");
				if (_so == null)
					_so = _sc.addObjective("sorcerer_contract", ObjectiveCriteria.DUMMY, Component.literal("sorcerer_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("mad_scientist_contract");
				if (_so == null)
					_so = _sc.addObjective("mad_scientist_contract", ObjectiveCriteria.DUMMY, Component.literal("mad_scientist_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("swampmonster_contract");
				if (_so == null)
					_so = _sc.addObjective("swampmonster_contract", ObjectiveCriteria.DUMMY, Component.literal("swampmonster_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("werewolf_contract");
				if (_so == null)
					_so = _sc.addObjective("werewolf_contract", ObjectiveCriteria.DUMMY, Component.literal("werewolf_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("vampire_contract");
				if (_so == null)
					_so = _sc.addObjective("vampire_contract", ObjectiveCriteria.DUMMY, Component.literal("vampire_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("villager_contract");
				if (_so == null)
					_so = _sc.addObjective("villager_contract", ObjectiveCriteria.DUMMY, Component.literal("villager_contract"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("has_fly_sample");
				if (_so == null)
					_so = _sc.addObjective("has_fly_sample", ObjectiveCriteria.DUMMY, Component.literal("has_fly_sample"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("has_serpent_sample");
				if (_so == null)
					_so = _sc.addObjective("has_serpent_sample", ObjectiveCriteria.DUMMY, Component.literal("has_serpent_sample"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("has_eye_sample");
				if (_so == null)
					_so = _sc.addObjective("has_eye_sample", ObjectiveCriteria.DUMMY, Component.literal("has_eye_sample"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("has_spider_sample");
				if (_so == null)
					_so = _sc.addObjective("has_spider_sample", ObjectiveCriteria.DUMMY, Component.literal("has_spider_sample"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("has_illager_sample");
				if (_so == null)
					_so = _sc.addObjective("has_illager_sample", ObjectiveCriteria.DUMMY, Component.literal("has_illager_sample"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("werewolf_ability");
				if (_so == null)
					_so = _sc.addObjective("werewolf_ability", ObjectiveCriteria.DUMMY, Component.literal("werewolf_ability"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("vengeful_pumpkins");
				if (_so == null)
					_so = _sc.addObjective("vengeful_pumpkins", ObjectiveCriteria.DUMMY, Component.literal("vengeful_pumpkins"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("vengeful_pumpkin");
				if (_so == null)
					_so = _sc.addObjective("vengeful_pumpkin", ObjectiveCriteria.DUMMY, Component.literal("vengeful_pumpkin"), ObjectiveCriteria.RenderType.INTEGER, true, null);
				_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
			}
		}
	}
}