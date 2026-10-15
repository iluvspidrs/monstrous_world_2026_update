package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class SocietyGoonNeutralityProcedure {

    @SubscribeEvent
    public static void onTargetChange(LivingChangeTargetEvent event) {

        LivingEntity mob = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

      
        if (!(mob instanceof SocietyGoonEntity)) {
            return;
        }

        if (newTarget == null) {
            return;
        }


        if (newTarget instanceof Player player) {

            var playerVariables =
                    player.getData(
                            MonstrousWorldModVariables.PLAYER_VARIABLES
                    );

            boolean neutralPlayer =
                    playerVariables.MonsterClass == 0
                    && playerVariables.MonsterType == 0;

            if (neutralPlayer) {

                if (mob.getLastHurtByMob() == player) {
                    return;
                }

                event.setCanceled(true);
                return;
            }
        }

        boolean neutralMob =
                newTarget instanceof SocietyGoonEntity
                || newTarget instanceof AggressiveGuardEntity
                || newTarget instanceof Pillager
                || newTarget instanceof HunterNPCEntity
                || newTarget instanceof Villager
                || newTarget instanceof HunterPatrolNPCEntity;

        if (!neutralMob) {
            return;
        }

       
        if (mob.getLastHurtByMob() == newTarget) {
            return;
        }


        event.setCanceled(true);
    }
}