package net.mcreator.monstrousworld.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;
import java.util.UUID;

public class TradingFreezeGoalProcedure extends Goal {

    private static final double MAX_TRADE_DISTANCE = 5.0D;
    private static final double MAX_TRADE_DISTANCE_SQR =
            MAX_TRADE_DISTANCE * MAX_TRADE_DISTANCE;

    private final PathfinderMob mob;

    private ServerPlayer tradingPlayer;

    public TradingFreezeGoalProcedure(PathfinderMob mob) {
        this.mob = mob;

        /*
         * MOVE prevents lower-priority movement goals.
         * LOOK prevents other look goals from competing
         * while the NPC faces the customer.
         */
        this.setFlags(EnumSet.of(
                Goal.Flag.MOVE,
                Goal.Flag.LOOK
        ));
    }

    @Override
    public boolean canUse() {

        this.tradingPlayer = getTradingPlayer();

        if (this.tradingPlayer == null) {
            return false;
        }

        return isTradingMenuOpen(this.tradingPlayer);
    }

    @Override
    public boolean canContinueToUse() {

        if (this.tradingPlayer == null) {
            return false;
        }

        if (!this.tradingPlayer.isAlive()) {
            return false;
        }

        /*
         * Stop when the player closes the GUI.
         */
        if (!isTradingMenuOpen(this.tradingPlayer)) {
            return false;
        }

        return true;
    }

    @Override
    public void start() {

        /*
         * Immediately stop whatever navigation
         * the mob was doing.
         */
        this.mob.getNavigation().stop();
    }

    @Override
    public void tick() {

        if (this.tradingPlayer == null) {
            return;
        }

        /*
         * Keep navigation stopped every tick.
         */
        this.mob.getNavigation().stop();

        /*
         * Remove horizontal motion so things such as
         * previous navigation momentum do not make
         * the trader slide away.
         *
         * Keep Y motion so gravity still works.
         */
        this.mob.setDeltaMovement(
                0.0D,
                this.mob.getDeltaMovement().y,
                0.0D
        );

        /*
         * Continuously face the player.
         */
        this.mob.getLookControl().setLookAt(
                this.tradingPlayer,
                30.0F,
                30.0F
        );

        /*
         * If the mob and player become more than
         * 5 blocks apart, close the GUI automatically.
         */
        if (this.mob.distanceToSqr(this.tradingPlayer)
                > MAX_TRADE_DISTANCE_SQR) {

            this.tradingPlayer.closeContainer();

            clearTradingState();
        }
    }

    @Override
    public void stop() {

        clearTradingState();

        this.tradingPlayer = null;
    }

    private ServerPlayer getTradingPlayer() {

        if (!(this.mob.level() instanceof ServerLevel serverLevel)) {
            return null;
        }

        String uuidString =
                this.mob.getPersistentData()
                        .getString("TradingPlayer");

        if (uuidString.isEmpty()) {
            return null;
        }

        try {

            UUID uuid = UUID.fromString(uuidString);

            Entity entity =
                    serverLevel.getEntity(uuid);

            if (entity instanceof ServerPlayer player) {
                return player;
            }

        } catch (IllegalArgumentException ignored) {
        }

        return null;
    }

    private boolean isTradingMenuOpen(ServerPlayer player) {

        /*
         * When no custom/container GUI is open,
         * containerMenu returns to inventoryMenu.
         */
        return player.containerMenu != player.inventoryMenu;
    }

    private void clearTradingState() {

        this.mob.getPersistentData()
                .remove("TradingPlayer");
    }
}