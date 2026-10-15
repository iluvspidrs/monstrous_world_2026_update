package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.ChannelerSparkEntity;

import java.util.Comparator;

public class RobotTableSectionEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof ChannelerSparkEntity) {
				if ((entity.getPersistentData().getString("RobotType")).equals("Spider")) {
					if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip4 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip4) : -1) == 5) {
						if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y, z))), "blockstate") instanceof IntegerProperty _getip6 ? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getip6) : -1) == 4
								&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y, z))), "blockstate") instanceof IntegerProperty _getip8 ? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getip8) : -1) == 6) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SPIDER_ROBOT_ACTIVE.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								int _value = 2;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x + 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 3;
								BlockPos _pos = BlockPos.containing(x - 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pull_the_switch"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
										}
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y, z))), "blockstate") instanceof IntegerProperty _getip18 ? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getip18) : -1) == 4
								&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y, z))), "blockstate") instanceof IntegerProperty _getip20
										? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getip20)
										: -1) == 6) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SPIDER_ROBOT_ACTIVE.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								int _value = 2;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x - 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 3;
								BlockPos _pos = BlockPos.containing(x + 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pull_the_switch"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
										}
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z - 1))), "blockstate") instanceof IntegerProperty _getip30 ? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getip30) : -1) == 4
								&& (getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z + 1))), "blockstate") instanceof IntegerProperty _getip32
										? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getip32)
										: -1) == 6) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SPIDER_ROBOT_ACTIVE.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								int _value = 2;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x, y, z - 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 3;
								BlockPos _pos = BlockPos.containing(x, y, z + 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pull_the_switch"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
										}
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z + 1))), "blockstate") instanceof IntegerProperty _getip42 ? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getip42) : -1) == 4
								&& (getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z - 1))), "blockstate") instanceof IntegerProperty _getip44
										? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getip44)
										: -1) == 6) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.SPIDER_ROBOT_ACTIVE.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								int _value = 2;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x, y, z + 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 3;
								BlockPos _pos = BlockPos.containing(x, y, z - 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:pull_the_switch"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 5, 1, 1, 1, 0.1);
				}
				if ((entity.getPersistentData().getString("RobotType")).equals("Guard")) {
					if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "blockstate") instanceof IntegerProperty _getip56 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip56) : -1) == 8) {
						if ((getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y, z))), "blockstate") instanceof IntegerProperty _getip58 ? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getip58) : -1) == 7
								&& (getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y, z))), "blockstate") instanceof IntegerProperty _getip60
										? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getip60)
										: -1) == 9) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.GUARD_ROBOT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								int _value = 2;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x + 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 3;
								BlockPos _pos = BlockPos.containing(x - 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:its_alive"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
										}
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x - 1, y, z))), "blockstate") instanceof IntegerProperty _getip70 ? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getip70) : -1) == 7
								&& (getPropertyByName((world.getBlockState(BlockPos.containing(x + 1, y, z))), "blockstate") instanceof IntegerProperty _getip72
										? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getip72)
										: -1) == 9) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.GUARD_ROBOT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								int _value = 2;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x - 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 3;
								BlockPos _pos = BlockPos.containing(x + 1, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:its_alive"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
										}
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z - 1))), "blockstate") instanceof IntegerProperty _getip82 ? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getip82) : -1) == 7
								&& (getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z + 1))), "blockstate") instanceof IntegerProperty _getip84
										? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getip84)
										: -1) == 9) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.GUARD_ROBOT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								int _value = 2;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x, y, z - 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 3;
								BlockPos _pos = BlockPos.containing(x, y, z + 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:its_alive"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
										}
									}
								}
							}
						} else if ((getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z + 1))), "blockstate") instanceof IntegerProperty _getip94 ? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getip94) : -1) == 7
								&& (getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z - 1))), "blockstate") instanceof IntegerProperty _getip96
										? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getip96)
										: -1) == 9) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = MonstrousWorldModEntities.GUARD_ROBOT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							{
								int _value = 2;
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 1;
								BlockPos _pos = BlockPos.containing(x, y, z + 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								int _value = 3;
								BlockPos _pos = BlockPos.containing(x, y, z - 1);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
							{
								final Vec3 _center = new Vec3(x, y, z);
								for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
										.toList()) {
									if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
										if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:its_alive"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 5, 1, 1, 1, 0.1);
				}
			}
		}
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}