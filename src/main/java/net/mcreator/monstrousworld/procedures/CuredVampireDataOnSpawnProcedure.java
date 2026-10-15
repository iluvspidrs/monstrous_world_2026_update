package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.FeralVampireEntity;
import net.mcreator.monstrousworld.entity.CuredVampireEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class CuredVampireDataOnSpawnProcedure {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof CuredVampireEntity) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof FeralVampireEntity) {
							if (entity instanceof CuredVampireEntity _datEntSetI)
								_datEntSetI.getEntityData().set(CuredVampireEntity.DATA_Skin, (int) (entityiterator instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0));
						}
					}
				}
			}
		}
	}
}