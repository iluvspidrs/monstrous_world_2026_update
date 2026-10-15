package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.HunterNPCEntity;

public class HunterSkin1ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof HunterNPCEntity _datEntI ? _datEntI.getEntityData().get(HunterNPCEntity.DATA_Skin) : 0) == 1) {
			if ((entity instanceof HunterNPCEntity _datEntL1 && _datEntL1.getEntityData().get(HunterNPCEntity.DATA_Vampire)) == false) {
				return true;
			}
			return false;
		}
		return false;
	}
}