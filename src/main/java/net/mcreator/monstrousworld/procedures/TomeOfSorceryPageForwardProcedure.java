package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

public class TomeOfSorceryPageForwardProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
			_vars.markSyncDirty();
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Tome of Sorcery Page 1")) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Tome of Sorcery Page 2";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Tome of Sorcery Page 2")) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Tome of Sorcery Page 3";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Tome of Sorcery Page 3")) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Tome of Sorcery Page 4";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Tome of Sorcery Page 4")) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Tome of Sorcery Page 5";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Tome of Sorcery Page 5")) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Tome of Sorcery Page 6";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Tome of Sorcery Page 6")) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Tome of Sorcery Page 7";
				_vars.markSyncDirty();
			}
		}
	}
}