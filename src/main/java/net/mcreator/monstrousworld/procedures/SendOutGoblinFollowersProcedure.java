package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.GoblinFollowerEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SendOutGoblinFollowersProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getTarget(), event.getEntity());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.WISP_LANTERN.get()) {
			if (entity instanceof GoblinFollowerEntity) {
				if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.WISP_LANTERN.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your follower goes to find enchanted items and will return at sunrise"), true);
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
								Entity _ent = sourceentity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Goblin Skin 1");
								if (_so == null)
									_so = _sc.addObjective("Goblin Skin 1", ObjectiveCriteria.DUMMY, Component.literal("Goblin Skin 1"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) (entity instanceof GoblinFollowerEntity _datEntI ? _datEntI.getEntityData().get(GoblinFollowerEntity.DATA_Skin) : 0));
							}
							{
								MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Assignment1 = entity.getDisplayName().getString();
								_vars.markSyncDirty();
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
								Entity _ent = sourceentity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Goblin Skin 2");
								if (_so == null)
									_so = _sc.addObjective("Goblin Skin 2", ObjectiveCriteria.DUMMY, Component.literal("Goblin Skin 2"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) (entity instanceof GoblinFollowerEntity _datEntI ? _datEntI.getEntityData().get(GoblinFollowerEntity.DATA_Skin) : 0));
							}
							{
								MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Assignment2 = entity.getDisplayName().getString();
								_vars.markSyncDirty();
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
								Objective _so = _sc.getObjective("Goblin Skin 3");
								if (_so == null)
									_so = _sc.addObjective("Goblin Skin 3", ObjectiveCriteria.DUMMY, Component.literal("Goblin Skin 3"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) (entity instanceof GoblinFollowerEntity _datEntI ? _datEntI.getEntityData().get(GoblinFollowerEntity.DATA_Skin) : 0));
							}
							{
								MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Assignment3 = entity.getDisplayName().getString();
								_vars.markSyncDirty();
							}
							if (!entity.level().isClientSide())
								entity.discard();
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You have sent out the max number of followers for tonight"), true);
						}
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Only Goblins can send out these Followers..."), true);
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