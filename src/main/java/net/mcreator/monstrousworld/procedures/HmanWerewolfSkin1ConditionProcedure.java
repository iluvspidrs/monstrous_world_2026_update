package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.HumanWerewolfEntity;

public class HmanWerewolfSkin1ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof HumanWerewolfEntity _datEntI ? _datEntI.getEntityData().get(HumanWerewolfEntity.DATA_Skin) : 0) == 1;
	}
}