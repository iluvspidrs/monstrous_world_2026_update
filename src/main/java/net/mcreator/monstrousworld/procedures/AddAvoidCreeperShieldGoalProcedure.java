package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.monster.Creeper;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class AddAvoidCreeperShieldGoalProcedure {

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {

        // Server side only check
        if (event.getLevel().isClientSide()) {
            return;
        }

        // Ignore everything that isn't a creeper
        if (!(event.getEntity() instanceof Creeper creeper)) {
            return;
        }

        creeper.goalSelector.addGoal(
                2,
                new AvoidEntityGoal<LivingEntity>(
                        creeper,
                        LivingEntity.class,
                        AvoidCreeperShieldProcedure.AVOID_ENTITY_CONDITION,
                        8.0F,
                        1.0D,
                        1.0D,
                        entity -> true
                )
        );
    }
}