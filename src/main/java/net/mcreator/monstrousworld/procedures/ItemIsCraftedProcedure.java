package net.mcreator.monstrousworld.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.network.MonstrousWorldModVariables;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;
import net.mcreator.monstrousworld.init.MonstrousWorldModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ItemIsCraftedProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getCrafting());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (itemstack.getItem() == MonstrousWorldModBlocks.BLOOD_FOCUS.get().asItem()) {
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective("Blood Focus Created");
					if (_so == null)
						_so = _sc.addObjective("Blood Focus Created", ObjectiveCriteria.DUMMY, Component.literal("Blood Focus Created"), ObjectiveCriteria.RenderType.INTEGER, true, null);
					_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(1);
				}
			}
			if (itemstack.getItem() == MonstrousWorldModBlocks.CONFECTIONERY_TABLE.get().asItem()) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You advance a level!"), true);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.FactionLevel = 2;
							_vars.markSyncDirty();
						}
					}
				}
			}
			if (itemstack.getItem() == MonstrousWorldModItems.DEADLY_BALLOON_ITEM.get()) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 11) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 5) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You advance a level!"), true);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.FactionLevel = 5;
							_vars.markSyncDirty();
						}
					}
				}
			}
			if (itemstack.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_SHOVEL.get() || itemstack.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_SWORD.get() || itemstack.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_AXE.get()
					|| itemstack.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_PICKAXE.get() || itemstack.getItem() == MonstrousWorldModItems.SHINING_NETHERITE_HOE.get()) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).MonsterClass == 3) {
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You advance a level!"), true);
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.FactionLevel = 3;
							_vars.markSyncDirty();
						}
					}
				}
			}
		}
	}
}