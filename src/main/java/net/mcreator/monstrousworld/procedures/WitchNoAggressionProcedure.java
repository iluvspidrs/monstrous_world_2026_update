package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class WitchNoAggressionProcedure {

    @SubscribeEvent
    public static void onTargetChange(LivingChangeTargetEvent event) {

        LivingEntity mob = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

        // Only affect witches.
        if (!(mob instanceof Witch)) {
            return;
        }

        // Only care when the witch is attempting to target a player.
        if (!(newTarget instanceof Player player)) {
            return;
        }

        var playerVariables =
                player.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);

        // Witches are neutral toward MonsterClass 1 players.
        if (playerVariables.MonsterClass != 1) {
            return;
        }

        /*
         * If this specific player attacked the witch,
         * allow the witch to retaliate normally.
         */
        if (mob.getLastHurtByMob() == player) {
            return;
        }

        // Otherwise prevent the witch from targeting this player.
        event.setCanceled(true);
    }
}