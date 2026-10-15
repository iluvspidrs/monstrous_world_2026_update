package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.monstrousworld.entity.SocietyGoonEntity;
import net.mcreator.monstrousworld.entity.AggressiveGuardEntity;

import java.util.Comparator;

public class BlazingBarrierOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMALL_FLAME, x, y, z, 1, 0, 1, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMALL_FLAME, x, y, z, 1, 0, 1, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMALL_FLAME, x, y, z, 1, 0, 1, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMALL_FLAME, x, y, z, 1, 0, 1, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMALL_FLAME, x, y, z, 1, 0, 1, 0, 0);
			if (entity.getPersistentData().getDouble("DespawnTimer") >= 2) {
				entity.getPersistentData().putDouble("DespawnTimer", (entity.getPersistentData().getDouble("DespawnTimer") - 1));
			} else {
				entity.getPersistentData().putDouble("DespawnTimer", 12000);
			}
			if (entity.getPersistentData().getDouble("DespawnTimer") == 1) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator.getType().is(EntityTypeTags.UNDEAD)) {
						entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x * (-0.08)), (entity.getLookAngle().y * 0), (entity.getLookAngle().z * (-0.08))));
						entityiterator.igniteForSeconds(5);
					}
					if (entityiterator instanceof AggressiveGuardEntity) {
						entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x * (-0.08)), (entity.getLookAngle().y * 0), (entity.getLookAngle().z * (-0.08))));
						entityiterator.igniteForSeconds(5);
					}
					if (entityiterator instanceof SocietyGoonEntity) {
						entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x * (-0.08)), (entity.getLookAngle().y * 0), (entity.getLookAngle().z * (-0.08))));
						entityiterator.igniteForSeconds(5);
					}
					if (entityiterator instanceof ThrownTrident || entityiterator instanceof ThrowableProjectile || entityiterator instanceof Arrow) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof Vex || entityiterator instanceof EvokerFangs) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:raiders")))) {
						entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x * (-0.08)), (entity.getLookAngle().y * 0), (entity.getLookAngle().z * (-0.08))));
						entityiterator.igniteForSeconds(5);
					}
				}
			}
		}
	}
}