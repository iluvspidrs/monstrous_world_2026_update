package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class ConfectioneryCraftingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double coal_required = 0;
		double iron_required = 0;
		ConfectioneryTableItemCountProcedure.execute(world, x, y, z, entity);
		if (getAmountInGUISlot(entity, 3) <= 63) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Acid Bottle") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CURSED_CANDY
						.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					CreateCursedCandyProcedure.execute(entity);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Human") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.COTTON_CANDY_HUMAN.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					CreateCottonCandyHumanProcedure.execute(entity);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worlds_best_cotton_candy"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (getEntityScore("cotton_candy_human", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("cotton_candy_human");
							if (_so == null)
								_so = _sc.addObjective("cotton_candy_human", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_human"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
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
									_player.displayClientMessage(Component.literal("You advance a level!"), false);
							}
						}
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Villager") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.COTTON_CANDY_VILLAGER.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					CreateCottonCandyVillagerProcedure.execute(entity);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worlds_best_cotton_candy"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (getEntityScore("cotton_candy_villager", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("cotton_candy_villager");
							if (_so == null)
								_so = _sc.addObjective("cotton_candy_villager", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_villager"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
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
									_player.displayClientMessage(Component.literal("You advance a level!"), false);
							}
						}
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Illager") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.COTTON_CANDY_ILLAGER.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					CreateCottonCandyIllagerProcedure.execute(entity);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worlds_best_cotton_candy"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (getEntityScore("cotton_candy_illager", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("cotton_candy_illager");
							if (_so == null)
								_so = _sc.addObjective("cotton_candy_illager", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_illager"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
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
									_player.displayClientMessage(Component.literal("You advance a level!"), false);
							}
						}
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Goblin") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.COTTON_CANDY_GOBLIN.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					CreateCottonCandyGoblinProcedure.execute(entity);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worlds_best_cotton_candy"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (getEntityScore("cotton_candy_goblin", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("cotton_candy_goblin");
							if (_so == null)
								_so = _sc.addObjective("cotton_candy_goblin", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_goblin"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
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
									_player.displayClientMessage(Component.literal("You advance a level!"), false);
							}
						}
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Troll") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.COTTON_CANDY_TROLL.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu82 ? _menu82.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					CreateCottonCandyTrollProcedure.execute(entity);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worlds_best_cotton_candy"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (getEntityScore("cotton_candy_troll", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("cotton_candy_troll");
							if (_so == null)
								_so = _sc.addObjective("cotton_candy_troll", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_troll"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
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
									_player.displayClientMessage(Component.literal("You advance a level!"), false);
							}
						}
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Swampmonster") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu97 ? _menu97.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.COTTON_CANDY_SWAMPMONSTER.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu99 ? _menu99.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					CreateCottonCandySwampmonsterProcedure.execute(entity);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worlds_best_cotton_candy"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (getEntityScore("cotton_candy_swampmonster", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("cotton_candy_swampmonster");
							if (_so == null)
								_so = _sc.addObjective("cotton_candy_swampmonster", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_swampmonster"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
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
									_player.displayClientMessage(Component.literal("You advance a level!"), false);
							}
						}
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Vampire") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu114 ? _menu114.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.COTTON_CANDY_VAMPIRE.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu116 ? _menu116.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
					CreateCottonCandyVampireProcedure.execute(entity);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worlds_best_cotton_candy"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (getEntityScore("cotton_candy_vampire", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("cotton_candy_vampire");
							if (_so == null)
								_so = _sc.addObjective("cotton_candy_vampire", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_vampire"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
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
									_player.displayClientMessage(Component.literal("You advance a level!"), false);
							}
						}
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Werewolf") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu131 ? _menu131.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.COTTON_CANDY_WEREWOLF.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
					CreateCottonCandyWerewolfProcedure.execute(entity);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worlds_best_cotton_candy"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (getEntityScore("cotton_candy_werewolf", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("cotton_candy_werewolf");
							if (_so == null)
								_so = _sc.addObjective("cotton_candy_werewolf", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_werewolf"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
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
									_player.displayClientMessage(Component.literal("You advance a level!"), false);
							}
						}
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sugar") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Hint of Insanity") >= 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Cursed Confectionery Magical") >= 1) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu148 ? _menu148.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.COTTON_CANDY_MAGICAL.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
					CreateCottonCandyMagicalProcedure.execute(entity);
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_worlds_best_cotton_candy"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
					if (getEntityScore("cotton_candy_magical", entity) == 0) {
						{
							Entity _ent = entity;
							Scoreboard _sc = _ent.level().getScoreboard();
							Objective _so = _sc.getObjective("cotton_candy_magical");
							if (_so == null)
								_so = _sc.addObjective("cotton_candy_magical", ObjectiveCriteria.DUMMY, Component.literal("cotton_candy_magical"), ObjectiveCriteria.RenderType.INTEGER, true, null);
							_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Faction Points");
								if (_so == null)
									_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Faction Points", entity) + 1);
							}
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
									_player.displayClientMessage(Component.literal("You advance a level!"), false);
							}
						}
					}
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("Sugar 0", 0);
				_blockEntity.getPersistentData().putDouble("Sugar 1", 0);
				_blockEntity.getPersistentData().putDouble("Sugar 2", 0);
				_blockEntity.getPersistentData().putDouble("Hint of Insanity 0", 0);
				_blockEntity.getPersistentData().putDouble("Hint of Insanity 1", 0);
				_blockEntity.getPersistentData().putDouble("Hint of Insanity 2", 0);
				_blockEntity.getPersistentData().putDouble("Acid Bottle 1", 0);
				_blockEntity.getPersistentData().putDouble("Acid Bottle 2", 0);
				_blockEntity.getPersistentData().putDouble("Acid Bottle 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Human 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Human 1", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Human 2", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Villager 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Villager 1", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Villager 2", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Illager 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Illager 1", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Illager 2", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Magical 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Magical 1", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Magical 2", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Goblin 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Goblin 1", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Goblin 2", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Troll 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Troll 1", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Troll 2", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Vampire 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Vampire 1", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Vampire 2", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Werewolf 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Werewolf 1", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Werewolf 2", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Swampmonster 0", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Swampmonster 1", 0);
				_blockEntity.getPersistentData().putDouble("Cursed Confectionery Swampmonster 2", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}