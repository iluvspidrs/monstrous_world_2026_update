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
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.MonsterVillageMarkerEntity;
import net.mcreator.monstrousworld.entity.GoblinVillagerEntity;
import net.mcreator.monstrousworld.entity.GoblinFollowerEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class BabyVillagerBecomesFollowerProcedure {
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
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.COOKIE_OF_TRANSFORMATION.get()) {
			if (entity instanceof Villager) {
				if (entity instanceof LivingEntity _livEnt3 && _livEnt3.isBaby()) {
					if (!world.getEntitiesOfClass(MonsterVillageMarkerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty()) {
						if (!world.getEntitiesOfClass(GoblinVillagerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(150 / 2d), e -> true).isEmpty()) {
							if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
								if (sourceentity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.COOKIE_OF_TRANSFORMATION.get());
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = MonstrousWorldModEntities.GOBLIN_FOLLOWER.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									final Vec3 _center = new Vec3(x, y, z);
									for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList()) {
										if (entityiterator instanceof GoblinFollowerEntity) {
											entityiterator.getPersistentData().putString("Owner", (entity.getPersistentData().getString("Owner")));
											entityiterator.setCustomName(Component.literal(("Placeholder's Follower".replace("Placeholder", entity.getPersistentData().getString("Owner")))));
										}
									}
								}
								{
									final Vec3 _center = new Vec3(x, y, z);
									for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList()) {
										if (entityiterator instanceof ServerPlayer) {
											if ((entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("Owner"))) {
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
													if (entityiterator instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
													{
														MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.Reputation = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
														_vars.markSyncDirty();
													}
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.Reputation = -100;
																_vars.markSyncDirty();
															}
														}
													});
													if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
														{
															Entity _ent = entityiterator;
															Scoreboard _sc = _ent.level().getScoreboard();
															Objective _so = _sc.getObjective("create_goblin_follower");
															if (_so == null)
																_so = _sc.addObjective("create_goblin_follower", ObjectiveCriteria.DUMMY, Component.literal("create_goblin_follower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
															_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("create_goblin_follower", entityiterator) + 1);
														}
														MonstrousWorldMod.queueServerWork(1, () -> {
															if (getEntityScore("create_goblin_follower", entityiterator) >= 3) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 6;
																	_vars.markSyncDirty();
																}
																if (world instanceof Level _level) {
																	if (!_level.isClientSide()) {
																		_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
																	} else {
																		_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
																	}
																}
																if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("You advance one level!"), true);
																if (entityiterator instanceof ServerPlayer _player) {
																	AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:your_own_troop"));
																	if (_adv != null) {
																		AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
																		if (!_ap.isDone()) {
																			for (String criteria : _ap.getRemainingCriteria())
																				_player.getAdvancements().award(_adv, criteria);
																		}
																	}
																}
															}
														});
													}
												}
											}
										}
									}
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (!entity.level().isClientSide())
										entity.discard();
								});
							}
						}
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You must take this baby villager to a goblin village first..."), true);
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