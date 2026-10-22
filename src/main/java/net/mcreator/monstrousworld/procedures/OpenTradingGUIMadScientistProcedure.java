package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.world.inventory.TwoTradesMenu;
import net.mcreator.monstrousworld.world.inventory.SerpentMutantAssignmentMenu;
import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;
import net.mcreator.monstrousworld.world.inventory.FlyMutantAssignmentMenu;
import net.mcreator.monstrousworld.world.inventory.EyeMutantAssignmentMenu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.MutantSerpentEntity;
import net.mcreator.monstrousworld.entity.MutantEyeEntity;
import net.mcreator.monstrousworld.entity.MadScientistNPCEntity;
import net.mcreator.monstrousworld.entity.FlyMutantEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class OpenTradingGUIMadScientistProcedure {
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
			if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MONSTER_DETECTOR.get())
					&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLOODLETTER.get())) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
					if (!sourceentity.isShiftKeyDown()) {
						sourceentity.getPersistentData().putString("Interaction", (entity.getStringUUID()));
						entity.getPersistentData().putString("Interaction", (sourceentity.getStringUUID()));
						{
							MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.TradeType = "None";
							_vars.TradeHeading = "None";
							_vars.markSyncDirty();
						}
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (entity instanceof MadScientistNPCEntity) {
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession != 3) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6) {
												if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Mad Scientist Mentor Trade";
														_vars.TradeHeading = "Mad Scientist Mentor Trade";
														_vars.markSyncDirty();
													}
													if (!hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.TOME_OF_MAD_SCIENCE.get()))) {
														if (world instanceof ServerLevel _level) {
															ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(MonstrousWorldModItems.TOME_OF_MAD_SCIENCE.get()));
															entityToSpawn.setPickUpDelay(10);
															_level.addFreshEntity(entityToSpawn);
														}
														if (sourceentity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("\"Welcome. Take this guide to start some...unethical experimentation.\""), false);
													} else {
														if (sourceentity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("\"Follow the guide I gave you, and you'll know what to do.\""), false);
													}
												} else {
													if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2
															|| sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Mad Scientist Mutant Trade";
															_vars.TradeHeading = "Mad Scientist Mutant Trade";
															_vars.TradeButton = "Mad Scientist Button";
															_vars.markSyncDirty();
														}
														if (sourceentity instanceof ServerPlayer _ent) {
															BlockPos _bpos = BlockPos.containing(x, y, z);
															_ent.openMenu(new MenuProvider() {
																@Override
																public Component getDisplayName() {
																	return Component.literal("TwoTrades");
																}

																@Override
																public boolean shouldTriggerClientSideContainerClosingOnOpen() {
																	return false;
																}

																@Override
																public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
																	return new TwoTradesMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
																}
															}, _bpos);
														}
													} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1
															|| sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9
															|| sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Mad Scientist Normal Trade";
															_vars.TradeHeading = "Mad Scientist Normal Trade";
															_vars.TradeButton = "Mad Scientist Button";
															_vars.markSyncDirty();
														}
														if (sourceentity instanceof ServerPlayer _ent) {
															BlockPos _bpos = BlockPos.containing(x, y, z);
															_ent.openMenu(new MenuProvider() {
																@Override
																public Component getDisplayName() {
																	return Component.literal("TwoTrades");
																}

																@Override
																public boolean shouldTriggerClientSideContainerClosingOnOpen() {
																	return false;
																}

																@Override
																public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
																	return new TwoTradesMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
																}
															}, _bpos);
														}
													} else {
														if (sourceentity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("\"There are no beneficial trades I can offer to your kind.\""), false);
													}
												}
											} else {
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("\"There are no beneficial trades I can offer to your kind.\""), false);
											}
										} else {
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\"Get away from my lab!\""), false);
											if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
												_entity.setTarget(_ent);
										}
									} else {
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\"You seem too powerful to need my assistance...\""), false);
									}
								}
							}
							if (entity instanceof FlyMutantEntity) {
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
									if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (getEntityScore("Assignments Out", sourceentity) < 3) {
												if (sourceentity instanceof ServerPlayer _ent) {
													BlockPos _bpos = BlockPos.containing(x, y, z);
													_ent.openMenu(new MenuProvider() {
														@Override
														public Component getDisplayName() {
															return Component.literal("FlyMutantAssignment");
														}

														@Override
														public boolean shouldTriggerClientSideContainerClosingOnOpen() {
															return false;
														}

														@Override
														public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
															return new FlyMutantAssignmentMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
														}
													}, _bpos);
												}
											} else {
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("You have sent out the max number of assistants for today"), true);
											}
										} else {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeHeading = "None";
												_vars.TradeType = "Fly Mutant Trade";
												_vars.markSyncDirty();
											}
											if (sourceentity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("OneTrade");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new OneTradeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
									} else {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.TradeHeading = "None";
											_vars.TradeType = "Fly Mutant Trade";
											_vars.markSyncDirty();
										}
										if (sourceentity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("OneTrade");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new OneTradeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
								}
							}
							if (entity instanceof MutantEyeEntity) {
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
									if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (getEntityScore("Assignments Out", sourceentity) < 3) {
												if (sourceentity instanceof ServerPlayer _ent) {
													BlockPos _bpos = BlockPos.containing(x, y, z);
													_ent.openMenu(new MenuProvider() {
														@Override
														public Component getDisplayName() {
															return Component.literal("EyeMutantAssignment");
														}

														@Override
														public boolean shouldTriggerClientSideContainerClosingOnOpen() {
															return false;
														}

														@Override
														public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
															return new EyeMutantAssignmentMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
														}
													}, _bpos);
												}
											} else {
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("You have sent out the max number of assistants for today"), true);
											}
										} else {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeHeading = "None";
												_vars.TradeType = "Eye Mutant Trade";
												_vars.markSyncDirty();
											}
											if (sourceentity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("OneTrade");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new OneTradeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
									} else {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.TradeHeading = "None";
											_vars.TradeType = "Eye Mutant Trade";
											_vars.markSyncDirty();
										}
										if (sourceentity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("OneTrade");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new OneTradeMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
								}
							}
							if (entity instanceof MutantSerpentEntity) {
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
									if ((entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
											if (getEntityScore("Assignments Out", sourceentity) < 3) {
												if (sourceentity instanceof ServerPlayer _ent) {
													BlockPos _bpos = BlockPos.containing(x, y, z);
													_ent.openMenu(new MenuProvider() {
														@Override
														public Component getDisplayName() {
															return Component.literal("SerpentMutantAssignment");
														}

														@Override
														public boolean shouldTriggerClientSideContainerClosingOnOpen() {
															return false;
														}

														@Override
														public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
															return new SerpentMutantAssignmentMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
														}
													}, _bpos);
												}
											} else {
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("You have sent out the max number of assistants for today"), true);
											}
										} else {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Serpent Mutant Trade";
												_vars.TradeButton = "Mad Scientist Button";
												_vars.TradeHeading = "None";
												_vars.markSyncDirty();
											}
											if (sourceentity instanceof ServerPlayer _ent) {
												BlockPos _bpos = BlockPos.containing(x, y, z);
												_ent.openMenu(new MenuProvider() {
													@Override
													public Component getDisplayName() {
														return Component.literal("TwoTrades");
													}

													@Override
													public boolean shouldTriggerClientSideContainerClosingOnOpen() {
														return false;
													}

													@Override
													public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
														return new TwoTradesMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
													}
												}, _bpos);
											}
										}
									} else {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.TradeType = "Serpent Mutant Trade";
											_vars.TradeButton = "Mad Scientist Button";
											_vars.TradeHeading = "None";
											_vars.markSyncDirty();
										}
										if (sourceentity instanceof ServerPlayer _ent) {
											BlockPos _bpos = BlockPos.containing(x, y, z);
											_ent.openMenu(new MenuProvider() {
												@Override
												public Component getDisplayName() {
													return Component.literal("TwoTrades");
												}

												@Override
												public boolean shouldTriggerClientSideContainerClosingOnOpen() {
													return false;
												}

												@Override
												public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
													return new TwoTradesMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
												}
											}, _bpos);
										}
									}
								}
							}
						});
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}