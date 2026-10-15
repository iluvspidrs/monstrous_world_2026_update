package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.CuredVampireEntity;

public class CuredVampireSkin3ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof CuredVampireEntity _datEntI ? _datEntI.getEntityData().get(CuredVampireEntity.DATA_Skin) : 0) == 3;
	}
}