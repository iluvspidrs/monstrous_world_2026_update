package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.GuardRobotEntity;

public class AngerRobotProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (sourceentity instanceof ServerPlayer) {
				if (entity instanceof GuardRobotEntity) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 5) {
						entity.getPersistentData().putString("AngryAt", (sourceentity.getDisplayName().getString()));
					}
				}
			}
		}
	}
}