package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModEntities;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;

public class EnchantedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (Math.random() > 0.995) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound entity.vex.ambient master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CHERRY_LEAVES, x, (y + 1), z, 5, 1, 1, 1, 0.01);
			}
			if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ())).canOcclude()) {
				{
					Entity _ent = entity;
					double _tx = (entity.getPersistentData().getDouble("X"));
					double _ty = (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("X"), (int) entity.getPersistentData().getDouble("Z")) + 1);
					double _tz = (entity.getPersistentData().getDouble("Z"));
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			}
			if (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 2300
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 2000
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1700
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1400
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1100
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 800
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED)
							? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration()
							: 0) == 500) == ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 200)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 220, 1));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 220, 0));
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 2200
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1900
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1600
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1300
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1000
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 700
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 400
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 100) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Laughter rings out somewhere, and you follow..."), true);
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 2150
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1850
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1550
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 1250
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 950
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 650
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 350
					|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 50) {
				if (Math.random() < 0.25) {
					entity.getPersistentData().putDouble("X", (entity.getX() + Mth.nextInt(RandomSource.create(), 50, 250)));
					entity.getPersistentData().putDouble("Z", (entity.getZ() + Mth.nextInt(RandomSource.create(), 50, 250)));
					{
						Entity _ent = entity;
						double _tx = (entity.getPersistentData().getDouble("X"));
						double _ty = (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("X"), (int) entity.getPersistentData().getDouble("Z")) + 1);
						double _tz = (entity.getPersistentData().getDouble("Z"));
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
				} else if (Math.random() < 0.5) {
					entity.getPersistentData().putDouble("X", (entity.getX() - Mth.nextInt(RandomSource.create(), 50, 250)));
					entity.getPersistentData().putDouble("Z", (entity.getZ() - Mth.nextInt(RandomSource.create(), 50, 250)));
					{
						Entity _ent = entity;
						double _tx = (entity.getPersistentData().getDouble("X"));
						double _ty = (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("X"), (int) entity.getPersistentData().getDouble("Z")) + 1);
						double _tz = (entity.getPersistentData().getDouble("Z"));
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
				} else if (Math.random() < 0.75) {
					entity.getPersistentData().putDouble("X", (entity.getX() + Mth.nextInt(RandomSource.create(), 50, 250)));
					entity.getPersistentData().putDouble("Z", (entity.getZ() - Mth.nextInt(RandomSource.create(), 50, 250)));
					{
						Entity _ent = entity;
						double _tx = (entity.getPersistentData().getDouble("X"));
						double _ty = (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("X"), (int) entity.getPersistentData().getDouble("Z")) + 1);
						double _tz = (entity.getPersistentData().getDouble("Z"));
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
				} else {
					entity.getPersistentData().putDouble("X", (entity.getX() - Mth.nextInt(RandomSource.create(), 50, 250)));
					entity.getPersistentData().putDouble("Z", (entity.getZ() + Mth.nextInt(RandomSource.create(), 50, 250)));
					{
						Entity _ent = entity;
						double _tx = (entity.getPersistentData().getDouble("X"));
						double _ty = (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("X"), (int) entity.getPersistentData().getDouble("Z")) + 1);
						double _tz = (entity.getPersistentData().getDouble("Z"));
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.ENCHANTED) ? _livEnt.getEffect(MonstrousWorldModMobEffects.ENCHANTED).getDuration() : 0) == 5) {
				if (!entity.isInWaterOrBubble()) {
					if (Math.random() < 0.25) {
						entity.getPersistentData().putDouble("GX1", (entity.getX() + 4));
						entity.getPersistentData().putDouble("GX2", (entity.getX() - 4));
						entity.getPersistentData().putDouble("GZ1", (entity.getX() + 4));
						entity.getPersistentData().putDouble("GZ2", (entity.getX() - 4));
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_GOBLIN.get().spawn(_level,
									BlockPos.containing(x + 4, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("GX1"), (int) entity.getPersistentData().getDouble("GZ1")), z),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_GOBLIN.get().spawn(_level,
									BlockPos.containing(x + 4, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("GX2"), (int) entity.getPersistentData().getDouble("GZ1")), z),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_GOBLIN.get().spawn(_level,
									BlockPos.containing(x + 4, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("GX1"), (int) entity.getPersistentData().getDouble("GZ2")), z),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = MonstrousWorldModEntities.FERAL_GOBLIN.get().spawn(_level,
									BlockPos.containing(x + 4, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getPersistentData().getDouble("GX2"), (int) entity.getPersistentData().getDouble("GZ2")), z),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
			}
			if ((double) MonstrousWorldConfigConfiguration.ENCHANTMENT_CHANCE.get() == 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.ENCHANTED);
			}
		}
	}
}