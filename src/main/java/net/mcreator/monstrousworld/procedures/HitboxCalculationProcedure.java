package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HitboxCalculationProcedure {
	@SubscribeEvent
	public static void onHitboxCalculated(EntityEvent.Size event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
	}
}