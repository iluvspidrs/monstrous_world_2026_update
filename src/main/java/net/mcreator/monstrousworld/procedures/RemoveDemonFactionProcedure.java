package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class RemoveDemonFactionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		SetScoresToZeroProcedure.execute(world, entity);
		entity.getPersistentData().putBoolean("Monstrous World Demon", false);
		entity.getPersistentData().putBoolean("can_kill_maniac", false);
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.Disguised = false;
			_vars.DarknessInfectable = true;
			_vars.MonsterInfectable = true;
			_vars.Reputation_Static = false;
			_vars.markSyncDirty();
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.FIRE_RESISTANCE);
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:demon_armor"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(ResourceLocation.parse("monstrous_world:demon_safe_fall"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.GRAVITY).removeModifier(ResourceLocation.parse("monstrous_world:demon_gravity"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(NeoForgeMod.SWIM_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:demon_swim_speed"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.BURNING_TIME).removeModifier(ResourceLocation.parse("monstrous_world:demon_no_burn"));
		}
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.Reputation = 0;
			_vars.MonsterClass = 0;
			_vars.FactionLevel = 0;
			_vars.markSyncDirty();
		}
		entity.getPersistentData().putDouble("ChilledTimer", 0);
	}
}