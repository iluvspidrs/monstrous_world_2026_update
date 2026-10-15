package net.mcreator.monstrousworld.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class AddAvoidPureFearMarkerProcedure {

    private static final TagKey<EntityType<?>> TRUE_EVIL_NO_FEAR_TAG =
            TagKey.create(
                    Registries.ENTITY_TYPE,
                    ResourceLocation.parse("monstrous_world:true_evil")
            );

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {

        // Only modify AI on the server.
        if (event.getLevel().isClientSide()) {
            return;
        }

        // Only normal pathfinding mobs can use AvoidEntityGoal.
        if (!(event.getEntity() instanceof PathfinderMob mob)) {
            return;
        }

        // True Evil entities are immune to Pure Fear.
        if (mob.getType().is(TRUE_EVIL_NO_FEAR_TAG)) {
            return;
        }

        mob.goalSelector.addGoal(
                1,
                new AvoidEntityGoal<LivingEntity>(
                        mob,
                        LivingEntity.class,
                        AvoidPureFearMarkerProcedure.AVOID_ENTITY_CONDITION,
                        12.0F,
                        1.0D,
                        1.3D,
                        entity -> true
                )
        );
    }
}