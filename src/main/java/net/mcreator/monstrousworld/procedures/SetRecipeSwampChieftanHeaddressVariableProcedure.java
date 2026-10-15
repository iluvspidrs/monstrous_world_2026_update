package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class SetRecipeSwampChieftanHeaddressVariableProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.RecipeGuideShow = "Chieftan Headdress";
			_vars.markSyncDirty();
		}
	}
}