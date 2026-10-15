package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class SleepThroughDayProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _lvl0 && _lvl0.isDay()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.COFFIN_BOTTOM.get()) {
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), _serverPlayer.getYRot(), true, false);
				if (!(entity.getPersistentData().getBoolean("InCoffin") == true)) {
					MonstrousWorldMod.queueServerWork(1, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.nether_wood_door.close")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.nether_wood_door.close")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x, y + 1, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (entity instanceof ServerPlayer _serverPlayer)
							_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), _serverPlayer.getYRot(), true, false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Sleeping through the day. Press [C] to leave coffin"), true);
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("minecraft:time_since_rest");
							if (_so == null)
								_so = _sc.addObjective("minecraft:time_since_rest", ObjectiveCriteria.DUMMY, Component.literal("minecraft:time_since_rest"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("time_since_rest");
							if (_so == null)
								_so = _sc.addObjective("time_since_rest", ObjectiveCriteria.DUMMY, Component.literal("time_since_rest"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 7));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 220, 1));
						entity.getPersistentData().putBoolean("InCoffin", true);
						MonstrousWorldModVariables.PlayersInCoffins = MonstrousWorldModVariables.PlayersInCoffins + 1;
						MonstrousWorldMod.queueServerWork(100, () -> {
							if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) - MonstrousWorldModVariables.PlayersInCoffins == 0) {
								if (world instanceof ServerLevel _level)
									_level.setDayTime((int) (world.dayTime() + MonstrousWorldModVariables.TimeUntilNight));
								MonstrousWorldModVariables.PlayersInCoffins = 0;
								entity.getPersistentData().putBoolean("InCoffin", false);
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(MobEffects.BLINDNESS);
								if (entity instanceof ServerPlayer _serverPlayer)
									_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), _serverPlayer.getYRot(), true, false);
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You awaken at sunset..."), true);
							}
						});
					});
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.BLINDNESS);
					entity.getPersistentData().putBoolean("InCoffin", false);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.nether_wood_door.open")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.nether_wood_door.open")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				}
			}
		}
	}
}