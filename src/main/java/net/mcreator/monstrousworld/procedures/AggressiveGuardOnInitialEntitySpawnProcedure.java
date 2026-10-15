package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class AggressiveGuardOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		for (int _i1 = 0; _i1 < 35; _i1++) {
			if (!world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) || !world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))) {
				{
					Entity _ent = entity;
					double _tx = (entity.getX());
					double _ty = (entity.getY() + 1);
					double _tz = (entity.getZ());
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			} else {
				break;
			}
		}
	}
}