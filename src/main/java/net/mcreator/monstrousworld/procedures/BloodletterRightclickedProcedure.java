package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class BloodletterRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.isShiftKeyDown()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								if (world instanceof ServerLevel _level) {
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
									});
								}
								entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BLOOD_RECOVERY, 24000, 0, true, false));
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Bloodlevel = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Bloodlevel - 1;
									_vars.markSyncDirty();
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.honey_bottle.drink")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_GOBLIN_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_TROLL_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_SWAMPMONSTER_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_WEREWOLF_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_DEMON_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_BLOOD.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 1) {
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_FLY_MUTANT_BLOOD.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 2) {
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_EYE_MUTANT_BLOOD.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 3) {
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_SERPENT_MUTANT_BLOOD.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
								} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(MonstrousWorldModItems.BOTTLE_OF_WEREWOLF_BLOOD.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
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