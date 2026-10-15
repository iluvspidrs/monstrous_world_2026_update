package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import java.util.function.Predicate;

public class AvoidZombiePlayerGoalProcedure {

    public static final Predicate<LivingEntity> AVOID_PLAYER_CONDITION = entity -> {

        if (entity instanceof Player player) {
            return player.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4;
        }

        return false;
    };
}