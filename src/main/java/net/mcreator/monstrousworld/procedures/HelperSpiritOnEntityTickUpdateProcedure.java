package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class HelperSpiritOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double elevation = 0;
		elevation = 0;
		if (!world.isClientSide()) {
			if (!entity.onGround()) {
				elevation = entity.getY() - world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ());
			}
			if (elevation > 12) {
				{
					Entity _ent = entity;
					double _tx = (entity.getX());
					double _ty = (entity.getY() - 1);
					double _tz = (entity.getZ());
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}