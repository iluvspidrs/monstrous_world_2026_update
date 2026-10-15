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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.entity.VampireNPCEntity;
import net.mcreator.monstrousworld.entity.FeralVampireEntity;
import net.mcreator.monstrousworld.MonstrousWorldMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class FeralVampireDataOnSpawnProcedure {
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
			if (entity instanceof FeralVampireEntity) {
				entity.getPersistentData().putBoolean("vampire", true);
				if ((entity instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0) == 0) {
					if (entity instanceof FeralVampireEntity _datEntSetI)
						_datEntSetI.getEntityData().set(FeralVampireEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 4));
				}
				MonstrousWorldMod.queueServerWork(1, () -> {
					if (!entity.getPersistentData().contains("Owner")) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof ServerPlayer) {
									if ((entity.getPersistentData().getString("Owner")).equals(entityiterator.getDisplayName().getString())) {
										if ((entity.getPersistentData().getString("Assignment")).equals("1")) {
											entity.setCustomName(Component.literal(entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment1));
										}
										if ((entity.getPersistentData().getString("Assignment")).equals("2")) {
											entity.setCustomName(Component.literal(entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment2));
										}
										if ((entity.getPersistentData().getString("Assignment")).equals("3")) {
											entity.setCustomName(Component.literal(entityiterator.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Assignment3));
										}
									}
								}
							}
						}
					}
				});
			}
			if (entity instanceof VampireNPCEntity) {
				entity.getPersistentData().putBoolean("vampire", true);
				if ((entity instanceof VampireNPCEntity _datEntI ? _datEntI.getEntityData().get(VampireNPCEntity.DATA_Skin) : 0) == 0) {
					if (entity instanceof VampireNPCEntity _datEntSetI)
						_datEntSetI.getEntityData().set(VampireNPCEntity.DATA_Skin, Mth.nextInt(RandomSource.create(), 1, 3));
				}
			}
		}
	}
}