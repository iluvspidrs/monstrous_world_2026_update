package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.DemonNPCEntity;

public class DemonNPCSkin2ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof DemonNPCEntity _datEntI ? _datEntI.getEntityData().get(DemonNPCEntity.DATA_Skin) : 0) == 2) {
			return true;
		}
		return false;
	}
}