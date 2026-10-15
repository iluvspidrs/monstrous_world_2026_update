package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.configuration.MonstrousWorldConfigConfiguration;
import net.mcreator.monstrousworld.MonstrousWorldMod;

public class InsanityOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.NIGHT_VISION))) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MonstrousWorldModMobEffects.MENTAL_FORTITUDE))) {
					if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7) {
						if (entity.getPersistentData().getDouble("fear_countdown") < 6000) {
							entity.getPersistentData().putDouble("fear_countdown", (entity.getPersistentData().getDouble("fear_countdown") + 1));
						}
						if (entity.getPersistentData().getDouble("fear_countdown") == 600) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
								}
							}
						}
						if (entity.getPersistentData().getDouble("fear_countdown") == 2400) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
								}
							}
						}
						if (entity.getPersistentData().getDouble("fear_countdown") == 3600) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
								}
							}
						}
						if (entity.getPersistentData().getDouble("fear_countdown") == 4800) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
								}
							}
						}
						if (entity.getPersistentData().getDouble("fear_countdown") == 6000) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
								}
							}
							entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
						}
						if (entity.getPersistentData().getDouble("fear_countdown") < 3600 || entity.getPersistentData().getDouble("fear_countdown") >= 4800) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/stopsound @p * monstrous_world:nervous_heartbeat");
								}
							}
						}
						if (entity.getPersistentData().getDouble("fear_countdown") < 4800) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/stopsound @p * monstrous_world:terrified_heartbeat");
								}
							}
						}
						if (entity instanceof ServerPlayer) {
							if (entity.getPersistentData().getDouble("fear_countdown") >= 3600 && entity.getPersistentData().getDouble("fear_countdown") < 4800) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 220, 0, false, false));
								if (entity.getPersistentData().getBoolean("nervous") == false) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										entity.getPersistentData().putBoolean("nervous", true);
									});
								}
							}
						}
						if (entity instanceof ServerPlayer) {
							if (entity.getPersistentData().getDouble("fear_countdown") >= 4800) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 220, 0, false, false));
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 220, 0, false, false));
								if (entity.getPersistentData().getBoolean("terrified") == false) {
									MonstrousWorldMod.queueServerWork(1, () -> {
										entity.getPersistentData().putBoolean("terrified", true);
									});
								}
							}
						}
					} else {
						entity.getPersistentData().putBoolean("nervous", false);
						entity.getPersistentData().putBoolean("terrified", false);
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/stopsound @p * monstrous_world:nervous_heartbeat");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/stopsound @p * monstrous_world:terrified_heartbeat");
							}
						}
						if (entity.getPersistentData().getDouble("fear_countdown") >= 1) {
							entity.getPersistentData().putDouble("fear_countdown", (entity.getPersistentData().getDouble("fear_countdown") - 1));
						}
					}
				} else {
					if (entity.getPersistentData().getDouble("fear_countdown") >= 1) {
						entity.getPersistentData().putDouble("fear_countdown", (entity.getPersistentData().getDouble("fear_countdown") - 1));
					}
				}
			} else {
				if (entity.getPersistentData().getDouble("fear_countdown") >= 1) {
					entity.getPersistentData().putDouble("fear_countdown", (entity.getPersistentData().getDouble("fear_countdown") - 1));
				}
			}
			if ((double) MonstrousWorldConfigConfiguration.INSANITY_CHANCE.get() == 0) {
				entity.getPersistentData().putDouble("insanity_timer", 0);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MonstrousWorldModMobEffects.INSANITY);
			}
		}
	}
}