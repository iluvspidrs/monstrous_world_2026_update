package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SetTipTimersAndValuesOnJoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("General_Tip", (Mth.nextInt(RandomSource.create(), 1, 12)));
		entity.getPersistentData().putDouble("tip_message_time", (world.dayTime() + 200));
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 1) {
			entity.getPersistentData().putDouble("Witch_Tip", (Mth.nextInt(RandomSource.create(), 1, 12)));
		} else {
			entity.getPersistentData().putDouble("Witch_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 2) {
			entity.getPersistentData().putDouble("Goblin_Tip", (Mth.nextInt(RandomSource.create(), 1, 9)));
		} else {
			entity.getPersistentData().putDouble("Goblin_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
			entity.getPersistentData().putDouble("Troll_Tip", (Mth.nextInt(RandomSource.create(), 1, 8)));
		} else {
			entity.getPersistentData().putDouble("Troll_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 4) {
			entity.getPersistentData().putDouble("Sorcerer_Tip", (Mth.nextInt(RandomSource.create(), 1, 10)));
		} else {
			entity.getPersistentData().putDouble("Sorcerer_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 5) {
			entity.getPersistentData().putDouble("Science_Tip", (Mth.nextInt(RandomSource.create(), 1, 10)));
		} else {
			entity.getPersistentData().putDouble("Science_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 6) {
			entity.getPersistentData().putDouble("Swampmonster_Tip", (Mth.nextInt(RandomSource.create(), 1, 11)));
		} else {
			entity.getPersistentData().putDouble("Swampmonster_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 7 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 5) {
			entity.getPersistentData().putDouble("Werewolf_Tip", (Mth.nextInt(RandomSource.create(), 1, 11)));
		} else {
			entity.getPersistentData().putDouble("Werewolf_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 8 || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 6) {
			entity.getPersistentData().putDouble("Vampire_Tip", (Mth.nextInt(RandomSource.create(), 1, 13)));
		} else {
			entity.getPersistentData().putDouble("Vampire_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 0 && entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 0) {
			if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).HuntersGuild == true) {
				entity.getPersistentData().putDouble("Hunter_Tip", (Mth.nextInt(RandomSource.create(), 1, 9)));
			} else {
				entity.getPersistentData().putDouble("Hunter_Tip", 0);
			}
		} else {
			entity.getPersistentData().putDouble("Hunter_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 10) {
			entity.getPersistentData().putDouble("Demon_Tip", (Mth.nextInt(RandomSource.create(), 1, 10)));
		} else {
			entity.getPersistentData().putDouble("Demon_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
			entity.getPersistentData().putDouble("Clown_Tip", (Mth.nextInt(RandomSource.create(), 1, 10)));
		} else {
			entity.getPersistentData().putDouble("Clown_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 12) {
			entity.getPersistentData().putDouble("Maniac_Tip", (Mth.nextInt(RandomSource.create(), 1, 10)));
		} else {
			entity.getPersistentData().putDouble("Maniac_Tip", 0);
		}
		if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterType == 4) {
			entity.getPersistentData().putDouble("Zombified_Tip", (Mth.nextInt(RandomSource.create(), 1, 7)));
		} else {
			entity.getPersistentData().putDouble("Zombified_Tip", 0);
		}
	}
}