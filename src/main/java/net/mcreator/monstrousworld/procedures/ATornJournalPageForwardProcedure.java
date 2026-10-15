package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class ATornJournalPageForwardProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String page = "";
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Torn Journal Page 1")) {
			page = "2";
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Torn Journal Page 2")) {
			page = "3";
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Torn Journal Page 3")) {
			page = "4";
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		{
			MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
			_vars.RecipeGuideShow = "None";
			_vars.Page = "A Torn Journal Page placeholder".replace("placeholder", page);
			_vars.markSyncDirty();
		}
	}
}