package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.EntityTypeTags;

public class ModifiedIronSwordRoseLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!entity.getType().is(EntityTypeTags.UNDEAD)) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 18) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.setHealth((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 2);
			}
		}
	}
}