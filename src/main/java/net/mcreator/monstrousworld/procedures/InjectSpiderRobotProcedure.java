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
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.SpiderRobotActiveEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InjectSpiderRobotProcedure {
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
			if (entity instanceof SpiderRobotActiveEntity) {
				if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SYRINGE_OF_MIDAS_CURSE.get()) {
						if (!((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("MidasCurse"))) {
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack11 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack11.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack11);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("MidasCurse");
								if (_so == null)
									_so = _sc.addObjective("MidasCurse", ObjectiveCriteria.DUMMY, Component.literal("MidasCurse"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(100);
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider set to Midas Curse mode. 100 bites left."), false);
							if (entity instanceof SpiderRobotActiveEntity _datEntSetS)
								_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "MidasCurse");
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider is already in Midas Curse mode"), false);
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SYRINGE_OF_PARALYSIS.get()) {
						if (!((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Paralysis"))) {
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack25 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack25.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack25);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Paralysis");
								if (_so == null)
									_so = _sc.addObjective("Paralysis", ObjectiveCriteria.DUMMY, Component.literal("Paralysis"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(100);
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider set to Paralysis mode. 100 bites left."), false);
							if (entity instanceof SpiderRobotActiveEntity _datEntSetS)
								_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "Paralysis");
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider is already in Paralysis mode"), false);
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SYRINGE_OF_SINKING.get()) {
						if (!((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Sinking"))) {
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack39 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack39.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack39);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Sinking");
								if (_so == null)
									_so = _sc.addObjective("Sinking", ObjectiveCriteria.DUMMY, Component.literal("Sinking"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(100);
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider set to Sinking mode. 100 bites left."), false);
							if (entity instanceof SpiderRobotActiveEntity _datEntSetS)
								_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "Sinking");
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider is already in Sinking mode"), false);
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SYRINGE_OF_VANISHING.get()) {
						if (!((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Vanishing"))) {
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack53 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack53.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack53);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Vanishing");
								if (_so == null)
									_so = _sc.addObjective("Vanishing", ObjectiveCriteria.DUMMY, Component.literal("Vanishing"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(100);
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider set to Vanishing mode. 100 bites left."), false);
							if (entity instanceof SpiderRobotActiveEntity _datEntSetS)
								_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "Vanishing");
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider is already in Vanishing mode"), false);
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SYRINGE_OF_FROGIFY.get()) {
						if (!((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Frogify"))) {
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack67 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack67.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack67);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Frogify");
								if (_so == null)
									_so = _sc.addObjective("Frogify", ObjectiveCriteria.DUMMY, Component.literal("Frogify"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(100);
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider set to Frogify mode. 100 bites left."), false);
							if (entity instanceof SpiderRobotActiveEntity _datEntSetS)
								_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "Frogify");
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider is already in Frogify mode"), false);
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SYRINGE_OF_CHICKENIFY.get()) {
						if (!((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Chickenify"))) {
							if (sourceentity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
								if (sourceentity instanceof LivingEntity _entity) {
									ItemStack _setstack81 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack81.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack81);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Chickenify");
								if (_so == null)
									_so = _sc.addObjective("Chickenify", ObjectiveCriteria.DUMMY, Component.literal("Chickenify"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(100);
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider set to Chickenify mode. 100 bites left."), false);
							if (entity instanceof SpiderRobotActiveEntity _datEntSetS)
								_datEntSetS.getEntityData().set(SpiderRobotActiveEntity.DATA_Mode, "Chickenify");
						} else {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Robot Spider is already in Chickenify mode"), false);
						}
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You can only inject robots under your control"), true);
				}
			}
		}
	}
}