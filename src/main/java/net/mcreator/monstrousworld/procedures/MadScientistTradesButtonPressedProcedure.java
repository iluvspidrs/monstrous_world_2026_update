package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class MadScientistTradesButtonPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Mad Scientist Normal Trade")) {
				if (Math.random() > (double) MonstrousWorldConfigConfiguration.MUTATION_CHANCE.get()) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.GLOWSTONE_DUST) {
						if (getAmountInGUISlot(entity, 0) >= 3) {
							if (getAmountInGUISlot(entity, 1) < 64) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(3);
									ItemStack _setstack8 = new ItemStack(MonstrousWorldModItems.CURE_SERUM_SYRINGE.get()).copy();
									_setstack8.setCount(getAmountInGUISlot(entity, 1) + 1);
									_menu.getSlots().get(1).set(_setstack8);
									_player.containerMenu.broadcastChanges();
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_calculated_risk"));
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
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TIN_INGOT
							.get()) {
						if (getAmountInGUISlot(entity, 2) >= 4) {
							if (getAmountInGUISlot(entity, 3) < 64) {
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(2).remove(4);
									ItemStack _setstack17 = new ItemStack(MonstrousWorldModItems.CURE_SERUM_SYRINGE.get()).copy();
									_setstack17.setCount(getAmountInGUISlot(entity, 3) + 1);
									_menu.getSlots().get(3).set(_setstack17);
									_player.containerMenu.broadcastChanges();
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:a_calculated_risk"));
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
				} else {
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
						entity.getPersistentData().putDouble("MutationType", (Mth.nextInt(RandomSource.create(), 1, 3)));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.STRANGE_SERUM, 300, 0));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\"Ah, this other serum will also make you immune to the zombie virus!\""), false);
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:mutation"));
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
			if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Mad Scientist Mutant Trade")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT.get()) {
					if (getAmountInGUISlot(entity, 0) >= 12) {
						if (getAmountInGUISlot(entity, 1) < 64) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(12);
								ItemStack _setstack33 = new ItemStack(MonstrousWorldModItems.STABILIZER_SYRINGE.get()).copy();
								_setstack33.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack33);
								_player.containerMenu.broadcastChanges();
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:more_than_cosmetic"));
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
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TIN_INGOT
						.get()) {
					if (getAmountInGUISlot(entity, 2) >= 3) {
						if (getAmountInGUISlot(entity, 3) < 64) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(4);
								ItemStack _setstack42 = new ItemStack(MonstrousWorldModItems.CURE_SERUM_SYRINGE.get()).copy();
								_setstack42.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack42);
								_player.containerMenu.broadcastChanges();
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					}
				}
			}
			if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Serpent Mutant Trade")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.NETHER_GEM
						.get()) {
					if (getAmountInGUISlot(entity, 0) >= 1) {
						if (getAmountInGUISlot(entity, 1) < 64) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(1);
								ItemStack _setstack50 = new ItemStack(MonstrousWorldModItems.VENOM_BOTTLE.get()).copy();
								_setstack50.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack50);
								_player.containerMenu.broadcastChanges();
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:reluctant_trading"));
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
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu52 ? _menu52.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TIN_INGOT
						.get()) {
					if (getAmountInGUISlot(entity, 2) >= 4) {
						if (getAmountInGUISlot(entity, 3) < 64) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(4);
								ItemStack _setstack58 = new ItemStack(MonstrousWorldModItems.SERPENT_SCALE.get()).copy();
								_setstack58.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack58);
								_player.containerMenu.broadcastChanges();
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:reluctant_trading"));
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

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}