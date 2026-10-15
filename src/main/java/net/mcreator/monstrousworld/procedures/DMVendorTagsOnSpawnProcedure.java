package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.entity.DarkMarketVendorEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DMVendorTagsOnSpawnProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof DarkMarketVendorEntity) {
			if ((entity instanceof DarkMarketVendorEntity _datEntI ? _datEntI.getEntityData().get(DarkMarketVendorEntity.DATA_Trade) : 0) == 0) {
				if (entity instanceof DarkMarketVendorEntity _datEntSetI)
					_datEntSetI.getEntityData().set(DarkMarketVendorEntity.DATA_Trade, Mth.nextInt(RandomSource.create(), 1, 3));
			}
		}
	}
}