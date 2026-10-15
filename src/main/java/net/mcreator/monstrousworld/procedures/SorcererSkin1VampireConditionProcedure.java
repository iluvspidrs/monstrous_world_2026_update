package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.SorcererNPCEntity;

public class SorcererSkin1VampireConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof SorcererNPCEntity _datEntI ? _datEntI.getEntityData().get(SorcererNPCEntity.DATA_Skin) : 0) == 1) {
			if ((entity instanceof SorcererNPCEntity _datEntL1 && _datEntL1.getEntityData().get(SorcererNPCEntity.DATA_Vampire)) == true) {
				return true;
			}
			return false;
		}
		return false;
	}
}