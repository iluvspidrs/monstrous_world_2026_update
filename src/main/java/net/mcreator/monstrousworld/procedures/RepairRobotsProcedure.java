package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;
import net.mcreator.monstrousworld.entity.SpiderRobotActiveEntity;
import net.mcreator.monstrousworld.entity.GuardRobotEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RepairRobotsProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof SpiderRobotActiveEntity) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 200) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.iron_golem.repair")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.iron_golem.repair")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (sourceentity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (sourceentity instanceof LivingEntity _entity) {
								ItemStack _setstack11 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack11.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack11);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= 181) {
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth(200);
						} else {
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 20);
						}
					}
				}
			}
			if (entity instanceof GuardRobotEntity) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_IRON_INGOT.get()) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 500) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.iron_golem.repair")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.iron_golem.repair")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (sourceentity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (sourceentity instanceof LivingEntity _entity) {
								ItemStack _setstack26 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack26.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack26);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= 481) {
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth(500);
						} else {
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 20);
						}
					}
				}
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModBlocks.BLOCK_OF_DARKENED_IRON.get().asItem()) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 500) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.iron_golem.repair")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.iron_golem.repair")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth(500);
						if (sourceentity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
							if (sourceentity instanceof LivingEntity _entity) {
								ItemStack _setstack41 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
								_setstack41.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack41);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
		}
	}
}