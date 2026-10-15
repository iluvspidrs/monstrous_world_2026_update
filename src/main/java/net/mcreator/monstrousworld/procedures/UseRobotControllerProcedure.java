package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.TamableAnimal;
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
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.SpiderRobotActiveEntity;
import net.mcreator.monstrousworld.entity.GuardRobotEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class UseRobotControllerProcedure {
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
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ROBOT_CONTROLLER.get()) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
							if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true)) {
								if (!("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("dark_stone")) {
									if (entity instanceof SpiderRobotActiveEntity) {
										if (!(entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This Robot Spider will now obey you!"), true);
											entity.getPersistentData().putString("xx", ("" + entity.getX()));
											entity.getPersistentData().putString("yy", ("" + entity.getY()));
											entity.getPersistentData().putString("zz", ("" + entity.getZ()));
											entity.getPersistentData().putString("spawnlocation", "xx yy zz");
											entity.getPersistentData().putString("spawncommand", "/summon monstrous_world:spider_robot_active ~ ~ ~ {Owner:placeholder}");
											MonstrousWorldMod.queueServerWork(1, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
												entity.getPersistentData().putString("spawncommand", ((entity.getPersistentData().getString("spawncommand")).replace("placeholder", sourceentity.getDisplayName().getString())));
											});
											MonstrousWorldMod.queueServerWork(2, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
											});
											MonstrousWorldMod.queueServerWork(3, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
											});
											MonstrousWorldMod.queueServerWork(4, () -> {
												entity.getPersistentData().putString("spawncommand", ((entity.getPersistentData().getString("spawncommand")).replace("~ ~ ~", entity.getPersistentData().getString("spawnlocation"))));
											});
											MonstrousWorldMod.queueServerWork(5, () -> {
												{
													Entity _ent = sourceentity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands()
																.performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																				_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																		("placeholder".replace("placeholder", entity.getPersistentData().getString("spawncommand"))));
													}
												}
											});
											MonstrousWorldMod.queueServerWork(7, () -> {
												if (!entity.level().isClientSide())
													entity.discard();
											});
										} else {
											if (entity instanceof LivingEntity _livingEntity41 && _livingEntity41.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(ResourceLocation.parse("monstrous_world:robotpause"))) {
												if (entity instanceof LivingEntity _entity) {
													_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:robotpause"));
												}
												entity.getPersistentData().putBoolean("Sitting", false);
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Robot Spider will now follow"), true);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											} else {
												if (entity instanceof LivingEntity _entity) {
													AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:robotpause"), (-0.3), AttributeModifier.Operation.ADD_VALUE);
													if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
														_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
													}
												}
												entity.getPersistentData().putBoolean("Sitting", true);
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Robot Spider set to pause"), true);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal(("Health: placeholder / 200".replace("placeholder", "" + entity.getPersistentData().getDouble("Health")))), false);
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Paralysis")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Paralysis bites left".replace("placeholder", "" + getEntityScore("Paralysis", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("MidasCurse")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Midas Curse bites left".replace("placeholder", "" + getEntityScore("MidasCurse", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Vanishing")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Vanishing bites left".replace("placeholder", "" + getEntityScore("Vanishing", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Sinking")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Sinking bites left".replace("placeholder", "" + getEntityScore("Sinking", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Frogify")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Frogify bites left".replace("placeholder", "" + getEntityScore("Frogify", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Chickenify")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Chickenify bites left".replace("placeholder", "" + getEntityScore("Chickenify", entity)))), false);
												}
											}
										}
									}
									if (entity instanceof GuardRobotEntity) {
										if (!(entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This Robot Guard will now obey you!"), true);
											entity.getPersistentData().putString("xx", ("" + entity.getX()));
											entity.getPersistentData().putString("yy", ("" + entity.getY()));
											entity.getPersistentData().putString("zz", ("" + entity.getZ()));
											entity.getPersistentData().putString("spawnlocation", "xx yy zz");
											entity.getPersistentData().putString("spawncommand", "/summon monstrous_world:guard_robot ~ ~ ~ {Owner:placeholder}");
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
												if (sourceentity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:its_alive"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 6;
														_vars.markSyncDirty();
													}
												}
											}
											MonstrousWorldMod.queueServerWork(1, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
												entity.getPersistentData().putString("spawncommand", ((entity.getPersistentData().getString("spawncommand")).replace("placeholder", sourceentity.getDisplayName().getString())));
											});
											MonstrousWorldMod.queueServerWork(2, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
											});
											MonstrousWorldMod.queueServerWork(3, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
											});
											MonstrousWorldMod.queueServerWork(4, () -> {
												entity.getPersistentData().putString("spawncommand", ((entity.getPersistentData().getString("spawncommand")).replace("~ ~ ~", entity.getPersistentData().getString("spawnlocation"))));
											});
											MonstrousWorldMod.queueServerWork(5, () -> {
												{
													Entity _ent = sourceentity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands()
																.performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																				_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																		("placeholder".replace("placeholder", entity.getPersistentData().getString("spawncommand"))));
													}
												}
											});
											MonstrousWorldMod.queueServerWork(7, () -> {
												if (!entity.level().isClientSide())
													entity.discard();
											});
										} else {
											if (entity instanceof LivingEntity _livingEntity107 && _livingEntity107.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(ResourceLocation.parse("monstrous_world:robotpause"))) {
												if (entity instanceof LivingEntity _entity) {
													_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:robotpause"));
												}
												entity.getPersistentData().putBoolean("Sitting", false);
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Robot Guard will now follow"), true);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											} else {
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal(("Health: placeholder / 500".replace("placeholder", "" + entity.getPersistentData().getDouble("Health")))), false);
												if (entity instanceof LivingEntity _entity) {
													AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:robotpause"), (-0.3), AttributeModifier.Operation.ADD_VALUE);
													if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
														_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
													}
												}
												entity.getPersistentData().putBoolean("Sitting", true);
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Robot Guard set to pause"), true);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											}
										}
									}
								}
							}
						} else {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
								if (!("" + BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString()).contains("dark_stone")) {
									if (entity instanceof SpiderRobotActiveEntity) {
										if (!(entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This Robot Spider will now obey you!"), true);
											entity.getPersistentData().putString("xx", ("" + entity.getX()));
											entity.getPersistentData().putString("yy", ("" + entity.getY()));
											entity.getPersistentData().putString("zz", ("" + entity.getZ()));
											entity.getPersistentData().putString("spawnlocation", "xx yy zz");
											entity.getPersistentData().putString("spawncommand", "/summon monstrous_world:spider_robot_active ~ ~ ~ {Owner:placeholder}");
											MonstrousWorldMod.queueServerWork(1, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
												entity.getPersistentData().putString("spawncommand", ((entity.getPersistentData().getString("spawncommand")).replace("placeholder", sourceentity.getDisplayName().getString())));
											});
											MonstrousWorldMod.queueServerWork(2, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
											});
											MonstrousWorldMod.queueServerWork(3, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
											});
											MonstrousWorldMod.queueServerWork(4, () -> {
												entity.getPersistentData().putString("spawncommand", ((entity.getPersistentData().getString("spawncommand")).replace("~ ~ ~", entity.getPersistentData().getString("spawnlocation"))));
											});
											MonstrousWorldMod.queueServerWork(5, () -> {
												{
													Entity _ent = sourceentity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands()
																.performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																				_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																		("placeholder".replace("placeholder", entity.getPersistentData().getString("spawncommand"))));
													}
												}
											});
											MonstrousWorldMod.queueServerWork(7, () -> {
												if (!entity.level().isClientSide())
													entity.discard();
											});
										} else {
											if (entity instanceof LivingEntity _livingEntity156 && _livingEntity156.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(ResourceLocation.parse("monstrous_world:robotpause"))) {
												if (entity instanceof LivingEntity _entity) {
													_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:robotpause"));
												}
												entity.getPersistentData().putBoolean("Sitting", false);
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Robot Spider will now follow"), true);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											} else {
												if (entity instanceof LivingEntity _entity) {
													AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:robotpause"), (-0.3), AttributeModifier.Operation.ADD_VALUE);
													if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
														_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
													}
												}
												entity.getPersistentData().putBoolean("Sitting", true);
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Robot Spider set to pause"), true);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal(("Health: placeholder / 200".replace("placeholder", "" + entity.getPersistentData().getDouble("Health")))), false);
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Paralysis")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Paralysis bites left".replace("placeholder", "" + getEntityScore("Paralysis", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("MidasCurse")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Midas Curse bites left".replace("placeholder", "" + getEntityScore("MidasCurse", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Vanishing")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Vanishing bites left".replace("placeholder", "" + getEntityScore("Vanishing", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Sinking")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Sinking bites left".replace("placeholder", "" + getEntityScore("Sinking", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Frogify")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Frogify bites left".replace("placeholder", "" + getEntityScore("Frogify", entity)))), false);
												}
												if ((entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Chickenify")) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal(("placeholder Chickenify bites left".replace("placeholder", "" + getEntityScore("Chickenify", entity)))), false);
												}
											}
										}
									}
									if (entity instanceof GuardRobotEntity) {
										if (!(entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This Robot Guard will now obey you!"), true);
											entity.getPersistentData().putString("xx", ("" + entity.getX()));
											entity.getPersistentData().putString("yy", ("" + entity.getY()));
											entity.getPersistentData().putString("zz", ("" + entity.getZ()));
											entity.getPersistentData().putString("spawnlocation", "xx yy zz");
											entity.getPersistentData().putString("spawncommand", "/summon monstrous_world:guard_robot ~ ~ ~ {Owner:placeholder}");
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
												if (sourceentity instanceof ServerPlayer _player) {
													AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:its_alive"));
													if (_adv != null) {
														AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
														if (!_ap.isDone()) {
															for (String criteria : _ap.getRemainingCriteria())
																_player.getAdvancements().award(_adv, criteria);
														}
													}
												}
												if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.FactionLevel = 6;
														_vars.markSyncDirty();
													}
												}
											}
											MonstrousWorldMod.queueServerWork(1, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("xx", entity.getPersistentData().getString("xx"))));
												entity.getPersistentData().putString("spawncommand", ((entity.getPersistentData().getString("spawncommand")).replace("placeholder", sourceentity.getDisplayName().getString())));
											});
											MonstrousWorldMod.queueServerWork(2, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("yy", entity.getPersistentData().getString("yy"))));
											});
											MonstrousWorldMod.queueServerWork(3, () -> {
												entity.getPersistentData().putString("spawnlocation", ((entity.getPersistentData().getString("spawnlocation")).replace("zz", entity.getPersistentData().getString("zz"))));
											});
											MonstrousWorldMod.queueServerWork(4, () -> {
												entity.getPersistentData().putString("spawncommand", ((entity.getPersistentData().getString("spawncommand")).replace("~ ~ ~", entity.getPersistentData().getString("spawnlocation"))));
											});
											MonstrousWorldMod.queueServerWork(5, () -> {
												{
													Entity _ent = sourceentity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands()
																.performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																				_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																		("placeholder".replace("placeholder", entity.getPersistentData().getString("spawncommand"))));
													}
												}
											});
											MonstrousWorldMod.queueServerWork(7, () -> {
												if (!entity.level().isClientSide())
													entity.discard();
											});
										} else {
											if (entity instanceof LivingEntity _livingEntity222 && _livingEntity222.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(ResourceLocation.parse("monstrous_world:robotpause"))) {
												if (entity instanceof LivingEntity _entity) {
													_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(ResourceLocation.parse("monstrous_world:robotpause"));
												}
												entity.getPersistentData().putBoolean("Sitting", false);
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Robot Guard will now follow"), true);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											} else {
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal(("Health: placeholder / 500".replace("placeholder", "" + entity.getPersistentData().getDouble("Health")))), false);
												if (entity instanceof LivingEntity _entity) {
													AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:robotpause"), (-0.3), AttributeModifier.Operation.ADD_VALUE);
													if (!_entity.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier.id())) {
														_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
													}
												}
												entity.getPersistentData().putBoolean("Sitting", true);
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("Robot Guard set to pause"), true);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											}
										}
									}
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This baffles you"), true);
							}
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You need more skill before you can use this"), true);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You don't have the skill to use this"), true);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You need a Robot Controller for this creation..."), false);
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