package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StoreVariablesOnCureProcedure {
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
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:drinks/honey"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:buckets/milk")))) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.DarknessTimer = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0;
					_vars.WerewolfEffect = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_EFFECT).getDuration() : 0;
					_vars.WerewolfInfectionTimer = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION) ? _livEnt.getEffect(MonstrousWorldModMobEffects.WEREWOLF_INFECTION).getDuration() : 0;
					_vars.LunarPullTimer = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.LUNAR_PULL) ? _livEnt.getEffect(MonstrousWorldModMobEffects.LUNAR_PULL).getDuration() : 0;
					_vars.TransformCooldown = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRANSFORM_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRANSFORM_COOLDOWN).getDuration() : 0;
					_vars.VampireInfection = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT)
							? _livEnt.getEffect(MonstrousWorldModMobEffects.VAMPIRE_INFECTION_EFFECT).getDuration()
							: 0;
					_vars.ZombieInfection = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ZOMBIE_INFECTION_EFFECT).getDuration() : 0;
					_vars.Trident_Countdown = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0;
					_vars.MurkanusMarth = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MURKANUS_MARTH).getDuration() : 0;
					_vars.markSyncDirty();
				}
			}
		}
	}
}