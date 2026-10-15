package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class WerewolfEffectsProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world.dimensionType().moonPhase(world.dayTime()) == 0 && world.dayTime() % 24000 >= 13000) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
					if (!(entityiterator instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.LUNAR_PULL, 100, 0));
						if (entityiterator instanceof LivingEntity _entity)
							_entity.setHealth((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
					}
				}
			}
		}
	}
}