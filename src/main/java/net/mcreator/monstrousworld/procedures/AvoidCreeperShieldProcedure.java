package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import java.util.function.Predicate;

public class AvoidCreeperShieldProcedure {

    public static final Predicate<LivingEntity> AVOID_ENTITY_CONDITION = entity -> {
        return entity.hasEffect(MonstrousWorldModMobEffects.CREEPER_SHIELD);
    };
}