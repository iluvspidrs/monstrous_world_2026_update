package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.SpiderRobotActiveEntity;

public class SpiderVanishingEyesConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof SpiderRobotActiveEntity _datEntS ? _datEntS.getEntityData().get(SpiderRobotActiveEntity.DATA_Mode) : "").equals("Vanishing");
	}
}