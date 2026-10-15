package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class WebbedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEBBED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEBBED).getAmplifier() : 0) == 0) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.WebbedLevel = 1;
					_vars.markSyncDirty();
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEBBED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEBBED).getAmplifier() : 0) >= 1) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.WebbedLevel = 2;
					_vars.markSyncDirty();
				}
			}
		}
	}
}