package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WerewolfStartsToEatProcedure {
	@SubscribeEvent
	public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getItem());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		execute(null, world, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (itemstack.has(DataComponents.FOOD)) {
				if (!itemstack.is(ItemTags.create(ResourceLocation.parse("c:foods/raw_meat")))) {
					if (!itemstack.is(ItemTags.create(ResourceLocation.parse("c:foods/cooked_meat")))) {
						if (!itemstack.is(ItemTags.create(ResourceLocation.parse("c:foods/cooked_fish")))) {
							if (!itemstack.is(ItemTags.create(ResourceLocation.parse("c:foods/raw_fish")))) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7) {
									if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
										if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL)) {
											if (event instanceof ICancellableEvent _cancellable) {
												_cancellable.setCanceled(true);
											}
											if (entity instanceof Player _player && !_player.level().isClientSide())
												_player.displayClientMessage(Component.literal("You can only eat meat while in beast form"), true);
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
}