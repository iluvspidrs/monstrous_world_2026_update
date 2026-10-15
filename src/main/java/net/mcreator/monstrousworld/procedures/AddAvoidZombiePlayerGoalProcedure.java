package net.mcreator.monstrousworld.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class AddAvoidZombiePlayerGoalProcedure {

    private static final TagKey<EntityType<?>> AVOIDS_ZOMBIES_TAG =
            TagKey.create(
                    Registries.ENTITY_TYPE,
                    ResourceLocation.parse("monstrous_world:avoids_zombies")
            );

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {

        if (event.getLevel().isClientSide()) {
            return;
        }

        if (!(event.getEntity() instanceof PathfinderMob mob)) {
            return;
        }

        if (!mob.getType().is(AVOIDS_ZOMBIES_TAG)) {
            return;
        }

        mob.goalSelector.addGoal(
                2,
                new AvoidEntityGoal<Player>(
                        mob,
                        Player.class,
                        AvoidZombiePlayerGoalProcedure.AVOID_PLAYER_CONDITION,
                        12.0F,
                        1.0D,
                        1.0D,
                        player -> true
                )
        );

        System.out.println(
                "[Monstrous_World] Added Avoid Zombie Player avoidance goal to "
                        + mob.getType()
        );
    }
}