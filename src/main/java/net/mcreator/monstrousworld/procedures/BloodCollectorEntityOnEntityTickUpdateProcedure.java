package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import java.util.Comparator;

public class BloodCollectorEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.BLOOD_COLLECTOR.get()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof ServerPlayer) {
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Regeneration") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Regeneration") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Regeneration") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Speed") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Speed") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Speed") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Strength") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Strength") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Strength") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fire Resistance") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fire Resistance") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fire Resistance") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Dolphins Grace") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Dolphins Grace") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Dolphins Grace") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Jump Boost") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Jump Boost") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Jump Boost") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slow Falling") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slow Falling") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slow Falling") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Haste") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Haste") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Haste") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hypnosis") == 1) {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost", 1);
							} else {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost", 0);
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hypnosis Boost 2") == 2) {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost 2", 2);
							} else {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost 2", 0);
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hypnosis Boost 3") == 3) {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost 3", 3);
							} else {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost 3", 0);
							}
						}
					}
					if (entityiterator instanceof LivingEntity) {
						if (entityiterator.getPersistentData().getBoolean("vampire") == true) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Regeneration") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Regeneration") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Regeneration") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Speed") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Speed") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Speed") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Strength") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Strength") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Strength") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fire Resistance") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fire Resistance") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fire Resistance") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Dolphins Grace") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Dolphins Grace") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Dolphins Grace") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Jump Boost") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Jump Boost") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Jump Boost") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slow Falling") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slow Falling") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slow Falling") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Haste") == 1) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 220, 0));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Haste") == 2) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 220, 1));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Haste") == 3) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 220, 2));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hypnosis") == 1) {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost", 1);
							} else {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost", 0);
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hypnosis Boost 2") == 2) {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost 2", 2);
							} else {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost 2", 0);
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hypnosis Boost 3") == 3) {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost 3", 3);
							} else {
								entityiterator.getPersistentData().putDouble("Hypnosis Boost 3", 0);
							}
						}
					}
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.UPGRADED_BLOOD_COLLECTOR.get()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof ServerPlayer) {
						if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 || entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 220, 0));
							entityiterator.getPersistentData().putDouble("Hypnosis Boost", 1);
							if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
								if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
									if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == MonstrousWorldModBlocks.CLOSED_BAT_SNARE.get()) {
										if (getEntityScore("bat_unlocked", entityiterator) == 0) {
											if (world instanceof Level)
												((Level) world).playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")),
														SoundSource.NEUTRAL, 1, 1, false);
											{
												Entity _ent = entityiterator;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("bat_unlocked");
												if (_so == null)
													_so = _sc.addObjective("bat_unlocked", ObjectiveCriteria.DUMMY, Component.literal("bat_unlocked"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
											}
											if (entityiterator instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("The Collector infuses you with the ability to use Bat Form! Press [B] to toggle..."), false);
											if (entityiterator instanceof ServerPlayer _player) {
												AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:batform_unlocked"));
												if (_adv != null) {
													AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
													if (!_ap.isDone()) {
														for (String criteria : _ap.getRemainingCriteria())
															_player.getAdvancements().award(_adv, criteria);
													}
												}
											}
											{
												BlockPos _bp = BlockPos.containing(x, y + 1, z);
												BlockState _bs = MonstrousWorldModBlocks.EMPTY_BAT_SNARE.get().defaultBlockState();
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
					if (entityiterator instanceof LivingEntity) {
						if (entityiterator.getPersistentData().getBoolean("vampire") == true) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 220, 0));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 220, 0));
							entityiterator.getPersistentData().putDouble("Hypnosis Boost", 1);
						}
					}
				}
			}
		}
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.BLOOD_COLLECTOR.get())) {
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.UPGRADED_BLOOD_COLLECTOR.get())) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 200);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}