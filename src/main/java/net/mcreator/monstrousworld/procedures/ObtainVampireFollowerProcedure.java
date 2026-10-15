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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.VampireNPCEntity;
import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class ObtainVampireFollowerProcedure {
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
		if (!world.isClientSide()) {
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
					if (entity.getPersistentData().getBoolean("vampire") == true) {
						if (!(entity instanceof VampireNPCEntity)) {
							if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AMULET_OF_FOLLOWING.get()) {
								if (sourceentity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.MAIN_HAND, true);
								if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
									if (sourceentity instanceof LivingEntity _entity) {
										ItemStack _setstack10 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack10.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack10);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
								}
								if (sourceentity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:fanged_following"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
								entity.getPersistentData().putString("Owner", (sourceentity.getDisplayName().getString()));
								entity.setCustomName(Component.literal(("placeholder's Follower".replace("placeholder", sourceentity.getDisplayName().getString()))));
								if (entity instanceof SocietyGoonEntity || entity instanceof AggressiveGuardEntity) {
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_ultimate_irony"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									final Vec3 _center = new Vec3(x, y, z);
									for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList()) {
										if (entityiterator instanceof ServerPlayer) {
											if ((entityiterator.getDisplayName().getString()).equals(entity.getPersistentData().getString("Owner"))) {
												if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
													{
														Entity _ent = entityiterator;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Has Follower");
														if (_so == null)
															_so = _sc.addObjective("Has Follower", ObjectiveCriteria.DUMMY, Component.literal("Has Follower"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Has Follower", entityiterator) + 1);
													}
													{
														Entity _ent = entityiterator;
														Scoreboard _sc = _ent.level().getScoreboard();
														Objective _so = _sc.getObjective("Faction Points");
														if (_so == null)
															_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
														_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entityiterator) + 1);
													}
													MonstrousWorldMod.queueServerWork(1, () -> {
														if (entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
															if (getEntityScore("Faction Points", entityiterator) >= 3) {
																{
																	MonstrousWorldModVariables.PlayerVariables _vars = entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																	_vars.FactionLevel = 4;
																	_vars.markSyncDirty();
																}
																{
																	Entity _ent = entityiterator;
																	Scoreboard _sc = _ent.level().getScoreboard();
																	Objective _so = _sc.getObjective("Faction Points");
																	if (_so == null)
																		_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
																	_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
																}
																if (entityiterator instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("You advance a level!"), true);
															}
														}
													});
												}
											}
										}
									}
								}
							}
							if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AMULET_OF_RESERVE.get()) {
								if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
									if (!(entity.getPersistentData().getString("Reserve")).equals("true")) {
										if (sourceentity instanceof LivingEntity _entity)
											_entity.swing(InteractionHand.MAIN_HAND, true);
										if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
											if (sourceentity instanceof LivingEntity _entity) {
												ItemStack _setstack42 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
												_setstack42.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
												_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack42);
												if (_entity instanceof Player _player)
													_player.getInventory().setChanged();
											}
										}
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your follower gains better self control and can now gather blood..."), false);
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your reputation improves!"), true);
										entity.getPersistentData().putString("Reserve", "true");
										if (entity instanceof Mob) {
											try {
												((Mob) entity).setTarget(null);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 10;
											_vars.markSyncDirty();
										}
										MonstrousWorldMod.queueServerWork(1, () -> {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.Reputation = 100;
													_vars.markSyncDirty();
												}
											}
										});
									}
								}
							}
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You can only convince converted vampires to follow you"), true);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You aren't yet skilled enough to use this"), true);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You have no use for this"), true);
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