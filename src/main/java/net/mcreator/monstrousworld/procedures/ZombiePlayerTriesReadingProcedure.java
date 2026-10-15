package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ZombiePlayerTriesReadingProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
				if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MonstrousWorldModMobEffects.UNDEAD_GLOW))) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:books")))) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), true);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:manuals")))) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), true);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
					if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("book")) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), true);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
					if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("journal")) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), true);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
					if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("guide")) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), true);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
					if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("compendium")) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), true);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
					if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("atlas")) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), true);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.MAP
							|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.FILLED_MAP) {
						if (event instanceof ICancellableEvent _cancellable) {
							_cancellable.setCanceled(true);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("This baffles you"), true);
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
				}
			}
		}
	}
}