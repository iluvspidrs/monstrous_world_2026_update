package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TrackTimeProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		MonstrousWorldModVariables.CurrentTime = world.dayTime() % 24000;
		MonstrousWorldModVariables.TimeUntilNight = 13000 - MonstrousWorldModVariables.CurrentTime;
		if (MonstrousWorldModVariables.MapVariables.get(world).TeamResetTimer >= 1) {
			MonstrousWorldModVariables.MapVariables.get(world).TeamResetTimer = MonstrousWorldModVariables.MapVariables.get(world).TeamResetTimer - 1;
			MonstrousWorldModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}