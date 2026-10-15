package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ScanSelfWithDetectorProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MONSTER_DETECTOR.get() && entity.isShiftKeyDown()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Undead creature detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Vampirism detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Lycanthropy detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType <= 3 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType >= 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Mutation detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Goblin detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Mad scientist detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Troll detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Swamp monster detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Demonic entity detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Slasher detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Magic user detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Unusual concentration of dark force detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74Evil clown detected!"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:alarm_beeping")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7aOrdinary human. No action advised."), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}