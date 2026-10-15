package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.VampireNPCEntity;

public class VampireNPCSkin1ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof VampireNPCEntity _datEntI ? _datEntI.getEntityData().get(VampireNPCEntity.DATA_Skin) : 0) == 1;
	}
}