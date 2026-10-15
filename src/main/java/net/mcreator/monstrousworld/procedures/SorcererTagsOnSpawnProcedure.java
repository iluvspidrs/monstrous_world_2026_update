package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.entity.SorcererNPCEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SorcererTagsOnSpawnProcedure {
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
		if (entity instanceof SorcererNPCEntity) {
			if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Skin) : 0) == 0) {
				if (entity instanceof SorcererNPCEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 9));
			}
			if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Trade) : 0) == 0) {
				if (entity instanceof SorcererNPCEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SorcererNPCEntity.DATA_Trade, Mth.nextInt(RandomSource.create(), 1, 9));
			}
		}
	}
}