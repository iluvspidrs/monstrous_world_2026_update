package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.entity.FeralMountainTrollEntity;
import net.mcreator.monstrousworld.entity.DireWerewolfEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ReputationAdjustKillProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 0 || sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 0) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation_Static == false) {
					if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:innocent")))) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation - 10;
							_vars.markSyncDirty();
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your reputation worsens..."), true);
					}
					if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:hostile")))) {
						if (!(entity instanceof SocietyGoonEntity)) {
							if (!(entity instanceof AggressiveGuardEntity)) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 2;
									_vars.markSyncDirty();
								}
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Your reputation improves..."), true);
							}
						}
					}
					if (entity instanceof DireWerewolfEntity) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 10;
							_vars.markSyncDirty();
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your reputation improves..."), true);
					}
					if (entity instanceof FeralMountainTrollEntity) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Reputation = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation + 10;
							_vars.markSyncDirty();
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your reputation improves..."), true);
					}
					MonstrousWorldMod.queueServerWork(1, () -> {
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Reputation = -100;
								_vars.markSyncDirty();
							}
						}
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > 100) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.Reputation = 100;
								_vars.markSyncDirty();
							}
						}
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation <= -25) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.BAD_REPUTATION, 24000, 0, true, false));
						}
						if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation > -25) {
							if (sourceentity instanceof LivingEntity _entity)
								_entity.removeEffect(MonstrousWorldModMobEffects.BAD_REPUTATION);
						}
					});
				}
			}
		}
	}
}