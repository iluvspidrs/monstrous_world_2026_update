package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class UndeadNoAggressionProcedure {

    @SubscribeEvent
    public static void onTargetChange(LivingChangeTargetEvent event) {

        LivingEntity mob = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

        // Only care when the new target is a player.
        if (!(newTarget instanceof Player player)) {
            return;
        }

        // Only affect undead mobs.
        if (!mob.getType().is(EntityTypeTags.UNDEAD)) {
            return;
        }

        var playerVariables =
                player.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);

        /*
         * Undead are neutral toward players who meet ANY
         * of these conditions:
         *
         * MonsterType == 4
         * MonsterType == 6
         * MonsterClass == 8
         */
        boolean undeadNeutralPlayer =
                playerVariables.MonsterType == 4
                || playerVariables.MonsterType == 6
                || playerVariables.MonsterClass == 8;

        // Normal players can still be targeted normally.
        if (!undeadNeutralPlayer) {
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