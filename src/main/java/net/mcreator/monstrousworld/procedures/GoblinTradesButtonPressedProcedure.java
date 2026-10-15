package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class GoblinTradesButtonPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Goblin Trade Boots")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.HUNTER_BOOTS
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MALACHITE
						.get()) {
					if (getAmountInGUISlot(entity, 2) >= 12) {
						if (getAmountInGUISlot(entity, 1) == 0) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack6 = new ItemStack(MonstrousWorldModItems.HUNTER_MALACHITE_BOOTS.get()).copy();
								_setstack6.setCount(1);
								_menu.getSlots().get(1).set(_setstack6);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(12);
								_player.containerMenu.broadcastChanges();
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:extra_protection"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Goblin Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("monstrous_world:precious_stones")))) {
				if (getAmountInGUISlot(entity, 0) >= 1 && getAmountInGUISlot(entity, 2) >= 16) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_SWORD) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack23 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:iron_swords_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack23.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack23);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_PICKAXE) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack34 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:iron_pickaxes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack34.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack34);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_AXE) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack45 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:iron_axes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack45.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack45);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_SHOVEL) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack56 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:iron_shovels_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack56.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack56);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu58 ? _menu58.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_SWORD) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack67 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:diamond_swords_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack67.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack67);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu73 ? _menu73.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_PICKAXE) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack78 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:diamond_pickaxes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack78.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack78);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu79 ? _menu79.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu84 ? _menu84.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_AXE) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack89 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:diamond_axes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack89.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack89);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu91 ? _menu91.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu95 ? _menu95.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_SHOVEL) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack100 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:diamond_shovels_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack100.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack100);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu101 ? _menu101.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_SWORD) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack111 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:netherite_swords_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack111.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack111);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu113 ? _menu113.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu117 ? _menu117.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_PICKAXE) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack122 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:netherite_pickaxes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack122.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack122);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu124 ? _menu124.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu123 ? _menu123.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu128 ? _menu128.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_AXE) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack133 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:netherite_axes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack133.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack133);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu135 ? _menu135.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu134 ? _menu134.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu139 ? _menu139.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_SHOVEL) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack144 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:netherite_shovels_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack144.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack144);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu146 ? _menu146.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu145 ? _menu145.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.BRONZE_SWORD.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack155 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:bronze_swords_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack155.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack155);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu157 ? _menu157.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu156 ? _menu156.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu161 ? _menu161.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.BRONZE_PICKAXE.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack166 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:bronze_pickaxes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack166.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack166);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu168 ? _menu168.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu167 ? _menu167.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu172 ? _menu172.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.BRONZE_AXE.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack177 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:bronze_axes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack177.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack177);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu179 ? _menu179.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu178 ? _menu178.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu183 ? _menu183.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.BRONZE_SHOVEL.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack188 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:bronze_shovels_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack188.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack188);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu190 ? _menu190.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu189 ? _menu189.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu194 ? _menu194.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.CORINTHIAN_BRONZE_SWORD.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack199 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:corinthian_bronze_swords_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack199.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack199);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu201 ? _menu201.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu200 ? _menu200.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu205 ? _menu205.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.CORINTHIAN_BRONZE_PICKAXE.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack210 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:corinthian_bronze_pickaxes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack210.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack210);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu212 ? _menu212.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu211 ? _menu211.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu216 ? _menu216.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.CORINTHIAN_BRONZE_AXE.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack221 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:corinthian_bronze_axes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack221.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack221);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu223 ? _menu223.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu222 ? _menu222.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu227 ? _menu227.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.CORINTHIAN_BRONZE_SHOVEL.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack232 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:corinthian_bronze_shovels_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack232.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack232);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu234 ? _menu234.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu233 ? _menu233.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu238 ? _menu238.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_SWORD.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack243 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:shining_netherite_swords_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack243.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack243);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu245 ? _menu245.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu244 ? _menu244.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu249 ? _menu249.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_PICKAXE.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack254 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:shining_netherite_pickaxes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack254.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack254);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu256 ? _menu256.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu255 ? _menu255.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu260 ? _menu260.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_AXE.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack265 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:shining_netherite_axes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack265.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack265);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu267 ? _menu267.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu266 ? _menu266.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu271 ? _menu271.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_SHOVEL.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack276 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:shining_netherite_shovels_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack276.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack276);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu278 ? _menu278.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu277 ? _menu277.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu282 ? _menu282.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.HUNTER_BOOTS.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack287 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:hunter_boots_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack287.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack287);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu289 ? _menu289.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu288 ? _menu288.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu293 ? _menu293.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SHOVEL.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack298 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:swamp_shovels_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack298.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack298);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu300 ? _menu300.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu299 ? _menu299.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu304 ? _menu304.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SPEAR.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack309 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:swamp_spears_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack309.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack309);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu311 ? _menu311.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu310 ? _menu310.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu315 ? _menu315.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SILVER_DAGGER.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack320 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:silver_daggers_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack320.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack320);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu322 ? _menu322.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu321 ? _menu321.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu326 ? _menu326.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.DARKENED_DAGGER.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modified_darkness"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack332 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:darkened_daggers_modifed"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack332.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack332);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu334 ? _menu334.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu333 ? _menu333.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu338 ? _menu338.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.DARKENED_SWORD.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modified_darkness"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack344 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:darkened_swords_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack344.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack344);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu346 ? _menu346.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu345 ? _menu345.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu350 ? _menu350.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.DARKENED_AXE.get()) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modding_is_fun"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:modified_darkness"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack356 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("monstrous_world:darkened_axes_modified"))).getRandomElement(RandomSource.create())
										.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
								_setstack356.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack356);
								_player.containerMenu.broadcastChanges();
							}
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu358 ? _menu358.getSlots().get(1).getItem() : ItemStack.EMPTY).applyComponents(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu357 ? _menu357.getSlots().get(0).getItem() : ItemStack.EMPTY).getComponents());
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(2).remove(16);
								_player.containerMenu.broadcastChanges();
							}
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