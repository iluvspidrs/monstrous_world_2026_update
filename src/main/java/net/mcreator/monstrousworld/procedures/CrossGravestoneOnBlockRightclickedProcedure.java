package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class CrossGravestoneOnBlockRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Respawn point set"), false);
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), _serverPlayer.getYRot(), true, false);
			}
		}
	}
}