package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ManiacThisEntityKillsAnotherOneProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			sourceentity.getPersistentData().putString("AngryAt", "None");
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 200) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= 190) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.setHealth(200);
				} else {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 10);
				}
			}
		}
	}
}