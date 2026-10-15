package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class TamedCreaturesDefendPlayerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if (sourceentity instanceof LivingEntity) {
				if (!(sourceentity.getPersistentData().getString("Owner")).equals(entity.getDisplayName().getString())) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof LivingEntity) {
								if ((entityiterator.getPersistentData().getString("Owner")).equals(entity.getDisplayName().getString())) {
									if (entityiterator instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
										_entity.setTarget(_ent);
								}
							}
						}
					}
				}
			}
		}
		if (sourceentity instanceof ServerPlayer) {
			if (entity instanceof LivingEntity) {
				if (!(entity.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof LivingEntity) {
								if ((entityiterator.getPersistentData().getString("Owner")).equals(sourceentity.getDisplayName().getString())) {
									if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
										_entity.setTarget(_ent);
								}
							}
						}
					}
				}
			}
		}
	}
}