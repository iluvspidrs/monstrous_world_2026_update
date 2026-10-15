package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Level6SaveSpawnProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= 1) {
				if (!entity.isInLava()) {
					if (!entity.isInWall()) {
						entity.getPersistentData().putDouble("xloc", (entity.getX()));
						entity.getPersistentData().putDouble("yloc", (entity.getY()));
						entity.getPersistentData().putDouble("zloc", (entity.getZ()));
					}
				}
			}
		}
	}
}