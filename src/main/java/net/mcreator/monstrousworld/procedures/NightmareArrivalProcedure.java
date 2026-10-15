package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NightmareArrivalProcedure {
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		execute(null, world, x, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			MonstrousWorldMod.queueServerWork(1, () -> {
				if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("monstrous_world:nightmare_realm"))) {
					if (entity instanceof Player || entity instanceof ServerPlayer) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
							{
								Entity _ent = entity;
								double _tx = x;
								double _ty = (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z));
								double _tz = z;
								_ent.teleportTo(_tx, _ty, _tz);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
							}
							entity.getPersistentData().putBoolean("inNightmare", true);
							MonstrousWorldMod.queueServerWork(20, () -> {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												("/execute in monstrous_world:nightmare_realm run summon minecraft:villager ~ ~ ~ details".replace("details", entity.getPersistentData().getString("villagerdata"))));
									}
								}
							});
						} else {
							{
								Entity _ent = entity;
								double _tx = x;
								double _ty = (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z));
								double _tz = z;
								_ent.teleportTo(_tx, _ty, _tz);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You find yourself in a terrifying nightmare..."), true);
							MonstrousWorldMod.queueServerWork(60, () -> {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MANIAC.get().spawn(_level,
												BlockPos.containing(entity.getX(), world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 25)), entity.getZ() + 25), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MANIAC.get().spawn(_level,
												BlockPos.containing(entity.getX() + 25, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 25), (int) z), entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MANIAC.get().spawn(_level,
												BlockPos.containing(entity.getX(), world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 25)), entity.getZ() - 25), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MANIAC.get().spawn(_level,
												BlockPos.containing(entity.getX() - 25, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 25), (int) z), entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
								}
							});
						}
					}
				}
				if ((entity.level().dimension()) == Level.OVERWORLD) {
					if (entity.getPersistentData().getBoolean("inNightmare") == true) {
						{
							Entity _ent = entity;
							double _tx = (entity.getPersistentData().getDouble("NightmareX"));
							double _ty = (entity.getPersistentData().getDouble("NightmareY"));
							double _tz = (entity.getPersistentData().getDouble("NightmareZ"));
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
						MonstrousWorldMod.queueServerWork(10, () -> {
							entity.getPersistentData().putBoolean("inNightmare", false);
						});
					}
				}
			});
		}
	}
}