package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class ButtonPressedGoblinOvenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (getAmountInGUISlot(entity, 2) < 64) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_ESSENCE
						.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE_OF_SATURATION.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack12 = new ItemStack(MonstrousWorldModItems.PUMPKIN_COOKIE_OF_SATURATION.get()).copy();
							_setstack12.setCount(getAmountInGUISlot(entity, 2) + 1);
							_menu.getSlots().get(2).set(_setstack12);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SPIRIT_DUST
						.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE_OF_WEIGHTLESSNESS.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack26 = new ItemStack(MonstrousWorldModItems.PUMPKIN_COOKIE_OF_WEIGHTLESSNESS.get()).copy();
							_setstack26.setCount(getAmountInGUISlot(entity, 2) + 1);
							_menu.getSlots().get(2).set(_setstack26);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.RED_HOTS
						.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PUMPKIN_COOKIEOF_FIRE_RESISTANCE.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack40 = new ItemStack(MonstrousWorldModItems.PUMPKIN_COOKIEOF_FIRE_RESISTANCE.get()).copy();
							_setstack40.setCount(getAmountInGUISlot(entity, 2) + 1);
							_menu.getSlots().get(2).set(_setstack40);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu43 ? _menu43.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.A_HINT_OF_INSANITY.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE_OF_INSANITY.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack54 = new ItemStack(MonstrousWorldModItems.PUMPKIN_COOKIE_OF_INSANITY.get()).copy();
							_setstack54.setCount(getAmountInGUISlot(entity, 2) + 1);
							_menu.getSlots().get(2).set(_setstack54);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.HINT_OF_SANITY.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE_OF_SANITY.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack68 = new ItemStack(MonstrousWorldModItems.PUMPKIN_COOKIE_OF_SANITY.get()).copy();
							_setstack68.setCount(getAmountInGUISlot(entity, 2) + 1);
							_menu.getSlots().get(2).set(_setstack68);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu71 ? _menu71.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu73 ? _menu73.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.UNDEATHLY_ESSENCE.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu75 ? _menu75.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE_OF_REANIMATION.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack82 = new ItemStack(MonstrousWorldModItems.PUMPKIN_COOKIE_OF_REANIMATION.get()).copy();
							_setstack82.setCount(getAmountInGUISlot(entity, 2) + 1);
							_menu.getSlots().get(2).set(_setstack82);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.ESSENCE_OF_DECEPTION.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu89 ? _menu89.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.COOKIE_OF_CONFUSION.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack96 = new ItemStack(MonstrousWorldModItems.COOKIE_OF_CONFUSION.get()).copy();
							_setstack96.setCount(getAmountInGUISlot(entity, 2) + 1);
							_menu.getSlots().get(2).set(_setstack96);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu99 ? _menu99.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu101 ? _menu101.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.ESSENCE_OF_EXHAUSTION.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu103 ? _menu103.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.COOKIE_OF_EXHAUSTION.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack110 = new ItemStack(MonstrousWorldModItems.COOKIE_OF_EXHAUSTION.get()).copy();
							_setstack110.setCount(getAmountInGUISlot(entity, 2) + 1);
							_menu.getSlots().get(2).set(_setstack110);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu113 ? _menu113.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PUMPKIN_COOKIE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu115 ? _menu115.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.ESSENCE_OF_TRANSFORMATION.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu117 ? _menu117.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu120 ? _menu120.getSlots().get(2).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.COOKIE_OF_TRANSFORMATION.get()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.furnace.fire_crackle")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							ItemStack _setstack124 = new ItemStack(MonstrousWorldModItems.COOKIE_OF_TRANSFORMATION.get()).copy();
							_setstack124.setCount(getAmountInGUISlot(entity, 2) + 1);
							_menu.getSlots().get(2).set(_setstack124);
							_menu.getSlots().get(0).remove(1);
							_menu.getSlots().get(1).remove(1);
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