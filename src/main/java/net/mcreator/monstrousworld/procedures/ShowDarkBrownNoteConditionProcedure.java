package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class ShowDarkBrownNoteConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Hunter's Warning Swamp") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Hunter's Warning Werewolf")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Hunter's Warning Vampire") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Hunter's Warning Wisp")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Hunter's Warning Troll") || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Unusual Infection")
				|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Mysterious Container") || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Museum Closed")
				|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Sacrifice") || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("A Hunter's Warning Circus Tents")
				|| entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("A Hunter's Warning Maniacs") || entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("A Hunter's Warning Demon")) {
			return true;
		}
		return false;
	}
}