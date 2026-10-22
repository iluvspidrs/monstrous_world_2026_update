package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.world.inventory.TwoTradesMenu;
import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.GoblinVillagerEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import io.netty.buffer.Unpooled;

public class OpenTradingGUIGoblinProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof ServerPlayer || sourceentity instanceof Player) {
			if (!(sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
				if (entity instanceof GoblinVillagerEntity) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass >= 10 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == false) {
						MonstrousWorldMod.queueServerWork(1, () -> {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\"I won't trade with a monster like you!\""), false);
						});
					} else {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
							if (!sourceentity.isShiftKeyDown()) {
								sourceentity.getPersistentData().putString("Interaction", (entity.getStringUUID()));
								entity.getPersistentData().putString("Interaction", (sourceentity.getStringUUID()));
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.TradeHeading = "None";
									_vars.TradeType = "None";
									_vars.markSyncDirty();
								}
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 2) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == false || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
												if (Math.random() <= 0.33) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Goblin Trade Troll";
														_vars.TradeHeading = "Goblin Trade Troll";
														_vars.TradeButton = "Goblin Button";
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
												} else {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Goblin Trade";
														_vars.TradeHeading = "None";
														_vars.TradeButton = "Goblin Button";
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
													_vars.TradeType = "Goblin Trade";
													_vars.TradeHeading = "None";
													_vars.TradeButton = "Goblin Button";
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
									} else {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.TradeHeading = "Goblin Mentor Heading";
											_vars.TradeType = "Goblin Mentor Trade";
											_vars.markSyncDirty();
										}
										if (!hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_GOBLIN.get()))) {
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\"You'll need this guide to learn the trade of trickery!:"), false);
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(MonstrousWorldModItems.TOME_OF_THE_GOBLIN.get()));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
										} else {
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\"Follow the guide we gave you, and you'll know what to do.\""), false);
										}
									}
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
											if (Math.random() <= 0.33) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeType = "Goblin Trade Boots";
													_vars.TradeHeading = "None";
													_vars.TradeButton = "Goblin Button";
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
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeType = "Goblin Trade";
													_vars.TradeHeading = "None";
													_vars.TradeButton = "Goblin Button";
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
												_vars.TradeType = "Goblin Trade";
												_vars.TradeButton = "Goblin Button";
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
							}
						}
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
}