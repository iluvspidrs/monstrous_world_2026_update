package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

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
import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class OpenTradingGUIHunterProcedure {
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
					&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLOODLETTER.get())
					&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CURSED_CANDY.get())) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
					if (!sourceentity.isShiftKeyDown()) {
						if (!(sourceentity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
							if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation >= -24 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true) {
								sourceentity.getPersistentData().putString("Interaction", (entity.getStringUUID()));
								entity.getPersistentData().putString("Interaction", (sourceentity.getStringUUID()));
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.TradeType = "None";
									_vars.TradeHeading = "None";
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (entity instanceof HunterNPCEntity || entity instanceof HunterPatrolNPCEntity) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
												if (hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.DROPPED_SOCIETY_PLANS_ITEM.get()))) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Goblin to Hunter Trade Complete";
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
														_vars.TradeType = "Goblin to Hunter Trade";
														_vars.TradeButton = "Hunter Button";
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
											} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeType = "Goblin to Hunter Trade Advanced";
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
												if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
													if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 1
															|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 1) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Hunter Trade 1";
															_vars.TradeHeading = "Hunter Trade";
															_vars.TradeButton = "Hunter Button";
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
													if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 2
															|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 2) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Hunter Trade 2";
															_vars.TradeHeading = "Hunter Trade";
															_vars.TradeButton = "Hunter Button";
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
													if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 3
															|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Hunter Trade 3";
															_vars.TradeHeading = "Hunter Trade";
															_vars.TradeButton = "Hunter Button";
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
										} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6) {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
												if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
													if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Hunter Mentor Trade";
															_vars.markSyncDirty();
														}
														if (!hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.HUNTERS_GUILD_FIELD_GUIDE_ITEM.get()))) {
															if (world instanceof ServerLevel _level) {
																ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()),
																		new ItemStack(MonstrousWorldModItems.HUNTERS_GUILD_FIELD_GUIDE_ITEM.get()));
																entityToSpawn.setPickUpDelay(10);
																_level.addFreshEntity(entityToSpawn);
															}
															if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel < 6) {
																if (sourceentity instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("\"You'll need this guide to survive this job!\""), false);
															}
														} else {
															if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel < 6) {
																if (sourceentity instanceof Player _player && !_player.level().isClientSide())
																	_player.displayClientMessage(Component.literal("\"Follow the guide we gave you, and you'll know what to do.\""), false);
															}
														}
													}
													if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == false || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType >= 1) {
														if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 1
																|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 1) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Hunter Trade 1";
																_vars.TradeHeading = "Hunter Trade";
																_vars.TradeButton = "Hunter Button";
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
														if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 2
																|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 2) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Hunter Trade 2";
																_vars.TradeHeading = "Hunter Trade";
																_vars.TradeButton = "Hunter Button";
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
														if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 3
																|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 3) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Hunter Trade 3";
																_vars.TradeHeading = "Hunter Trade";
																_vars.TradeButton = "Hunter Button";
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
													if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass >= 10) {
														if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
															if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true) {
																if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 1
																		|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 1) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.TradeType = "Hunter Trade 1";
																		_vars.TradeHeading = "Hunter Trade";
																		_vars.TradeButton = "Hunter Button";
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
																if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 2
																		|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 2) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.TradeType = "Hunter Trade 2";
																		_vars.TradeHeading = "Hunter Trade";
																		_vars.TradeButton = "Hunter Button";
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
																if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 3
																		|| (entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 3) {
																	{
																		MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																		_vars.TradeType = "Hunter Trade 3";
																		_vars.TradeHeading = "Hunter Trade";
																		_vars.TradeButton = "Hunter Button";
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
																if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
																	_entity.setTarget(_ent);
															}
														} else {
															if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
																_entity.setTarget(_ent);
														}
													}
												} else {
													if (entity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("\"There is nothing we can trade you. Please keep your kind under control.\""), false);
												}
											} else {
												if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
													_entity.setTarget(_ent);
											}
										} else {
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\"There is nothing we can trade you! Go away!\""), false);
											if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
												_entity.setTarget(_ent);
										}
									}
								});
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