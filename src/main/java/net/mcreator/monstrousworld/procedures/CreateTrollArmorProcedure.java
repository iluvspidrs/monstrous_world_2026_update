package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class CreateTrollArmorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ARMOR_CORE.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(4).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(7).getItem() : ItemStack.EMPTY)
										.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(8).getItem() : ItemStack.EMPTY)
											.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
										if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(9).getItem() : ItemStack.EMPTY)
												.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
											if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(10).getItem() : ItemStack.EMPTY)
													.getItem() == ItemStack.EMPTY.getItem()) {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
												if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
													ItemStack _setstack22 = new ItemStack(MonstrousWorldModItems.BRONZE_CHESTPLATE.get()).copy();
													_setstack22.setCount(1);
													_menu.getSlots().get(10).set(_setstack22);
													_menu.getSlots().get(0).remove(1);
													_menu.getSlots().get(1).remove(1);
													_menu.getSlots().get(3).remove(1);
													_menu.getSlots().get(4).remove(1);
													_menu.getSlots().get(5).remove(1);
													_menu.getSlots().get(6).remove(1);
													_menu.getSlots().get(7).remove(1);
													_menu.getSlots().get(8).remove(1);
													_menu.getSlots().get(9).remove(1);
													_player.containerMenu.broadcastChanges();
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
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(4).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(7).getItem() : ItemStack.EMPTY)
										.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(8).getItem() : ItemStack.EMPTY)
											.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
										if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(9).getItem() : ItemStack.EMPTY)
												.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
											if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(10).getItem() : ItemStack.EMPTY)
													.getItem() == ItemStack.EMPTY.getItem()) {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
												if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
													ItemStack _setstack52 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_CHESTPLATE.get()).copy();
													_setstack52.setCount(1);
													_menu.getSlots().get(10).set(_setstack52);
													_menu.getSlots().get(0).remove(1);
													_menu.getSlots().get(1).remove(1);
													_menu.getSlots().get(3).remove(1);
													_menu.getSlots().get(4).remove(1);
													_menu.getSlots().get(5).remove(1);
													_menu.getSlots().get(6).remove(1);
													_menu.getSlots().get(7).remove(1);
													_menu.getSlots().get(8).remove(1);
													_menu.getSlots().get(9).remove(1);
													_player.containerMenu.broadcastChanges();
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
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(4).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu70 ? _menu70.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(7).getItem() : ItemStack.EMPTY)
										.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(8).getItem() : ItemStack.EMPTY)
											.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
										if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(9).getItem() : ItemStack.EMPTY)
												.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
											if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(10).getItem() : ItemStack.EMPTY)
													.getItem() == ItemStack.EMPTY.getItem()) {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
												if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
													ItemStack _setstack82 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_CHESTPLATE.get()).copy();
													_setstack82.setCount(1);
													_menu.getSlots().get(10).set(_setstack82);
													_menu.getSlots().get(0).remove(1);
													_menu.getSlots().get(1).remove(1);
													_menu.getSlots().get(3).remove(1);
													_menu.getSlots().get(4).remove(1);
													_menu.getSlots().get(5).remove(1);
													_menu.getSlots().get(6).remove(1);
													_menu.getSlots().get(7).remove(1);
													_menu.getSlots().get(8).remove(1);
													_menu.getSlots().get(9).remove(1);
													_player.containerMenu.broadcastChanges();
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
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu94 ? _menu94.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(7).getItem() : ItemStack.EMPTY)
										.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu104 ? _menu104.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
										if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(10).getItem() : ItemStack.EMPTY)
												.getItem() == ItemStack.EMPTY.getItem()) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
												ItemStack _setstack110 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_LEGGINGS.get()).copy();
												_setstack110.setCount(1);
												_menu.getSlots().get(10).set(_setstack110);
												_menu.getSlots().get(0).remove(1);
												_menu.getSlots().get(1).remove(1);
												_menu.getSlots().get(2).remove(1);
												_menu.getSlots().get(3).remove(1);
												_menu.getSlots().get(4).remove(1);
												_menu.getSlots().get(6).remove(1);
												_menu.getSlots().get(7).remove(1);
												_menu.getSlots().get(9).remove(1);
												_player.containerMenu.broadcastChanges();
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu119 ? _menu119.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu121 ? _menu121.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu123 ? _menu123.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu125 ? _menu125.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu127 ? _menu127.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu129 ? _menu129.getSlots().get(7).getItem() : ItemStack.EMPTY)
										.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu131 ? _menu131.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
										if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get(10).getItem() : ItemStack.EMPTY)
												.getItem() == ItemStack.EMPTY.getItem()) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
												ItemStack _setstack137 = new ItemStack(MonstrousWorldModItems.BRONZE_LEGGINGS.get()).copy();
												_setstack137.setCount(1);
												_menu.getSlots().get(10).set(_setstack137);
												_menu.getSlots().get(0).remove(1);
												_menu.getSlots().get(1).remove(1);
												_menu.getSlots().get(2).remove(1);
												_menu.getSlots().get(3).remove(1);
												_menu.getSlots().get(4).remove(1);
												_menu.getSlots().get(6).remove(1);
												_menu.getSlots().get(7).remove(1);
												_menu.getSlots().get(9).remove(1);
												_player.containerMenu.broadcastChanges();
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu146 ? _menu146.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu148 ? _menu148.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu152 ? _menu152.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu154 ? _menu154.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu156 ? _menu156.getSlots().get(7).getItem() : ItemStack.EMPTY)
										.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu158 ? _menu158.getSlots().get(9).getItem() : ItemStack.EMPTY)
											.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
										if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu160 ? _menu160.getSlots().get(10).getItem() : ItemStack.EMPTY)
												.getItem() == ItemStack.EMPTY.getItem()) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
												ItemStack _setstack164 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_LEGGINGS.get()).copy();
												_setstack164.setCount(1);
												_menu.getSlots().get(10).set(_setstack164);
												_menu.getSlots().get(0).remove(1);
												_menu.getSlots().get(1).remove(1);
												_menu.getSlots().get(2).remove(1);
												_menu.getSlots().get(3).remove(1);
												_menu.getSlots().get(4).remove(1);
												_menu.getSlots().get(6).remove(1);
												_menu.getSlots().get(7).remove(1);
												_menu.getSlots().get(9).remove(1);
												_player.containerMenu.broadcastChanges();
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu173 ? _menu173.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu175 ? _menu175.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu177 ? _menu177.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu179 ? _menu179.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu181 ? _menu181.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu183 ? _menu183.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										ItemStack _setstack187 = new ItemStack(MonstrousWorldModItems.BRONZE_HELMET.get()).copy();
										_setstack187.setCount(1);
										_menu.getSlots().get(10).set(_setstack187);
										_menu.getSlots().get(0).remove(1);
										_menu.getSlots().get(1).remove(1);
										_menu.getSlots().get(2).remove(1);
										_menu.getSlots().get(3).remove(1);
										_menu.getSlots().get(4).remove(1);
										_menu.getSlots().get(6).remove(1);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu194 ? _menu194.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu196 ? _menu196.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu198 ? _menu198.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu200 ? _menu200.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu202 ? _menu202.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu204 ? _menu204.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										ItemStack _setstack208 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_HELMET.get()).copy();
										_setstack208.setCount(1);
										_menu.getSlots().get(10).set(_setstack208);
										_menu.getSlots().get(0).remove(1);
										_menu.getSlots().get(1).remove(1);
										_menu.getSlots().get(2).remove(1);
										_menu.getSlots().get(3).remove(1);
										_menu.getSlots().get(4).remove(1);
										_menu.getSlots().get(6).remove(1);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu215 ? _menu215.getSlots().get(1).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu217 ? _menu217.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu219 ? _menu219.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu221 ? _menu221.getSlots().get(4).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu223 ? _menu223.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu225 ? _menu225.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										ItemStack _setstack229 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_HELMET.get()).copy();
										_setstack229.setCount(1);
										_menu.getSlots().get(10).set(_setstack229);
										_menu.getSlots().get(0).remove(1);
										_menu.getSlots().get(1).remove(1);
										_menu.getSlots().get(2).remove(1);
										_menu.getSlots().get(3).remove(1);
										_menu.getSlots().get(4).remove(1);
										_menu.getSlots().get(6).remove(1);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu236 ? _menu236.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu238 ? _menu238.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu240 ? _menu240.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu242 ? _menu242.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu244 ? _menu244.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack248 = new ItemStack(MonstrousWorldModItems.BRONZE_BOOTS.get()).copy();
								_setstack248.setCount(1);
								_menu.getSlots().get(10).set(_setstack248);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(4).remove(1);
								_menu.getSlots().get(3).remove(1);
								_menu.getSlots().get(6).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu254 ? _menu254.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu256 ? _menu256.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu258 ? _menu258.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu260 ? _menu260.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu262 ? _menu262.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack266 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_BOOTS.get()).copy();
								_setstack266.setCount(1);
								_menu.getSlots().get(10).set(_setstack266);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(4).remove(1);
								_menu.getSlots().get(3).remove(1);
								_menu.getSlots().get(6).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu272 ? _menu272.getSlots().get(1).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu274 ? _menu274.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu276 ? _menu276.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu278 ? _menu278.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu280 ? _menu280.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								ItemStack _setstack284 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_BOOTS.get()).copy();
								_setstack284.setCount(1);
								_menu.getSlots().get(10).set(_setstack284);
								_menu.getSlots().get(0).remove(1);
								_menu.getSlots().get(1).remove(1);
								_menu.getSlots().get(4).remove(1);
								_menu.getSlots().get(3).remove(1);
								_menu.getSlots().get(6).remove(1);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
				}
			}
		}
		MonstrousWorldMod.queueServerWork(1, () -> {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu290 ? _menu290.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu292 ? _menu292.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu294 ? _menu294.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu296 ? _menu296.getSlots().get(7).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu298 ? _menu298.getSlots().get(9).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu300 ? _menu300.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										ItemStack _setstack304 = new ItemStack(MonstrousWorldModItems.BRONZE_HELMET.get()).copy();
										_setstack304.setCount(1);
										_menu.getSlots().get(10).set(_setstack304);
										_menu.getSlots().get(0).remove(1);
										_menu.getSlots().get(4).remove(1);
										_menu.getSlots().get(5).remove(1);
										_menu.getSlots().get(6).remove(1);
										_menu.getSlots().get(7).remove(1);
										_menu.getSlots().get(9).remove(1);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu311 ? _menu311.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu313 ? _menu313.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu315 ? _menu315.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu317 ? _menu317.getSlots().get(7).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu319 ? _menu319.getSlots().get(9).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu321 ? _menu321.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										ItemStack _setstack325 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_HELMET.get()).copy();
										_setstack325.setCount(1);
										_menu.getSlots().get(10).set(_setstack325);
										_menu.getSlots().get(0).remove(1);
										_menu.getSlots().get(4).remove(1);
										_menu.getSlots().get(5).remove(1);
										_menu.getSlots().get(6).remove(1);
										_menu.getSlots().get(7).remove(1);
										_menu.getSlots().get(9).remove(1);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu332 ? _menu332.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu334 ? _menu334.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu336 ? _menu336.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu338 ? _menu338.getSlots().get(7).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu340 ? _menu340.getSlots().get(9).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu342 ? _menu342.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										ItemStack _setstack346 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_HELMET.get()).copy();
										_setstack346.setCount(1);
										_menu.getSlots().get(10).set(_setstack346);
										_menu.getSlots().get(0).remove(1);
										_menu.getSlots().get(4).remove(1);
										_menu.getSlots().get(5).remove(1);
										_menu.getSlots().get(6).remove(1);
										_menu.getSlots().get(7).remove(1);
										_menu.getSlots().get(9).remove(1);
										_player.containerMenu.broadcastChanges();
									}
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu353 ? _menu353.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu355 ? _menu355.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu357 ? _menu357.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu359 ? _menu359.getSlots().get(9).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu361 ? _menu361.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack365 = new ItemStack(MonstrousWorldModItems.BRONZE_BOOTS.get()).copy();
									_setstack365.setCount(1);
									_menu.getSlots().get(10).set(_setstack365);
									_menu.getSlots().get(0).remove(1);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(7).remove(1);
									_menu.getSlots().get(6).remove(1);
									_menu.getSlots().get(9).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu371 ? _menu371.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu373 ? _menu373.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu375 ? _menu375.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu377 ? _menu377.getSlots().get(9).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("c:ingots/corinthian_bronze")))) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu379 ? _menu379.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack383 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_BOOTS.get()).copy();
									_setstack383.setCount(1);
									_menu.getSlots().get(10).set(_setstack383);
									_menu.getSlots().get(0).remove(1);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(7).remove(1);
									_menu.getSlots().get(6).remove(1);
									_menu.getSlots().get(9).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu389 ? _menu389.getSlots().get(4).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu391 ? _menu391.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu393 ? _menu393.getSlots().get(6).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu395 ? _menu395.getSlots().get(9).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_INGOT.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu397 ? _menu397.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									ItemStack _setstack401 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_BOOTS.get()).copy();
									_setstack401.setCount(1);
									_menu.getSlots().get(10).set(_setstack401);
									_menu.getSlots().get(0).remove(1);
									_menu.getSlots().get(4).remove(1);
									_menu.getSlots().get(7).remove(1);
									_menu.getSlots().get(6).remove(1);
									_menu.getSlots().get(9).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
				}
			}
		});
	}
}