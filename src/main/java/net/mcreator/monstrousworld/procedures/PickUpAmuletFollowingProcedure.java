package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PickUpAmuletFollowingProcedure {
	@SubscribeEvent
	public static void onPickup(ItemEntityPickupEvent.Pre event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getItemEntity().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (itemstack.getItem() == MonstrousWorldModItems.AMULET_OF_FOLLOWING.get()) {
				if (entity instanceof Player || entity instanceof ServerPlayer) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							if (getEntityScore("Amulet of Following Created", entity) == 0) {
								{
									Entity _ent = entity;
									Scoreboard _sc = _ent.level().getScoreboard();
									Objective _so = _sc.getObjective("Amulet of Following Created");
									if (_so == null)
										_so = _sc.addObjective("Amulet of Following Created", ObjectiveCriteria.DUMMY, Component.literal("Amulet of Following Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
									_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
								}
							}
							if (getEntityScore("Amulet Placed", entity) == 1) {
								if (getEntityScore("Amulet of Following Created", entity) == 1) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 3;
										_vars.markSyncDirty();
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You advance a level!"), false);
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Amulet Placed");
										if (_so == null)
											_so = _sc.addObjective("Amulet Placed", ObjectiveCriteria.DUMMY, Component.literal("Amulet Placed"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof LivingEntity _entity) {
										AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampirearmor3"), 5, AttributeModifier.Operation.ADD_VALUE);
										if (!_entity.getAttribute(Attributes.ARMOR).hasModifier(modifier.id())) {
											_entity.getAttribute(Attributes.ARMOR).addPermanentModifier(modifier);
										}
									}
									if (entity instanceof LivingEntity _entity) {
										AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:vampireattackstrength3"), 2, AttributeModifier.Operation.ADD_VALUE);
										if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
											_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
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