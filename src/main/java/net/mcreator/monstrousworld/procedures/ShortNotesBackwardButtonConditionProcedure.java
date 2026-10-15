package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class ShortNotesBackwardButtonConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Page 1")) {
			if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("A Hunter's Warning")) {
				if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Museum Closed")) {
					if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Quota")) {
						if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Dark Market Ad")) {
							if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Museum Ad")) {
								if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Note on Piglins")) {
									if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Note on Maniacs")) {
										if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Fresh Cookies")) {
											if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Trick or Treat Ad")) {
												if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Tome of Light")) {
													if (!entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page.contains("Recipe")) {
														return true;
													}
													return false;
												}
												return false;
											}
											return false;
										}
										return false;
									}
									return false;
								}
								return false;
							}
							return false;
						}
						return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}