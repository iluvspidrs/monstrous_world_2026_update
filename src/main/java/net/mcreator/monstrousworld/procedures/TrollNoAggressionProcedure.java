package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TrollNoAggressionProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity TargetedEntity = null;
		TargetedEntity = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
		if (!world.isClientSide()) {
			if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).contains("troll")) {
				if (TargetedEntity != null) {
					if (TargetedEntity instanceof ServerPlayer) {
						if (TargetedEntity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
							if (!(entity.getPersistentData().getString("AngryAt")).equals(TargetedEntity.getDisplayName().getString())) {
								if (entity instanceof Mob) {
									try {
										((Mob) entity).setTarget(null);
									} catch (Exception e) {
										e.printStackTrace();
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