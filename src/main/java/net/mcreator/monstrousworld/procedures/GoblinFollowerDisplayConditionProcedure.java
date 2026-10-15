package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.GoblinFollowerEntity;

public class GoblinFollowerDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof GoblinFollowerEntity _datEntI ? _datEntI.getEntityData().get(GoblinFollowerEntity.DATA_Skin) : 0) == 2) {
			return true;
		}
		return false;
	}
}