package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class CreateThumbProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.COMPUTER_CHIP.get()) {
			if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Dreadful Watcher DNA")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack5 = new ItemStack(MonstrousWorldModItems.COMPUTER_CHIP.get()).copy();
					_setstack5.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount() - 1);
					_menu.getSlots().get(0).set(_setstack5);
					ItemStack _setstack8 = new ItemStack(MonstrousWorldModItems.THUMB_DRIVE_DW.get()).copy();
					_setstack8.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount() + 1);
					_menu.getSlots().get(1).set(_setstack8);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
					if (getEntityScore("Laptops Crafted", entity) >= 1) {
						if (getEntityScore("Dreadful Watcher Thumbs Created", entity) == 0) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Dreadful Watcher Thumbs Created");
								if (_so == null)
									_so = _sc.addObjective("Dreadful Watcher Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Dreadful Watcher Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (getEntityScore("Faction Points", entity) >= 5) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 3;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You advance one level!"), true);
								}
							});
						}
					}
				}
			}
			if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Fly DNA")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack22 = new ItemStack(MonstrousWorldModItems.COMPUTER_CHIP.get()).copy();
					_setstack22.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount() - 1);
					_menu.getSlots().get(0).set(_setstack22);
					ItemStack _setstack25 = new ItemStack(MonstrousWorldModItems.THUMB_DRIVE_FLY.get()).copy();
					_setstack25.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount() + 1);
					_menu.getSlots().get(1).set(_setstack25);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
					if (getEntityScore("Laptops Crafted", entity) >= 1) {
						if (getEntityScore("Fly Thumbs Created", entity) == 0) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Fly Thumbs Created");
								if (_so == null)
									_so = _sc.addObjective("Fly Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Fly Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (getEntityScore("Faction Points", entity) >= 5) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 3;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You advance one level!"), true);
								}
							});
						}
					}
				}
			}
			if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Serpent DNA")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack39 = new ItemStack(MonstrousWorldModItems.COMPUTER_CHIP.get()).copy();
					_setstack39.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount() - 1);
					_menu.getSlots().get(0).set(_setstack39);
					ItemStack _setstack42 = new ItemStack(MonstrousWorldModItems.THUMB_DRIVE_SERPENT.get()).copy();
					_setstack42.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount() + 1);
					_menu.getSlots().get(1).set(_setstack42);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
					if (getEntityScore("Laptops Crafted", entity) >= 1) {
						if (getEntityScore("Serpent Thumbs Created", entity) == 0) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Serpent Thumbs Created");
								if (_so == null)
									_so = _sc.addObjective("Serpent Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Serpent Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (getEntityScore("Faction Points", entity) >= 5) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 3;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You advance one level!"), true);
								}
							});
						}
					}
				}
			}
			if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider DNA") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider 2 DNA")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack56 = new ItemStack(MonstrousWorldModItems.COMPUTER_CHIP.get()).copy();
					_setstack56.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount() - 1);
					_menu.getSlots().get(0).set(_setstack56);
					ItemStack _setstack59 = new ItemStack(MonstrousWorldModItems.THUMB_DRIVE_SPIDER.get()).copy();
					_setstack59.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount() + 1);
					_menu.getSlots().get(1).set(_setstack59);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
					if (getEntityScore("Laptops Crafted", entity) >= 1) {
						if (getEntityScore("Spider Thumbs Created", entity) == 0) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Spider Thumbs Created");
								if (_so == null)
									_so = _sc.addObjective("Spider Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Spider Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (getEntityScore("Faction Points", entity) >= 5) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 3;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You advance one level!"), true);
								}
							});
						}
					}
				}
			}
			if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager DNA") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager 2 DNA")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("monstrous_world:humming_machinery")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack73 = new ItemStack(MonstrousWorldModItems.COMPUTER_CHIP.get()).copy();
					_setstack73.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu71 ? _menu71.getSlots().get(0).getItem() : ItemStack.EMPTY).getCount() - 1);
					_menu.getSlots().get(0).set(_setstack73);
					ItemStack _setstack76 = new ItemStack(MonstrousWorldModItems.THUMB_DRIVE_ILLAGER.get()).copy();
					_setstack76.setCount((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(1).getItem() : ItemStack.EMPTY).getCount() + 1);
					_menu.getSlots().get(1).set(_setstack76);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
					if (getEntityScore("Laptops Crafted", entity) >= 1) {
						if (getEntityScore("Illager Thumbs Created", entity) == 0) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Illager Thumbs Created");
								if (_so == null)
									_so = _sc.addObjective("Illager Thumbs Created", ObjectiveCriteria.DUMMY, Component.literal("Illager Thumbs Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
							}
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (getEntityScore("Faction Points", entity) >= 5) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 3;
										_vars.markSyncDirty();
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You advance one level!"), true);
								}
							});
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