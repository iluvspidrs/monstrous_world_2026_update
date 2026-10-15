package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.Witch1Entity;

public class Witch1Skin4VampireConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Witch1Entity _datEntI ? _datEntI.getEntityData().get(Witch1Entity.DATA_Skin) : 0) == 4) {
			if ((entity instanceof Witch1Entity _datEntL1 && _datEntL1.getEntityData().get(Witch1Entity.DATA_Vampire)) == true) {
				return true;
			}
			return false;
		}
		return false;
	}
}