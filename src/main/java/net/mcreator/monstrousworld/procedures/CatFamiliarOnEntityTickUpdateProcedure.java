package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.monstrousworld.entity.FeralGoblinEntity;

import java.util.Comparator;

public class CatFamiliarOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity NearestFeralGoblin = null;
		NearestFeralGoblin = findEntityInWorldRange(world, FeralGoblinEntity.class, x, y, z, 32);
		if (!world.isClientSide()) {
			if (NearestFeralGoblin instanceof FeralGoblinEntity) {
				if (!world.getEntitiesOfClass(ServerPlayer.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(16 / 2d), e -> true).isEmpty()) {
					if (entity instanceof Mob _entity && NearestFeralGoblin instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}