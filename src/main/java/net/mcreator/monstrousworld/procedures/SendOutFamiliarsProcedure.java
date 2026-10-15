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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.CatFamiliarEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class SendOutFamiliarsProcedure {
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
			if (entity instanceof CatFamiliarEntity) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
					if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.NAME_TAG)) {
						if (!sourceentity.isShiftKeyDown()) {
							if (getEntityScore("Assignments Out", sourceentity) < 3) {
								if ((sourceentity.getDisplayName().getString()).equals(entity.getPersistentData().getString("Owner"))) {
									sourceentity.getPersistentData().putString("Interaction", (entity.getStringUUID()));
									MonstrousWorldMod.queueServerWork(1, () -> {
										{
											final Vec3 _center = new Vec3(x, y, z);
											for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
													.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
												if ((entityiterator.getStringUUID()).equals(sourceentity.getPersistentData().getString("Interaction"))) {
													if (!entityiterator.level().isClientSide())
														entityiterator.discard();
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("Your familiar goes out to hunt and will return when you wake up..."), true);
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
															_vars.Assignment1 = entityiterator.getDisplayName().getString();
															_vars.markSyncDirty();
														}
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
															_vars.Assignment2 = entityiterator.getDisplayName().getString();
															_vars.markSyncDirty();
														}
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
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.Assignment3 = entityiterator.getDisplayName().getString();
															_vars.markSyncDirty();
														}
													}
												}
											}
										}
									});
								}
							} else {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You have sent out the max number of familiars for today..."), true);
							}
						}
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You must be a Witch or Warlock to send out Familiars"), true);
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