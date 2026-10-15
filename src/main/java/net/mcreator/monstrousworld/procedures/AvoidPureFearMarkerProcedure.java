package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;

import net.mcreator.monstrousworld.entity.PureFearMarkerEntity;

import java.util.function.Predicate;

public class AvoidPureFearMarkerProcedure {

    public static final Predicate<LivingEntity> AVOID_ENTITY_CONDITION = entity -> {
        return entity instanceof PureFearMarkerEntity;
    };
}