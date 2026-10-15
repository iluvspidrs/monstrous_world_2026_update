package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.SwampmonsterVillagerEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class TribalMembersReturnProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (world.dayTime() % 24000 == 200) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).AssistantsAreOut == true) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
							if ((entity.level().dimension()) == Level.OVERWORLD) {
								for (int _i1 = 0; _i1 < getEntityScore("Assignments Out", entity) * Mth.nextInt(RandomSource.create(), 3, 5); _i1++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()),
												new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:swamp_treasure_common"))).getRandomElement(RandomSource.create())
														.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 0, getEntityScore("Assignments Out", entity)); _i1++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()),
												new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:swamp_treasure_rare"))).getRandomElement(RandomSource.create())
														.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								if (getEntityScore("Assignments Out", entity) >= 1) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.SWAMPMONSTER_VILLAGER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof SwampmonsterVillagerEntity) {
												entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
												entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
												entityiterator.getPersistentData().putString("Assignment", "1");
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if (world.dayTime() % 24000 == 201) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).AssistantsAreOut == true) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
							if ((entity.level().dimension()) == Level.OVERWORLD) {
								if (getEntityScore("Assignments Out", entity) >= 2) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.SWAMPMONSTER_VILLAGER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof SwampmonsterVillagerEntity) {
												if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
													entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
													entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
													entityiterator.getPersistentData().putString("Assignment", "2");
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
			if (world.dayTime() % 24000 == 202) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).AssistantsAreOut == true) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
							if ((entity.level().dimension()) == Level.OVERWORLD) {
								if (getEntityScore("Assignments Out", entity) == 3) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.SWAMPMONSTER_VILLAGER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									{
										final Vec3 _center = new Vec3(x, y, z);
										for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList()) {
											if (entityiterator instanceof SwampmonsterVillagerEntity) {
												if (!(entityiterator.getPersistentData().getString("Assignment")).equals("1")) {
													if (!(entityiterator.getPersistentData().getString("Assignment")).equals("2")) {
														entityiterator.setCustomName(Component.literal(entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
														entityiterator.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
														entityiterator.getPersistentData().putString("Assignment", "3");
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
			if (world.dayTime() % 24000 == 203) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).AssistantsAreOut == true) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
							if ((entity.level().dimension()) == Level.OVERWORLD) {
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Assignments Out");
									if (_so == null)
										_so = _sc.addObjective("Assignments Out", ObjectiveCriteria.DUMMY, Component.literal("Assignments Out"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
								}
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.AssistantsAreOut = false;
									_vars.markSyncDirty();
								}
							}
						}
					}
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