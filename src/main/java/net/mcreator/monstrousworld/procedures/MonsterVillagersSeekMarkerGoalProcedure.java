package net.mcreator.monstrousworld.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;

import java.util.EnumSet;
import java.util.List;

public class MonsterVillagersSeekMarkerGoalProcedure extends Goal {

    private static final TagKey<EntityType<?>> VILLAGE_MARKERS_TAG =
            TagKey.create(
                    Registries.ENTITY_TYPE,
                    ResourceLocation.parse("monstrous_world:village_markers")
            );

    private static final double MIN_DISTANCE = 60.0D;
    private static final double MAX_DISTANCE = 70.0D;

    private static final double MIN_DISTANCE_SQR =
            MIN_DISTANCE * MIN_DISTANCE;

    private static final double MAX_DISTANCE_SQR =
            MAX_DISTANCE * MAX_DISTANCE;

    private final PathfinderMob mob;
    private final double speedModifier;

    private Entity marker;
    private int pathRecalculationTimer;

    public MonsterVillagersSeekMarkerGoalProcedure(
            PathfinderMob mob,
            double speedModifier
    ) {
        this.mob = mob;
        this.speedModifier = speedModifier;

        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {

        this.marker = findNearestVillageMarker();

        if (this.marker == null) {
            return false;
        }

        double distanceSqr =
                this.mob.distanceToSqr(this.marker);

        /*
         * Only activate when:
         *
         * distance > 120
         * AND
         * distance < 150
         */
        return distanceSqr > MIN_DISTANCE_SQR
                && distanceSqr < MAX_DISTANCE_SQR;
    }

    @Override
    public boolean canContinueToUse() {

        if (this.marker == null) {
            return false;
        }

        if (!this.marker.isAlive()) {
            return false;
        }

        /*
         * Make sure it is still a village marker.
         */
        if (!this.marker.getType().is(VILLAGE_MARKERS_TAG)) {
            return false;
        }

        double distanceSqr =
                this.mob.distanceToSqr(this.marker);

        /*
         * Stop once the mob reaches 120 blocks or closer.
         *
         * Also stop if for some reason the marker gets
         * beyond 150 blocks away.
         */
        return distanceSqr > MIN_DISTANCE_SQR
                && distanceSqr < MAX_DISTANCE_SQR;
    }

    @Override
    public void start() {

        this.pathRecalculationTimer = 0;

        moveTowardMarker();
    }

    @Override
    public void tick() {

        if (this.marker == null) {
            return;
        }

        /*
         * Recalculate the path every 20 ticks
         * so this still works if the marker moves.
         */
        if (--this.pathRecalculationTimer <= 0) {

            this.pathRecalculationTimer = 20;

            moveTowardMarker();
        }
    }

    @Override
    public void stop() {

        this.marker = null;

        this.mob.getNavigation().stop();
    }

    private void moveTowardMarker() {

        if (this.marker == null) {
            return;
        }

        this.mob.getNavigation().moveTo(
                this.marker.getX(),
                this.marker.getY(),
                this.marker.getZ(),
                this.speedModifier
        );
    }

    private Entity findNearestVillageMarker() {

        /*
         * Search 150 blocks in every direction.
         */
        AABB searchArea =
                this.mob.getBoundingBox().inflate(MAX_DISTANCE);

        List<Entity> markers =
                this.mob.level().getEntities(
                        this.mob,
                        searchArea,
                        entity ->
                                entity.isAlive()
                                && entity.getType().is(VILLAGE_MARKERS_TAG)
                );

        Entity closest = null;
        double closestDistanceSqr = MAX_DISTANCE_SQR;

        for (Entity candidate : markers) {

            double distanceSqr =
                    this.mob.distanceToSqr(candidate);

            /*
             * We only care about markers between
             * 120 and 150 blocks away.
             */
            if (distanceSqr <= MIN_DISTANCE_SQR) {
                continue;
            }

            if (distanceSqr >= MAX_DISTANCE_SQR) {
                continue;
            }

            if (distanceSqr < closestDistanceSqr) {
                closest = candidate;
                closestDistanceSqr = distanceSqr;
            }
        }

        return closest;
    }
}