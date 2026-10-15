package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.entity.Witch1Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class WitchTagsOnSpawnProcedure {
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
		if (entity instanceof Witch1Entity) {
			if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Skin) : 0) == 0) {
				if (entity instanceof Witch1Entity _datEntSetI)
					_datEntSetI.getEntityData().set(Witch1Entity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
			}
			if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Trade) : 0) == 0) {
				if (entity instanceof Witch1Entity _datEntSetI)
					_datEntSetI.getEntityData().set(Witch1Entity.DATA_Trade, Mth.nextInt(RandomSource.create(), 1, 10));
			}
			if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_HasZombieCure) : 0) == 0) {
				if (entity instanceof Witch1Entity _datEntSetI)
					_datEntSetI.getEntityData().set(Witch1Entity.DATA_HasZombieCure, Mth.nextInt(RandomSource.create(), 1, 5));
			}
			if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_HasVampireCure) : 0) == 0) {
				if (entity instanceof Witch1Entity _datEntSetI)
					_datEntSetI.getEntityData().set(Witch1Entity.DATA_HasVampireCure, Mth.nextInt(RandomSource.create(), 1, 5));
			}
			if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_HasWerewolfCure) : 0) == 0) {
				if (entity instanceof Witch1Entity _datEntSetI)
					_datEntSetI.getEntityData().set(Witch1Entity.DATA_HasWerewolfCure, Mth.nextInt(RandomSource.create(), 1, 5));
			}
		}
	}
}