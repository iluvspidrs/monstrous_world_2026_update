package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;

public class HunterPatrolSkin3VampireConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Skin) : 0) == 3) {
			if ((entity instanceof HunterPatrolNPCEntity _datEntL1 && _datEntL1.getEntityData().get(HunterPatrolNPCEntity.DATA_Vampire)) == true) {
				return true;
			}
			return false;
		}
		return false;
	}
}