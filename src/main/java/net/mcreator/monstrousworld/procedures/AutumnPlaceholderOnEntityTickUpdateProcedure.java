package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class AutumnPlaceholderOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() || entity.isInWaterOrBubble()) {
				if (!((world.getBlockState(BlockPos.containing(x, y - 0.5, z))).getBlock() == MonstrousWorldModBlocks.WHITE_GLYPH.get())) {
					if (!((world.getBlockState(BlockPos.containing(x, y - 0.5, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get())) {
						{
							Entity _ent = entity;
							double _tx = x;
							double _ty = (y - 0.5);
							double _tz = z;
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			}
		}
	}
}