package net.mcreator.monstrousworld.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class VampiresSeekShadeGoalProcedure extends Goal {

    private final PathfinderMob mob;
    private final double speedModifier;

    private double wantedX;
    private double wantedY;
    private double wantedZ;

    public VampiresSeekShadeGoalProcedure (
            PathfinderMob mob,
            double speedModifier
    ) {
        this.mob = mob;
        this.speedModifier = speedModifier;

        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {

        
        if (!mob.level().isDay()) {
            return false;
        }

        
        if (mob.level().isRaining()) {
            return false;
        }

        BlockPos mobPos = mob.blockPosition();

        
        if (!mob.level().canSeeSky(mobPos)) {
            return false;
        }

        Vec3 shadePos = findShadePosition();

        if (shadePos == null) {
            return false;
        }

        this.wantedX = shadePos.x;
        this.wantedY = shadePos.y;
        this.wantedZ = shadePos.z;

        return true;
    }

    @Override
    public boolean canContinueToUse() {

        // Stop once navigation is complete.
        if (mob.getNavigation().isDone()) {
            return false;
        }

        // Stop if night arrives.
        if (!mob.level().isDay()) {
            return false;
        }

        // Stop fleeing if rain begins.
        if (mob.level().isRaining()) {
            return false;
        }

        return true;
    }

    @Override
    public void start() {

        mob.getNavigation().moveTo(
                wantedX,
                wantedY,
                wantedZ,
                speedModifier
        );
    }

    private Vec3 findShadePosition() {

        BlockPos origin = mob.blockPosition();

        /*
         * Try several nearby random positions.
         *
         * Search roughly:
         * 12 blocks horizontally
         * 6 blocks vertically
         */
        for (int attempt = 0; attempt < 100; attempt++) {

            int x = origin.getX() + mob.getRandom().nextInt(25) - 16;
            int y = origin.getY() + mob.getRandom().nextInt(13) - 8;
            int z = origin.getZ() + mob.getRandom().nextInt(25) - 16;

            BlockPos candidate = new BlockPos(x, y, z);

            /*
             * Candidate must be sheltered from the sky.
             */
            if (mob.level().canSeeSky(candidate)) {
                continue;
            }

            /*
             * Candidate must have enough room for the mob.
             */
            if (!mob.level().getBlockState(candidate).getCollisionShape(
                    mob.level(),
                    candidate
            ).isEmpty()) {
                continue;
            }

            /*
             * Make sure there is somewhere solid enough to stand.
             */
            BlockPos below = candidate.below();

            if (mob.level().getBlockState(below).getCollisionShape(
                    mob.level(),
                    below
            ).isEmpty()) {
                continue;
            }

            /*
             * Make sure the navigation system can actually
             * generate a path there.
             */
            if (mob.getNavigation().createPath(candidate, 0) == null) {
                continue;
            }

            return Vec3.atBottomCenterOf(candidate);
        }

        return null;
    }
}