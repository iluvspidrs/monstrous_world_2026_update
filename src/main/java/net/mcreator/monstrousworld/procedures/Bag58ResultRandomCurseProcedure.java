package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class Bag58ResultRandomCurseProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.25) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A72This bag is cursed! You will become a zombie upon death!"), false);
				{
					MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
					_vars.Zombify = 1;
					_vars.markSyncDirty();
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
			}
		} else if (Math.random() < 0.5) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession < 3) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A74This bag is cursed! You can no longer use defenses against darkness..."), false);
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.No_Defense = 1;
						_vars.markSyncDirty();
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
			}
		} else if (Math.random() < 0.75) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType < 3) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession < 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74This bag is cursed! You move more slowly through spooky environments..."), false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Slower_Movement = 1;
							_vars.markSyncDirty();
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
			}
		} else {
			if (MonstrousWorldModVariables.MapVariables.get(world).Nightmare_Mode_World == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession < 3) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74This bag is cursed! Nightmares become more frequent..."), false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.More_Nightmares = 1;
							_vars.markSyncDirty();
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
				}
			} else {
				if (Math.random() < 0.33) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterInfectable == true) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72This bag is cursed! You will become a zombie at your next death!"), false);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.Zombify = 1;
							_vars.markSyncDirty();
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
					}
				} else if (Math.random() < 0.66) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession < 3) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A74This bag is cursed! You can no longer use defenses against darkness..."), false);
							{
								MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
								_vars.No_Defense = 1;
								_vars.markSyncDirty();
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
					}
				} else {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass < 10) {
						if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType < 3) {
							if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession < 3) {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A74This bag is cursed! You move more slowly through spooky environments..."), false);
								{
									MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
									_vars.Slower_Movement = 1;
									_vars.markSyncDirty();
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A72The curse in this bag cannot affect you..."), false);
					}
				}
			}
		}
	}
}