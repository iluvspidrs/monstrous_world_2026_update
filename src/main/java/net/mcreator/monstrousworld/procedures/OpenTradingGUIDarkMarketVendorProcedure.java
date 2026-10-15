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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.DarkMarketVendorEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class OpenTradingGUIDarkMarketVendorProcedure {
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
								_vars.TradeHeading = "None";
								_vars.TradeType = "None";
								_vars.markSyncDirty();
							}
							MonstrousWorldMod.queueServerWork(1, () -> {
								if (entity instanceof DarkMarketVendorEntity) {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
										if ((entity instanceof DarkMarketVendorEntity _datEntI ? _datEntI.getEntityData().get(DarkMarketVendorEntity.DATA_Trade) : 0) == 1) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "DM Trade 1";
												_vars.TradeHeading = "DM Trade";
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
										if ((entity instanceof DarkMarketVendorEntity _datEntI ? _datEntI.getEntityData().get(DarkMarketVendorEntity.DATA_Trade) : 0) == 2) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "DM Trade 2";
												_vars.TradeHeading = "DM Trade";
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
										if ((entity instanceof DarkMarketVendorEntity _datEntI ? _datEntI.getEntityData().get(DarkMarketVendorEntity.DATA_Trade) : 0) == 3) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "DM Trade 3";
												_vars.TradeHeading = "DM Trade";
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
							});
						}
					}
				}
			}
		}
	}
}