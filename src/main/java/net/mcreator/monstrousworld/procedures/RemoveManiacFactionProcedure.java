package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class RemoveManiacFactionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		SetScoresToZeroProcedure.execute(world, entity);
		entity.getPersistentData().putBoolean("Monstrous World Maniac", false);
		entity.getPersistentData().putBoolean("can_kill_maniac", false);
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.Reputation_Static = false;
			_vars.markSyncDirty();
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:maniac_strength"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:maniac_resistance"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:maniac_strength_2"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ResourceLocation.parse("monstrous_world:maniac_strength_4"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:maniac_armor_4"));
		}
		if (entity instanceof LivingEntity _entity) {
			_entity.getAttribute(Attributes.ARMOR).removeModifier(ResourceLocation.parse("monstrous_world:maniac_armor_6"));
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.Reputation = 0;
			_vars.MonsterClass = 0;
			_vars.FactionLevel = 0;
			_vars.markSyncDirty();
		}
	}
}