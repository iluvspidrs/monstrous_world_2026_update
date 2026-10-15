package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class PurifyPreciousStonesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_SILVER.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack22 = new ItemStack(MonstrousWorldModItems.PURIFIED_CLEAR_QUARTZ_SHARD.get()).copy();
									_setstack22.setCount(1);
									_menu.getSlots().get(8).set(_setstack22);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack28 = new ItemStack(MonstrousWorldModItems.PURIFIED_ROSE_QUARTZ_SHARD.get()).copy();
									_setstack28.setCount(1);
									_menu.getSlots().get(8).set(_setstack28);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack34 = new ItemStack(MonstrousWorldModItems.PURIFIED_MALACHITE.get()).copy();
									_setstack34.setCount(1);
									_menu.getSlots().get(8).set(_setstack34);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack40 = new ItemStack(MonstrousWorldModItems.PURIFIED_NETHER_GEM.get()).copy();
									_setstack40.setCount(1);
									_menu.getSlots().get(8).set(_setstack40);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack46 = new ItemStack(MonstrousWorldModItems.PURIFIED_ONYX.get()).copy();
									_setstack46.setCount(1);
									_menu.getSlots().get(8).set(_setstack46);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack52 = new ItemStack(MonstrousWorldModItems.PURIFIED_TIGERS_EYE.get()).copy();
									_setstack52.setCount(1);
									_menu.getSlots().get(8).set(_setstack52);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack58 = new ItemStack(MonstrousWorldModItems.PURIFIED_SARDONYX.get()).copy();
									_setstack58.setCount(1);
									_menu.getSlots().get(8).set(_setstack58);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack64 = new ItemStack(MonstrousWorldModItems.PURIFIED_MOONSTONE.get()).copy();
									_setstack64.setCount(1);
									_menu.getSlots().get(8).set(_setstack64);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack70 = new ItemStack(MonstrousWorldModItems.PURIFIED_GREEN_AGATE.get()).copy();
									_setstack70.setCount(1);
									_menu.getSlots().get(8).set(_setstack70);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack76 = new ItemStack(MonstrousWorldModItems.PURIFIED_BLUE_AGATE.get()).copy();
									_setstack76.setCount(1);
									_menu.getSlots().get(8).set(_setstack76);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack82 = new ItemStack(MonstrousWorldModItems.PURIFIED_PALE_AGATE.get()).copy();
									_setstack82.setCount(1);
									_menu.getSlots().get(8).set(_setstack82);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
										}
									}
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu86 ? _menu86.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack88 = new ItemStack(MonstrousWorldModItems.PURIFIED_RED_AGATE.get()).copy();
									_setstack88.setCount(1);
									_menu.getSlots().get(8).set(_setstack88);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(5).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:purity_culture"));
									if (_adv != null) {
										AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
										if (!_ap.isDone()) {
											for (String criteria : _ap.getRemainingCriteria())
												_player.getAdvancements().award(_adv, criteria);
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