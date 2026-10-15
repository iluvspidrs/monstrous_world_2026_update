package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.world.inventory.TwoTradesMenu;
import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.SwampmonsterVillagerEntity;
import net.mcreator.monstrousworld.entity.SwampmonsterChieftanEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class OpenTradingGUISwampmonsterProcedure {
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
							if (entity instanceof SwampmonsterVillagerEntity) {
								if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
									if (!(sourceentity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass <= 5) {
											if ((entity instanceof SwampmonsterVillagerEntity _datEntI ? _datEntI.getEntityData().get(SwampmonsterVillagerEntity.DATA_Trade) : 0) == 1) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeType = "Swamp Trade 1";
													_vars.TradeHeading = "Swamp Trade";
													_vars.TradeButton = "Swampmonster Button";
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
											if ((entity instanceof SwampmonsterVillagerEntity _datEntI ? _datEntI.getEntityData().get(SwampmonsterVillagerEntity.DATA_Trade) : 0) == 2) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeType = "Swamp Trade 2";
													_vars.TradeHeading = "Swamp Trade";
													_vars.TradeButton = "Swampmonster Button";
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
											if ((entity instanceof SwampmonsterVillagerEntity _datEntI ? _datEntI.getEntityData().get(SwampmonsterVillagerEntity.DATA_Trade) : 0) == 3) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeType = "Swamp Trade 3";
													_vars.TradeHeading = "Swamp Trade";
													_vars.TradeButton = "Swampmonster Button";
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
											if (!(entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
												if ((entity instanceof SwampmonsterVillagerEntity _datEntI ? _datEntI.getEntityData().get(SwampmonsterVillagerEntity.DATA_Trade) : 0) == 1) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Swamp Trade 1";
														_vars.TradeHeading = "Swamp Trade";
														_vars.TradeButton = "Swampmonster Button";
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
												if ((entity instanceof SwampmonsterVillagerEntity _datEntI ? _datEntI.getEntityData().get(SwampmonsterVillagerEntity.DATA_Trade) : 0) == 2) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Swamp Trade 2";
														_vars.TradeHeading = "Swamp Trade";
														_vars.TradeButton = "Swampmonster Button";
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
												if ((entity instanceof SwampmonsterVillagerEntity _datEntI ? _datEntI.getEntityData().get(SwampmonsterVillagerEntity.DATA_Trade) : 0) == 3) {
													{
														MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
														_vars.TradeType = "Swamp Trade 3";
														_vars.TradeHeading = "Swamp Trade";
														_vars.TradeButton = "Swampmonster Button";
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
												if (getEntityScore("Assignments Out", entity) == 3) {
													if ((entity instanceof SwampmonsterVillagerEntity _datEntI ? _datEntI.getEntityData().get(SwampmonsterVillagerEntity.DATA_Trade) : 0) == 1) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Swamp Trade 1";
															_vars.TradeHeading = "Swamp Trade";
															_vars.TradeButton = "Swampmonster Button";
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
													if ((entity instanceof SwampmonsterVillagerEntity _datEntI ? _datEntI.getEntityData().get(SwampmonsterVillagerEntity.DATA_Trade) : 0) == 2) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Swamp Trade 2";
															_vars.TradeHeading = "Swamp Trade";
															_vars.TradeButton = "Swampmonster Button";
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
													if ((entity instanceof SwampmonsterVillagerEntity _datEntI ? _datEntI.getEntityData().get(SwampmonsterVillagerEntity.DATA_Trade) : 0) == 3) {
														{
															MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
															_vars.TradeType = "Swamp Trade 3";
															_vars.TradeHeading = "Swamp Trade";
															_vars.TradeButton = "Swampmonster Button";
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
									} else {
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\"You're in no shape to trade. Go talk to the Chieftain...\""), false);
									}
								} else {
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\"You think you're better than us. I only trade with my own kind!\""), false);
								}
							}
							if (entity instanceof SwampmonsterChieftanEntity) {
								if (sourceentity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH)) {
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\"This brand restores your full potential. Take care and make our kind proud.\""), false);
									if (sourceentity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:civilization_restored"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (sourceentity instanceof LivingEntity _entity)
										_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH);
									if (sourceentity instanceof LivingEntity _entity)
										_entity.removeEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH_COUNTDOWN);
									{
										MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = 0;
										_vars.MurkanusMarth = 0;
										_vars.markSyncDirty();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
								} else {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Swamp Mentor Trade";
												_vars.TradeHeading = "Swamp Mentor Trade";
												_vars.markSyncDirty();
											}
											if (!hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.TOME_OF_THE_SWAMP.get()))) {
												if (sourceentity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("\"Use this guidebook to learn the ways of our kind.\""), false);
												if (world instanceof ServerLevel _level) {
													ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(MonstrousWorldModItems.TOME_OF_THE_SWAMP.get()));
													entityToSpawn.setPickUpDelay(10);
													_level.addFreshEntity(entityToSpawn);
												}
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Poisoned Skull Trade";
												_vars.TradeHeading = "Poisoned Skull Trade";
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
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\"Make your Deathbloom before we speak again.\""), false);
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Hungry Tree Heart Trade";
												_vars.TradeHeading = "Hungry Tree Heart Trade";
												_vars.TradeButton = "Swampmonster Button";
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
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Elder Guardian Core Trade";
												_vars.TradeHeading = "Elder Guardian Core Trade";
												_vars.TradeButton = "Swampmonster Button";
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
									} else if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Deathbloom Trade";
												_vars.TradeHeading = "Deathbloom Trade";
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
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\"I might have a trade for you when you're stronger.\""), false);
										}
									} else {
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\"Everyone thinks they're better than us. I don't trade with many!\""), false);
									}
								}
							}
						});
					}
				}
			}
		}
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}