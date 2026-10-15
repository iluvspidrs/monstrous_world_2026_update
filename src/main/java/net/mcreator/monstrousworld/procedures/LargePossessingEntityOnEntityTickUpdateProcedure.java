package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import java.util.Comparator;

public class LargePossessingEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double elevation = 0;
		Entity NearestPlayer = null;
		Entity Shademarker = null;
		Entity NearestHungryTree = null;
		Entity TargetEntity = null;
		elevation = 0;
		NearestPlayer = findEntityInWorldRange(world, ServerPlayer.class, x, y, z, 125);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 1, 1, 1, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FALLING_OBSIDIAN_TEAR, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 1, 1, 1, 0.01);
		if (MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed == true) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (!entity.onGround()) {
			elevation = entity.getY() - world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ());
		}
		if (elevation > 10) {
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
		if (elevation < 0) {
			if (NearestPlayer != null) {
				if (NearestPlayer instanceof ServerPlayer) {
					if (elevation < NearestPlayer.getY()) {
						{
							Entity _ent = entity;
							double _tx = (entity.getX());
							double _ty = (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()));
							double _tz = (entity.getZ());
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			}
		}
		if (NearestPlayer != null) {
			if (NearestPlayer instanceof ServerPlayer) {
				if (!(getEntityGameType(NearestPlayer) == GameType.CREATIVE) && !(getEntityGameType(NearestPlayer) == GameType.SPECTATOR)) {
					if (NearestPlayer.getPersistentData().getDouble("DeepTimer") >= 2000) {
						if (entity instanceof Mob _entity && NearestPlayer instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}