package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class HunterMobAttackGoalOnSpawnProcedure {

    private static final TagKey<EntityType<?>> ATTACKED_BY_HUNTER_TAG =
            TagKey.create(
                    Registries.ENTITY_TYPE,
                    ResourceLocation.parse("monstrous_world:attacked_by_hunter")
            );

    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {

        // Server Side Check
        if (event.getLevel().isClientSide()) {
            return;
        }

		// Don't use non-pathfinding entities, defines the entity here as hunter

        if (!(event.getEntity() instanceof PathfinderMob hunter)) {
            return;
        }

		//only Hunters of both types are affected by this

        if (!(hunter instanceof HunterNPCEntity || hunter instanceof HunterPatrolNPCEntity)) {
            return;
        }


        hunter.targetSelector.addGoal(1, new HurtByTargetGoal(hunter));

        hunter.targetSelector.addGoal(2, new NearestAttackableTargetGoal<LivingEntity>(hunter, LivingEntity.class, 16, true, false, target -> canAttackTaggedEntity(hunter, target)));

    }

    private static boolean canAttackTaggedEntity(
            PathfinderMob hunter,
            LivingEntity target
    ) {

        // If it's not tagged as something a hunter would attack, ignore it
        
        if (!target.getType().is(ATTACKED_BY_HUNTER_TAG)) {
            return false;
        }

		return true;
		
    }
}