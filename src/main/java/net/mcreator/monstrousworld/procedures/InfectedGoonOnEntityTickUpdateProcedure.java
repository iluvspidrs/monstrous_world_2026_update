package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.entity.SocietyGoonEntity;

import java.util.Comparator;

public class InfectedGoonOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity NearestPlayer = null;
		Entity Shademarker = null;
		Entity NearestHungryTree = null;
		Entity TargetEntity = null;
		Entity TargetedEntity = null;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS) ? _livEnt.getEffect(MonstrousWorldModMobEffects.MYSTERIOUS_DARKNESS).getDuration() : 0) == 1) {
				if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 0) {
					if (Math.random() < 0.2) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_WEREWOLF.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if (Math.random() < 0.4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_SWAMPMONSTER.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if (Math.random() < 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_GOBLIN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if (Math.random() < 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.MAD_SCIENTIST_NPC.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof SocietyGoonEntity) {
									entityiterator.getPersistentData().putBoolean("vampire", true);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY, 20000, 0, true, false));
									entity.getPersistentData().putDouble("vampireInfection", 1);
								}
							}
						}
					}
				} else {
					if (Math.random() < 0.1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_WEREWOLF.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if (Math.random() < 0.2) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_SWAMPMONSTER.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if (Math.random() < 0.3) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_GOBLIN.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if (Math.random() < 0.4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.MAD_SCIENTIST_NPC.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if (Math.random() < 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.SOCIETY_GOON.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								if (entityiterator instanceof SocietyGoonEntity) {
									entityiterator.getPersistentData().putBoolean("vampire", true);
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.VAMPIRISM_ENTITY, 20000, 0, true, false));
									entity.getPersistentData().putDouble("vampireInfection", 1);
								}
							}
						}
					} else if (Math.random() < 0.67) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.EVIL_CLOWN_1.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if (Math.random() < 0.83) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.DEMON_NPC.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.MANIAC.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
			if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))
					|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))) {
				{
					Entity _ent = entity;
					double _tx = (entity.getX());
					double _ty = (entity.getY() + 1);
					double _tz = (entity.getZ());
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}