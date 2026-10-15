package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;

@EventBusSubscriber(modid = "monstrous_world")
public class TrueEvilNeutralityProcedure {

    private static final TagKey<EntityType<?>> TRUE_EVIL_MOB_TAG =
            TagKey.create(
                    Registries.ENTITY_TYPE,
                    ResourceLocation.parse("monstrous_world:true_evil"));

    @SubscribeEvent
    public static void onTargetChange(LivingChangeTargetEvent event) {

        LivingEntity mob = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

        // only works when player is targeted
        
        if (!(newTarget instanceof Player player)) {
            return;
        }

        boolean trueEvil = mob.getType().is(TRUE_EVIL_MOB_TAG);

        boolean netherSpawned = mob.getPersistentData().getBoolean("nether_spawned");

        if (!trueEvil && !netherSpawned) {
            return;
        }

        var playerVariables = player.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);

        boolean neutralPlayer = playerVariables.MonsterClass >= 10 || playerVariables.Possession == 3;

        if (!neutralPlayer) {
            return;
        }


        if (mob.getLastHurtByMob() == player) {
            return;
        }

        event.setCanceled(true);
    }
}