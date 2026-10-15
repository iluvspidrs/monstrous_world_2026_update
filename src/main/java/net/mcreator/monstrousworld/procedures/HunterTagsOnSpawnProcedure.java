package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;
import net.mcreator.monstrousworld.entity.FeralVampireEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class HunterTagsOnSpawnProcedure {
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
		if (entity instanceof HunterNPCEntity) {
			if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Skin) : 0) == 0) {
				if (entity instanceof HunterNPCEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
			}
			if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Trade) : 0) == 0) {
				if (entity instanceof HunterNPCEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HunterNPCEntity.DATA_Trade, Mth.nextInt(RandomSource.create(), 1, 3));
			}
		}
		if (entity instanceof HunterPatrolNPCEntity) {
			if ((entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Skin) : 0) == 0) {
				if (!(!world.getEntitiesOfClass(FeralVampireEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(4 / 2d), e -> true).isEmpty())) {
					if (entity instanceof HunterPatrolNPCEntity _datEntSetI)
						_datEntSetI.getEntityData().set(HunterPatrolNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 5));
				} else {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof FeralVampireEntity) {
								if ((entityiterator instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0) == 4) {
									if (entity instanceof HunterPatrolNPCEntity _datEntSetI)
										_datEntSetI.getEntityData().set(HunterPatrolNPCEntity.DATA_Skin, 1);
								}
								if ((entityiterator instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0) == 5) {
									if (entity instanceof HunterPatrolNPCEntity _datEntSetI)
										_datEntSetI.getEntityData().set(HunterPatrolNPCEntity.DATA_Skin, 2);
								}
								if ((entityiterator instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0) == 6) {
									if (entity instanceof HunterPatrolNPCEntity _datEntSetI)
										_datEntSetI.getEntityData().set(HunterPatrolNPCEntity.DATA_Skin, 3);
								}
								if ((entityiterator instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0) == 7) {
									if (entity instanceof HunterPatrolNPCEntity _datEntSetI)
										_datEntSetI.getEntityData().set(HunterPatrolNPCEntity.DATA_Skin, 4);
								}
								if ((entityiterator instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0) == 8) {
									if (entity instanceof HunterPatrolNPCEntity _datEntSetI)
										_datEntSetI.getEntityData().set(HunterPatrolNPCEntity.DATA_Skin, 5);
								}
							}
						}
					}
				}
			}
			if ((entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Trade) : 0) == 0) {
				if (entity instanceof HunterPatrolNPCEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HunterPatrolNPCEntity.DATA_Trade, Mth.nextInt(RandomSource.create(), 1, 3));
			}
		}
	}
}