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
import net.mcreator.monstrousworld.entity.TrollNPCEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class OpenTradingGUITrollProcedure {
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
			if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
				if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MONSTER_DETECTOR.get())
						&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLOODLETTER.get())) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
						if (!(sourceentity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
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
									if (entity instanceof TrollNPCEntity) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 3) {
												if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
													if (Math.random() <= 0.33) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Troll Trade Blood";
															_vars.TradeHeading = "Troll Trade Blood";
															_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 1) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 1";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 2) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 2";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 3) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 3";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 4) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 4";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 5";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
												} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
													if (Math.random() <= 0.33) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Troll Trade Goblin";
															_vars.TradeHeading = "Troll Trade Goblin";
															_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 1) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 1";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 2) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 2";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 3) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 3";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 4) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 4";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 5";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
												} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass >= 10) {
													if (!(sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true)) {
														if (sourceentity instanceof Player _player && !_player.level().isClientSide())
															_player.displayClientMessage(Component.literal("\"Get away from me, you vile creature!\""), false);
													} else {
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 1) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 1";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 2) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 2";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 3) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 3";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 4) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 4";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
														if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Troll Trade 5";
																_vars.TradeHeading = "Troll Trade";
																_vars.TradeButton = "Troll Trade";
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
												} else {
													if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 1) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Troll Trade 1";
															_vars.TradeHeading = "Troll Trade";
															_vars.TradeButton = "Troll Trade";
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
													if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 2) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Troll Trade 2";
															_vars.TradeHeading = "Troll Trade";
															_vars.TradeButton = "Troll Trade";
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
													if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Troll Trade 3";
															_vars.TradeHeading = "Troll Trade";
															_vars.TradeButton = "Troll Trade";
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
													if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 4) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Troll Trade 4";
															_vars.TradeHeading = "Troll Trade";
															_vars.TradeButton = "Troll Trade";
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
													if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Troll Trade 5";
															_vars.TradeHeading = "Troll Trade";
															_vars.TradeButton = "Troll Trade";
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
											} else {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeHeading = "Troll Mentor Heading";
													_vars.TradeType = "Troll Mentor Trade";
													_vars.markSyncDirty();
												}
												if (!hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_TROLL.get()))) {
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("\"Hey. Take this book to start the warrior's journey!\""), false);
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(MonstrousWorldModItems.TOME_OF_THE_TROLL.get()));
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
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}