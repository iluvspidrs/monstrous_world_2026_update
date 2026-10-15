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

import net.mcreator.monstrousworld.world.inventory.TwoTradesMenu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.Witch1Entity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class Witch1RightclickedOnEntityProcedure {
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
			if (entity instanceof Witch1Entity) {
				if (!(entity.getPersistentData().getString("AngryAt")).equals(sourceentity.getDisplayName().getString())) {
					if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MONSTER_DETECTOR.get())
							&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLOODLETTER.get())
							&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DEMONIC_CONTRACT_WITCH.get())
							&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CURSED_CANDY.get())) {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
							if (!sourceentity.isShiftKeyDown()) {
								sourceentity.getPersistentData().putString("Interaction", (entity.getStringUUID()));
								entity.getPersistentData().putString("Interaction", (sourceentity.getStringUUID()));
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass <= 9 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Disguised == true) {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
										MonstrousWorldMod.queueServerWork(2, () -> {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeHeading = "Witch Mentor Trade";
												_vars.TradeType = "Witch Mentor Trade";
												_vars.markSyncDirty();
											}
											if (!hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.TOME_OF_WITCHERY.get()))) {
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(MonstrousWorldModItems.TOME_OF_WITCHERY.get()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("\"Here, take this guidebook! It'll get you started on Witchery!\""), false);
											}
										});
									} else {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
											if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= 20) {
												if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_HasZombieCure) : 0) == 1) {
													MonstrousWorldMod.queueServerWork(2, () -> {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Zombie Cure Trade";
															_vars.TradeHeading = "Witch Cure Trade";
															_vars.TradeButton = "Witch Button";
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
													});
												} else {
													MonstrousWorldMod.queueServerWork(2, () -> {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeHeading = "Witch Trade";
															_vars.TradeButton = "Witch Button";
															_vars.markSyncDirty();
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 1) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 1";
																_vars.markSyncDirty();
															}
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 2) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 2";
																_vars.markSyncDirty();
															}
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 3) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 3";
																_vars.markSyncDirty();
															}
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 4) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 4";
																_vars.markSyncDirty();
															}
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 5) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 5";
																_vars.markSyncDirty();
															}
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 6) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 6";
																_vars.markSyncDirty();
															}
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 7) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 7";
																_vars.markSyncDirty();
															}
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 8) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 8";
																_vars.markSyncDirty();
															}
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 9) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 9";
																_vars.markSyncDirty();
															}
														}
														if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 10) {
															{
																MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
																_vars.TradeType = "Witch Trade 10";
																_vars.markSyncDirty();
															}
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
													});
												}
											}
										} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
											if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_HasWerewolfCure) : 0) == 1) {
												MonstrousWorldMod.queueServerWork(2, () -> {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Witch Werewolf Cure Trade";
														_vars.TradeHeading = "Witch Cure Trade";
														_vars.TradeButton = "Witch Button";
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
												});
											} else {
												MonstrousWorldMod.queueServerWork(2, () -> {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeHeading = "Witch Trade";
														_vars.TradeButton = "Witch Button";
														_vars.markSyncDirty();
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 1) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 1";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 2) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 2";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 3";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 4) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 4";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 5";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 6) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 6";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 7) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 7";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 8) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 8";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 9) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 9";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 10) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 10";
															_vars.markSyncDirty();
														}
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
												});
											}
										} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
											if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_HasVampireCure) : 0) == 1) {
												MonstrousWorldMod.queueServerWork(2, () -> {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeHeading = "Witch Cure Trade";
														_vars.TradeType = "Witch Vampire Cure Trade";
														_vars.TradeButton = "Witch Button";
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
												});
											} else {
												MonstrousWorldMod.queueServerWork(2, () -> {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeHeading = "Witch Trade";
														_vars.TradeButton = "Witch Button";
														_vars.markSyncDirty();
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 1) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 1";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 2) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 2";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 3";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 4) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 4";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 5";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 6) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 6";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 7) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 7";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 8) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 8";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 9) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 9";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 10) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 10";
															_vars.markSyncDirty();
														}
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
												});
											}
										} else {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 1) {
												MonstrousWorldMod.queueServerWork(2, () -> {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeHeading = "Witch Trade";
														_vars.TradeButton = "Witch Button";
														_vars.markSyncDirty();
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 1) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 1";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 2) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 2";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 3";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 4) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 4";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 5) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 5";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 6) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 6";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 7) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 7";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 8) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 8";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 9) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 9";
															_vars.markSyncDirty();
														}
													}
													if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 10) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Witch Trade 10";
															_vars.markSyncDirty();
														}
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
												});
											}
										}
									}
								} else {
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\"I don't trade with evil creatures!\""), false);
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