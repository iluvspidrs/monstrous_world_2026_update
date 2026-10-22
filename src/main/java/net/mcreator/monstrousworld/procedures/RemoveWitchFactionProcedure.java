package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class RemoveWitchFactionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
		}
		entity.getPersistentData().putBoolean("Monstrous World Witch", false);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.WITCH_EFFECT);
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
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WITCHERY_CHESTPLATE.get()) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("This item rejects you..."), true);
		}
	}
}