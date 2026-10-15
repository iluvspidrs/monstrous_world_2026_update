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
import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.entity.VampireNPCEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class OpenTradingGUIVampireProcedure {
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
			if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MONSTER_DETECTOR.get())) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
					if (!(sourceentity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH))) {
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
								if (entity instanceof VampireNPCEntity) {
									if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BeastForm == false) {
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Fly Mutant Blood";
												_vars.TradeHeading = "Vampire Blood Trade";
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Eye Mutant Blood";
												_vars.TradeHeading = "Vampire Blood Trade";
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Serpent Mutant Blood";
												_vars.TradeHeading = "Vampire Blood Trade";
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Werewolf Blood";
												_vars.TradeHeading = "Vampire Blood Trade";
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1
													|| sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5
													|| sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeType = "Human Blood";
													_vars.TradeHeading = "Vampire Blood Trade";
													_vars.markSyncDirty();
												}
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Goblin Blood";
												_vars.TradeHeading = "Vampire Blood Trade";
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Troll Blood";
												_vars.TradeHeading = "Vampire Blood Trade";
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Swampmonster Blood";
												_vars.TradeHeading = "Vampire Blood Trade";
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.TradeType = "Werewolf Blood";
												_vars.TradeHeading = "Vampire Blood Trade";
												_vars.markSyncDirty();
											}
										}
										if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
												if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 10 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 11) {
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
														_player.displayClientMessage(Component.literal("\"I will not trade with a creature like you!\""), false);
												}
											}
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeType = "Vampire To Vampire";
													_vars.TradeHeading = "Vampire To Vampire";
													_vars.TradeButton = "Vampire Button";
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
											if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8) {
												{
													MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
													_vars.TradeType = "Vampire Mentor";
													_vars.TradeHeading = "Vampire Mentor";
													_vars.markSyncDirty();
												}
												if (!hasEntityInInventory(sourceentity, new ItemStack(MonstrousWorldModItems.TOME_OF_BLOODLUST.get()))) {
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(MonstrousWorldModItems.TOME_OF_BLOODLUST.get()));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
													if (sourceentity instanceof Player _player && !_player.level().isClientSide())
														_player.displayClientMessage(Component.literal("\"Tap into your growing power with this guidebook.\""), false);
												}
											}
										} else {
											if (sourceentity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("\"Go away, you disgusting creature!\""), false);
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