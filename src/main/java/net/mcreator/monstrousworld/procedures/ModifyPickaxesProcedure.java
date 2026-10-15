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

public class ModifyPickaxesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(4).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:nuggets/electrum")))
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("monstrous_world:precious_stones")))
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(5).getItem() : ItemStack.EMPTY)
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
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_PICKAXE) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack11 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_PICKAXE_CLEAR.get()).copy();
					_setstack11.setCount(1);
					_menu.getSlots().get(8).set(_setstack11);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack20 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_PICKAXE_ROSE.get()).copy();
					_setstack20.setCount(1);
					_menu.getSlots().get(8).set(_setstack20);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack29 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_PICKAXE_GREEN_AGATE.get()).copy();
					_setstack29.setCount(1);
					_menu.getSlots().get(8).set(_setstack29);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack38 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_PICKAXE_BLUE_AGATE.get()).copy();
					_setstack38.setCount(1);
					_menu.getSlots().get(8).set(_setstack38);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack47 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_PICKAXE_NETHER.get()).copy();
					_setstack47.setCount(1);
					_menu.getSlots().get(8).set(_setstack47);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_PICKAXE) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack58 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_PICKAXE_CLEAR.get()).copy();
					_setstack58.setCount(1);
					_menu.getSlots().get(8).set(_setstack58);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack67 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_PICKAXE_ROSE.get()).copy();
					_setstack67.setCount(1);
					_menu.getSlots().get(8).set(_setstack67);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack76 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_PICKAXE_GREEN_AGATE.get()).copy();
					_setstack76.setCount(1);
					_menu.getSlots().get(8).set(_setstack76);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu77 ? _menu77.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack85 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_PICKAXE_VLUE_AGATE.get()).copy();
					_setstack85.setCount(1);
					_menu.getSlots().get(8).set(_setstack85);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu86 ? _menu86.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack94 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_PICKAXE_NETHER.get()).copy();
					_setstack94.setCount(1);
					_menu.getSlots().get(8).set(_setstack94);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu95 ? _menu95.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu101 ? _menu101.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_PICKAXE) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu103 ? _menu103.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack105 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_PICKAXE_CLEAR.get()).copy();
					_setstack105.setCount(1);
					_menu.getSlots().get(8).set(_setstack105);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu107 ? _menu107.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack114 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_PICKAXE_ROSE.get()).copy();
					_setstack114.setCount(1);
					_menu.getSlots().get(8).set(_setstack114);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu116 ? _menu116.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu115 ? _menu115.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu121 ? _menu121.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack123 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_PICKAXE_GREEN_AGATE.get()).copy();
					_setstack123.setCount(1);
					_menu.getSlots().get(8).set(_setstack123);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu125 ? _menu125.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu124 ? _menu124.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu130 ? _menu130.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack132 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_PICKAXE_BLUE_AGATE.get()).copy();
					_setstack132.setCount(1);
					_menu.getSlots().get(8).set(_setstack132);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu134 ? _menu134.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu139 ? _menu139.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack141 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_PICKAXE_NETHER.get()).copy();
					_setstack141.setCount(1);
					_menu.getSlots().get(8).set(_setstack141);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu143 ? _menu143.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu142 ? _menu142.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu148 ? _menu148.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:nuggets/electrum")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.BRONZE_PICKAXE.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu152 ? _menu152.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack154 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_PICKAXE_CLEAR.get()).copy();
							_setstack154.setCount(1);
							_menu.getSlots().get(8).set(_setstack154);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu156 ? _menu156.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu155 ? _menu155.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu162 ? _menu162.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack164 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_PICKAXE_ROSE.get()).copy();
							_setstack164.setCount(1);
							_menu.getSlots().get(8).set(_setstack164);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu166 ? _menu166.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu165 ? _menu165.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu172 ? _menu172.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack174 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_PICKAXE_GREEN_AGATE.get()).copy();
							_setstack174.setCount(1);
							_menu.getSlots().get(8).set(_setstack174);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu176 ? _menu176.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu175 ? _menu175.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack184 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_PICKAXE_BLUE_AGATE.get()).copy();
							_setstack184.setCount(1);
							_menu.getSlots().get(8).set(_setstack184);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu185 ? _menu185.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu192 ? _menu192.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack194 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_PICKAXE_NETHER.get()).copy();
							_setstack194.setCount(1);
							_menu.getSlots().get(8).set(_setstack194);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu196 ? _menu196.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu195 ? _menu195.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu202 ? _menu202.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.CORINTHIAN_BRONZE_PICKAXE.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu204 ? _menu204.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack206 = new ItemStack(MonstrousWorldModItems.MODIFIED_COR_BRONZE_PICKAXE_CLEAR.get()).copy();
							_setstack206.setCount(1);
							_menu.getSlots().get(8).set(_setstack206);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu208 ? _menu208.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu207 ? _menu207.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu214 ? _menu214.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack216 = new ItemStack(MonstrousWorldModItems.MODIFIED_COR_BRONZE_PICKAXE_ROSE.get()).copy();
							_setstack216.setCount(1);
							_menu.getSlots().get(8).set(_setstack216);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu218 ? _menu218.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu217 ? _menu217.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu224 ? _menu224.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack226 = new ItemStack(MonstrousWorldModItems.MODIFIED_COR_BRONZE_PICKAXE_GREEN_AGATE.get()).copy();
							_setstack226.setCount(1);
							_menu.getSlots().get(8).set(_setstack226);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu228 ? _menu228.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu227 ? _menu227.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu234 ? _menu234.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack236 = new ItemStack(MonstrousWorldModItems.MODIFIED_COR_BRONZE_PICKAXE_BLUE_AGATE.get()).copy();
							_setstack236.setCount(1);
							_menu.getSlots().get(8).set(_setstack236);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu238 ? _menu238.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu237 ? _menu237.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu244 ? _menu244.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack246 = new ItemStack(MonstrousWorldModItems.MODIFIED_COR_BRONZE_PICKAXE_NETHER.get()).copy();
							_setstack246.setCount(1);
							_menu.getSlots().get(8).set(_setstack246);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu248 ? _menu248.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu247 ? _menu247.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu254 ? _menu254.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_PICKAXE.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu256 ? _menu256.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack258 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_PICKAXE_CLEAR.get()).copy();
							_setstack258.setCount(1);
							_menu.getSlots().get(8).set(_setstack258);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu260 ? _menu260.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu259 ? _menu259.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu266 ? _menu266.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack268 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_PICKAXE_ROSE.get()).copy();
							_setstack268.setCount(1);
							_menu.getSlots().get(8).set(_setstack268);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu270 ? _menu270.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu269 ? _menu269.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu276 ? _menu276.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack278 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_PICKAXE_GREEN_AGATE.get()).copy();
							_setstack278.setCount(1);
							_menu.getSlots().get(8).set(_setstack278);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu280 ? _menu280.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu279 ? _menu279.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu286 ? _menu286.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack288 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_PICKAXE_BLUE_AGATE.get()).copy();
							_setstack288.setCount(1);
							_menu.getSlots().get(8).set(_setstack288);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu290 ? _menu290.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu289 ? _menu289.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu296 ? _menu296.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack298 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_PICKAXE_NETHER.get()).copy();
							_setstack298.setCount(1);
							_menu.getSlots().get(8).set(_setstack298);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu300 ? _menu300.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu299 ? _menu299.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
	}
}