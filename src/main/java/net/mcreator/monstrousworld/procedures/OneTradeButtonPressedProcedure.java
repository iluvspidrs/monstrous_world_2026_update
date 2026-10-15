package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

public class OneTradeButtonPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Human Blood")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BOTTLE_OF_BLOOD
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:selling_your_blood"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack7 = new ItemStack(Items.GOLD_INGOT).copy();
							_setstack7.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack7);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Goblin Blood")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.BOTTLE_OF_GOBLIN_BLOOD.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:selling_your_blood"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack15 = new ItemStack(MonstrousWorldModItems.SARDONYX.get()).copy();
							_setstack15.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack15);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Troll Blood")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.BOTTLE_OF_TROLL_BLOOD.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:selling_your_blood"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack23 = new ItemStack(MonstrousWorldModItems.DARKENED_IRON_INGOT.get()).copy();
							_setstack23.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack23);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Swampmonster Blood")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.BOTTLE_OF_SWAMPMONSTER_BLOOD.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:selling_your_blood"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack31 = new ItemStack(MonstrousWorldModItems.SWAMP_CRYSTAL_SHARD.get()).copy();
							_setstack31.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack31);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Werewolf Blood")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.BOTTLE_OF_WEREWOLF_BLOOD.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:selling_your_blood"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack39 = new ItemStack(Items.COOKED_BEEF).copy();
							_setstack39.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack39);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:undigified_hunting"));
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
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Eye Mutant Blood")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.BOTTLE_OF_EYE_MUTANT_BLOOD.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:selling_your_blood"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack48 = new ItemStack(MonstrousWorldModItems.DARKENED_IRON_INGOT.get()).copy();
							_setstack48.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack48);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Fly Mutant Blood")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.BOTTLE_OF_FLY_MUTANT_BLOOD.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:selling_your_blood"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack56 = new ItemStack(MonstrousWorldModItems.DARKENED_IRON_INGOT.get()).copy();
							_setstack56.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack56);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Serpent Mutant Blood")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.BOTTLE_OF_SERPENT_MUTANT_BLOOD.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:selling_your_blood"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack64 = new ItemStack(MonstrousWorldModItems.DARKENED_IRON_INGOT.get()).copy();
							_setstack64.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack64);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Deathbloom Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MONSTER_DETECTOR
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 10) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(10);
							ItemStack _setstack71 = new ItemStack(MonstrousWorldModItems.DEATH_BLOOM.get()).copy();
							_setstack71.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack71);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Poisoned Skull Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.POISONED_SKULL
					.get().asItem()) {
				if (getAmountInGUISlot(entity, 0) >= 10) {
					if (getAmountInGUISlot(entity, 1) < 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(10);
							ItemStack _setstack78 = new ItemStack(MonstrousWorldModItems.DEATHBLOOM_INSTRUCTIONS.get()).copy();
							_setstack78.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack78);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FactionLevel = 3;
									_vars.markSyncDirty();
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You advance a level!"), true);
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:the_toxic_avenger"));
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
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Fly Mutant Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu82 ? _menu82.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.ROTTEN_FLESH) {
				if (getAmountInGUISlot(entity, 0) >= 32) {
					if (getAmountInGUISlot(entity, 1) <= 63) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack88 = new ItemStack(MonstrousWorldModItems.DIGESTED_ROTTEN_FLESH.get()).copy();
							_setstack88.setCount(getAmountInGUISlot(entity, 1) + 3);
							_menu.getSlots().get(1).set(_setstack88);
							_player.containerMenu.broadcastChanges();
						}
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
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Eye Mutant Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TIN_INGOT
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 4) {
					if (getAmountInGUISlot(entity, 1) <= 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(4);
							ItemStack _setstack96 = new ItemStack(MonstrousWorldModItems.DREADFUL_TEARS.get()).copy();
							_setstack96.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack96);
							_player.containerMenu.broadcastChanges();
						}
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
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Goblin to Hunter Trade Complete")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.DROPPED_SOCIETY_PLANS_ITEM.get()) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) <= 60) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack104 = new ItemStack(MonstrousWorldModItems.PURIFIED_SILVER.get()).copy();
							_setstack104.setCount(getAmountInGUISlot(entity, 1) + 6);
							_menu.getSlots().get(1).set(_setstack104);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.FactionLevel = 4;
									_vars.markSyncDirty();
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("You advance a level!"), true);
								if (entity instanceof LivingEntity _entity) {
									AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:goblinsneak4"), 0.1, AttributeModifier.Operation.ADD_VALUE);
									if (!_entity.getAttribute(Attributes.SNEAKING_SPEED).hasModifier(modifier.id())) {
										_entity.getAttribute(Attributes.SNEAKING_SPEED).addPermanentModifier(modifier);
									}
								}
							}
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Goblin to Hunter Trade Advanced")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("monstrous_world:modified_silver_daggers")))) {
				if (getAmountInGUISlot(entity, 0) >= 1) {
					if (getAmountInGUISlot(entity, 1) <= 63) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							ItemStack _setstack114 = new ItemStack(MonstrousWorldModItems.PURIFIED_SILVER.get()).copy();
							_setstack114.setCount(getAmountInGUISlot(entity, 1) + 3);
							_menu.getSlots().get(1).set(_setstack114);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Troll Trade Goblin")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu115 ? _menu115.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT) {
				if (getAmountInGUISlot(entity, 0) >= 32) {
					if (getAmountInGUISlot(entity, 1) <= 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack121 = new ItemStack(MonstrousWorldModItems.ELECTRUM_NUGGET.get()).copy();
							_setstack121.setCount(getAmountInGUISlot(entity, 1) + 8);
							_menu.getSlots().get(1).set(_setstack121);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Troll Trade Blood")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu122 ? _menu122.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TIN_INGOT
					.get()) {
				if (getAmountInGUISlot(entity, 0) >= 8) {
					if (getAmountInGUISlot(entity, 1) <= 64) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(8);
							ItemStack _setstack128 = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_TROLL_BLOOD.get()).copy();
							_setstack128.setCount(getAmountInGUISlot(entity, 1) + 4);
							_menu.getSlots().get(1).set(_setstack128);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Troll Trade 1")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu129 ? _menu129.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.CASSITERITE_CRYSTAL.get()) {
				if (getAmountInGUISlot(entity, 0) >= 32) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack136 = new ItemStack(MonstrousWorldModItems.BRONZE_SWORD.get()).copy();
							_setstack136.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack136);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu137 ? _menu137.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD) {
				if (getAmountInGUISlot(entity, 0) >= 32) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack144 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_SWORD.get()).copy();
							_setstack144.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack144);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu145 ? _menu145.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_SCRAP) {
				if (getAmountInGUISlot(entity, 0) >= 4) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(4);
							ItemStack _setstack152 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_SWORD.get()).copy();
							_setstack152.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack152);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Troll Trade 2")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu153 ? _menu153.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tin_ores")))) {
				if (getAmountInGUISlot(entity, 0) >= 32) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack160 = new ItemStack(MonstrousWorldModItems.BRONZE_PICKAXE.get()).copy();
							_setstack160.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack160);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu161 ? _menu161.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD) {
				if (getAmountInGUISlot(entity, 0) >= 32) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack168 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_PICKAXE.get()).copy();
							_setstack168.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack168);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu169 ? _menu169.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_SCRAP) {
				if (getAmountInGUISlot(entity, 0) >= 4) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(4);
							ItemStack _setstack176 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_PICKAXE.get()).copy();
							_setstack176.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack176);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Troll Trade 3")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu177 ? _menu177.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tin_ores")))) {
				if (getAmountInGUISlot(entity, 0) >= 32) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack184 = new ItemStack(MonstrousWorldModItems.BRONZE_AXE.get()).copy();
							_setstack184.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack184);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu185 ? _menu185.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD) {
				if (getAmountInGUISlot(entity, 0) >= 32) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack192 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_AXE.get()).copy();
							_setstack192.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack192);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu193 ? _menu193.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_SCRAP) {
				if (getAmountInGUISlot(entity, 0) >= 4) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(4);
							ItemStack _setstack200 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_AXE.get()).copy();
							_setstack200.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack200);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Troll Trade 4")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu201 ? _menu201.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tin_ores")))) {
				if (getAmountInGUISlot(entity, 0) >= 16) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(16);
							ItemStack _setstack208 = new ItemStack(MonstrousWorldModItems.BRONZE_SHOVEL.get()).copy();
							_setstack208.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack208);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu209 ? _menu209.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD) {
				if (getAmountInGUISlot(entity, 0) >= 16) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(16);
							ItemStack _setstack216 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_SHOVEL.get()).copy();
							_setstack216.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack216);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu217 ? _menu217.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_SCRAP) {
				if (getAmountInGUISlot(entity, 0) >= 2) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							ItemStack _setstack224 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_SHOVEL.get()).copy();
							_setstack224.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack224);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Troll Trade 5")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu225 ? _menu225.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:raw_materials/tin_ores")))) {
				if (getAmountInGUISlot(entity, 0) >= 16) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(16);
							ItemStack _setstack232 = new ItemStack(MonstrousWorldModItems.BRONZE_HOE.get()).copy();
							_setstack232.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack232);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu233 ? _menu233.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.RAW_GOLD) {
				if (getAmountInGUISlot(entity, 0) >= 16) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(16);
							ItemStack _setstack240 = new ItemStack(MonstrousWorldModItems.CORINTHIAN_BRONZE_HOE.get()).copy();
							_setstack240.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack240);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu241 ? _menu241.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_SCRAP) {
				if (getAmountInGUISlot(entity, 0) >= 2) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:not_trolling"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(2);
							ItemStack _setstack248 = new ItemStack(MonstrousWorldModItems.SHINING_NETHERITE_HOE.get()).copy();
							_setstack248.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack248);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Goblin Trade Troll")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu249 ? _menu249.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:nuggets/electrum")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu251 ? _menu251.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ARMOR_CORE
						.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu253 ? _menu253.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
								.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 9) {
						if (getAmountInGUISlot(entity, 1) <= 63) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(9);
								ItemStack _setstack260 = new ItemStack(MonstrousWorldModItems.ARMOR_CORE.get()).copy();
								_setstack260.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack260);
								_player.containerMenu.broadcastChanges();
							}
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:our_talents_combined"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Sorcerer Trade 1")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu262 ? _menu262.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.TIGERS_EYE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu264 ? _menu264.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 32) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack270 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_WITCHERY.get()).copy();
							_setstack270.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack270);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:choose_your_own_adventure"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Sorcerer Trade 2")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu272 ? _menu272.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MALACHITE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu274 ? _menu274.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 32) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack280 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_GOBLIN.get()).copy();
							_setstack280.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack280);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:choose_your_own_adventure"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Sorcerer Trade 3")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu282 ? _menu282.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLACK_ONYX
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu284 ? _menu284.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 32) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack290 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_TROLL.get()).copy();
							_setstack290.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack290);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:choose_your_own_adventure"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Sorcerer Trade 4")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu292 ? _menu292.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GREEN_AGATE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu294 ? _menu294.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 32) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack300 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_SORCERY.get()).copy();
							_setstack300.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack300);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:choose_your_own_adventure"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Sorcerer Trade 5")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu302 ? _menu302.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PALE_AGATE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu304 ? _menu304.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 32) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack310 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_MAD_SCIENCE.get()).copy();
							_setstack310.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack310);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:choose_your_own_adventure"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Sorcerer Trade 6")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu312 ? _menu312.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.BLUE_AGATE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu314 ? _menu314.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 32) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack320 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_SWAMP.get()).copy();
							_setstack320.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack320);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:choose_your_own_adventure"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Sorcerer Trade 7")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu322 ? _menu322.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MOONSTONE
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu324 ? _menu324.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 32) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack330 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_THE_MOON.get()).copy();
							_setstack330.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack330);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:choose_your_own_adventure"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Sorcerer Trade 8")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu332 ? _menu332.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SARDONYX
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu334 ? _menu334.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 32) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack340 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_BLOODLUST.get()).copy();
							_setstack340.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack340);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:choose_your_own_adventure"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Sorcerer Trade 9")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu342 ? _menu342.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu344 ? _menu344.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 32) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(32);
							ItemStack _setstack350 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_DARKNESS.get()).copy();
							_setstack350.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack350);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:choose_your_own_adventure"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("DM Trade 1")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu352 ? _menu352.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.NETHER_GEM
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu354 ? _menu354.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 24) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(24);
							ItemStack _setstack360 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_INFERNAL_POWER.get()).copy();
							_setstack360.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack360);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:buyers_remorse"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("DM Trade 2")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu362 ? _menu362.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu364 ? _menu364.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 24) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(24);
							ItemStack _setstack370 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_FUN_AND_GAMES.get()).copy();
							_setstack370.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack370);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:buyers_remorse"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("DM Trade 3")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu372 ? _menu372.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SARDONYX
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu374 ? _menu374.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 24) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(24);
							ItemStack _setstack380 = new ItemStack(MonstrousWorldModItems.ENCHANTED_TOME_OF_VIOLENCE.get()).copy();
							_setstack380.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack380);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:buyers_remorse"));
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Infernal Knife")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu382 ? _menu382.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.JAR_OF_EYES
					.get()) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu384 ? _menu384.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
					if (getAmountInGUISlot(entity, 0) >= 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player)
							_player.closeContainer();
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
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(MonstrousWorldModItems.INFERNAL_BUTCHER_KNIFE.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.FactionLevel = 2;
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\"I strengthen you! Make good use of your knife!\""), false);
							if (entity instanceof LivingEntity _entity) {
								AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("monstrous_world:maniac_strength_2"), 2, AttributeModifier.Operation.ADD_VALUE);
								if (!_entity.getAttribute(Attributes.ATTACK_DAMAGE).hasModifier(modifier.id())) {
									_entity.getAttribute(Attributes.ATTACK_DAMAGE).addPermanentModifier(modifier);
								}
							}
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Maniac Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu398 ? _menu398.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()) {
				if (getAmountInGUISlot(entity, 1) <= 63) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu401 ? _menu401.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu404 ? _menu404.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.VICTIM_HEART.get()) {
						if (getAmountInGUISlot(entity, 0) >= 6) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(6);
								ItemStack _setstack409 = new ItemStack(MonstrousWorldModItems.VICTIM_HEART.get()).copy();
								_setstack409.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack409);
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Maniac Trade 2")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu411 ? _menu411.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()) {
				if (getAmountInGUISlot(entity, 1) <= 63) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu414 ? _menu414.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu417 ? _menu417.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.JAR_OF_EYES.get()) {
						if (getAmountInGUISlot(entity, 0) >= 3) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(3);
								ItemStack _setstack422 = new ItemStack(MonstrousWorldModItems.JAR_OF_EYES.get()).copy();
								_setstack422.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack422);
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
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Maniac Trade 3")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu424 ? _menu424.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.INFERNAL_IRON_INGOT.get()) {
				if (getAmountInGUISlot(entity, 1) <= 63) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu427 ? _menu427.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu430 ? _menu430.getSlots().get(1).getItem() : ItemStack.EMPTY)
									.getItem() == MonstrousWorldModItems.PURE_FEAR.get()) {
						if (getAmountInGUISlot(entity, 0) >= 8) {
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(0).remove(8);
								ItemStack _setstack435 = new ItemStack(MonstrousWorldModItems.PURE_FEAR.get()).copy();
								_setstack435.setCount(getAmountInGUISlot(entity, 1) + 1);
								_menu.getSlots().get(1).set(_setstack435);
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