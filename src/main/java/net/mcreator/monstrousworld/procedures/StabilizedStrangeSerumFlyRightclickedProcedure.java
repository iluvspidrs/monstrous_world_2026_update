package net.mcreator.monstrousworld.procedures;

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

public class StabilizedStrangeSerumFlyRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1
							|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5
							|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
						if (getEntityScore("Food Tolerance", entity) == 0) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You gain improved movement speed and food tolerance!"), true);
							if (entity instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flyspeed"), 0.05, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
								}
							}
							if (entity instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:flyfalldamage"), 0, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).addPermanentModifier(modifier);
								}
							}
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack10 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack10.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack10);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Food Tolerance");
								if (_so == null)
									_so = _sc.addObjective("Food Tolerance", ObjectiveCriteria.DUMMY, Component.literal("Food Tolerance"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:genetic_modification"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You already have this modification"), true);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This can only affect humans..."), true);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("This won't affect you..."), true);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("This can only affect humans..."), true);
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