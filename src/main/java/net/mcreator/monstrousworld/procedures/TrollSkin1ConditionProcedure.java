package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.TrollNPCEntity;

public class TrollSkin1ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof TrollNPCEntity _datEntI ? _datEntI.getEntityData().get(TrollNPCEntity.DATA_Skin) : 0) == 1;
	}
}