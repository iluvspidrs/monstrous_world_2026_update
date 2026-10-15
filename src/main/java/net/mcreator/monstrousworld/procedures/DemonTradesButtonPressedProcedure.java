package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class DemonTradesButtonPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Victim Heart")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VICTIM_HEART
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 8) {
					if (getAmountInGUISlot(entity, 1) <= 56) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(8);
							ItemStack _setstack6 = new ItemStack(MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()).copy();
							_setstack6.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack6);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
							if (entity instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\"I make you more powerful! You can now invade the nightmares of villagers!\""), false);
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.FactionLevel = 4;
								_vars.markSyncDirty();
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.JAR_OF_EYES
					.get()) {
				if (getAmountInGUISlot(entity, 2) >= 1) {
					if (getAmountInGUISlot(entity, 3) == 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							ItemStack _setstack19 = new ItemStack(MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()).copy();
							_setstack19.setCount(getAmountInGUISlot(entity, 3) + 6);
							_menu.getSlots().get(3).set(_setstack19);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Pure Fear")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PURE_FEAR
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 4) {
					if (getAmountInGUISlot(entity, 1) <= 60) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(4);
							ItemStack _setstack26 = new ItemStack(MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()).copy();
							_setstack26.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack26);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
							if (entity instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\"I make you more powerful! You can now make and use the chainsaw!\""), false);
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.FactionLevel = 5;
								_vars.markSyncDirty();
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.JAR_OF_EYES
					.get()) {
				if (getAmountInGUISlot(entity, 2) >= 1) {
					if (getAmountInGUISlot(entity, 3) == 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							ItemStack _setstack39 = new ItemStack(MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()).copy();
							_setstack39.setCount(getAmountInGUISlot(entity, 3) + 6);
							_menu.getSlots().get(3).set(_setstack39);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_ghastly_alliance"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Maniac Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) <= 63) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack47 = new ItemStack(MonstrousWorldModItems.JAR_OF_EYES.get()).copy();
							_setstack47.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack47);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:macabe_trading"));
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
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()) {
				if (getAmountInGUISlot(entity, 2) >= 6) {
					if (getAmountInGUISlot(entity, 3) <= 63) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(6);
							ItemStack _setstack55 = new ItemStack(MonstrousWorldModItems.VICTIM_HEART.get()).copy();
							_setstack55.setCount(getAmountInGUISlot(entity, 3) + 1);
							_menu.getSlots().get(3).set(_setstack55);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:macabe_trading"));
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

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}