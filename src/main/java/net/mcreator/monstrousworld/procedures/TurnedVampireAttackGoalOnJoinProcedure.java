package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.VampireNPCEntity;

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
public class TurnedVampireAttackGoalOnJoinProcedure {

    private static final TagKey<EntityType<?>> ATTACKED_BY_VAMPIRE_TAG =
            TagKey.create(
                    Registries.ENTITY_TYPE,
                    ResourceLocation.parse("monstrous_world:attacked_by_vampire")
            );

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {


        if (event.getLevel().isClientSide()) {
            return;
        }

  
        if (!(event.getEntity() instanceof PathfinderMob vampire)) {
            return;
        }


        if (!vampire.getPersistentData().getBoolean("vampire") || (vampire instanceof VampireNPCEntity)) {
            return;
        }



        vampire.targetSelector.addGoal(
                1,
                new HurtByTargetGoal(vampire)
        );


        vampire.targetSelector.addGoal(
                2,
                new NearestAttackableTargetGoal<LivingEntity>(
                        vampire,
                        LivingEntity.class,
                        16,
                        true,
                        false,
                        target -> canAttackTaggedEntity(vampire, target)
                )
        );


        vampire.targetSelector.addGoal(
                2,
                new NearestAttackableTargetGoal<Player>(
                        vampire,
                        Player.class,
                        32,
                        true,
                        false,
                        target -> target instanceof Player player
                                && canAttackPlayer(vampire, player)
                )
        );
    }

    private static boolean canAttackTaggedEntity(
            PathfinderMob vampire,
            LivingEntity target
    ) {


        if (target instanceof Player) {
            return false;
        }


        if (!target.getType().is(ATTACKED_BY_VAMPIRE_TAG)) {
            return false;
        }


        if (vampire.getPersistentData()
                .getString("Reserve")
                .equals("true")) {
            return false;
        }

        // Do not hunt hypnotized targets.
        if (target.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS)) {
            return false;
        }

        // Do not hunt other vampires.
        if (target.getPersistentData().getBoolean("vampire")) {
            return false;
        }

        // Target must have BloodLevel greater than 8.
        if (target.getPersistentData().getDouble("BloodLevel") <= 8) {
            return false;
        }

        // Do not hunt infected targets.
        if (target.getPersistentData().getDouble("vampireInfection") >= 1) {
            return false;
        }

        // Only hunt when the target's location has brightness below 15.
        int brightness =
                vampire.level().getMaxLocalRawBrightness(
                        BlockPos.containing(
                                target.getX(),
                                target.getY(),
                                target.getZ()
                        )
                );

        if (brightness >= 15) {
            return false;
        }

        return true;
    }

    private static boolean canAttackPlayer(
            PathfinderMob vampire,
            Player player
    ) {

        // Reserve vampires do not hunt players normally.
        if (vampire.getPersistentData()
                .getString("Reserve")
                .equals("true")) {
            return false;
        }

        // Player must be in brightness below 15.
        int brightness =
                vampire.level().getMaxLocalRawBrightness(
                        BlockPos.containing(
                                player.getX(),
                                player.getY(),
                                player.getZ()
                        )
                );

        if (brightness >= 15) {
            return false;
        }

        // Player cannot have Hypnosis.
        if (player.hasEffect(MonstrousWorldModMobEffects.HYPNOSIS)) {
            return false;
        }

        // Vampire cannot have this player's UUID stored as its hypnosis target.
        if (vampire.getPersistentData()
                .getString("hypnosis")
                .equals(player.getStringUUID())) {
            return false;
        }

        // Player cannot have this vampire's UUID stored as its hypnosis target.
        if (player.getPersistentData()
                .getString("hypnosis")
                .equals(vampire.getStringUUID())) {
            return false;
        }

        var playerVariables =
                player.getData(
                        MonstrousWorldModVariables.PLAYER_VARIABLES
                );

        // Player must have at least 8 Bloodlevel.
        if (playerVariables.Bloodlevel < 8) {
            return false;
        }

        // Already infected players are excluded.
        if (playerVariables.VampireInfection != 0) {
            return false;
        }

        // Excluded MonsterClass values.
        if (playerVariables.MonsterClass == 8
                || playerVariables.MonsterClass == 10
                || playerVariables.MonsterClass == 11) {
            return false;
        }

        // Excluded MonsterType values.
        if (playerVariables.MonsterType == 4
                || playerVariables.MonsterType == 6) {
            return false;
        }

        // Excluded possession state.
        if (playerVariables.Possession == 3) {
            return false;
        }

        return true;
    }
}