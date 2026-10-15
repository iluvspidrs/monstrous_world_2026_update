package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
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
import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;

public class NetherAltarCraftingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double coal_required = 0;
		double iron_required = 0;
		NetherAltarItemCountProcedure.execute(world, x, y, z, entity);
		if (getAmountInGUISlot(entity, 5) == 0) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Infernal Ingot") == 3 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Nether Gem") == 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Captive Infernal Light") == 1) {
				CreatePitchforkProcedure.execute(world, x, y, z, entity);
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 1) {
					{
						MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
						_vars.FactionLevel = 2;
						_vars.markSyncDirty();
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You advance a level!"), true);
					if (world instanceof Level)
						((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Infernal Fabric") == 3 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Nether Gem") == 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Captive Infernal Light") == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
					CreateInfernalTunicProcedure.execute(world, x, y, z, entity);
				} else {
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You are not skilled enough to make this yet"), true);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Infernal Fabric") == 4 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Captive Infernal Light") == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 2) {
					CreateInfernalLeggingsProcedure.execute(world, x, y, z, entity);
				} else {
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You are not skilled enough to make this yet"), true);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Diamond") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Villager Bone") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Virtuous Soul") == 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Captive Infernal Light") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Netherite Ingot") == 1) {
				if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel >= 3) {
					CreateCharmOfDeceptionProcedure.execute(world, x, y, z, entity);
					if (entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES).FactionLevel == 3) {
						{
							MonstrousWorldModVariables.PlayerVariables _vars = entity.getData(MonstrousWorldModVariables.PLAYER_VARIABLES);
							_vars.FactionLevel = 4;
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You advance a level!"), true);
						if (world instanceof Level)
							((Level) world).playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.power_select")), SoundSource.NEUTRAL, 1, 1, false);
					}
				} else {
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You are not skilled enough to make this yet"), true);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Villager Bone") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Captive Infernal Light") == 1
					&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Nether Gem") == 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Wicked Soul") == 2) {
				CreateNetherBoneDaggerProcedure.execute(world, x, y, z, entity);
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("Infernal Ingot 0", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Ingot 1", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Ingot 2", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Ingot 3", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Ingot 4", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Ingot", 0);
				_blockEntity.getPersistentData().putDouble("Nether Gem 0", 0);
				_blockEntity.getPersistentData().putDouble("Nether Gem 1", 0);
				_blockEntity.getPersistentData().putDouble("Nether Gem 2", 0);
				_blockEntity.getPersistentData().putDouble("Nether Gem 3", 0);
				_blockEntity.getPersistentData().putDouble("Nether Gem 4", 0);
				_blockEntity.getPersistentData().putDouble("Nether Gem", 0);
				_blockEntity.getPersistentData().putDouble("Captive Infernal Light 0", 0);
				_blockEntity.getPersistentData().putDouble("Captive Infernal Light 1", 0);
				_blockEntity.getPersistentData().putDouble("Captive Infernal Light 2", 0);
				_blockEntity.getPersistentData().putDouble("Captive Infernal Light 3", 0);
				_blockEntity.getPersistentData().putDouble("Captive Infernal Light 4", 0);
				_blockEntity.getPersistentData().putDouble("Captive Infernal Light", 0);
				_blockEntity.getPersistentData().putDouble("Diamond 0", 0);
				_blockEntity.getPersistentData().putDouble("Diamond 1", 0);
				_blockEntity.getPersistentData().putDouble("Diamond 2", 0);
				_blockEntity.getPersistentData().putDouble("Diamond 3", 0);
				_blockEntity.getPersistentData().putDouble("Diamond 4", 0);
				_blockEntity.getPersistentData().putDouble("Diamond", 0);
				_blockEntity.getPersistentData().putDouble("Villager Bone 0", 0);
				_blockEntity.getPersistentData().putDouble("Villager Bone 1", 0);
				_blockEntity.getPersistentData().putDouble("Villager Bone 2", 0);
				_blockEntity.getPersistentData().putDouble("Villager Bone 3", 0);
				_blockEntity.getPersistentData().putDouble("Villager Bone 4", 0);
				_blockEntity.getPersistentData().putDouble("Villager Bone", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Fabric 0", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Fabric 1", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Fabric 2", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Fabric 3", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Fabric 4", 0);
				_blockEntity.getPersistentData().putDouble("Infernal Fabric", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Ingot 0", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Ingot 1", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Ingot 2", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Ingot 3", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Ingot 4", 0);
				_blockEntity.getPersistentData().putDouble("Netherite Ingot", 0);
				_blockEntity.getPersistentData().putDouble("Virtuous Soul 0", 0);
				_blockEntity.getPersistentData().putDouble("Virtuous Soul 1", 0);
				_blockEntity.getPersistentData().putDouble("Virtuous Soul 2", 0);
				_blockEntity.getPersistentData().putDouble("Virtuous Soul 3", 0);
				_blockEntity.getPersistentData().putDouble("Virtuous Soul 4", 0);
				_blockEntity.getPersistentData().putDouble("Virtuous Soul", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}