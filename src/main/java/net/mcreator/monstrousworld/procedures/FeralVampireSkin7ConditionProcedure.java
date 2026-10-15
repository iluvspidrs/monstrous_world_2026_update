package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.FeralVampireEntity;

public class FeralVampireSkin7ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof FeralVampireEntity _datEntI ? _datEntI.getEntityData().get(FeralVampireEntity.DATA_Skin) : 0) == 7;
	}
}