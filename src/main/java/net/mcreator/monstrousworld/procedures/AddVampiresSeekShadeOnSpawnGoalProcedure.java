package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.entity.VampireNPCEntity;
import net.mcreator.monstrousworld.entity.FeralVampireEntity;

import net.minecraft.world.entity.PathfinderMob;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class AddVampiresSeekShadeOnSpawnGoalProcedure {

    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {

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
                mob instanceof VampireNPCEntity || mob instanceof FeralVampireEntity;

        // Ignore non-vampires.
        if (!turnedVampire && !vampireNPC) {
            return;
        }

        
        mob.goalSelector.addGoal(
                1,
                new VampiresSeekShadeGoalProcedure (
                        mob,
                        1.25D
                )
        );
    }
}