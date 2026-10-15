package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Level6RespawnsProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
				if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("monstrous_world:nightmare_realm")))) {
					if (!((entity.level().dimension()) == Level.END)) {
						if (entity instanceof ServerPlayer _serverPlayer)
							_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(),
									BlockPos.containing(entity.getPersistentData().getDouble("xloc"), entity.getPersistentData().getDouble("yloc"), entity.getPersistentData().getDouble("zloc")), _serverPlayer.getYRot(), true, false);
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("monstrous_world:they_always_get_back_up"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
				}
			}
		}
	}
}