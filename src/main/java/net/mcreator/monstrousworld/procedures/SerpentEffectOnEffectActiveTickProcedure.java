package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class SerpentEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
			if (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f < 0.1) {
				if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PORTABLE_HEAT_LAMP.get())) {
					if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PORTABLE_HEAT_LAMP.get())) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.COLD_BLOODED, 220, 0));
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MonstrousWorldModMobEffects.COLD_BLOODED);
					}
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MonstrousWorldModMobEffects.COLD_BLOODED);
				}
			}
		}
	}
}