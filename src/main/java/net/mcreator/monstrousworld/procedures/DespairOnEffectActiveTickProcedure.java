package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class DespairOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!(getEntityGameType(entity) == GameType.CREATIVE) && !(getEntityGameType(entity) == GameType.SPECTATOR)) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) == 11000) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("A powerful despair fills your chest, and your feet sink into the ground..."), false);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) == 9000) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your despair grows heavier, and you sink up to your knees..."), false);
					{
						Entity _ent = entity;
						double _tx = (entity.getX());
						double _ty = (entity.getY() - 0.24);
						double _tz = (entity.getZ());
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) == 6000) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Hopelessness pulls you deeper into the soil..."), false);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) == 3000) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You want to stop moving. You sink to your neck..."), false);
					{
						Entity _ent = entity;
						double _tx = (entity.getX());
						double _ty = (entity.getY() - (-0.1));
						double _tz = (entity.getZ());
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.soul_sand.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You give up, and disappear under the dark soil..."), true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.SINKING, 24000, 0));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) < 11000
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) >= 9000) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0));
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) < 9000
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) >= 6000) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0));
					if (entity.onGround()) {
						if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY() + 0.1, entity.getZ()))) {
							int horizontalRadiusHemiBot = (int) 3 - 1;
							int verticalRadiusHemiBot = (int) 1;
							int yIterationsHemiBot = verticalRadiusHemiBot;
							for (int i = -yIterationsHemiBot; i <= 0; i++) {
								if (i == -verticalRadiusHemiBot) {
									continue;
								}
								for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
									for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
										double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
												+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
										if (distanceSq <= 1.0) {
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_SAND.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_SAND_DEEP.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_DIRT.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT_DEEP.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_CRYSTAL_DEEP.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_STONE.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_STONE_DEEP.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
										}
									}
								}
							}
						} else {
							int horizontalRadiusHemiBot = (int) 3 - 1;
							int verticalRadiusHemiBot = (int) 1;
							int yIterationsHemiBot = verticalRadiusHemiBot;
							for (int i = -yIterationsHemiBot; i <= 0; i++) {
								if (i == -verticalRadiusHemiBot) {
									continue;
								}
								for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
									for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
										double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
												+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
										if (distanceSq <= 1.0) {
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_SAND.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_SAND_DEEP.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_DIRT.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT_DEEP.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_CRYSTAL_DEEP.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_STONE.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_STONE_DEEP.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) < 6000
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) > 3000) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
					if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
						if (entity.onGround()) {
							{
								Entity _ent = entity;
								double _tx = (entity.getX());
								double _ty = (entity.getY() - 0.5);
								double _tz = (entity.getZ());
								_ent.teleportTo(_tx, _ty, _tz);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
							}
						}
						int horizontalRadiusHemiBot = (int) 3 - 1;
						int verticalRadiusHemiBot = (int) 1;
						int yIterationsHemiBot = verticalRadiusHemiBot;
						for (int i = -yIterationsHemiBot; i <= 0; i++) {
							if (i == -verticalRadiusHemiBot) {
								continue;
							}
							for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
								for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
									double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
											+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
									if (distanceSq <= 1.0) {
										if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_SAND_DEEP.get()) {
											{
												BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_SAND.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_DIRT_DEEP.get()) {
											{
												BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_CRYSTAL_DEEP.get()) {
											{
												BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_CRYSTAL.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_STONE_DEEP.get()) {
											{
												BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_STONE.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
									}
								}
							}
						}
					} else {
						int horizontalRadiusHemiBot = (int) 3 - 1;
						int verticalRadiusHemiBot = (int) 1;
						int yIterationsHemiBot = verticalRadiusHemiBot;
						for (int i = -yIterationsHemiBot; i <= 0; i++) {
							if (i == -verticalRadiusHemiBot) {
								continue;
							}
							for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
								for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
									double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
											+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
									if (distanceSq <= 1.0) {
										if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_SAND.get()) {
											{
												BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_SAND_PASSTHROUGH.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_DIRT.get()) {
											{
												BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT_PASSTHROUGH.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get()) {
											{
												BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_CRYSTAL_PASSTHROUGH.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
										if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_STONE.get()) {
											{
												BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
												BlockState _bs = MonstrousWorldModBlocks.DARKENED_STONE_PASSTHROUGH.get().defaultBlockState();
												BlockState _bso = world.getBlockState(_bp);
												for (Property<?> _propertyOld : _bso.getProperties()) {
													Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
													if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
														try {
															_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
														} catch (Exception e) {
														}
												}
												world.setBlock(_bp, _bs, 3);
											}
										}
									}
								}
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) < 3000
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.DESPAIR) ? _livEnt.getEffect(MonstrousWorldModMobEffects.DESPAIR).getDuration() : 0) > 1) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
					if (entity.onGround()) {
						if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.AIR
								|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.CAVE_AIR) {
							if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.AIR
									|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.CAVE_AIR) {
								int horizontalRadiusHemiBot = (int) 3 - 1;
								int verticalRadiusHemiBot = (int) 1;
								int yIterationsHemiBot = verticalRadiusHemiBot;
								for (int i = -yIterationsHemiBot; i <= 0; i++) {
									if (i == -verticalRadiusHemiBot) {
										continue;
									}
									for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
										for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
											double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
													+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
											if (distanceSq <= 1.0) {
												if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_SAND.get()) {
													{
														BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
														BlockState _bs = MonstrousWorldModBlocks.DARKENED_SAND_PASSTHROUGH.get().defaultBlockState();
														BlockState _bso = world.getBlockState(_bp);
														for (Property<?> _propertyOld : _bso.getProperties()) {
															Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
															if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																try {
																	_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																} catch (Exception e) {
																}
														}
														world.setBlock(_bp, _bs, 3);
													}
												}
												if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_DIRT.get()) {
													{
														BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
														BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT_PASSTHROUGH.get().defaultBlockState();
														BlockState _bso = world.getBlockState(_bp);
														for (Property<?> _propertyOld : _bso.getProperties()) {
															Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
															if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																try {
																	_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																} catch (Exception e) {
																}
														}
														world.setBlock(_bp, _bs, 3);
													}
												}
												if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get()) {
													{
														BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
														BlockState _bs = MonstrousWorldModBlocks.DARKENED_CRYSTAL_PASSTHROUGH.get().defaultBlockState();
														BlockState _bso = world.getBlockState(_bp);
														for (Property<?> _propertyOld : _bso.getProperties()) {
															Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
															if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																try {
																	_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																} catch (Exception e) {
																}
														}
														world.setBlock(_bp, _bs, 3);
													}
												}
												if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_STONE.get()) {
													{
														BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
														BlockState _bs = MonstrousWorldModBlocks.DARKENED_STONE_PASSTHROUGH.get().defaultBlockState();
														BlockState _bso = world.getBlockState(_bp);
														for (Property<?> _propertyOld : _bso.getProperties()) {
															Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
															if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																try {
																	_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																} catch (Exception e) {
																}
														}
														world.setBlock(_bp, _bs, 3);
													}
												}
											}
										}
									}
								}
							} else {
								int horizontalRadiusHemiBot = (int) 3 - 1;
								int verticalRadiusHemiBot = (int) 1;
								int yIterationsHemiBot = verticalRadiusHemiBot;
								for (int i = -yIterationsHemiBot; i <= 0; i++) {
									if (i == -verticalRadiusHemiBot) {
										continue;
									}
									for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
										for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
											double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
													+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
											if (distanceSq <= 1.0) {
												if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_SAND.get()) {
													{
														BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
														BlockState _bs = MonstrousWorldModBlocks.DARKENED_SAND_PASSTHROUGH.get().defaultBlockState();
														BlockState _bso = world.getBlockState(_bp);
														for (Property<?> _propertyOld : _bso.getProperties()) {
															Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
															if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																try {
																	_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																} catch (Exception e) {
																}
														}
														world.setBlock(_bp, _bs, 3);
													}
												}
												if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_DIRT.get()) {
													{
														BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
														BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT_PASSTHROUGH.get().defaultBlockState();
														BlockState _bso = world.getBlockState(_bp);
														for (Property<?> _propertyOld : _bso.getProperties()) {
															Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
															if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																try {
																	_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																} catch (Exception e) {
																}
														}
														world.setBlock(_bp, _bs, 3);
													}
												}
												if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get()) {
													{
														BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
														BlockState _bs = MonstrousWorldModBlocks.DARKENED_CRYSTAL_PASSTHROUGH.get().defaultBlockState();
														BlockState _bso = world.getBlockState(_bp);
														for (Property<?> _propertyOld : _bso.getProperties()) {
															Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
															if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																try {
																	_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																} catch (Exception e) {
																}
														}
														world.setBlock(_bp, _bs, 3);
													}
												}
												if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_STONE.get()) {
													{
														BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
														BlockState _bs = MonstrousWorldModBlocks.DARKENED_STONE_PASSTHROUGH.get().defaultBlockState();
														BlockState _bso = world.getBlockState(_bp);
														for (Property<?> _propertyOld : _bso.getProperties()) {
															Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
															if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
																try {
																	_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
																} catch (Exception e) {
																}
														}
														world.setBlock(_bp, _bs, 3);
													}
												}
											}
										}
									}
								}
							}
						} else {
							int horizontalRadiusHemiBot = (int) 3 - 1;
							int verticalRadiusHemiBot = (int) 1;
							int yIterationsHemiBot = verticalRadiusHemiBot;
							for (int i = -yIterationsHemiBot; i <= 0; i++) {
								if (i == -verticalRadiusHemiBot) {
									continue;
								}
								for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
									for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
										double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
												+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
										if (distanceSq <= 1.0) {
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_SAND.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_SAND_BOTTOM.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_DIRT.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_DIRT_BOTTOM.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_CRYSTAL.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_CRYSTAL_BOTTOM.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
												}
											}
											if ((world.getBlockState(BlockPos.containing(x + xi, y + i - 1, z + zi))).getBlock() == MonstrousWorldModBlocks.DARKENED_STONE.get()) {
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i - 1, z + zi);
													BlockState _bs = MonstrousWorldModBlocks.DARKENED_STONE_BOTTOM.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Property<?> _propertyOld : _bso.getProperties()) {
														Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
														if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
															try {
																_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
															} catch (Exception e) {
															}
													}
													world.setBlock(_bp, _bs, 3);
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
			if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("monstrous_world:the_deep")))) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.DESPAIR);
			}
		}
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