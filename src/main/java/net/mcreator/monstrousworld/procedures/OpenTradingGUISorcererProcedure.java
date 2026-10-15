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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.SorcererNPCEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class OpenTradingGUISorcererProcedure {
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
					if (!(sourceentity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
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
								if (entity instanceof SorcererNPCEntity) {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 4) {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
												if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 1) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Sorcerer Trade 1";
														_vars.TradeHeading = "Sorcerer Trade";
														_vars.TradeButton = "Sorcerer Trade";
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
												if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 2) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Sorcerer Trade 2";
														_vars.TradeHeading = "Sorcerer Trade";
														_vars.TradeButton = "Sorcerer Trade";
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
												if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 3) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Sorcerer Trade 3";
														_vars.TradeHeading = "Sorcerer Trade";
														_vars.TradeButton = "Sorcerer Trade";
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
												if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 4) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Sorcerer Trade 4";
														_vars.TradeHeading = "Sorcerer Trade";
														_vars.TradeButton = "Sorcerer Trade";
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
												if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 5) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Sorcerer Trade 5";
														_vars.TradeHeading = "Sorcerer Trade";
														_vars.TradeButton = "Sorcerer Trade";
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
												if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 6) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Sorcerer Trade 6";
														_vars.TradeHeading = "Sorcerer Trade";
														_vars.TradeButton = "Sorcerer Trade";
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
												if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 7) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Sorcerer Trade 7";
														_vars.TradeHeading = "Sorcerer Trade";
														_vars.TradeButton = "Sorcerer Trade";
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
												if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 8) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Sorcerer Trade 8";
														_vars.TradeHeading = "Sorcerer Trade";
														_vars.TradeButton = "Sorcerer Trade";
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
												if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 9) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Sorcerer Trade 9";
														_vars.TradeHeading = "Sorcerer Trade";
														_vars.TradeButton = "Sorcerer Trade";
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
												if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true)) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("\"I will not trade with a creature like you!\""), false);
												} else {
													if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 1) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Sorcerer Trade 1";
															_vars.TradeHeading = "Sorcerer Trade";
															_vars.TradeButton = "Sorcerer Trade";
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
													if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 2) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Sorcerer Trade 2";
															_vars.TradeHeading = "Sorcerer Trade";
															_vars.TradeButton = "Sorcerer Trade";
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
													if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Sorcerer Trade 3";
															_vars.TradeHeading = "Sorcerer Trade";
															_vars.TradeButton = "Sorcerer Trade";
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
													if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 4) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Sorcerer Trade 4";
															_vars.TradeHeading = "Sorcerer Trade";
															_vars.TradeButton = "Sorcerer Trade";
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
													if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Sorcerer Trade 5";
															_vars.TradeHeading = "Sorcerer Trade";
															_vars.TradeButton = "Sorcerer Trade";
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
													if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 6) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Sorcerer Trade 6";
															_vars.TradeHeading = "Sorcerer Trade";
															_vars.TradeButton = "Sorcerer Trade";
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
													if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 7) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Sorcerer Trade 7";
															_vars.TradeHeading = "Sorcerer Trade";
															_vars.TradeButton = "Sorcerer Trade";
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
													if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 8) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Sorcerer Trade 8";
															_vars.TradeHeading = "Sorcerer Trade";
															_vars.TradeButton = "Sorcerer Trade";
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
													if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 9) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Sorcerer Trade 9";
															_vars.TradeHeading = "Sorcerer Trade";
															_vars.TradeButton = "Sorcerer Trade";
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
										} else {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeHeading = "Sorcerer Mentor Heading";
												_vars.TradeType = "Sorcerer Mentor Trade";
												_vars.markSyncDirty();
											}
											if (!hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.TOME_OF_SORCERY.get()))) {
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("\"I bet you can't wait to start learning your magic! Take this guide\" "), false);
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(MonstrousWorldModItems.TOME_OF_SORCERY.get()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
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
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}