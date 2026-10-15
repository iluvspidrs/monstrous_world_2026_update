package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.item.Items;
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

public class ModifyAxesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(4).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:nuggets/electrum")))
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("monstrous_world:precious_stones")))
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("monstrous_world:troll_tools_basic")))) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_monstrous_alliance"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_AXE) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack11 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_CLEAR.get()).copy();
					_setstack11.setCount(1);
					_menu.getSlots().get(8).set(_setstack11);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack20 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_ROSE.get()).copy();
					_setstack20.setCount(1);
					_menu.getSlots().get(8).set(_setstack20);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack29 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_MALACHITE.get()).copy();
					_setstack29.setCount(1);
					_menu.getSlots().get(8).set(_setstack29);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack38 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_TIGERS.get()).copy();
					_setstack38.setCount(1);
					_menu.getSlots().get(8).set(_setstack38);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack47 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_GREEN_AGATE.get()).copy();
					_setstack47.setCount(1);
					_menu.getSlots().get(8).set(_setstack47);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack56 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_BLUE_AGATE.get()).copy();
					_setstack56.setCount(1);
					_menu.getSlots().get(8).set(_setstack56);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu58 ? _menu58.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack65 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_PALE_AGATE.get()).copy();
					_setstack65.setCount(1);
					_menu.getSlots().get(8).set(_setstack65);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu67 ? _menu67.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack74 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_RED_AGATE.get()).copy();
					_setstack74.setCount(1);
					_menu.getSlots().get(8).set(_setstack74);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu75 ? _menu75.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack83 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_ONYX.get()).copy();
					_setstack83.setCount(1);
					_menu.getSlots().get(8).set(_setstack83);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu84 ? _menu84.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack92 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_SARDONYX.get()).copy();
					_setstack92.setCount(1);
					_menu.getSlots().get(8).set(_setstack92);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu94 ? _menu94.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu93 ? _menu93.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu99 ? _menu99.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.NETHER_GEM
					.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack101 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_RED_NETHER.get()).copy();
					_setstack101.setCount(1);
					_menu.getSlots().get(8).set(_setstack101);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu103 ? _menu103.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack110 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_AXE_MOONSTONE.get()).copy();
					_setstack110.setCount(1);
					_menu.getSlots().get(8).set(_setstack110);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu111 ? _menu111.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu117 ? _menu117.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_AXE) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu119 ? _menu119.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack121 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_CLEAR.get()).copy();
					_setstack121.setCount(1);
					_menu.getSlots().get(8).set(_setstack121);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu123 ? _menu123.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu122 ? _menu122.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu128 ? _menu128.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack130 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_ROSE.get()).copy();
					_setstack130.setCount(1);
					_menu.getSlots().get(8).set(_setstack130);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu132 ? _menu132.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu131 ? _menu131.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu137 ? _menu137.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack139 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_MALACHITE.get()).copy();
					_setstack139.setCount(1);
					_menu.getSlots().get(8).set(_setstack139);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu141 ? _menu141.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu140 ? _menu140.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu146 ? _menu146.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack148 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_TIGERS.get()).copy();
					_setstack148.setCount(1);
					_menu.getSlots().get(8).set(_setstack148);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu149 ? _menu149.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu155 ? _menu155.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack157 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_GREEN_AGATE.get()).copy();
					_setstack157.setCount(1);
					_menu.getSlots().get(8).set(_setstack157);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu159 ? _menu159.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu158 ? _menu158.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu164 ? _menu164.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack166 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_BLUE_AGATE.get()).copy();
					_setstack166.setCount(1);
					_menu.getSlots().get(8).set(_setstack166);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu168 ? _menu168.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu167 ? _menu167.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu173 ? _menu173.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack175 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_PALE_AGATE.get()).copy();
					_setstack175.setCount(1);
					_menu.getSlots().get(8).set(_setstack175);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu177 ? _menu177.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu176 ? _menu176.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack184 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_RED_AGATE.get()).copy();
					_setstack184.setCount(1);
					_menu.getSlots().get(8).set(_setstack184);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu185 ? _menu185.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu191 ? _menu191.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack193 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_ONYX.get()).copy();
					_setstack193.setCount(1);
					_menu.getSlots().get(8).set(_setstack193);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu195 ? _menu195.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu194 ? _menu194.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu200 ? _menu200.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack202 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_SARDONYX.get()).copy();
					_setstack202.setCount(1);
					_menu.getSlots().get(8).set(_setstack202);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu204 ? _menu204.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu203 ? _menu203.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu209 ? _menu209.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.NETHER_GEM
					.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack211 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_NETHER.get()).copy();
					_setstack211.setCount(1);
					_menu.getSlots().get(8).set(_setstack211);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu213 ? _menu213.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu212 ? _menu212.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu218 ? _menu218.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack220 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_AXE_MOONSTONE.get()).copy();
					_setstack220.setCount(1);
					_menu.getSlots().get(8).set(_setstack220);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu222 ? _menu222.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu221 ? _menu221.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu227 ? _menu227.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_AXE) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu229 ? _menu229.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack231 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_CLEAR.get()).copy();
					_setstack231.setCount(1);
					_menu.getSlots().get(8).set(_setstack231);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu233 ? _menu233.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu232 ? _menu232.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu238 ? _menu238.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack240 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_ROSE.get()).copy();
					_setstack240.setCount(1);
					_menu.getSlots().get(8).set(_setstack240);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu242 ? _menu242.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu241 ? _menu241.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu247 ? _menu247.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack249 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_MALACHITE.get()).copy();
					_setstack249.setCount(1);
					_menu.getSlots().get(8).set(_setstack249);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu251 ? _menu251.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu250 ? _menu250.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu256 ? _menu256.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack258 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_TIGERS.get()).copy();
					_setstack258.setCount(1);
					_menu.getSlots().get(8).set(_setstack258);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu260 ? _menu260.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu259 ? _menu259.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu265 ? _menu265.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack267 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_GREEN_AGATE.get()).copy();
					_setstack267.setCount(1);
					_menu.getSlots().get(8).set(_setstack267);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu269 ? _menu269.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu268 ? _menu268.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu274 ? _menu274.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack276 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_BLUE_AGATE.get()).copy();
					_setstack276.setCount(1);
					_menu.getSlots().get(8).set(_setstack276);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu278 ? _menu278.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu277 ? _menu277.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu283 ? _menu283.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack285 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_PALE_AGATE.get()).copy();
					_setstack285.setCount(1);
					_menu.getSlots().get(8).set(_setstack285);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu287 ? _menu287.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu286 ? _menu286.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu292 ? _menu292.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack294 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_RED_AGATE.get()).copy();
					_setstack294.setCount(1);
					_menu.getSlots().get(8).set(_setstack294);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu296 ? _menu296.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu295 ? _menu295.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu301 ? _menu301.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack303 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_ONYX.get()).copy();
					_setstack303.setCount(1);
					_menu.getSlots().get(8).set(_setstack303);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu305 ? _menu305.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu304 ? _menu304.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu310 ? _menu310.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack312 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_SARDONYX.get()).copy();
					_setstack312.setCount(1);
					_menu.getSlots().get(8).set(_setstack312);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu314 ? _menu314.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu313 ? _menu313.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu319 ? _menu319.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.NETHER_GEM
					.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack321 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_NETHER.get()).copy();
					_setstack321.setCount(1);
					_menu.getSlots().get(8).set(_setstack321);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu323 ? _menu323.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu322 ? _menu322.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu328 ? _menu328.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack330 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_AXE_MOONSTONE.get()).copy();
					_setstack330.setCount(1);
					_menu.getSlots().get(8).set(_setstack330);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu332 ? _menu332.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu331 ? _menu331.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu337 ? _menu337.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:nuggets/electrum")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu339 ? _menu339.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BRONZE_AXE
						.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu341 ? _menu341.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack343 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_CLEAR.get()).copy();
							_setstack343.setCount(1);
							_menu.getSlots().get(8).set(_setstack343);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu345 ? _menu345.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu344 ? _menu344.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu351 ? _menu351.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack353 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_ROSE.get()).copy();
							_setstack353.setCount(1);
							_menu.getSlots().get(8).set(_setstack353);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu355 ? _menu355.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu354 ? _menu354.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu361 ? _menu361.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack363 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_MALACHITE.get()).copy();
							_setstack363.setCount(1);
							_menu.getSlots().get(8).set(_setstack363);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu365 ? _menu365.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu364 ? _menu364.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu371 ? _menu371.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack373 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_TIGERS.get()).copy();
							_setstack373.setCount(1);
							_menu.getSlots().get(8).set(_setstack373);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu375 ? _menu375.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu374 ? _menu374.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu381 ? _menu381.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack383 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_GREEN_AGATE.get()).copy();
							_setstack383.setCount(1);
							_menu.getSlots().get(8).set(_setstack383);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu385 ? _menu385.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu384 ? _menu384.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu391 ? _menu391.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack393 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_BLUE_AGATE.get()).copy();
							_setstack393.setCount(1);
							_menu.getSlots().get(8).set(_setstack393);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu395 ? _menu395.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu394 ? _menu394.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu401 ? _menu401.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack403 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_PALE_AGATE.get()).copy();
							_setstack403.setCount(1);
							_menu.getSlots().get(8).set(_setstack403);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu405 ? _menu405.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu404 ? _menu404.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu411 ? _menu411.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack413 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_RED_AGATE.get()).copy();
							_setstack413.setCount(1);
							_menu.getSlots().get(8).set(_setstack413);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu415 ? _menu415.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu414 ? _menu414.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu421 ? _menu421.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack423 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_ONYX.get()).copy();
							_setstack423.setCount(1);
							_menu.getSlots().get(8).set(_setstack423);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu425 ? _menu425.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu424 ? _menu424.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu431 ? _menu431.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack433 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_SARDONYX.get()).copy();
							_setstack433.setCount(1);
							_menu.getSlots().get(8).set(_setstack433);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu435 ? _menu435.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu434 ? _menu434.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu441 ? _menu441.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.NETHER_GEM.get()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack443 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_NETHER.get()).copy();
							_setstack443.setCount(1);
							_menu.getSlots().get(8).set(_setstack443);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu445 ? _menu445.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu444 ? _menu444.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu451 ? _menu451.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack453 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_AXE_MOONSTONE.get()).copy();
							_setstack453.setCount(1);
							_menu.getSlots().get(8).set(_setstack453);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu455 ? _menu455.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu454 ? _menu454.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu461 ? _menu461.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.CORINTHIAN_BRONZE_AXE.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu463 ? _menu463.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack465 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_CLEAR.get()).copy();
							_setstack465.setCount(1);
							_menu.getSlots().get(8).set(_setstack465);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu467 ? _menu467.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu466 ? _menu466.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu473 ? _menu473.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack475 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_ROSE.get()).copy();
							_setstack475.setCount(1);
							_menu.getSlots().get(8).set(_setstack475);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu477 ? _menu477.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu476 ? _menu476.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu483 ? _menu483.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack485 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_MALACHITE.get()).copy();
							_setstack485.setCount(1);
							_menu.getSlots().get(8).set(_setstack485);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu487 ? _menu487.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu486 ? _menu486.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu493 ? _menu493.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack495 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_TIGERS.get()).copy();
							_setstack495.setCount(1);
							_menu.getSlots().get(8).set(_setstack495);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu497 ? _menu497.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu496 ? _menu496.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu503 ? _menu503.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack505 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_GREEN_AGATE.get()).copy();
							_setstack505.setCount(1);
							_menu.getSlots().get(8).set(_setstack505);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu507 ? _menu507.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu506 ? _menu506.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu513 ? _menu513.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack515 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_BLUE_AGATE.get()).copy();
							_setstack515.setCount(1);
							_menu.getSlots().get(8).set(_setstack515);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu517 ? _menu517.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu516 ? _menu516.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu523 ? _menu523.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack525 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_PALE_AGATE.get()).copy();
							_setstack525.setCount(1);
							_menu.getSlots().get(8).set(_setstack525);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu527 ? _menu527.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu526 ? _menu526.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu533 ? _menu533.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack535 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_RED_AGATE.get()).copy();
							_setstack535.setCount(1);
							_menu.getSlots().get(8).set(_setstack535);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu537 ? _menu537.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu536 ? _menu536.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu543 ? _menu543.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack545 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_ONYX.get()).copy();
							_setstack545.setCount(1);
							_menu.getSlots().get(8).set(_setstack545);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu547 ? _menu547.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu546 ? _menu546.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu553 ? _menu553.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack555 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_SARDONYX.get()).copy();
							_setstack555.setCount(1);
							_menu.getSlots().get(8).set(_setstack555);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu557 ? _menu557.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu556 ? _menu556.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu563 ? _menu563.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.NETHER_GEM.get()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack565 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_NETHER.get()).copy();
							_setstack565.setCount(1);
							_menu.getSlots().get(8).set(_setstack565);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu567 ? _menu567.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu566 ? _menu566.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu573 ? _menu573.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack575 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_MOONSTONE.get()).copy();
							_setstack575.setCount(1);
							_menu.getSlots().get(8).set(_setstack575);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu577 ? _menu577.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu576 ? _menu576.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu583 ? _menu583.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_AXE.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu585 ? _menu585.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack587 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_CLEAR.get()).copy();
							_setstack587.setCount(1);
							_menu.getSlots().get(8).set(_setstack587);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu589 ? _menu589.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu588 ? _menu588.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu595 ? _menu595.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack597 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_ROSE.get()).copy();
							_setstack597.setCount(1);
							_menu.getSlots().get(8).set(_setstack597);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu599 ? _menu599.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu598 ? _menu598.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu605 ? _menu605.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack607 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_MALACHITE.get()).copy();
							_setstack607.setCount(1);
							_menu.getSlots().get(8).set(_setstack607);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu609 ? _menu609.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu608 ? _menu608.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu615 ? _menu615.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack617 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_TIGERS.get()).copy();
							_setstack617.setCount(1);
							_menu.getSlots().get(8).set(_setstack617);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu619 ? _menu619.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu618 ? _menu618.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu625 ? _menu625.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack627 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_GREEN_AGATE.get()).copy();
							_setstack627.setCount(1);
							_menu.getSlots().get(8).set(_setstack627);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu629 ? _menu629.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu628 ? _menu628.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu635 ? _menu635.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack637 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_BLUE_AGATE.get()).copy();
							_setstack637.setCount(1);
							_menu.getSlots().get(8).set(_setstack637);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu639 ? _menu639.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu638 ? _menu638.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu645 ? _menu645.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack647 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_PALE_AGATE.get()).copy();
							_setstack647.setCount(1);
							_menu.getSlots().get(8).set(_setstack647);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu649 ? _menu649.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu648 ? _menu648.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu655 ? _menu655.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack657 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_RED_AGATE.get()).copy();
							_setstack657.setCount(1);
							_menu.getSlots().get(8).set(_setstack657);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu659 ? _menu659.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu658 ? _menu658.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu665 ? _menu665.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack667 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_ONYX.get()).copy();
							_setstack667.setCount(1);
							_menu.getSlots().get(8).set(_setstack667);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu669 ? _menu669.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu668 ? _menu668.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu675 ? _menu675.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack677 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_SARDONYX.get()).copy();
							_setstack677.setCount(1);
							_menu.getSlots().get(8).set(_setstack677);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu679 ? _menu679.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu678 ? _menu678.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu685 ? _menu685.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.NETHER_GEM.get()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack687 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_NETHER.get()).copy();
							_setstack687.setCount(1);
							_menu.getSlots().get(8).set(_setstack687);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu689 ? _menu689.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu688 ? _menu688.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu695 ? _menu695.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack697 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_AXE_MOONSTONE.get()).copy();
							_setstack697.setCount(1);
							_menu.getSlots().get(8).set(_setstack697);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu699 ? _menu699.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu698 ? _menu698.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu705 ? _menu705.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.DARKENED_AXE.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu707 ? _menu707.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack709 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_CLEAR.get()).copy();
							_setstack709.setCount(1);
							_menu.getSlots().get(8).set(_setstack709);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu711 ? _menu711.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu710 ? _menu710.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu717 ? _menu717.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack719 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_ROSE.get()).copy();
							_setstack719.setCount(1);
							_menu.getSlots().get(8).set(_setstack719);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu721 ? _menu721.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu720 ? _menu720.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu727 ? _menu727.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack729 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_MALACHITE.get()).copy();
							_setstack729.setCount(1);
							_menu.getSlots().get(8).set(_setstack729);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu731 ? _menu731.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu730 ? _menu730.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu737 ? _menu737.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack739 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_TIGERS.get()).copy();
							_setstack739.setCount(1);
							_menu.getSlots().get(8).set(_setstack739);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu741 ? _menu741.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu740 ? _menu740.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu747 ? _menu747.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack749 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_GREEN_AGATE.get()).copy();
							_setstack749.setCount(1);
							_menu.getSlots().get(8).set(_setstack749);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu751 ? _menu751.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu750 ? _menu750.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu757 ? _menu757.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack759 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_BLUE_AGATE.get()).copy();
							_setstack759.setCount(1);
							_menu.getSlots().get(8).set(_setstack759);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu761 ? _menu761.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu760 ? _menu760.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu767 ? _menu767.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack769 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_PALE_AGATE.get()).copy();
							_setstack769.setCount(1);
							_menu.getSlots().get(8).set(_setstack769);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu771 ? _menu771.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu770 ? _menu770.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu777 ? _menu777.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack779 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_RED_AGATE.get()).copy();
							_setstack779.setCount(1);
							_menu.getSlots().get(8).set(_setstack779);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu781 ? _menu781.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu780 ? _menu780.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu787 ? _menu787.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack789 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_ONYX.get()).copy();
							_setstack789.setCount(1);
							_menu.getSlots().get(8).set(_setstack789);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu791 ? _menu791.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu790 ? _menu790.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu797 ? _menu797.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack799 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_SARDONYX.get()).copy();
							_setstack799.setCount(1);
							_menu.getSlots().get(8).set(_setstack799);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu801 ? _menu801.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu800 ? _menu800.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu807 ? _menu807.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.NETHER_GEM.get()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack809 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_NETHER.get()).copy();
							_setstack809.setCount(1);
							_menu.getSlots().get(8).set(_setstack809);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu811 ? _menu811.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu810 ? _menu810.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu817 ? _menu817.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack819 = new ItemStack(MonstrousWorldModItems.MODIFIED_DARKENED_AXE_MOONSTONE.get()).copy();
							_setstack819.setCount(1);
							_menu.getSlots().get(8).set(_setstack819);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu821 ? _menu821.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu820 ? _menu820.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
	}
}