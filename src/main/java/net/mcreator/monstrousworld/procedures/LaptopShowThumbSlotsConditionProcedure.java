package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class LaptopShowThumbSlotsConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Serpent DNA") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider DNA")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Spider 2 DNA") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager 2 DNA")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Illager DNA") || (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Dreadful Watcher DNA")
				|| (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Laptop Fly DNA")) {
			return true;
		}
		return false;
	}
}