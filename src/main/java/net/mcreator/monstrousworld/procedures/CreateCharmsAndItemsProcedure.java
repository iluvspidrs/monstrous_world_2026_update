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
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class CreateCharmsAndItemsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("IncantationBook", 0);
				_blockEntity.getPersistentData().putDouble("GoldNugget", 0);
				_blockEntity.getPersistentData().putDouble("MagicallyTreatedLeather", 0);
				_blockEntity.getPersistentData().putDouble("Moonstone", 0);
				_blockEntity.getPersistentData().putDouble("Sardonyx", 0);
				_blockEntity.getPersistentData().putDouble("BlackOnyx", 0);
				_blockEntity.getPersistentData().putDouble("PaleAgate", 0);
				_blockEntity.getPersistentData().putDouble("GreenAgate", 0);
				_blockEntity.getPersistentData().putDouble("RedAgate", 0);
				_blockEntity.getPersistentData().putDouble("BlueAgate", 0);
				_blockEntity.getPersistentData().putDouble("TigersEye", 0);
				_blockEntity.getPersistentData().putDouble("ClearQuartz", 0);
				_blockEntity.getPersistentData().putDouble("RoseQuartz", 0);
				_blockEntity.getPersistentData().putDouble("Malachite", 0);
				_blockEntity.getPersistentData().putDouble("AnointmentOil", 0);
				_blockEntity.getPersistentData().putDouble("CaptiveSpirit", 0);
				_blockEntity.getPersistentData().putDouble("String", 0);
				_blockEntity.getPersistentData().putDouble("AutumnalInk", 0);
				_blockEntity.getPersistentData().putDouble("DarkInk", 0);
				_blockEntity.getPersistentData().putDouble("UnstableInk", 0);
				_blockEntity.getPersistentData().putDouble("DeathlyInk", 0);
				_blockEntity.getPersistentData().putDouble("RichInk", 0);
				_blockEntity.getPersistentData().putDouble("SpiritualInk", 0);
				_blockEntity.getPersistentData().putDouble("Feather", 0);
				_blockEntity.getPersistentData().putDouble("Book", 0);
				_blockEntity.getPersistentData().putDouble("PureDarkEssence", 0);
				_blockEntity.getPersistentData().putDouble("DarkEssenceDust", 0);
				_blockEntity.getPersistentData().putDouble("FlightPowder", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		MonstrousWorldMod.queueServerWork(1, () -> {
			ItemCountCharmAltarProcedure.execute(world, x, y, z, entity);
			if (getAmountInGUISlot(entity, 4) < 64) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(4).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					AltarCreateTTBagProcedure.execute(world, x, y, z, entity);
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ClearQuartz") >= 1) {
							AltarCreateCharmSpeedProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Speed Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Speed Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Speed Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Speed Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Speed Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "PaleAgate") >= 1) {
							AltarCreateCharmProjectileProtectionProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Projectile Protection Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Projectile Protection Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Projectile Protection Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Projectile Protection Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Projectile Protection Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Moonstone") >= 1) {
							AltarCreateCharmNocturnalGuardProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Nocturnal Guard Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Nocturnal Guard Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Nocturnal Guard Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Nocturnal Guard Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Nocturnal Guard Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BlackOnyx") >= 1) {
							AltarCreateCharmStrengthProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Strength Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Strength Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Strength Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Strength Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Strength Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GreenAgate") >= 1) {
							AltarCreateLuckCharmProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Luck Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Luck Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Luck Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Luck Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Luck Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BlueAgate") >= 1) {
							AltarCreateCharmWaterBreathingProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Water Breathing Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Water Breathing Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Water Breathing Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Water Breathing Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Water Breathing Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RedAgate") >= 1) {
							AltarCreateCharmFireResistanceProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Fire Resistance Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Fire Resistance Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Fire Resistance Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Fire Resistance Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Fire Resistance Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Malachite") >= 1) {
							AltarCreateCharmCleansingProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Cleansing Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Cleansing Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Cleansing Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Cleansing Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Cleansing Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Sardonyx") >= 1) {
							AltarCreateCharmThornsProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Thorns Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Thorns Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Thorns Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Thorns Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Thorns Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RoseQuartz") >= 1) {
							AltarCreateCharmHealingProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Healing Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Healing Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Healing Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Healing Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Healing Charm Created", entity) + 1);
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
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
								&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "TigersEye") >= 1) {
							AltarCreateCharmPossessionImmunityProcedure.execute(world, x, y, z, entity);
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (getEntityScore("Possession Immunity Charm Created", entity) == 0) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("Possession Immunity Charm Created");
											if (_so == null)
												_so = _sc.addObjective("Possession Immunity Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Possession Immunity Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Possession Immunity Charm Created", entity) + 1);
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
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "RichInk") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Book") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") >= 1) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
							AltarCreateTomeWealthProcedure.execute(world, x, y, z, entity);
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Wealth Tome Created");
								if (_so == null)
									_so = _sc.addObjective("Wealth Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Wealth Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Wealth Tome Created", entity) + 1);
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:stay_for_a_spell"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						} else {
							if (entity instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You don't have the skill to make this yet"), true);
						}
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AutumnalInk") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Book") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") >= 1) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
							AltarCreateTomePumpkinsRestProcedure.execute(world, x, y, z, entity);
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Rest Tome Created");
								if (_so == null)
									_so = _sc.addObjective("Rest Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Rest Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Rest Tome Created", entity) + 1);
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:stay_for_a_spell"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						} else {
							if (entity instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You don't have the skill to make this yet"), true);
						}
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DeathlyInk") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Book") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") >= 1) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
							AltarCreateTomeTrueDeathProcedure.execute(world, x, y, z, entity);
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("True Death Tome Created");
								if (_so == null)
									_so = _sc.addObjective("True Death Tome Created", ObjectiveCriteria.DUMMY, Component.literal("True Death Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("True Death Tome Created", entity) + 1);
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:stay_for_a_spell"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						} else {
							if (entity instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You don't have the skill to make this yet"), true);
						}
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SpiritualInk") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Book") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") >= 1) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
							AltarCreateTomeExorcismProcedure.execute(world, x, y, z, entity);
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Exorcism Tome Created");
								if (_so == null)
									_so = _sc.addObjective("Exorcism Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Exorcism Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Exorcism Tome Created", entity) + 1);
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:stay_for_a_spell"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						} else {
							if (entity instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You don't have the skill to make this yet"), true);
						}
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "UnstableInk") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Book") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") >= 1) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
							AltarCreateTomeCreeperShieldProcedure.execute(world, x, y, z, entity);
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Shield Tome Created");
								if (_so == null)
									_so = _sc.addObjective("Shield Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Shield Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Shield Tome Created", entity) + 1);
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:stay_for_a_spell"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						} else {
							if (entity instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You don't have the skill to make this yet"), true);
						}
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DarkInk") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Book") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Feather") >= 1) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
							AltarCreateTomeBindingProcedure.execute(world, x, y, z, entity);
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Binding Tome Created");
								if (_so == null)
									_so = _sc.addObjective("Binding Tome Created", ObjectiveCriteria.DUMMY, Component.literal("Binding Tome Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Binding Tome Created", entity) + 1);
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:stay_for_a_spell"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						} else {
							if (entity instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You don't have the skill to make this yet"), true);
						}
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "DarkEssenceDust") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "IncantationBook") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ClearQuartz") >= 1) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
							AltarCreateDarkCharmProcedure.execute(world, x, y, z, entity);
							{
								Entity _ent = entity;
								Scoreboard _sc = _ent.level().getScoreboard();
								Objective _so = _sc.getObjective("Dark Charm Created");
								if (_so == null)
									_so = _sc.addObjective("Dark Charm Created", ObjectiveCriteria.DUMMY, Component.literal("Dark Charm Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
								_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(getEntityScore("Dark Charm Created", entity) + 1);
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:nightmare_catcher"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						} else {
							if (entity instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("You don't have the skill to make this yet"), false);
						}
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GoldNugget") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "AnointmentOil") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ClearQuartz") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FlightPowder") >= 1) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
								AltarCreateFlightCharmProcedure.execute(world, x, y, z, entity);
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You don't have the skill to make this yet"), false);
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
								MonstrousWorldMod.queueServerWork(1, () -> {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.FactionLevel = 6;
										_vars.markSyncDirty();
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You advance a level!"), true);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("Faction Points");
										if (_so == null)
											_so = _sc.addObjective("Faction Points", ObjectiveCriteria.DUMMY, Component.literal("Faction Points"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
								});
							}
						}
					}
				}
			}
		});
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