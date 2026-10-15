package net.mcreator.monstrousworld.procedures;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.EnumSet;
import java.util.List;

public class HunterReputationTargetGoalProcedure extends Goal {

    private static final double MAX_SEARCH_DISTANCE = 64.0D;
    private static final double DISTANCE_32_SQR = 32.0D * 32.0D;
    private static final double DISTANCE_48_SQR = 48.0D * 48.0D;
    private static final double DISTANCE_64_SQR = 64.0D * 64.0D;

    private final PathfinderMob hunter;

    private Player targetPlayer;

    public HunterReputationTargetGoalProcedure(PathfinderMob hunter) {
        this.hunter = hunter;

        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    @Override
    public boolean canUse() {

        /*
         * Don't perform the relatively large 64-block search
         * every single AI tick.
         *
         * On average, this checks about twice per second.
         */
        if (this.hunter.getRandom().nextInt(10) != 0) {
            return false;
        }

        this.targetPlayer = findNearestValidPlayer();

        return this.targetPlayer != null;
    }

    @Override
    public boolean canContinueToUse() {

        if (this.targetPlayer == null) {
            return false;
        }

        if (!this.targetPlayer.isAlive()) {
            return false;
        }

        if (this.targetPlayer.isSpectator()) {
            return false;
        }

        if (this.targetPlayer.isCreative()) {
            return false;
        }

        /*
         * Continue targeting only while the player's
         * Reputation and current distance still qualify.
         */
        return canAttackPlayer(this.targetPlayer);
    }

    @Override
    public void start() {

        if (this.targetPlayer != null) {
            this.hunter.setTarget(this.targetPlayer);
        }
    }

    @Override
    public void tick() {

        /*
         * Keep the hunter's target set to the qualifying
         * player while this goal is active.
         */
        if (this.targetPlayer != null
                && this.hunter.getTarget() != this.targetPlayer) {

            this.hunter.setTarget(this.targetPlayer);
        }
    }

    @Override
    public void stop() {

        /*
         * Only clear the mob's target if this goal's player
         * is still the current target.
         *
         * This prevents us from accidentally clearing a
         * target chosen by another higher-priority goal.
         */
        if (this.hunter.getTarget() == this.targetPlayer) {
            this.hunter.setTarget(null);
        }

        this.targetPlayer = null;
    }

    private Player findNearestValidPlayer() {

        AABB searchArea =
                this.hunter.getBoundingBox()
                        .inflate(MAX_SEARCH_DISTANCE);

        List<Player> players =
                this.hunter.level().getEntitiesOfClass(
                        Player.class,
                        searchArea,
                        player ->
                                player.isAlive()
                                && !player.isSpectator()
                                && !player.isCreative()
                                && canAttackPlayer(player)
                );

        Player closestPlayer = null;
        double closestDistanceSqr = Double.MAX_VALUE;

        for (Player player : players) {

            double distanceSqr =
                    this.hunter.distanceToSqr(player);

            if (distanceSqr < closestDistanceSqr) {

                closestPlayer = player;
                closestDistanceSqr = distanceSqr;
            }
        }

        return closestPlayer;
    }

    private boolean canAttackPlayer(Player player) {

        var playerVariables =
                player.getData(
                        MonstrousWorldModVariables.PLAYER_VARIABLES
                );

        double reputation =
                playerVariables.Reputation;

        double distanceSqr =
                this.hunter.distanceToSqr(player);

        /*
         * Reputation <= -75:
         * attack from as far as 64 blocks.
         */
        if (reputation <= -75) {
            return distanceSqr <= DISTANCE_64_SQR;
        }

        /*
         * Reputation <= -50:
         * attack from as far as 48 blocks.
         */
        if (reputation <= -50) {
            return distanceSqr <= DISTANCE_48_SQR;
        }

        /*
         * Reputation <= -25:
         * attack from as far as 32 blocks.
         */
        if (reputation <= -25) {
            return distanceSqr <= DISTANCE_32_SQR;
        }

        /*
         * Reputation above -25:
         * Hunters remain neutral.
         */
        return false;
    }
}