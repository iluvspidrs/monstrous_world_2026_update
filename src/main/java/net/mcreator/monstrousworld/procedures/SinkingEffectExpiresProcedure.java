package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class SinkingEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			{
				Entity _ent = entity;
				double _tx = (entity.getX());
				double _ty = (entity.getY() + 2);
				double _tz = (entity.getZ());
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}