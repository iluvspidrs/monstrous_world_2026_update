package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BloodBarDepleteProcedure {
	@SubscribeEvent
	public static void onEntityHealed(LivingHealEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar >= 1) {
				if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.REGENERATION))) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
								_vars.markSyncDirty();
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar == 10) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 0) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You must feed soon. Sneak and right-click to hypnotize a victim..."), false);
								}
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel <= 2) {
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
								_vars.markSyncDirty();
							}
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar == 10) {
								if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FeralLevel == 0 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("You must feed soon. Sneak and right-click to hypnotize a victim..."), false);
								}
							}
						} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
							if (Math.random() >= 0.25) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
									_vars.markSyncDirty();
								}
							}
						} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
							if (Math.random() >= 0.4) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
									_vars.markSyncDirty();
								}
							}
						} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
							if (Math.random() >= 0.55) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
									_vars.markSyncDirty();
								}
							}
						} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
							if (Math.random() >= 0.66) {
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.BloodBar = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar - 1;
									_vars.markSyncDirty();
								}
							}
						}
					}
				}
			} else if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).BloodBar == 0) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
		}
	}
}