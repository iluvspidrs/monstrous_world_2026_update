package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.entity.TrollNPCEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TrollTagsOnSpawnProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof TrollNPCEntity) {
				if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Skin) : 0) == 0) {
					if (entity instanceof TrollNPCEntity _datEntSetI)
						_datEntSetI.getEntityData().set(TrollNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 2));
				}
				if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Trade) : 0) == 0) {
					if (entity instanceof TrollNPCEntity _datEntSetI)
						_datEntSetI.getEntityData().set(TrollNPCEntity.DATA_Trade, Mth.nextInt(RandomSource.create(), 1, 5));
				}
				if ((entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Blood_Trade) : 0) == 0) {
					if (entity instanceof TrollNPCEntity _datEntSetI)
						_datEntSetI.getEntityData().set(TrollNPCEntity.DATA_Blood_Trade, Mth.nextInt(RandomSource.create(), 1, 3));
				}
			}
		}
	}
}