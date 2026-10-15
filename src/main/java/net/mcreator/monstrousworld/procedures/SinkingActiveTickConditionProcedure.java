package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.entity.FeralSwampmonsterEntity;

import java.util.Comparator;

public class SinkingActiveTickConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			entity.stopRiding();
			if (!entity.isInWaterOrBubble()) {
				if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:lamp_entity")))) {
					if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("monstrous_world:spirit_entity")))) {
						if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
							if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
								{
									Entity _ent = entity;
									double _tx = x;
									double _ty = (y - 0.05);
									double _tz = z;
									_ent.teleportTo(_tx, _ty, _tz);
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
								}
							}
						}
					} else if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
						{
							Entity _ent = entity;
							double _tx = x;
							double _ty = (y - 1);
							double _tz = z;
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			}
			if (entity.isInWaterOrBubble()) {
				if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), Direction.UP)) {
					{
						Entity _ent = entity;
						double _tx = x;
						double _ty = (y - 0.5);
						double _tz = z;
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof FeralSwampmonsterEntity) {
								if ((entityiterator.getStringUUID()).equals(entity.getPersistentData().getString("attacker"))) {
									{
										Entity _ent = entityiterator;
										double _tx = (entity.getX());
										double _ty = (entity.getY());
										double _tz = (entity.getZ());
										_ent.teleportTo(_tx, _ty, _tz);
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
									}
								}
							}
						}
					}
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
			if (entity.isInWaterOrBubble()) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.SINKING);
			}
		}
	}
}