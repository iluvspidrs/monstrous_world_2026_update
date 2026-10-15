package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;

public class StrangeSerumEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!(entity instanceof ServerPlayer)) {
				if (!(entity instanceof Player)) {
					if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("neoforge:human")))) {
						if (!(entity.getPersistentData().getBoolean("vampire") == true)) {
							if (entity.getPersistentData().getDouble("MutationType") == 0) {
								if (Math.random() <= 0.33) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_EYE.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									if (!entity.level().isClientSide())
										entity.discard();
								} else if (Math.random() <= 0.66) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.FLY_MUTANT.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									if (!entity.level().isClientSide())
										entity.discard();
								} else {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = MonstrousWorldModEntities.MUTANT_SERPENT.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									if (!entity.level().isClientSide())
										entity.discard();
								}
							}
						}
					}
				}
			}
		}
	}
}