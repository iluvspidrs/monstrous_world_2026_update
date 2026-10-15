package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.HunterPatrolNPCEntity;
import net.mcreator.monstrousworld.entity.HunterNPCEntity;

public class HunterPatrolSkin4ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof HunterPatrolNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterPatrolNPCEntity.DATA_Skin) : 0) == 4) {
			if ((entity instanceof HunterNPCEntity _datEntL1 && _datEntL1.getEntityData().get(HunterNPCEntity.DATA_Vampire)) == false) {
				return true;
			}
			return false;
		}
		return false;
	}
}