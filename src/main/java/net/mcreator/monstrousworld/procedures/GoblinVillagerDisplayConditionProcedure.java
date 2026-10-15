package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.GoblinVillagerEntity;

public class GoblinVillagerDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof GoblinVillagerEntity _datEntI ? _datEntI.getEntityData().get(GoblinVillagerEntity.DATA_Skin) : 0) == 2) {
			return true;
		}
		return false;
	}
}