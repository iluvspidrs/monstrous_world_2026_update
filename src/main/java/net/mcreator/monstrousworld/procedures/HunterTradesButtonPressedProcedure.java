package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class HunterTradesButtonPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Goblin to Hunter Trade")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER) {
				if (getAmountInGUISlot(entity, 0) >= 12) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(12);
							ItemStack _setstack6 = new ItemStack(MonstrousWorldModItems.HUNTER_BOOTS.get()).copy();
							_setstack6.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack6);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation_Static == false) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = 100;
											_vars.markSyncDirty();
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
									}
								});
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.getItem() == MonstrousWorldModItems.HUNTER_MALACHITE_BOOTS.get()) {
				if (getAmountInGUISlot(entity, 2) == 1) {
					if (getAmountInGUISlot(entity, 3) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:good_relations"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(1);
							ItemStack _setstack17 = new ItemStack(MonstrousWorldModItems.HUNTER_MISSION_FOR_GOBLIN.get()).copy();
							_setstack17.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(3).set(_setstack17);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation_Static == false) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = 100;
											_vars.markSyncDirty();
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
									}
								});
							}
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Hunter Trade 1")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER) {
				if (getAmountInGUISlot(entity, 0) >= 12) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:defense_against_darkness"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(12);
							ItemStack _setstack28 = new ItemStack(MonstrousWorldModItems.AMULET_OF_CLEAR_MIND.get()).copy();
							_setstack28.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack28);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation_Static == false) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = 100;
											_vars.markSyncDirty();
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
									}
								});
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:nuggets/silver")))) {
				if (getAmountInGUISlot(entity, 2) >= 6) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.DISTILLED_SILVER_INJECTION.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getAmountInGUISlot(entity, 3) <= 64) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:defense_against_darkness"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(6);
								ItemStack _setstack44 = new ItemStack(MonstrousWorldModItems.DISTILLED_SILVER_INJECTION.get()).copy();
								_setstack44.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack44);
								_player.containerMenu.broadcastChanges();
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation_Static == false) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
										_vars.markSyncDirty();
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = 100;
												_vars.markSyncDirty();
											}
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
										}
									});
								}
							}
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Hunter Trade 2")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.STRING) {
				if (getAmountInGUISlot(entity, 0) >= 8) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:defense_against_darkness"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(8);
							ItemStack _setstack55 = new ItemStack(MonstrousWorldModItems.INJECTION_OF_CLARITY.get()).copy();
							_setstack55.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack55);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation_Static == false) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = 100;
											_vars.markSyncDirty();
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
									}
								});
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(2).getItem() : ItemStack.EMPTY)
					.is(ItemTags.create(ResourceLocation.parse("c:dusts/silver")))) {
				if (getAmountInGUISlot(entity, 2) >= 6) {
					if (getAmountInGUISlot(entity, 3) <= 64) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:defense_against_darkness"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(2).remove(6);
							ItemStack _setstack66 = new ItemStack(MonstrousWorldModItems.AMULET_OF_STRONG_WILL.get()).copy();
							_setstack66.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(3).set(_setstack66);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation_Static == false) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = 100;
											_vars.markSyncDirty();
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
									}
								});
							}
						}
					}
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).TradeType).equals("Hunter Trade 3")) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu70 ? _menu70.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
				if (getAmountInGUISlot(entity, 0) >= 12) {
					if (getAmountInGUISlot(entity, 1) == 0) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:defense_against_darkness"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(12);
							ItemStack _setstack77 = new ItemStack(MonstrousWorldModItems.AMULET_OF_STRONG_WILL.get()).copy();
							_setstack77.setCount(getAmountInGUISlot(entity, 1) + 1);
							_menu.getSlots().get(1).set(_setstack77);
							_player.containerMenu.broadcastChanges();
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation_Static == false) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
									_vars.markSyncDirty();
								}
								MonstrousWorldMod.queueServerWork(1, () -> {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
										{
											MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
											_vars.Reputation = 100;
											_vars.markSyncDirty();
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
									}
								});
							}
						}
					}
				}
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER) {
				if (getAmountInGUISlot(entity, 2) >= 6) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu84 ? _menu84.getSlots().get(3).getItem() : ItemStack.EMPTY)
							.getItem() == MonstrousWorldModItems.INJECTION_OF_CLARITY.get()
							|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu86 ? _menu86.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
									.getItem()) {
						if (getAmountInGUISlot(entity, 3) <= 64) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:defense_against_darkness"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
								_menu.getSlots().get(2).remove(6);
								ItemStack _setstack93 = new ItemStack(MonstrousWorldModItems.INJECTION_OF_CLARITY.get()).copy();
								_setstack93.setCount(getAmountInGUISlot(entity, 3) + 1);
								_menu.getSlots().get(3).set(_setstack93);
								_player.containerMenu.broadcastChanges();
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation_Static == false) {
									{
										MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
										_vars.Reputation = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 5;
										_vars.markSyncDirty();
									}
									MonstrousWorldMod.queueServerWork(1, () -> {
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
											{
												MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
												_vars.Reputation = 100;
												_vars.markSyncDirty();
											}
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
										}
										if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
											if (entity instanceof LivingEntity _entity)
												_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
										}
									});
								}
							}
						}
					}
				}
			}
		}
		MonstrousWorldMod.queueServerWork(1, () -> {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.Reputation = 100;
					_vars.markSyncDirty();
				}
			}
		});
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