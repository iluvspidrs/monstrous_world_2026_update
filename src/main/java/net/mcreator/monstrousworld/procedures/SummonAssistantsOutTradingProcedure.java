package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.MutantSerpentEntity;
import net.mcreator.monstrousworld.entity.MutantEyeEntity;
import net.mcreator.monstrousworld.entity.FlyMutantEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class SummonAssistantsOutTradingProcedure {
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
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HANDHELD_RADIO.get()) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (getEntityScore("Assignments Out", entity) >= 1) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).AssistantsAreOut == false) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								for (int _i1 = 0; _i1 < getEntityScore("Vanishing Trade", entity); _i1++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.VANISHING_POWDER.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								for (int _i1 = 0; _i1 < getEntityScore("Frogify Trade", entity); _i1++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.FROGIFY_POWDER.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								for (int _i1 = 0; _i1 < getEntityScore("Paralysis Trade", entity); _i1++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.PARALYSIS_POWDER.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								for (int _i1 = 0; _i1 < getEntityScore("Chickenify Trade", entity); _i1++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.CHICKENIFY_POWDER.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								for (int _i1 = 0; _i1 < getEntityScore("Midas Curse Trade", entity); _i1++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.MIDAS_CURSE_POWDER.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								for (int _i1 = 0; _i1 < getEntityScore("Sinking Trade", entity); _i1++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.SINKING_POWDER.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								if (getEntityScore("Assignment 1 Type", entity) == 1) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.FLY_MUTANT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof FlyMutantEntity) {
												entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
												entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
												entityiterator.getPersistentData().putString("Assignment", "1");
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
											}
										}
									}
								}
								if (getEntityScore("Assignment 2 Type", entity) == 1) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.FLY_MUTANT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof FlyMutantEntity) {
												if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
													entityiterator.getPersistentData().putString("Assignment", "2");
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
												}
											}
										}
									}
								}
								if (getEntityScore("Assignment 3 Type", entity) == 1) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.FLY_MUTANT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof FlyMutantEntity) {
												if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
													if (!(entityiterator.getPersistentData().getString("Assignment")).equals("2")) {
														entityiterator.getPersistentData().putString("Assignment", "3");
														entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
														entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
													}
												}
											}
										}
									}
								}
								if (getEntityScore("Assignment 1 Type", entity) == 2) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_EYE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof MutantEyeEntity) {
												entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
												entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
												entityiterator.getPersistentData().putString("Assignment", "1");
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
											}
										}
									}
								}
								if (getEntityScore("Assignment 2 Type", entity) == 2) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_EYE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof MutantEyeEntity) {
												entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
												entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
												entityiterator.getPersistentData().putString("Assignment", "2");
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
											}
										}
									}
								}
								if (getEntityScore("Assignment 3 Type", entity) == 2) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_EYE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof MutantEyeEntity) {
												entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
												entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
												entityiterator.getPersistentData().putString("Assignment", "3");
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
											}
										}
									}
								}
								if (getEntityScore("Assignment 1 Type", entity) == 3) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_SERPENT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof MutantSerpentEntity) {
												entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
												entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
												entityiterator.getPersistentData().putString("Assignment", "1");
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
											}
										}
									}
								}
								if (getEntityScore("Assignment 2 Type", entity) == 3) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_SERPENT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof MutantSerpentEntity) {
												entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
												entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
												entityiterator.getPersistentData().putString("Assignment", "2");
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
											}
										}
									}
								}
								if (getEntityScore("Assignment 3 Type", entity) == 3) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_SERPENT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof MutantSerpentEntity) {
												entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
												entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
												entityiterator.getPersistentData().putString("Assignment", "3");
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
											}
										}
									}
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Assignments Out");
										if (_so == null)
											_so = _sc.addObjective("Assignments Out", ObjectiveCriteria.DUMMY, Component.literal("Assignments Out"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Assignment 1 Type");
										if (_so == null)
											_so = _sc.addObjective("Assignment 1 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 1 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Assignment 2 Type");
										if (_so == null)
											_so = _sc.addObjective("Assignment 2 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 2 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Assignment 3 Type");
										if (_so == null)
											_so = _sc.addObjective("Assignment 3 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 3 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Frogify Trade");
										if (_so == null)
											_so = _sc.addObjective("Frogify Trade", ObjectiveCriteria.DUMMY, Component.literal("Frogify Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Vanishing Trade");
										if (_so == null)
											_so = _sc.addObjective("Vanishing Trade", ObjectiveCriteria.DUMMY, Component.literal("Vanishing Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Chickenify Trade");
										if (_so == null)
											_so = _sc.addObjective("Chickenify Trade", ObjectiveCriteria.DUMMY, Component.literal("Chickenify Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Paralysis Trade");
										if (_so == null)
											_so = _sc.addObjective("Paralysis Trade", ObjectiveCriteria.DUMMY, Component.literal("Paralysis Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Midas Curse Trade");
										if (_so == null)
											_so = _sc.addObjective("Midas Curse Trade", ObjectiveCriteria.DUMMY, Component.literal("Midas Curse Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Sinking Trade");
										if (_so == null)
											_so = _sc.addObjective("Sinking Trade", ObjectiveCriteria.DUMMY, Component.literal("Sinking Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								});
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your assistant(s) are still out trading"), true);
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You haven't sent out any assistants to trade"), true);
						}
					} else {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
							if (getEntityScore("Assignments Out", entity) >= 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).AssistantsAreOut == false) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									for (int _i1 = 0; _i1 < getEntityScore("Vanishing Trade", entity); _i1++) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.VANISHING_POWDER.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
									for (int _i1 = 0; _i1 < getEntityScore("Frogify Trade", entity); _i1++) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.FROGIFY_POWDER.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
									for (int _i1 = 0; _i1 < getEntityScore("Paralysis Trade", entity); _i1++) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.PARALYSIS_POWDER.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
									for (int _i1 = 0; _i1 < getEntityScore("Chickenify Trade", entity); _i1++) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.CHICKENIFY_POWDER.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
									for (int _i1 = 0; _i1 < getEntityScore("Midas Curse Trade", entity); _i1++) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.MIDAS_CURSE_POWDER.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
									for (int _i1 = 0; _i1 < getEntityScore("Sinking Trade", entity); _i1++) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.SINKING_POWDER.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									}
									if (getEntityScore("Assignment 1 Type", entity) == 1) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.FLY_MUTANT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof FlyMutantEntity) {
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Assignment", "1");
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
												}
											}
										}
									}
									if (getEntityScore("Assignment 2 Type", entity) == 1) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.FLY_MUTANT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof FlyMutantEntity) {
													if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
														entityiterator.getPersistentData().putString("Assignment", "2");
														entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
														entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
														if (entity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
													}
												}
											}
										}
									}
									if (getEntityScore("Assignment 3 Type", entity) == 1) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.FLY_MUTANT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof FlyMutantEntity) {
													if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
														if (!(entityiterator.getPersistentData().getString("Assignment")).equals("2")) {
															entityiterator.getPersistentData().putString("Assignment", "3");
															entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
															entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
														}
													}
												}
											}
										}
									}
									if (getEntityScore("Assignment 1 Type", entity) == 2) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_EYE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof MutantEyeEntity) {
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Assignment", "1");
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
												}
											}
										}
									}
									if (getEntityScore("Assignment 2 Type", entity) == 2) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_EYE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof MutantEyeEntity) {
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Assignment", "2");
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
												}
											}
										}
									}
									if (getEntityScore("Assignment 3 Type", entity) == 2) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_EYE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof MutantEyeEntity) {
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Assignment", "3");
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
												}
											}
										}
									}
									if (getEntityScore("Assignment 1 Type", entity) == 3) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_SERPENT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof MutantSerpentEntity) {
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Assignment", "1");
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
												}
											}
										}
									}
									if (getEntityScore("Assignment 2 Type", entity) == 3) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_SERPENT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof MutantSerpentEntity) {
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Assignment", "2");
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
												}
											}
										}
									}
									if (getEntityScore("Assignment 3 Type", entity) == 3) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_SERPENT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entityToSpawn != null) {
												entityToSpawn.setDeltaMovement(0, 0, 0);
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if (entityiterator instanceof MutantSerpentEntity) {
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Assignment", "3");
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your assistant returns from trading!"), true);
												}
											}
										}
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Assignments Out");
											if (_so == null)
												_so = _sc.addObjective("Assignments Out", ObjectiveCriteria.DUMMY, Component.literal("Assignments Out"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Assignment 1 Type");
											if (_so == null)
												_so = _sc.addObjective("Assignment 1 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 1 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Assignment 2 Type");
											if (_so == null)
												_so = _sc.addObjective("Assignment 2 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 2 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Assignment 3 Type");
											if (_so == null)
												_so = _sc.addObjective("Assignment 3 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 3 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Frogify Trade");
											if (_so == null)
												_so = _sc.addObjective("Frogify Trade", ObjectiveCriteria.DUMMY, Component.literal("Frogify Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Vanishing Trade");
											if (_so == null)
												_so = _sc.addObjective("Vanishing Trade", ObjectiveCriteria.DUMMY, Component.literal("Vanishing Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Chickenify Trade");
											if (_so == null)
												_so = _sc.addObjective("Chickenify Trade", ObjectiveCriteria.DUMMY, Component.literal("Chickenify Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Paralysis Trade");
											if (_so == null)
												_so = _sc.addObjective("Paralysis Trade", ObjectiveCriteria.DUMMY, Component.literal("Paralysis Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Midas Curse Trade");
											if (_so == null)
												_so = _sc.addObjective("Midas Curse Trade", ObjectiveCriteria.DUMMY, Component.literal("Midas Curse Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Sinking Trade");
											if (_so == null)
												_so = _sc.addObjective("Sinking Trade", ObjectiveCriteria.DUMMY, Component.literal("Sinking Trade"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
									});
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your assistant(s) are still out trading"), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You haven't sent out any assistants to trade"), true);
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("This baffles you"), true);
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You don't seem to have a use for this"), true);
				}
			}
		}
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}