package net.mcreator.monstrousworld.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class Bag57ResultChooChooProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (ModList.get().isLoaded("choochoocharles")) {
			if (Math.random() < 0.33) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worst_bag"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				MonstrousWorldMod.queueServerWork(100, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7cRun..."), false);
					if (world.isEmptyBlock(BlockPos.containing(x + 60, 0 + 5, z))) {
						entity.getPersistentData().putString("xx", ("" + (x + 60)));
						entity.getPersistentData().putString("yy", ("" + (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 60), (int) z) + 5)));
						entity.getPersistentData().putString("zz", ("" + z));
						entity.getPersistentData().putString("spawnlocation", "xx yy zz");
						MonstrousWorldMod.queueServerWork(1, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
						});
						MonstrousWorldMod.queueServerWork(2, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
						});
						MonstrousWorldMod.queueServerWork(3, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
						});
						MonstrousWorldMod.queueServerWork(4, () -> {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands()
											.performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("/summon choochoocharles:choo_choo_charles placeholder".replace("placeholder", entity.getPersistentData().getString("spawnlocation"))));
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						});
					} else if (world.isEmptyBlock(BlockPos.containing(x - 60, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 60), (int) z) + 5, z))) {
						entity.getPersistentData().putString("xx", ("" + (x - 60)));
						entity.getPersistentData().putString("yy", ("" + (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 60), (int) z) + 5)));
						entity.getPersistentData().putString("zz", ("" + z));
						entity.getPersistentData().putString("spawnlocation", "xx yy zz");
						MonstrousWorldMod.queueServerWork(1, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
						});
						MonstrousWorldMod.queueServerWork(2, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
						});
						MonstrousWorldMod.queueServerWork(3, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
						});
						MonstrousWorldMod.queueServerWork(4, () -> {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands()
											.performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("/summon choochoocharles:choo_choo_charles placeholder".replace("placeholder", entity.getPersistentData().getString("spawnlocation"))));
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						});
					} else if (world.isEmptyBlock(BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)) + 5, z + 60))) {
						entity.getPersistentData().putString("xx", ("" + x));
						entity.getPersistentData().putString("yy", ("" + (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 60)) + 5)));
						entity.getPersistentData().putString("zz", ("" + (z + 60)));
						entity.getPersistentData().putString("spawnlocation", "xx yy zz");
						MonstrousWorldMod.queueServerWork(1, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
						});
						MonstrousWorldMod.queueServerWork(2, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
						});
						MonstrousWorldMod.queueServerWork(3, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
						});
						MonstrousWorldMod.queueServerWork(4, () -> {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands()
											.performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("/summon choochoocharles:choo_choo_charles placeholder".replace("placeholder", entity.getPersistentData().getString("spawnlocation"))));
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						});
					} else if (world.isEmptyBlock(BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 60)) + 5, z - 60))) {
						entity.getPersistentData().putString("xx", ("" + x));
						entity.getPersistentData().putString("yy", ("" + (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 60)) + 5)));
						entity.getPersistentData().putString("zz", ("" + (z - 60)));
						entity.getPersistentData().putString("spawnlocation", "xx yy zz");
						MonstrousWorldMod.queueServerWork(1, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
						});
						MonstrousWorldMod.queueServerWork(2, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
						});
						MonstrousWorldMod.queueServerWork(3, () -> {
							entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
						});
						MonstrousWorldMod.queueServerWork(4, () -> {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands()
											.performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("/summon choochoocharles:choo_choo_charles placeholder".replace("placeholder", entity.getPersistentData().getString("spawnlocation"))));
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						});
					}
				});
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.TRICKED, 200, 0));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cRun..."), false);
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worst_bag"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 3) {
					entity.getPersistentData().putString("Enemy_Type", "Feral Mountain Troll");
				} else {
					entity.getPersistentData().putString("Enemy_Type", "Dire Werewolf");
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.TRICKED, 200, 0));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cRun..."), false);
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worst_bag"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 3) {
				entity.getPersistentData().putString("Enemy_Type", "Feral Mountain Troll");
			} else {
				entity.getPersistentData().putString("Enemy_Type", "Dire Werewolf");
			}
		}
	}
}