package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

public class GiantSnakePlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !entity.onGround();
	}
}