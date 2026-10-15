package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class CursedCandyPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10
					&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 1
					&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 2 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 3) {
				if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MonstrousWorldModMobEffects.CURSED_CONFECTION))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.CURSED_CONFECTION, 300, 0, false, false));
				}
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0, false, false));
			}
		}
	}
}