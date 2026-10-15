package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CottonCandyPlayerFinishesUsingItemProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
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
			if (itemstack.getItem() == MonstrousWorldModItems.COTTON_CANDY_VILLAGER.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 12000, 0, false, false));
			}
			if (itemstack.getItem() == MonstrousWorldModItems.COTTON_CANDY_HUMAN.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 6000, 0, false, false));
			}
			if (itemstack.getItem() == MonstrousWorldModItems.COTTON_CANDY_GOBLIN.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0, false, false));
			}
			if (itemstack.getItem() == MonstrousWorldModItems.COTTON_CANDY_TROLL.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 12000, 0, false, false));
			}
			if (itemstack.getItem() == MonstrousWorldModItems.COTTON_CANDY_SWAMPMONSTER.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 12000, 0, false, false));
			}
			if (itemstack.getItem() == MonstrousWorldModItems.COTTON_CANDY_WEREWOLF.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 0, false, false));
			}
			if (itemstack.getItem() == MonstrousWorldModItems.COTTON_CANDY_ILLAGER.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 12000, 0, false, false));
			}
			if (itemstack.getItem() == MonstrousWorldModItems.COTTON_CANDY_VAMPIRE.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 12000, 0, false, false));
			}
			if (itemstack.getItem() == MonstrousWorldModItems.COTTON_CANDY_MAGICAL.get()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 12000, 0, false, false));
			}
		}
	}
}