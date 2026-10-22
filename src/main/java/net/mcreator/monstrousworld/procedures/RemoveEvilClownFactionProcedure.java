package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class RemoveEvilClownFactionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		SetScoresToZeroProcedure.execute(world, entity);
		entity.getPersistentData().putBoolean("Monstrous World Evil Clown", false);
		entity.getPersistentData().putBoolean("can_kill_maniac", false);
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.BeastForm = false;
			_vars.Balloon = false;
			_vars.Reputation_Static = false;
			_vars.markSyncDirty();
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