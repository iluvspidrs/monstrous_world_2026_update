package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.DeadlyBalloonEntity;

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
public class DeadlyBalloonAttackGoalOnSpawnProcedure {

    private static final TagKey<EntityType<?>> ATTACKED_BY_DARK_FACTIONS_TAG =
            TagKey.create(
                    Registries.ENTITY_TYPE,
                    ResourceLocation.parse("monstrous_world:attacked_by_dark_factions")
            );

    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {

        // Only modify AI on the server.
        if (event.getLevel().isClientSide()) {
            return;
        }

		// Don't use non-pathfinding entities, defines the entity here as balloon

        if (!(event.getEntity() instanceof PathfinderMob balloon)) {
            return;
        }

		//only Deadly Balloons are affected by this

        if (!(balloon instanceof DeadlyBalloonEntity)) {
            return;
        }


        balloon.targetSelector.addGoal(1, new HurtByTargetGoal(balloon));


        balloon.targetSelector.addGoal(2, new NearestAttackableTargetGoal<LivingEntity>(balloon, LivingEntity.class, 16, true, false, target -> canAttackTaggedEntity(balloon, target)));


        balloon.targetSelector.addGoal(
                2,
                new NearestAttackableTargetGoal<Player>(
                        balloon,
                        Player.class,
                        32,
                        true,
                        false,
                        target -> target instanceof Player player
                                && canAttackPlayer(balloon, player)
                )
        );
    }

    private static boolean canAttackTaggedEntity(
            PathfinderMob balloon,
            LivingEntity target
    ) {

        // Players can have exceptions, so toss them out here
        if (target instanceof Player) {
            return false;
        }

        // Only mobs in the tag set above can be targeted
        
        if (!target.getType().is(ATTACKED_BY_DARK_FACTIONS_TAG)) {
            return false;
        }

		return true;
		
    }

    private static boolean canAttackPlayer(PathfinderMob balloon, Player player) {

        var playerVariables =
                player.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);

        // Deadly Balloons will ignore players with bad factions
        if (playerVariables.MonsterClass >= 10) {
            return false;
        }

        // They also ignore players possessed by the mysterious dark entity
        if (playerVariables.Possession == 3) {
            return false;
        }

        return true;
    }
}