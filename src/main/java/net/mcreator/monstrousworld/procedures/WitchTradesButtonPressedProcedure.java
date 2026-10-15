package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class WitchTradesButtonPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 1")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.SLIME_BLOSSOM
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 0) >= 2) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							ItemStack _setstack7 = new ItemStack(MonstrousWorldModItems.PARALYSIS_POWDER.get()).copy();
							_setstack7.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack7);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY
					.get()) {
				if (getAmountInGUISlot(entity, 2) >= 3) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
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
							ItemStack _setstack15 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack15.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack15);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 2")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DREADFUL_TEARS
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 3) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(3);
							ItemStack _setstack23 = new ItemStack(MonstrousWorldModItems.PARALYSIS_POWDER.get()).copy();
							_setstack23.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack23);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.FINGER_GRASS
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 2) >= 8) {
					if (getAmountInGUISlot(entity, 3) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(8);
							ItemStack _setstack31 = new ItemStack(MonstrousWorldModItems.CHARM_OF_CLEANSING.get()).copy();
							_setstack31.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack31);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 3")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.LUNAR_BLOOM
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 0) >= 2) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							ItemStack _setstack39 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack39.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack39);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.DIGESTED_ROTTEN_FLESH.get()) {
				if (getAmountInGUISlot(entity, 2) >= 3) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
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
							ItemStack _setstack47 = new ItemStack(MonstrousWorldModItems.VANISHING_POWDER.get()).copy();
							_setstack47.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack47);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 4")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SPIRIT_DUST
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 7) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(7);
							ItemStack _setstack55 = new ItemStack(MonstrousWorldModItems.CHARM_OF_POSSESSION_IMMUNITY.get()).copy();
							_setstack55.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack55);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VENOM_BOTTLE
					.get()) {
				if (getAmountInGUISlot(entity, 2) >= 2) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							ItemStack _setstack63 = new ItemStack(MonstrousWorldModItems.MIDAS_CURSE_POWDER.get()).copy();
							_setstack63.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack63);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 5")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VENOM_BOTTLE
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
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
							ItemStack _setstack71 = new ItemStack(MonstrousWorldModItems.SINKING_POWDER.get()).copy();
							_setstack71.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack71);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_ESSENCE
					.get()) {
				if (getAmountInGUISlot(entity, 2) >= 3) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
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
							ItemStack _setstack79 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack79.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack79);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 6")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DREADFUL_TEARS
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 2) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							ItemStack _setstack87 = new ItemStack(MonstrousWorldModItems.CHICKENIFY_POWDER.get()).copy();
							_setstack87.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack87);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.INSANOSUS.get()
					.asItem()) {
				if (getAmountInGUISlot(entity, 2) >= 3) {
					if (getAmountInGUISlot(entity, 3) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
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
							ItemStack _setstack95 = new ItemStack(MonstrousWorldModItems.CHARM_OF_HEALING.get()).copy();
							_setstack95.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack95);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 7")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.DIGESTED_ROTTEN_FLESH.get()) {
				if (getAmountInGUISlot(entity, 0) >= 2) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							ItemStack _setstack103 = new ItemStack(MonstrousWorldModItems.FROGIFY_POWDER.get()).copy();
							_setstack103.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack103);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu104 ? _menu104.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.PUMPESS_BLOOM
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 2) >= 2) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							ItemStack _setstack111 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack111.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack111);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 8")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.UNDEATHLY_ESSENCE.get()) {
				if (getAmountInGUISlot(entity, 0) >= 2) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							ItemStack _setstack119 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack119.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack119);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu120 ? _menu120.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.SOULFLOWER
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 2) >= 2) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							ItemStack _setstack127 = new ItemStack(MonstrousWorldModItems.EXPLOSION_POWDER.get()).copy();
							_setstack127.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack127);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 9")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu128 ? _menu128.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.VILE_LATTICE
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 0) >= 2) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							ItemStack _setstack135 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack135.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack135);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu136 ? _menu136.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.INSANOSUS
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 2) >= 2) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							ItemStack _setstack143 = new ItemStack(MonstrousWorldModItems.OBSTRUCTION_POWDER.get()).copy();
							_setstack143.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack143);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Trade 10")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu144 ? _menu144.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.FINGER_GRASS
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 0) >= 2) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							ItemStack _setstack151 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack151.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack151);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu152 ? _menu152.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.SLIME_BLOSSOM
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 2) >= 2) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:magical_wares"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							ItemStack _setstack159 = new ItemStack(MonstrousWorldModItems.PUMPKIN_POWDER.get()).copy();
							_setstack159.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack159);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Vampire Cure Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu160 ? _menu160.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.BLOOD_BULB
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 0) >= 3) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(3);
							ItemStack _setstack166 = new ItemStack(MonstrousWorldModItems.VAMPIRE_CURE_POWDER.get()).copy();
							_setstack166.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack166);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu167 ? _menu167.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.VILE_LATTICE
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 2) >= 2) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							ItemStack _setstack173 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack173.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack173);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Werewolf Cure Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu174 ? _menu174.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.LUNAR_BLOOM
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 0) >= 3) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(3);
							ItemStack _setstack180 = new ItemStack(MonstrousWorldModItems.WEREWOLF_CURE_POWDER.get()).copy();
							_setstack180.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack180);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu181 ? _menu181.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.PUMPESS_BLOOM
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 2) >= 2) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							ItemStack _setstack187 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack187.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack187);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Witch Zombie Cure Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu188 ? _menu188.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.DEATHCATCHER
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 0) >= 3) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(3);
							ItemStack _setstack194 = new ItemStack(MonstrousWorldModItems.UNDEATH_CURE_POWDER.get()).copy();
							_setstack194.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack194);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu195 ? _menu195.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.FINGER_GRASS
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 2) >= 2) {
					if (getAmountInGUISlot(entity, 3) < 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(2);
							ItemStack _setstack201 = new ItemStack(MonstrousWorldModItems.TRICK_OR_TREAT_BAG.get()).copy();
							_setstack201.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack201);
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
}