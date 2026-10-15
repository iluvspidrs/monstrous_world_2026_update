package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class CursedDirtEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (Mth.nextInt(RandomSource.create(), 1, 300) == 1) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 1) {
						if (!(!world.getEntitiesOfClass(Spider.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(16 / 2d), e -> true).isEmpty())) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 3); _i1++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z + 10)), z + 10), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 2) {
						if (!(!world.getEntitiesOfClass(Spider.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(16 / 2d), e -> true).isEmpty())) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 3); _i1++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x + 10, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + 10), (int) z), z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 3) {
						if (!(!world.getEntitiesOfClass(Spider.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(16 / 2d), e -> true).isEmpty())) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 2, 3); _i1++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) (z - 10)), z - 10), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).PlayerFace == 4) {
						if (!(!world.getEntitiesOfClass(Spider.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(16 / 2d), e -> true).isEmpty())) {
							for (int _i1 = 0; _i1 < Mth.nextInt(RandomSource.create(), 3, 6); _i1++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x - 10, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x - 10), (int) z), z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
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