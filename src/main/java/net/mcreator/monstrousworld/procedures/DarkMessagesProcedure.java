package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DarkMessagesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double DarkMessageTimer = 0;
		if (MonstrousWorldModVariables.MapVariables.get(world).PlayerPossessed == false) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel <= 5) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.Dark_Message_Timer = Mth.nextInt(RandomSource.create(), 12000, 18000);
						_vars.markSyncDirty();
					}
				}
			}
			if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("monstrous_world:the_deep")))) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer == 5) {
						entity.getPersistentData().putDouble("MessageType", (Mth.nextInt(RandomSource.create(), 1, 3)));
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer == 2) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound entity.ender_dragon.growl master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
							if (entity.getPersistentData().getDouble("MessageType") == 1) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75When attacked, you might infect the world where you stand..."), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 2) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Stand over plants and pumpkins while attacked to raise servants..."), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 3) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Stand over skulls while attacked, and they will fight for you\u2026"), false);
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
							if (entity.getPersistentData().getDouble("MessageType") == 1) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Throw my dark power by pressing [Y]\u2026"), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 2) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Infect the cowards in black who kill my children\u2026"), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 3) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Throw my dark power at plants and the dead\u2026"), false);
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
							if (entity.getPersistentData().getDouble("MessageType") == 1) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75You can now strengthen diamond and silver weapons with my essence\u2026"), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 2) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Use your darkened weapons often to grow more powerful..."), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 3) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Strengthen diamond and silver weapons by right-clicking them in your hand..."), false);
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 4) {
							if (entity.getPersistentData().getDouble("MessageType") == 1) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75You can now create stronger creatures from  jack o lanterns..."), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 2) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75You can become stronger...find a true, divine weapon for us..."), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 3) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Sneak and attack to banish them to my abyss..."), false);
							}
						}
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
							if (entity.getPersistentData().getDouble("MessageType") == 1) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Use our weapon...and let the darkness consume you..."), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 2) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75Enter the dark..."), false);
							}
							if (entity.getPersistentData().getDouble("MessageType") == 3) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A75You stand on the cusp of greatness..."), false);
							}
						}
					}
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer == 10000) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel <= 5) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
								}
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A75I languish in the depths with no form..."), true);
						}
					}
				}
			}
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 9 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 6) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer == -1) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound entity.ender_dragon.growl master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75We are hungry..."), false);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer == -6000) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound entity.ender_dragon.growl master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75Find us a human or villager...and right-click to consume..."), false);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer == -12000) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound entity.ender_dragon.growl master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75We grow ever more hungry..."), false);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer == -18000) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound entity.ender_dragon.growl master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75I am restless! Find us prey!"), false);
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer <= -1 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer >= -5999) {
				if (entity instanceof Player _player)
					_player.getFoodData().setSaturation(0);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 0));
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer <= -6000 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer >= -11999) {
				if (entity instanceof Player _player)
					_player.getFoodData().setSaturation(0);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 1));
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer <= -12000 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer >= -17999) {
				if (entity instanceof Player _player)
					_player.getFoodData().setSaturation(0);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 2));
			}
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Dark_Message_Timer <= -18000) {
				if (entity instanceof Player _player)
					_player.getFoodData().setSaturation(0);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.ENTITY_HUNGER, 24000, 0));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 3));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20, 3));
			}
		}
	}
}