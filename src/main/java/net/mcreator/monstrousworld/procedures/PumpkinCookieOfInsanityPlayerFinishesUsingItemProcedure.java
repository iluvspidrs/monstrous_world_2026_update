package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModMobEffects;

public class PumpkinCookieOfInsanityPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 4 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType != 6
					&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 8 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 10
					&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 11 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass != 12
					&& entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Possession < 3) {
				if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MonstrousWorldModMobEffects.INSANITY))) {
					entity.getPersistentData().putDouble("insanity_timer", (Mth.nextInt(RandomSource.create(), 24000, 36000)));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MonstrousWorldModMobEffects.INSANITY, (int) entity.getPersistentData().getDouble("insanity_timer"), 0));
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/playsound ambient.cave master # ~ ~ ~".replace("#", entity.getDisplayName().getString())));
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Your mind grows unstable as your paranoia rises..."), false);
				}
			}
		}
	}
}