package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.world.inventory.TwoTradesMenu;
import net.mcreator.monstrousworld.world.inventory.OneTradeMenu;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class NPCNoLeaveProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof Player _plr1 && _plr1.containerMenu instanceof TwoTradesMenu || entity instanceof Player _plr2 && _plr2.containerMenu instanceof OneTradeMenu) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof LivingEntity) {
							if ((entityiterator.getPersistentData().getString("Interaction")).equals(entity.getStringUUID())) {
								if ((entity.getPersistentData().getString("Interaction")).equals(entityiterator.getStringUUID())) {
									if ((new Vec3((entity.getX()), (entity.getY()), (entity.getZ()))).distanceTo((new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())))) > 5) {
										if (entity instanceof Player _player)
											_player.closeContainer();
									}
								}
							}
						}
					}
				}
			}
		}
	}
}