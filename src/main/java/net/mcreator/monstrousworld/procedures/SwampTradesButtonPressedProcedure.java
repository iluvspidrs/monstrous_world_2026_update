package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class SwampTradesButtonPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Swamp Trade 1")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.SALMON) {
				if (getAmountInGUISlot(entity, 0) >= 6) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:unfriendly_faces"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(6);
							ItemStack _setstack7 = new ItemStack(Items.TADPOLE_BUCKET).copy();
							_setstack7.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack7);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ODD_ROOT.get()) {
				if (getAmountInGUISlot(entity, 2) >= 1) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:unfriendly_faces"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							ItemStack _setstack15 = new ItemStack(MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get()).copy();
							_setstack15.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack15);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Swamp Trade 2")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get()) {
				if (getAmountInGUISlot(entity, 0) >= 12) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:unfriendly_faces"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(12);
							ItemStack _setstack23 = new ItemStack(MonstrousWorldModItems.MYSTERIOUS_SEED.get()).copy();
							_setstack23.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack23);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNGRY_TREE_BARK
					.get()) {
				if (getAmountInGUISlot(entity, 2) >= 3) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:unfriendly_faces"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(3);
							ItemStack _setstack31 = new ItemStack(MonstrousWorldModItems.CAPTURED_SWAMP_LIGHT.get()).copy();
							_setstack31.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack31);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Swamp Trade 3")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SWAMP_ESSENCE
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) <= 48) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:unfriendly_faces"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack39 = new ItemStack(Items.SALMON).copy();
							_setstack39.setCount(getAmountInGUISlot(entity, 1) + 16);
							_menu.getSlots().get(1).set(_setstack39);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SWAMP_ESSENCE_DUST.get()) {
				if (getAmountInGUISlot(entity, 2) >= 3) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:unfriendly_faces"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(3);
							ItemStack _setstack47 = new ItemStack(MonstrousWorldModItems.HUNGRY_TREE_BARK.get()).copy();
							_setstack47.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack47);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Hungry Tree Heart Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNGRY_TREE_HEART
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.NETHER_GEM
						.get()) {
					if (getAmountInGUISlot(entity, 0) >= 5) {
						if (getAmountInGUISlot(entity, 2) >= 10) {
							if (getAmountInGUISlot(entity, 1) == 0) {
								if (getEntityScore("nether_gems_mined", entity) >= 10) {
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:unfriendly_faces"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(0).remove(5);
										_menu.getSlots().get(2).remove(10);
										ItemStack _setstack59 = new ItemStack(MonstrousWorldModItems.BRAND_OF_STRENGTH.get()).copy();
										_setstack59.setCount(1);
										_menu.getSlots().get(1).set(_setstack59);
										_player.containerMenu.broadcastChanges();
									}
								}
								if (getEntityScore("nether_gems_mined", entity) < 10) {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\"You can't fool me. Go mine Nether Gems from the Nether, and then we'll talk.\""), false);
								}
							}
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Elder Guardian Core Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNGRY_TREE_HEART
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.ELDER_GUARDIAN_CORE.get()) {
					if (getAmountInGUISlot(entity, 0) >= 5) {
						if (getAmountInGUISlot(entity, 2) >= 3) {
							if (getAmountInGUISlot(entity, 1) == 0) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(5);
									_menu.getSlots().get(2).remove(3);
									ItemStack _setstack72 = new ItemStack(MonstrousWorldModItems.BRAND_OF_CONQUEST.get()).copy();
									_setstack72.setCount(1);
									_menu.getSlots().get(1).set(_setstack72);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Goblin to Hunter Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu73 ? _menu73.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER) {
				if (getAmountInGUISlot(entity, 0) >= 12) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(12);
							ItemStack _setstack79 = new ItemStack(MonstrousWorldModItems.HUNTER_BOOTS.get()).copy();
							_setstack79.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack79);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.HUNTER_MALACHITE_BOOTS.get()) {
				if (getAmountInGUISlot(entity, 2) == 1) {
					if (getAmountInGUISlot(entity, 3) == 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							ItemStack _setstack86 = new ItemStack(MonstrousWorldModItems.HUNTER_MISSION_FOR_GOBLIN.get()).copy();
							_setstack86.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(3).set(_setstack86);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static int getEntityScore(String score, Entity entity) {
		Scoreboard scoreboard = entity.level().getScoreboard();
		Objective scoreboardObjective = scoreboard.getObjective(score);
		if (scoreboardObjective != null)
			return scoreboard.getOrCreatePlayerScore(ScoreHolder.forNameOnly(entity.getScoreboardName()), scoreboardObjective).get();
		return 0;
	}
}