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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class RemoveVampireFactionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		SetScoresToZeroProcedure.execute(world, entity);
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.Bloodlevel = 12;
			_vars.BloodBar = -1;
			_vars.MonsterType = 0;
			_vars.Reputation = 0;
			_vars.markSyncDirty();
		}
		MonstrousWorldModVariables.MapVariables.get(world).TeamResetTimer = 5;
		MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
		entity.getPersistentData().putBoolean("can_kill_maniac", false);
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.MonsterInfectable = true;
			_vars.BeastForm = false;
			_vars.markSyncDirty();
		}
		entity.getPersistentData().putBoolean("Monstrous World Vampire", false);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.VAMPIRISM);
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackspeed"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.OXYGEN_BONUS).removeModifier(ResourceLocation.parse("monstrous_world:vampireoxygenbonus"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampiremovementspeed"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ATTACK_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:vampire_amulet_attack"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor3"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:vampirearmor5"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength3"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength5"));
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
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VAMPIRE_CLOAK_HELMET.get()) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("This item rejects you..."), true);
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
				}
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VAMPIRE_CLOAK_CHESTPLATE.get()) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("This item rejects you..."), true);
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
				}
			}
		}
	}
}