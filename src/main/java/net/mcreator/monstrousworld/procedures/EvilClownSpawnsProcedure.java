package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.EvilClown3Entity;
import net.mcreator.monstrousworld.entity.EvilClown2Entity;
import net.mcreator.monstrousworld.entity.EvilClown1Entity;
import net.mcreator.monstrousworld.entity.DeadlyBalloonEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EvilClownSpawnsProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof EvilClown1Entity || entity instanceof EvilClown2Entity || entity instanceof EvilClown3Entity) {
				if (Math.random() > 0.95) {
					if (!(!world.getEntitiesOfClass(DeadlyBalloonEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(200 / 2d), e -> true).isEmpty())) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.DEADLY_BALLOON.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
			}
		}
	}
}