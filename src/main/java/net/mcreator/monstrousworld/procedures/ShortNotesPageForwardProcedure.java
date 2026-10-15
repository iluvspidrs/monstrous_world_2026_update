package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.world.inventory.CureSerumPage2Menu;
import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;

import io.netty.buffer.Unpooled;

public class ShortNotesPageForwardProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String page = "";
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Note On Spirits Page 1")) {
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "A Note On Spirits Page 2";
				_vars.markSyncDirty();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Farmer's Log Page 1")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Farmer's Log Page 2";
				_vars.markSyncDirty();
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Cure Serum Note Page 1")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Cure Serum Note Page 2";
				_vars.markSyncDirty();
			}
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("CureSerumPage2");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new CureSerumPage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Email Archive Page 1")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Email Archive Page 2";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Email Archive Page 2")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Email Archive Page 3";
				_vars.markSyncDirty();
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Recovered Journal Page 1")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "A Recovered Journal Page 2";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("A Recovered Journal Page 2")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "A Recovered Journal Page 3";
				_vars.markSyncDirty();
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Letter From Countess Page 1")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Letter From Countess Page 2";
				_vars.markSyncDirty();
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Unusual Infection Page 1")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Unusual Infection Page 2";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Unusual Infection Page 2")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Unusual Infection Page 3";
				_vars.markSyncDirty();
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Mysterious Container Page 1")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Mysterious Container Page 2";
				_vars.markSyncDirty();
			}
		}
		if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Sacrifice Page 1")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Sacrifice Page 2";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).Page).equals("Sacrifice Page 2")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.book.page_turn")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
				_vars.Page = "Sacrifice Page 3";
				_vars.markSyncDirty();
			}
		}
	}
}