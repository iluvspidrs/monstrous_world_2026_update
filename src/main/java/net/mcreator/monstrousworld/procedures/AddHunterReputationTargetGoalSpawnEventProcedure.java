package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;

import net.minecraft.world.entity.PathfinderMob;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class AddHunterReputationTargetGoalSpawnEventProcedure {

    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {

        // AI changes should only happen server-side.
        if (event.getLevel().isClientSide()) {
            return;
        }

        if (!(event.getEntity() instanceof PathfinderMob hunter)) {
            return;
        }

        /*
         * Only Hunter NPC and Hunter Patrol NPC
         * receive this targeting goal.
         */
        boolean isHunter =
                hunter instanceof HunterNPCEntity
                || hunter instanceof HunterPatrolNPCEntity;

        if (!isHunter) {
            return;
        }

        /*
         * Reputation-based player targeting.
         *
         * Priority 2 leaves priority 1 available for
         * retaliation or other critical targeting behaviors.
         */
        hunter.targetSelector.addGoal(
                2,
                new HunterReputationTargetGoalProcedure(hunter)
        );
    }
}