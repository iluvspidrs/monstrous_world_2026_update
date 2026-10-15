package net.mcreator.monstrousworld.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.minecraft.world.entity.Mob;

@EventBusSubscriber(modid = "monstrous_world")
public class AddMonsterVillagersSeekMarkerGoalProcedure {

    private static final TagKey<EntityType<?>> SEEKS_MARKER_TAG =
            TagKey.create(
                    Registries.ENTITY_TYPE,
                    ResourceLocation.parse("monstrous_world:seeks_marker")
            );

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {

        // AI should only be modified server-side.
        if (event.getLevel().isClientSide()) {
            return;
        }

        /*
         * The entity needs PathfinderMob AI in order
         * to use navigation goals.
         */
        if (!(event.getEntity() instanceof PathfinderMob mob)) {
            return;
        }

        /*
         * Only entities in:
         *
         * #monstrous_world:seeks_marker
         *
         * receive this goal.
         */
        if (!mob.getType().is(SEEKS_MARKER_TAG)) {
            return;
        }


        if (mob.getPersistentData().contains("Owner")) {
        	return;
        }

        /*
         * Priority 2.
         *
         * Your vampire shade-seeking goal is priority 1,
         * so escaping sunlight will still take precedence.
         */
        mob.goalSelector.addGoal(
                2,
                new MonsterVillagersSeekMarkerGoalProcedure(
                        mob,
                        1.0D
                )
        );
    }
}