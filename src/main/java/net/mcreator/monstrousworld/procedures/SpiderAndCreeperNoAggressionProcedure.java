package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Creeper;

@EventBusSubscriber(modid = "monstrous_world")
public class SpiderAndCreeperNoAggressionProcedure {

    @SubscribeEvent
    public static void onTargetChange(LivingChangeTargetEvent event) {

        LivingEntity mob = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

        // Only care when the new target is a player.
        if (!(newTarget instanceof Player player)) {
            return;
        }

        // Only affect creepers and spiders
        if (!(mob instanceof Creeper || mob instanceof Spider || mob instanceof CaveSpider)) {
            return;
        }

        var playerVariables =
                player.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);

        
        boolean creeperAndSpiderNeutralPlayer =
                playerVariables.MonsterType == 4;

        // Normal players can still be targeted normally.
        if (!creeperAndSpiderNeutralPlayer) {
            return;
        }

        /*
         * If this specific player attacked the undead mob,
         * allow the mob to retaliate.
         */
        if (mob.getLastHurtByMob() == player) {
            return;
        }

        // Otherwise prevent the undead mob from targeting the player.
        event.setCanceled(true);
    }
}