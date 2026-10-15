package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.entity.Witch1Entity;

public class RenderVampireEyesWitchProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof Witch1Entity _datEntL0 && _datEntL0.getEntityData().get(Witch1Entity.DATA_Vampire)) == true;
	}
}