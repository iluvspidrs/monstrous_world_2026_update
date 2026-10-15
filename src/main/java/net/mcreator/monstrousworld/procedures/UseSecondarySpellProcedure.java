package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
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
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.entity.HelperSpiritEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import java.util.Comparator;

public class UseSecondarySpellProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6) {
							if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= 4) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 1) {
										if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.LEVITATION))) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 0));
											if (!(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6)) {
												if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= 4) {
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
														if (entity instanceof Player _player)
															_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 4);
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
														if (entity instanceof Player _player)
															_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 2);
													}
												}
											}
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 2) {
										if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.FIRE_RESISTANCE))) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0));
											if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= 4) {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
													if (entity instanceof Player _player)
														_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 4);
												}
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
													if (entity instanceof Player _player)
														_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 2);
												}
											}
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 4) {
										if (!(!world.getEntitiesOfClass(HelperSpiritEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(30 / 2d), e -> true).isEmpty())) {
											if (world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HELPER_SPIRIT.get().spawn(_level, BlockPos.containing(x, y + 2, z), MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
													}
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HELPER_SPIRIT.get().spawn(_level, BlockPos.containing(x, y + 2, z), MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
													}
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HELPER_SPIRIT.get().spawn(_level, BlockPos.containing(x, y + 2, z), MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
													}
												}
												if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= 4) {
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
														if (entity instanceof Player _player)
															_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 4);
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
														if (entity instanceof Player _player)
															_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 2);
													}
												}
												{
													final Vec3 _center = new Vec3(x, y, z);
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HelperSpiritEntity) {
															entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
															if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
																_toTame.tame(_owner);
														}
													}
												}
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You cannot summon too many spirit helpers at once!"), true);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 3) {
										if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()
												|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "Glyph_Type")).equals("Teleportation")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PEBBLE.get()) {
													if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= 4) {
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
															if (entity instanceof Player _player)
																_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 8);
															if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 2));
															{
																Entity _ent = entity;
																if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																			("/tp @p placeholder".replace("placeholder", (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
																					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("location"))));
																}
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																final Vec3 _center = new Vec3(x, y, z);
																for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
																		.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
																	if (entityiterator instanceof LivingEntity) {
																		{
																			Entity _ent = entityiterator;
																			double _tx = (entity.getX());
																			double _ty = (entity.getY());
																			double _tz = (entity.getZ());
																			_ent.teleportTo(_tx, _ty, _tz);
																			if (_ent instanceof ServerPlayer _serverPlayer)
																				_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
																		}
																	}
																}
															}
														}
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
															if (entity instanceof Player _player)
																_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 4);
															if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 1));
															{
																Entity _ent = entity;
																if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																			("/tp @p placeholder".replace("placeholder", (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
																					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("location"))));
																}
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																final Vec3 _center = new Vec3(x, y, z);
																for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
																		.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
																	if (entityiterator instanceof LivingEntity) {
																		{
																			Entity _ent = entityiterator;
																			double _tx = (entity.getX());
																			double _ty = (entity.getY());
																			double _tz = (entity.getZ());
																			_ent.teleportTo(_tx, _ty, _tz);
																			if (_ent instanceof ServerPlayer _serverPlayer)
																				_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
																		}
																	}
																}
															}
														}
													}
													MonstrousWorldMod.queueServerWork(20, () -> {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")),
																		SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1,
																		false);
															}
														}
													});
												} else {
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You need a pebble linked to another location..."), true);
												}
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You must stand on a Teleportation Glyph to use this ability"), true);
										}
									}
								}
							}
						} else {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar >= 2) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 1) {
										if (!(entity instanceof LivingEntity _livEnt75 && _livEnt75.hasEffect(MobEffects.LEVITATION))) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 0));
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar >= 2) {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 2;
														_vars.markSyncDirty();
													}
												}
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
														_vars.markSyncDirty();
													}
												}
											}
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 2) {
										if (!(entity instanceof LivingEntity _livEnt78 && _livEnt78.hasEffect(MobEffects.FIRE_RESISTANCE))) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0));
											if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar >= 2) {
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 2;
														_vars.markSyncDirty();
													}
												}
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
														_vars.markSyncDirty();
													}
												}
											}
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 4) {
										if (!(!world.getEntitiesOfClass(HelperSpiritEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(30 / 2d), e -> true).isEmpty())) {
											if (world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HELPER_SPIRIT.get().spawn(_level, BlockPos.containing(x, y + 2, z), MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
													}
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HELPER_SPIRIT.get().spawn(_level, BlockPos.containing(x, y + 2, z), MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
													}
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = MonstrousWorldModEntities.HELPER_SPIRIT.get().spawn(_level, BlockPos.containing(x, y + 2, z), MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
													}
												}
												{
													final Vec3 _center = new Vec3(x, y, z);
													for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
														if (entityiterator instanceof HelperSpiritEntity) {
															entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
															if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
																_toTame.tame(_owner);
														}
													}
												}
												if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar >= 2) {
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 2;
															_vars.markSyncDirty();
														}
													}
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
															_vars.markSyncDirty();
														}
													}
												}
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You cannot summon too many spirit helpers at once!"), true);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Magic_Type == 3) {
										if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()
												|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == MonstrousWorldModBlocks.CENTER_GLYPH.get()) {
											if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "Glyph_Type")).equals("Teleportation")) {
												if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PEBBLE.get()) {
													if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar >= 2) {
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 2;
																_vars.markSyncDirty();
															}
															if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 2));
															{
																Entity _ent = entity;
																if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																			("/tp @p placeholder".replace("placeholder", (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
																					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("location"))));
																}
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																final Vec3 _center = new Vec3(x, y, z);
																for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
																		.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
																	if (entityiterator instanceof LivingEntity) {
																		{
																			Entity _ent = entityiterator;
																			double _tx = (entity.getX());
																			double _ty = (entity.getY());
																			double _tz = (entity.getZ());
																			_ent.teleportTo(_tx, _ty, _tz);
																			if (_ent instanceof ServerPlayer _serverPlayer)
																				_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
																		}
																	}
																}
															}
														}
														if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
																_vars.markSyncDirty();
															}
															if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
																_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 220, 1));
															{
																Entity _ent = entity;
																if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																	_ent.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																					_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																			("/tp @p placeholder".replace("placeholder", (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
																					.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("location"))));
																}
															}
															if (world instanceof Level _level) {
																if (!_level.isClientSide()) {
																	_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
																} else {
																	_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
																}
															}
															{
																final Vec3 _center = new Vec3(x, y, z);
																for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
																		.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
																	if (entityiterator instanceof LivingEntity) {
																		{
																			Entity _ent = entityiterator;
																			double _tx = (entity.getX());
																			double _ty = (entity.getY());
																			double _tz = (entity.getZ());
																			_ent.teleportTo(_tx, _ty, _tz);
																			if (_ent instanceof ServerPlayer _serverPlayer)
																				_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
																		}
																	}
																}
															}
														}
													}
													MonstrousWorldMod.queueServerWork(20, () -> {
														if (world instanceof Level _level) {
															if (!_level.isClientSide()) {
																_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")),
																		SoundSource.NEUTRAL, 1, 1);
															} else {
																_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1,
																		false);
															}
														}
													});
												} else {
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("You need a pebble linked to another location..."), true);
												}
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You must stand on a Teleportation Glyph to use this ability"), true);
										}
									}
								}
							}
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You have no life force to draw this magic from"), true);
				}
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}