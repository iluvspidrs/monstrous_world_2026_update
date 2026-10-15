package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

public class ModifiedIronSwordNetherGemLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.igniteForSeconds(5);
	}
}