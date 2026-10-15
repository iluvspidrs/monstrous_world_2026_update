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
public class DireWerewolfNeutralityProcedure {

    @SubscribeEvent
    public static void onTargetChange(LivingChangeTargetEvent event) {

        LivingEntity mob = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

        /*
         * Only control targeting behavior
         * for the Feral Werewolf.
         */
        if (!(mob instanceof DireWerewolfEntity)) {
            return;
        }

        if (newTarget == null) {
            return;
        }

        /*
         * -------------------------------------------------
         * PLAYER NEUTRALITY
         * -------------------------------------------------
         *
         * Feral Werewolves are neutral to players if:
         *
         * MonsterType == 5
         */
        if (newTarget instanceof Player player) {

            var playerVariables =
                    player.getData(
                            MonstrousWorldModVariables.PLAYER_VARIABLES
                    );

            boolean neutralPlayer =
                    playerVariables.MonsterType == 5;

            if (neutralPlayer) {

                /*
                 * Allow retaliation if this player
                 * attacked this Feral Werewolf first.
                 */
                if (mob.getLastHurtByMob() == player) {
                    return;
                }

                event.setCanceled(true);
                return;
            }
        }

        /*
         * -------------------------------------------------
         * WEREWOLF NEUTRALITY
         * -------------------------------------------------
         *
         * Feral Werewolves are neutral toward:
         *
         * - other Feral Werewolves
         * - Follower Werewolves
         * - Human Werewolves
         * - Dire Werewolves
         */
        boolean neutralWerewolf =
                newTarget instanceof FeralWerewolfEntity
                || newTarget instanceof DireWerewolfEntity;

        if (!neutralWerewolf) {
            return;
        }

        /*
         * Allow retaliation if this specific
         * werewolf attacked the Feral Werewolf first.
         */
        if (mob.getLastHurtByMob() == newTarget) {
            return;
        }

        /*
         * Prevent normal targeting.
         */
        event.setCanceled(true);
    }
}