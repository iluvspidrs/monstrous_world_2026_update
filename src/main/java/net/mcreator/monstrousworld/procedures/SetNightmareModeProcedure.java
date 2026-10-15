package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SetNightmareModeProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass >= 10) {
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.Reputation = -100;
					_vars.Reputation_Static = true;
					_vars.markSyncDirty();
				}
				MonstrousWorldMod.queueServerWork(1, () -> {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Reputation < -100) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Reputation = -100;
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
			if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).DarknessTimer >= 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).EvilFaction == 0) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.EvilFaction = Mth.nextInt(RandomSource.create(), 1, 2);
							_vars.markSyncDirty();
						}
					}
				}
			}
		}
	}
}