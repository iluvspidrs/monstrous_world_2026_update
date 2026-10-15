package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GoToBedProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:beds")))) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).VampireInfection >= 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).VampireInfection < 42000) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You feel oddly awake right now"), true);
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You must use a coffin to sleep during daytime"), true);
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("The beast does not rest..."), true);
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You cannot sleep in this form..."), true);
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 10) {
					if (!((entity.level().dimension()) == Level.NETHER)) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.SetSpawn = false;
							_vars.markSyncDirty();
						}
					}
				}
				if (!(world instanceof Level _lvl10 && _lvl10.isDay())) {
					if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
											if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true)) {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).More_Nightmares == 0) {
													if (Math.random() >= 0.95) {
														if (entity instanceof ServerPlayer _serverPlayer)
															_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), _serverPlayer.getYRot(), true, false);
														MonstrousWorldMod.queueServerWork(5, () -> {
															if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
																ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("monstrous_world:nightmare_realm"));
																if (_player.level().dimension() == destinationType)
																	return;
																ServerLevel nextLevel = _player.server.getLevel(destinationType);
																if (nextLevel != null) {
																	_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
																	_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
																	_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
																	for (MobEffectInstance _effectinstance : _player.getActiveEffects())
																		_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
																	_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
																}
															}
														});
													}
												}
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).More_Nightmares == 1) {
													if (Math.random() >= 0.8) {
														if (entity instanceof ServerPlayer _serverPlayer)
															_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), _serverPlayer.getYRot(), true, false);
														MonstrousWorldMod.queueServerWork(5, () -> {
															if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
																ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("monstrous_world:nightmare_realm"));
																if (_player.level().dimension() == destinationType)
																	return;
																ServerLevel nextLevel = _player.server.getLevel(destinationType);
																if (nextLevel != null) {
																	_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
																	_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
																	_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
																	for (MobEffectInstance _effectinstance : _player.getActiveEffects())
																		_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
																	_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
																}
															}
														});
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}