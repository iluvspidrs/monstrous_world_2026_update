package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.entity.VampireNPCEntity;

import net.minecraft.world.entity.PathfinderMob;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class AddVampiresSeekShadeGoalProcedure {

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {

        // Only modify AI on the server.
        if (event.getLevel().isClientSide()) {
            return;
        }

        // Shade-seeking requires normal pathfinding AI.
        if (!(event.getEntity() instanceof PathfinderMob mob)) {
            return;
        }

        boolean turnedVampire =
                mob.getPersistentData().getBoolean("vampire");

        boolean vampireNPC =
                mob instanceof VampireNPCEntity;

        // Ignore non-vampires.
        if (!turnedVampire && !vampireNPC) {
            return;
        }

        /*
         * Priority 1:
         *
         * This should outrank ordinary movement/attack movement goals,
         * so escaping sunlight takes precedence over hunting prey.
         */
        mob.goalSelector.addGoal(
                1,
                new VampiresSeekShadeGoalProcedure (
                        mob,
                        1.25D
                )
        );
    }
}