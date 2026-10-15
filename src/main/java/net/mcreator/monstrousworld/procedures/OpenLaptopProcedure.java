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
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.world.inventory.*;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class OpenLaptopProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MonstrousWorldModBlocks.LAPTOP.get()) {
				if (!entity.isShiftKeyDown()) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
								if (entity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel
										&& _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:technical_expertise"))).isDone()) {
									{
										Entity _ent = entity;
										Scoreboard _sc = _ent.level().getScoreboard();
										Objective _so = _sc.getObjective("has_analyzer");
										if (_so == null)
											_so = _sc.addObjective("has_analyzer", ObjectiveCriteria.DUMMY, Component.literal("has_analyzer"), ObjectiveCriteria.RenderType.INTEGER, true, null);
										_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
									}
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.RecipeGuideShow = "None";
										_vars.markSyncDirty();
									}
									if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Laptop")) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Page = "Laptop TOC";
											_vars.markSyncDirty();
										}
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopTOC");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopTOCMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop TOC")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopTOC");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopTOCMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Analyze Fail")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopAnalyzeFail");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopAnalyzeFailMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Analyzer")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopAnalyzeFail");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopAnalyzeFailMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Main Screen Page 1")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopIntroPage1");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopIntroPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Main Screen Page 2")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopIntroPage2");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopIntroPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Main Screen Page 3")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopIntroPage3");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopIntroPage3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Sample List")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopDNASampleList");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopDNASampleListMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Fly DNA")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopSampleFly");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopSampleFlyMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Serpent DNA")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopSampleSerpent");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopSampleSerpentMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Dreadful Watcher DNA")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopSampleDreadfulWatcher");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopSampleDreadfulWatcherMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider DNA")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopSampleSpiderPage1");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopSampleSpiderPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider 2 DNA")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopSampleSpiderPage2");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopSampleSpiderPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager 2 DNA")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopSampleGuardRobotPage2");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopSampleGuardRobotPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager DNA")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopSampleGuardRobotPage1");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopSampleGuardRobotPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Strange Serum Page 1")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopCreatingStrangeSerumPage1");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopCreatingStrangeSerumPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Strange Serum Page 2")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopCreatingStrangeSerumPage2");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopCreatingStrangeSerumPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Strange Serum Page 3")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopCreatingStrangeSerumPage3");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopCreatingStrangeSerumPage3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Create Robot Page 1")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopCreatingRobotsPage1");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopCreatingRobotsPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
									if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Create Robot Page 2")) {
										if (entity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("LaptopCreatingRobotsPage2");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new LaptopCreatingRobotsPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You must first build your own laptop to gain the skill to use this"), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You need to advance a level to use this"), true);
							}
						} else {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == true) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
									if (entity instanceof ServerPlayer _plr28 && _plr28.level() instanceof ServerLevel
											&& _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:technical_expertise"))).isDone()) {
										{
											Entity _ent = entity;
											Scoreboard _sc = _ent.level().getScoreboard();
											Objective _so = _sc.getObjective("has_analyzer");
											if (_so == null)
												_so = _sc.addObjective("has_analyzer", ObjectiveCriteria.DUMMY, Component.literal("has_analyzer"), ObjectiveCriteria.RenderType.INTEGER, true, null);
											_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
										}
										if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Laptop")) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Page = "Laptop TOC";
												_vars.markSyncDirty();
											}
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopTOC");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopTOCMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop TOC")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopTOC");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopTOCMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Analyzer")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopAnalyzeFail");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopAnalyzeFailMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Analyze Fail")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopAnalyzeFail");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopAnalyzeFailMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Main Screen Page 1")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopIntroPage1");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopIntroPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Main Screen Page 2")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopIntroPage2");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopIntroPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Main Screen Page 3")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopIntroPage3");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopIntroPage3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Sample List")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopDNASampleList");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopDNASampleListMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Fly DNA")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopSampleFly");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopSampleFlyMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Serpent DNA")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopSampleSerpent");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopSampleSerpentMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Dreadful Watcher DNA")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopSampleDreadfulWatcher");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopSampleDreadfulWatcherMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider DNA")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopSampleSpiderPage1");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopSampleSpiderPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider 2 DNA")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopSampleSpiderPage2");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopSampleSpiderPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager 2 DNA")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopSampleGuardRobotPage2");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopSampleGuardRobotPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager DNA")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopSampleGuardRobotPage1");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopSampleGuardRobotPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Strange Serum Page 1")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopCreatingStrangeSerumPage1");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopCreatingStrangeSerumPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Strange Serum Page 2")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopCreatingStrangeSerumPage2");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopCreatingStrangeSerumPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Strange Serum Page 3")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopCreatingStrangeSerumPage3");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopCreatingStrangeSerumPage3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Create Robot Page 1")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopCreatingRobotsPage1");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopCreatingRobotsPage1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
										if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Create Robot Page 2")) {
											if (entity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("LaptopCreatingRobotsPage2");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new LaptopCreatingRobotsPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("You must first build your own laptop to gain the skill to use this"), true);
									}
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You need to advance a level to use this"), true);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This baffles you"), true);
							}
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You don't have the skill to use this"), true);
					}
				}
			}
		}
	}
}