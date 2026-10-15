package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class DarkenedTridentEntityHitProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKENED_TRIDENT.get()) {
			if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4) {
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
					if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
						sourceentity.getPersistentData().putDouble("DarkTendrils", (Mth.nextInt(RandomSource.create(), 1, 8)));
						if (sourceentity.getPersistentData().getDouble("DarkTendrils") == 1) {
							if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0) == 0) {
								{
									Entity _ent = sourceentity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands()
												.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
														_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														("/playsound entity.ender_dragon.growl master # ~ ~ ~".replace("#", sourceentity.getDisplayName().getString())));
									}
								}
								if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN, Mth.nextInt(RandomSource.create(), 2400, 3000), 0, true, false));
							}
							if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0) >= 1
									&& (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0) < 3000) {
								{
									Entity _ent = sourceentity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands()
												.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
														_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														("/playsound entity.ender_dragon.growl master # ~ ~ ~".replace("#", sourceentity.getDisplayName().getString())));
									}
								}
								if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN, Mth.nextInt(RandomSource.create(), 5000, 6000), 0, true, false));
							}
							if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0) >= 3001
									&& (sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0) < 6000) {
								{
									Entity _ent = sourceentity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands()
												.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
														_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														("/playsound entity.ender_dragon.growl master # ~ ~ ~".replace("#", sourceentity.getDisplayName().getString())));
									}
								}
								if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN, Mth.nextInt(RandomSource.create(), 7000, 8000), 0, true, false));
							}
							if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN) ? _livEnt.getEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN).getDuration() : 0) >= 6001) {
								if (sourceentity instanceof LivingEntity _entity)
									_entity.removeEffect(MonstrousWorldModMobEffects.TRIDENT_COOLDOWN);
								if (sourceentity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
									ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("monstrous_world:the_deep"));
									if (_player.level().dimension() == destinationType)
										return;
									ServerLevel nextLevel = _player.server.getLevel(destinationType);
									if (nextLevel != null) {
										_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
										_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
										_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
										for (MobEffectInstance _effectinstance : _player.getActiveEffects())
											_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
										_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
									}
								}
							}
						}
					}
				}
				if (sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 && sourceentity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 5) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0));
				}
			}
		}
	}
}