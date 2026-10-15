package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.entity.FeralSwampmonsterEntity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.FeralSwampmonsterEntity;
import net.mcreator.monstrousworld.entity.SwampmonsterVillagerEntity;
import net.mcreator.monstrousworld.entity.DeathbloomEntityEntity;
import net.mcreator.monstrousworld.entity.SwampmonsterChieftanEntity;
import net.mcreator.monstrousworld.entity.MurkanusWormEntity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class FeralSwampmonsterNeutralityProcedure {

    @SubscribeEvent
    public static void onTargetChange(LivingChangeTargetEvent event) {

        LivingEntity mob = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

     
        if (!(mob instanceof FeralSwampmonsterEntity)) {
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
                    playerVariables.MonsterClass == 6;

            if (neutralPlayer) {

               
                if (mob.getLastHurtByMob() == player) {
                    return;
                }

                event.setCanceled(true);
                return;
            }
        }

        boolean neutralSwampmonster = newTarget instanceof SwampmonsterVillagerEntity || newTarget instanceof SwampmonsterChieftanEntity || newTarget instanceof MurkanusWormEntity || newTarget instanceof FeralSwampmonsterEntity || newTarget instanceof DeathbloomEntityEntity;

        if (!neutralSwampmonster) {
        	return;
        }

        if (mob.getLastHurtByMob() == newTarget) {
            return;
        }

        event.setCanceled(true);
        
        
    }
}