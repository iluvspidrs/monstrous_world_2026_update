package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class SetRecipeGoblinWorktableVariableProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.RecipeGuideShow = "Goblin Worktable";
			_vars.markSyncDirty();
		}
	}
}