package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class MysteriousShadowEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double elevation = 0;
		elevation = 0;
		if (!world.isClientSide()) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 1, 1, 1, 0.01);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FALLING_OBSIDIAN_TEAR, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 1, 1, 1, 0.01);
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
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof ServerPlayer) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
					if (!((entity.getPersistentData().getString("AngryAt")).equals((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDisplayName().getString()))) {
						if (entity instanceof Mob) {
							try {
								((Mob) entity).setTarget(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}