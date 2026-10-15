package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;

public class StartEntityTradingProcedureProcedure {

    public static void execute(
            Entity entity,
            Entity sourceEntity
    ) {

        if (!(entity instanceof PathfinderMob mob)) {
            return;
        }

        if (!(sourceEntity instanceof Player player)) {
            return;
        }

        /*
         * Remember which player this mob is trading with.
         */
        mob.getPersistentData().putString(
                "TradingPlayer",
                player.getStringUUID()
        );

        /*
         * Add the trading lock goal.
         *
         * Priority 0 makes this higher priority than:
         *
         * 1 - vampire shade seeking
         * 2 - village marker seeking
         * normal attack/wander movement goals
         */
        mob.goalSelector.addGoal(
                0,
                new TradingFreezeGoalProcedure(mob)
        );

        /*
         * Stop immediately rather than waiting
         * for the next AI tick.
         */
        mob.getNavigation().stop();

        mob.getLookControl().setLookAt(
                player,
                30.0F,
                30.0F
        );
    }
}