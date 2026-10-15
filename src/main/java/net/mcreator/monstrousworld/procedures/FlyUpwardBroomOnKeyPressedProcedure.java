package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.PumpkinBroomEntityEntity;
import net.mcreator.monstrousworld.entity.GhostlyBroomEntityEntity;
import net.mcreator.monstrousworld.entity.EvilBroomEntityEntity;

public class FlyUpwardBroomOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if ((entity.getVehicle()) instanceof EvilBroomEntityEntity) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
						if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
							(entity.getVehicle()).setDeltaMovement(new Vec3(0, 0.3, 0));
						}
					}
				}
			}
			if ((entity.getVehicle()) instanceof PumpkinBroomEntityEntity) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
						if (getEntityScore("Can Fly", entity) >= 1) {
							if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
								(entity.getVehicle()).setDeltaMovement(new Vec3(0, 0.2, 0));
							}
						}
					}
				}
			}
			if ((entity.getVehicle()) instanceof GhostlyBroomEntityEntity) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
						if (getEntityScore("Can Fly", entity) >= 1) {
							if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
								(entity.getVehicle()).setDeltaMovement(new Vec3(0, 0.3, 0));
							}
						}
					}
				}
			}
		}
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}