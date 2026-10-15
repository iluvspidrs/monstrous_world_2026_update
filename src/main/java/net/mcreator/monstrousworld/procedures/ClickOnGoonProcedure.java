package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ClickOnGoonProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof SocietyGoonEntity) {
				if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\"You're scanned. Avoid the dark corruption and keep humanity pure.\""), false);
							} else if (entity.getPersistentData().getBoolean("vampire") == true) {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\"It's your imagination! There's...there's nothing wrong with me!\""), false);
								MonstrousWorldMod.queueServerWork(80, () -> {
									if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8)) {
										if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6)) {
											if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
												_entity.setTarget(_ent);
										}
									}
								});
							}
						} else {
							if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\"Die, you monster!\""), false);
							} else {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\"It's your imagination! There's...there's nothing wrong with me!\""), false);
								MonstrousWorldMod.queueServerWork(80, () -> {
									if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8)) {
										if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6)) {
											if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
												_entity.setTarget(_ent);
										}
									}
								});
							}
						}
					} else {
						if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\"Die, you monster!\""), false);
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\"It's your imagination! There's...there's nothing wrong with me!\""), false);
							MonstrousWorldMod.queueServerWork(80, () -> {
								if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8)) {
									if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6)) {
										if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
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