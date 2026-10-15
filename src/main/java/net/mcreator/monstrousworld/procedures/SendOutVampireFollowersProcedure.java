package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.Witch1Entity;
import net.mcreator.monstrousworld.entity.VampireNPCEntity;
import net.mcreator.monstrousworld.entity.SorcererNPCEntity;
import net.mcreator.monstrousworld.entity.FeralVampireEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SendOutVampireFollowersProcedure {
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
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLOODLETTER.get()) {
				if (sourceentity instanceof Player _player)
					_player.closeContainer();
				if (entity.getPersistentData().getBoolean("vampire") == true) {
					if (!(entity instanceof VampireNPCEntity)) {
						if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
								if ((entity.getPersistentData().getString("Reserve")).equals("true")) {
									if (!(world instanceof Level _lvl9 && _lvl9.isDay())) {
										if (sourceentity instanceof Player _player) {
											ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.BLOODLETTER.get());
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Your follower has gone to collect blood and will return by sunrise"), true);
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.AssistantsAreOut = true;
											_vars.markSyncDirty();
										}
										if (getEntityScore("Assignments Out", sourceentity) == 0) {
											{
												Entity _ent = sourceentity;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("Assignments Out");
												if (_so == null)
													_so = _sc.addObjective("Assignments Out", ObjectiveCriteria.DUMMY, Component.literal("Assignments Out"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Assignments Out", sourceentity) + 1);
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Assignment1 = entity.getDisplayName().getString();
												_vars.markSyncDirty();
											}
											{
												Entity _ent = sourceentity;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("Assignment 1 Type");
												if (_so == null)
													_so = _sc.addObjective("Assignment 1 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 1 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) entity.getPersistentData().getDouble("Vampire Type"));
											}
											if (entity instanceof FeralVampireEntity) {
												{
													Entity _ent = sourceentity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Vampire Skin 1");
													if (_so == null)
														_so = _sc.addObjective("Vampire Skin 1", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 1"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so)
															.set((int) (entity instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0));
												}
											}
											if (entity instanceof Witch1Entity) {
												{
													Entity _ent = sourceentity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Vampire Skin 1");
													if (_so == null)
														_so = _sc.addObjective("Vampire Skin 1", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 1"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) (entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Skin) : 0));
												}
											}
											if (entity instanceof SorcererNPCEntity) {
												{
													Entity _ent = sourceentity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Vampire Skin 1");
													if (_so == null)
														_so = _sc.addObjective("Vampire Skin 1", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 1"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so)
															.set((int) (entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Skin) : 0));
												}
											}
											if (entity instanceof Villager) {
												entity.getPersistentData().putBoolean("Follower", true);
											}
											if (!entity.level().isClientSide())
												entity.discard();
										} else if (getEntityScore("Assignments Out", sourceentity) == 1) {
											{
												Entity _ent = sourceentity;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("Assignments Out");
												if (_so == null)
													_so = _sc.addObjective("Assignments Out", ObjectiveCriteria.DUMMY, Component.literal("Assignments Out"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Assignments Out", sourceentity) + 1);
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Assignment2 = entity.getDisplayName().getString();
												_vars.markSyncDirty();
											}
											{
												Entity _ent = sourceentity;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("Assignment 2 Type");
												if (_so == null)
													_so = _sc.addObjective("Assignment 2 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 2 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) entity.getPersistentData().getDouble("Vampire Type"));
											}
											if (entity instanceof FeralVampireEntity) {
												{
													Entity _ent = sourceentity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Vampire Skin 2");
													if (_so == null)
														_so = _sc.addObjective("Vampire Skin 2", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 2"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so)
															.set((int) (entity instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0));
												}
											}
											if (entity instanceof Witch1Entity) {
												{
													Entity _ent = sourceentity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Vampire Skin 2");
													if (_so == null)
														_so = _sc.addObjective("Vampire Skin 2", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 2"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) (entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Skin) : 0));
												}
											}
											if (entity instanceof SorcererNPCEntity) {
												{
													Entity _ent = sourceentity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Vampire Skin 2");
													if (_so == null)
														_so = _sc.addObjective("Vampire Skin 2", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 2"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so)
															.set((int) (entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Skin) : 0));
												}
											}
											if (entity instanceof Villager) {
												entity.getPersistentData().putBoolean("Follower", true);
											}
											if (!entity.level().isClientSide())
												entity.discard();
										} else if (getEntityScore("Assignments Out", sourceentity) == 2) {
											{
												Entity _ent = sourceentity;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("Assignments Out");
												if (_so == null)
													_so = _sc.addObjective("Assignments Out", ObjectiveCriteria.DUMMY, Component.literal("Assignments Out"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Assignments Out", sourceentity) + 1);
											}
											{
												Entity _ent = sourceentity;
												Scoreboard _sc = _ent.level().getScoreboard();
												Objective _so = _sc.getObjective("Assignment 3 Type");
												if (_so == null)
													_so = _sc.addObjective("Assignment 3 Type", ObjectiveCriteria.DUMMY, Component.literal("Assignment 3 Type"), ObjectiveCriteria.RenderType.INTEGER, true, null);
												_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) entity.getPersistentData().getDouble("Vampire Type"));
											}
											if (entity instanceof FeralVampireEntity) {
												{
													Entity _ent = sourceentity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Vampire Skin 3");
													if (_so == null)
														_so = _sc.addObjective("Vampire Skin 3", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 3"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so)
															.set((int) (entity instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0));
												}
											}
											if (entity instanceof Witch1Entity) {
												{
													Entity _ent = sourceentity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Vampire Skin 3");
													if (_so == null)
														_so = _sc.addObjective("Vampire Skin 3", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 3"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) (entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Skin) : 0));
												}
											}
											if (entity instanceof SorcererNPCEntity) {
												{
													Entity _ent = sourceentity;
													Scoreboard _sc = _ent.level().getScoreboard();
													Objective _so = _sc.getObjective("Vampire Skin 3");
													if (_so == null)
														_so = _sc.addObjective("Vampire Skin 3", ObjectiveCriteria.DUMMY, Component.literal("Vampire Skin 3"), ObjectiveCriteria.RenderType.INTEGER, true, null);
													_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so)
															.set((int) (entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Skin) : 0));
												}
											}
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Assignment3 = entity.getDisplayName().getString();
												_vars.markSyncDirty();
											}
											if (entity instanceof Villager) {
												entity.getPersistentData().putBoolean("Follower", true);
											}
											if (!entity.level().isClientSide())
												entity.discard();
										} else {
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You have sent out the max number of followers for tonight"), true);
										}
									} else {
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("You cannot send out followers during the day"), true);
									}
								} else {
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("Your follower does not have the self control to collect blood yet"), true);
								}
							} else {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This vampire no longer follows you"), true);
							}
						}
					}
				}
			}
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AMULET_OF_RESERVE.get()) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
					if (sourceentity instanceof Player _player)
						_player.closeContainer();
					if (entity.getPersistentData().getBoolean("vampire") == true || entity instanceof LivingEntity _livEnt74 && _livEnt74.hasEffect(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY)) {
						if (!(entity instanceof VampireNPCEntity)) {
							if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
								if (!(entity.getPersistentData().getString("Reserve")).equals("true")) {
									entity.getPersistentData().putString("Reserve", "true");
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This vampire has been granted self-control!"), false);
									if (sourceentity instanceof LivingEntity _entity) {
										ItemStack _setstack83 = new ItemStack(MonstrousWorldModItems.AMULET_OF_RESERVE.get()).copy();
										_setstack83.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack83);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
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

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}