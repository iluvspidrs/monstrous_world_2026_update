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

public class ModifyShovelsProcedure {
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
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_SHOVEL) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack11 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_SHOVEL_ROSE.get()).copy();
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
					.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack20 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_SHOVEL_GREEN_AGATE.get()).copy();
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
					.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack29 = new ItemStack(MonstrousWorldModItems.MODIFIED_IRON_SHOVEL_NETHER.get()).copy();
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
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_SHOVEL) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack40 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_SHOVEL_ROSE.get()).copy();
					_setstack40.setCount(1);
					_menu.getSlots().get(8).set(_setstack40);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack49 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_SHOVEL_GREEN_AGATE.get()).copy();
					_setstack49.setCount(1);
					_menu.getSlots().get(8).set(_setstack49);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack58 = new ItemStack(MonstrousWorldModItems.MODIFIED_DIAMOND_SHOVEL_NETHER.get()).copy();
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
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_SHOVEL) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu67 ? _menu67.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack69 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_SHOVEL_ROSE.get()).copy();
					_setstack69.setCount(1);
					_menu.getSlots().get(8).set(_setstack69);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu71 ? _menu71.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu70 ? _menu70.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack78 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_SHOVEL_GREEN_AGATE.get()).copy();
					_setstack78.setCount(1);
					_menu.getSlots().get(8).set(_setstack78);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu79 ? _menu79.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(5).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					ItemStack _setstack87 = new ItemStack(MonstrousWorldModItems.MODIFIED_NETHERITE_SHOVEL_NETHER.get()).copy();
					_setstack87.setCount(1);
					_menu.getSlots().get(8).set(_setstack87);
					_player.containerMenu.broadcastChanges();
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu89 ? _menu89.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
				if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_menu.getSlots().get(7).remove(1);
					_menu.getSlots().get(6).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu94 ? _menu94.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:nuggets/electrum")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BRONZE_SHOVEL
						.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack100 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_SHOVEL_ROSE.get()).copy();
							_setstack100.setCount(1);
							_menu.getSlots().get(8).set(_setstack100);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu101 ? _menu101.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack110 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_SHOVEL_GREEN_AGATE.get()).copy();
							_setstack110.setCount(1);
							_menu.getSlots().get(8).set(_setstack110);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu111 ? _menu111.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu118 ? _menu118.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack120 = new ItemStack(MonstrousWorldModItems.MODIFIED_BRONZE_SHOVEL_NETHER.get()).copy();
							_setstack120.setCount(1);
							_menu.getSlots().get(8).set(_setstack120);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu122 ? _menu122.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu121 ? _menu121.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu128 ? _menu128.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.CORINTHIAN_BRONZE_SHOVEL.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu130 ? _menu130.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack132 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_SHOVEL_ROSE.get()).copy();
							_setstack132.setCount(1);
							_menu.getSlots().get(8).set(_setstack132);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu134 ? _menu134.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu140 ? _menu140.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack142 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_AXE_SHOVEL_AGATE.get()).copy();
							_setstack142.setCount(1);
							_menu.getSlots().get(8).set(_setstack142);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu144 ? _menu144.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu143 ? _menu143.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack152 = new ItemStack(MonstrousWorldModItems.MODIFIED_CORINTHIAN_BRONZE_SHOVEL_NETHER.get()).copy();
							_setstack152.setCount(1);
							_menu.getSlots().get(8).set(_setstack152);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu154 ? _menu154.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu153 ? _menu153.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu160 ? _menu160.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_SHOVEL.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu162 ? _menu162.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack164 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_SHOVEL_ROSE.get()).copy();
							_setstack164.setCount(1);
							_menu.getSlots().get(8).set(_setstack164);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu166 ? _menu166.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu165 ? _menu165.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu172 ? _menu172.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack174 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_SHOVEL_GREEN_AGATE.get()).copy();
							_setstack174.setCount(1);
							_menu.getSlots().get(8).set(_setstack174);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu176 ? _menu176.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu175 ? _menu175.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack184 = new ItemStack(MonstrousWorldModItems.MODIFIED_SHINING_NETHERITE_SHOVEL_NETHER.get()).copy();
							_setstack184.setCount(1);
							_menu.getSlots().get(8).set(_setstack184);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu185 ? _menu185.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu192 ? _menu192.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SWAMP_CRYSTAL_SHOVEL.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu194 ? _menu194.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack196 = new ItemStack(MonstrousWorldModItems.MODIFIED_SWAMP_CRYSTAL_SHOVEL_ROSE.get()).copy();
							_setstack196.setCount(1);
							_menu.getSlots().get(8).set(_setstack196);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu198 ? _menu198.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu197 ? _menu197.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu204 ? _menu204.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack206 = new ItemStack(MonstrousWorldModItems.MODIFIED_SWAMP_CRYSTAL_SHOVEL_GREEN_AGATE.get()).copy();
							_setstack206.setCount(1);
							_menu.getSlots().get(8).set(_setstack206);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu208 ? _menu208.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu207 ? _menu207.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
							_menu.getSlots().get(7).remove(1);
							_menu.getSlots().get(6).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu214 ? _menu214.getSlots().get(5).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:gems/nether_gem")))) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack216 = new ItemStack(MonstrousWorldModItems.MODIFIED_SWAMP_CRYSTAL_SHOVEL_NETHER.get()).copy();
							_setstack216.setCount(1);
							_menu.getSlots().get(8).set(_setstack216);
							_player.containerMenu.broadcastChanges();
						}
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu218 ? _menu218.getSlots().get(8).getItem() : ItemStack.EMPTY)
								.applyComponents((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu217 ? _menu217.getSlots().get(6).getItem() : ItemStack.EMPTY).getComponents());
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(4).remove(1);
							_menu.getSlots().get(5).remove(1);
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