package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class EnchantToolsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 4) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PURIFIED_CLEAR_QUARTZ_SHARD.get()) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof ArmorItem) {
									if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.is(ItemTags.create(ResourceLocation.parse("minecraft:foot_armor")))) {
										if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED)) != 0)) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
												_menu.getSlots().get(5).remove(1);
												_player.containerMenu.broadcastChanges();
											}
											(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(6).getItem() : ItemStack.EMPTY)
													.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED), 3);
										} else {
											if (entity instanceof Player _player)
												_player.closeContainer();
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This enchantment is already on this item"), false);
										}
									} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.is(ItemTags.create(ResourceLocation.parse("minecraft:leg_armor")))) {
										if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK)) != 0)) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
												_menu.getSlots().get(5).remove(1);
												_player.containerMenu.broadcastChanges();
											}
											(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(6).getItem() : ItemStack.EMPTY)
													.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK), 3);
										} else {
											if (entity instanceof Player _player)
												_player.closeContainer();
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This enchantment is already on this item"), false);
										}
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This enchantment doesn't work on this item"), false);
									}
								} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getItem() instanceof CrossbowItem) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu53 ? _menu53.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE), 3);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This enchantment is already on this item"), false);
									}
								} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getItem() instanceof PickaxeItem
										|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getItem() instanceof AxeItem
										|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getItem() instanceof ShovelItem) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu67 ? _menu67.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), 3);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This enchantment is already on this item"), false);
									}
								} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu71 ? _menu71.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getItem() instanceof TridentItem) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu73 ? _menu73.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu77 ? _menu77.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING), 1);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This enchantment is already on this item"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This enchantment doesn't work on this item type"), false);
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PURIFIED_ROSE_QUARTZ_SHARD.get()) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(6).getItem() : ItemStack.EMPTY).getMaxDamage() >= 1) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu91 ? _menu91.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), 1);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item already has this enchantment"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This enchantment only works on damageable items"), false);
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu97 ? _menu97.getSlots().get(5).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PURIFIED_MALACHITE.get()) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu99 ? _menu99.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
										|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu101 ? _menu101.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getItem() instanceof AxeItem) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu103 ? _menu103.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS)) != 0)) {
										if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu105 ? _menu105.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS)) != 0)) {
											if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu107 ? _menu107.getSlots().get(6).getItem() : ItemStack.EMPTY)
													.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE)) != 0)) {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
												if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
													_menu.getSlots().get(5).remove(1);
													_player.containerMenu.broadcastChanges();
												}
												(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu111 ? _menu111.getSlots().get(6).getItem() : ItemStack.EMPTY)
														.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS), 3);
											} else {
												if (entity instanceof Player _player)
													_player.closeContainer();
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
											}
										} else {
											if (entity instanceof Player _player)
												_player.closeContainer();
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
										}
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This enchantment can't be used on this type of item"), false);
								}
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu121 ? _menu121.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_ONYX.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu123 ? _menu123.getSlots().get(6).getItem() : ItemStack.EMPTY).getMaxDamage() >= 1) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu125 ? _menu125.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu129 ? _menu129.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 4);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof SwordItem
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu135 ? _menu135.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getItem() instanceof AxeItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu137 ? _menu137.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu141 ? _menu141.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), 2);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu145 ? _menu145.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof CrossbowItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu147 ? _menu147.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu151 ? _menu151.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), 2);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu155 ? _menu155.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof BowItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu157 ? _menu157.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu161 ? _menu161.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER), 5);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu165 ? _menu165.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof TridentItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu167 ? _menu167.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE)) != 0)) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu169 ? _menu169.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING)) != 0)) {
										if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu171 ? _menu171.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY)) != 0)) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
												_menu.getSlots().get(5).remove(1);
												_player.containerMenu.broadcastChanges();
											}
											(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu175 ? _menu175.getSlots().get(6).getItem() : ItemStack.EMPTY)
													.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE), 3);
										} else {
											if (entity instanceof Player _player)
												_player.closeContainer();
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
										}
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This enchantment doesn't work on this type of item"), false);
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu185 ? _menu185.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_SARDONYX.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu187 ? _menu187.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof ArmorItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu189 ? _menu189.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu193 ? _menu193.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS), 2);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu197 ? _menu197.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu199 ? _menu199.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getItem() instanceof SwordItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu201 ? _menu201.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS)) != 0)) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu203 ? _menu203.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE)) != 0)) {
										if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu205 ? _menu205.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS)) != 0)) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
												_menu.getSlots().get(5).remove(1);
												_player.containerMenu.broadcastChanges();
											}
											(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu209 ? _menu209.getSlots().get(6).getItem() : ItemStack.EMPTY)
													.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS), 5);
										} else {
											if (entity instanceof Player _player)
												_player.closeContainer();
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
										}
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu217 ? _menu217.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof BowItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu219 ? _menu219.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu223 ? _menu223.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH), 2);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu227 ? _menu227.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof TridentItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu229 ? _menu229.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu233 ? _menu233.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING), 5);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This enchantment doesn't work on this type of item"), false);
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu239 ? _menu239.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_MOONSTONE.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu241 ? _menu241.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof TridentItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu243 ? _menu243.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE)) != 0)) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu245 ? _menu245.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu249 ? _menu249.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY), 3);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu255 ? _menu255.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu257 ? _menu257.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getItem() instanceof PickaxeItem
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu259 ? _menu259.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getItem() instanceof ShovelItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu261 ? _menu261.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) != 0)) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu263 ? _menu263.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu267 ? _menu267.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH), 1);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu273 ? _menu273.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() == Items.FISHING_ROD) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu275 ? _menu275.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu279 ? _menu279.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE), 3);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This enchantment doesn't work on this type of item"), false);
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu285 ? _menu285.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_TIGERS_EYE.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu287 ? _menu287.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu289 ? _menu289.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getItem() instanceof AxeItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu291 ? _menu291.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS)) != 0)) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu293 ? _menu293.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu297 ? _menu297.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE), 4);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
								}
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This enchantment doesn't work on this type of item"), false);
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu305 ? _menu305.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_GREEN_AGATE.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu307 ? _menu307.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu309 ? _menu309.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getItem() instanceof AxeItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu311 ? _menu311.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu315 ? _menu315.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING), 3);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu319 ? _menu319.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() == Items.FISHING_ROD) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu321 ? _menu321.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu325 ? _menu325.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA), 3);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu329 ? _menu329.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof PickaxeItem
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu331 ? _menu331.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getItem() instanceof ShovelItem
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu333 ? _menu333.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getItem() instanceof HoeItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu335 ? _menu335.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) != 0)) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu337 ? _menu337.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu341 ? _menu341.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 3);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu347 ? _menu347.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof BowItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu349 ? _menu349.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY)) != 0)) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu351 ? _menu351.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu355 ? _menu355.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY), 1);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu361 ? _menu361.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof CrossbowItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu363 ? _menu363.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu367 ? _menu367.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT), 1);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("These enchantments can't go on this item"), false);
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu373 ? _menu373.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_BLUE_AGATE.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu375 ? _menu375.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("minecraft:head_armor")))) {
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu377 ? _menu377.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION)) != 0
										&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu379 ? _menu379.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY)) != 0) {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has these enchantments"), false);
								}
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu383 ? _menu383.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu387 ? _menu387.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY), 3);
								}
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu389 ? _menu389.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu393 ? _menu393.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION), 3);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu395 ? _menu395.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.is(ItemTags.create(ResourceLocation.parse("minecraft:foot_armor")))) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu397 ? _menu397.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu401 ? _menu401.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER), 3);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has this enchantment"), false);
								}
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This Stone can't enchant this particular item"), false);
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu407 ? _menu407.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_PALE_AGATE.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu409 ? _menu409.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof ArmorItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu411 ? _menu411.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.is(ItemTags.create(ResourceLocation.parse("minecraft:foot_armor"))))) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu413 ? _menu413.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION)) != 0)) {
										if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu415 ? _menu415.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION)) != 0)) {
											if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu417 ? _menu417.getSlots().get(6).getItem() : ItemStack.EMPTY)
													.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0)) {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
												if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
													_menu.getSlots().get(5).remove(1);
													_player.containerMenu.broadcastChanges();
												}
												(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu421 ? _menu421.getSlots().get(6).getItem() : ItemStack.EMPTY)
														.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION), 3);
											} else {
												if (entity instanceof Player _player)
													_player.closeContainer();
												if (entity instanceof Player _player && !_player.level().isClientSide())
													_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
											}
										} else {
											if (entity instanceof Player _player)
												_player.closeContainer();
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
										}
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item already has this enchantment"), false);
									}
								} else {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu429 ? _menu429.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING)) != 0)) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
											_menu.getSlots().get(5).remove(1);
											_player.containerMenu.broadcastChanges();
										}
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu433 ? _menu433.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING), 4);
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item already has this enchantment"), false);
									}
								}
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This Stone can't enchant this particular item"), false);
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu439 ? _menu439.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_RED_AGATE.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu441 ? _menu441.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof ArmorItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu443 ? _menu443.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION)) != 0)) {
									if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu445 ? _menu445.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION)) != 0)) {
										if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu447 ? _menu447.getSlots().get(6).getItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0)) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
												_menu.getSlots().get(5).remove(1);
												_player.containerMenu.broadcastChanges();
											}
											(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu451 ? _menu451.getSlots().get(6).getItem() : ItemStack.EMPTY)
													.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION), 3);
										} else {
											if (entity instanceof Player _player)
												_player.closeContainer();
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("This item already has this enchantment"), false);
										}
									} else {
										if (entity instanceof Player _player)
											_player.closeContainer();
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
									}
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item's Enchantments can't be used with each other"), false);
								}
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This Stone can't enchant this particular item"), false);
							}
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu461 ? _menu461.getSlots().get(5).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.PURIFIED_NETHER_GEM.get()) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu463 ? _menu463.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
									|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu465 ? _menu465.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.getItem() instanceof AxeItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu467 ? _menu467.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu471 ? _menu471.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), 3);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has this enchantment"), false);
								}
							} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu475 ? _menu475.getSlots().get(6).getItem() : ItemStack.EMPTY)
									.getItem() instanceof BowItem) {
								if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu477 ? _menu477.getSlots().get(6).getItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME)) != 0)) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
										_menu.getSlots().get(5).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu481 ? _menu481.getSlots().get(6).getItem() : ItemStack.EMPTY)
											.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME), 3);
								} else {
									if (entity instanceof Player _player)
										_player.closeContainer();
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("This item already has this enchantment"), false);
								}
							} else {
								if (entity instanceof Player _player)
									_player.closeContainer();
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("This Stone can't enchant this particular item"), false);
							}
						}
					}
				}
			}
		}
	}
}