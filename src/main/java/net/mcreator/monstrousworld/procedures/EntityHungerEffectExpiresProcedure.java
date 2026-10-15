package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class EntityHungerEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession == 3) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer < -18000) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.ENTITY_HUNGER, 24000, 0, true, false));
			}
		}
	}
}