package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class PolishedCrossbowPulling2InHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack nbt = ItemStack.EMPTY;
		double damage = 0;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
					if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("delayTime") > 0) {
						{
							final String _tagName = "delayTime";
							final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("delayTime") - 1);
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else {
						if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
							if (hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.SILVER_BOLT.get())) || hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.SILVER_BOLT_PARALYSIS.get()))
									|| hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.SILVER_BOLT_BLINDING.get())) || hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.SILVER_BOLT_SINKING.get()))
									|| hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.SILVER_BOLT_VANISHING.get()))) {
								nbt.applyComponents(itemstack.getComponents());
								damage = itemstack.getDamageValue();
								if (hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.SILVER_BOLT_SINKING.get()))) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack20 = new ItemStack(MonstrousWorldModItems.ADVANCED_CROSSBOW_LOADED_SINKING.get()).copy();
										_setstack20.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack20);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.SILVER_BOLT_SINKING.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else if (hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.SILVER_BOLT_VANISHING.get()))) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack23 = new ItemStack(MonstrousWorldModItems.ADVANCED_CROSSBOW_LOADED_VANISHING.get()).copy();
										_setstack23.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack23);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.SILVER_BOLT_VANISHING.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else if (hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.SILVER_BOLT_PARALYSIS.get()))) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack26 = new ItemStack(MonstrousWorldModItems.ADVANCED_CROSSBOW_LOADED_PARALYZE.get()).copy();
										_setstack26.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack26);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.SILVER_BOLT_PARALYSIS.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else if (hasEntityInInventory(entity, new ItemStack(MonstrousWorldModItems.SILVER_BOLT_BLINDING.get()))) {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack29 = new ItemStack(MonstrousWorldModItems.ADVANCED_CROSSBOW_LOADED_BLINDING.get()).copy();
										_setstack29.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack29);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.SILVER_BOLT_BLINDING.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else {
									if (entity instanceof LivingEntity _entity) {
										ItemStack _setstack31 = new ItemStack(MonstrousWorldModItems.ADVANCED_CROSSBOW_LOADED.get()).copy();
										_setstack31.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack31);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(MonstrousWorldModItems.SILVER_BOLT.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								}
								if (!world.isClientSide()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.crossbow.loading_middle")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.crossbow.loading_middle")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
								}
								(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).applyComponents(nbt.getComponents());
								(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((int) damage);
							}
						}
						{
							final String _tagName = "delayTime";
							final double _tagValue = 10;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("This weapon is for Hunters only"), true);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("This weapon is for Hunters only"), true);
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}