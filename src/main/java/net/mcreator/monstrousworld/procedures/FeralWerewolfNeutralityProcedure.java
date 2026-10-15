package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.entity.FeralWerewolfEntity;
import net.mcreator.monstrousworld.entity.FollowerWerewolfEntity;
import net.mcreator.monstrousworld.entity.HumanWerewolfEntity;
import net.mcreator.monstrousworld.entity.DireWerewolfEntity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class FeralWerewolfNeutralityProcedure {

    @SubscribeEvent
    public static void onTargetChange(LivingChangeTargetEvent event) {

        LivingEntity mob = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

        if (!(mob instanceof FeralWerewolfEntity)) {
            return;
        }

        if (newTarget == null) {
            return;
        }

        if (newTarget instanceof Player player) {

            var playerVariables = player.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);

            boolean neutralPlayer = playerVariables.MonsterClass == 7 || playerVariables.MonsterType == 5;

            if (neutralPlayer) {

                if (mob.getLastHurtByMob() == player) {
                    return;
                }

                event.setCanceled(true);
                return;
            }
        }


        boolean neutralWerewolf =
                newTarget instanceof FeralWerewolfEntity
                || newTarget instanceof FollowerWerewolfEntity
                || newTarget instanceof HumanWerewolfEntity
                || newTarget instanceof DireWerewolfEntity;

        if (!neutralWerewolf) {
            return;
        }


        if (mob.getLastHurtByMob() == newTarget) {
            return;
        }

        event.setCanceled(true);
    }
}