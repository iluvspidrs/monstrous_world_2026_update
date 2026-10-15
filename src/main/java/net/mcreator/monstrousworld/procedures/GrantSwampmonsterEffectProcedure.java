package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GrantSwampmonsterEffectProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
			if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MonstrousWorldModMobEffects.SWAMPMONSTER_EFFECT))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.SWAMPMONSTER_EFFECT, 24000, 0, true, false));
			}
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MonstrousWorldModMobEffects.DESSICATION);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MonstrousWorldModMobEffects.SWAMPMONSTER_EFFECT);
		}
	}
}