package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

public class PlayerFlyWingsFlappingPlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!entity.onGround()) {
			return true;
		}
		return false;
	}
}