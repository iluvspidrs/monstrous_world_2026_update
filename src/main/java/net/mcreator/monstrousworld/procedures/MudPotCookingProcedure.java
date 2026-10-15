package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class MudPotCookingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double coal_required = 0;
		double iron_required = 0;
		if (!world.isClientSide()) {
			MudPotItemCountProcedure.execute(world, x, y, z, entity);
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Mud Bowl") >= 1) {
				if (getAmountInGUISlot(entity, 6) <= 63) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Swamp Wort") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Slug") >= 4) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(6).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.SLUG_SOUP.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							if (getAmountInGUISlot(entity, 6) <= 63) {
								CreateSlugStewProcedure.execute(world, x, y, z, entity);
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Swamp Wort") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Caterpillar") >= 4) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(6).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.CATERPILLAR_STEW.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							if (getAmountInGUISlot(entity, 6) <= 63) {
								CreateCaterpillarStewProcedure.execute(world, x, y, z, entity);
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Swamp Wort") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Pond Scum") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Swamp Essence Dust") >= 1 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Swamp Essence") >= 1
							&& getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Salmon") >= 1) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(6).getItem() : ItemStack.EMPTY)
								.getItem() == MonstrousWorldModItems.MURKY_MEDLEY.get()
								|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY
										.getItem()) {
							if (getAmountInGUISlot(entity, 6) <= 63) {
								CreateMurkyMedleyProcedure.execute(world, x, y, z, entity);
								if (entity instanceof Player _player && _player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu) {
									_menu.getSlots().get(0).remove(1);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("Mud Bowl", 0);
				_blockEntity.getPersistentData().putDouble("Slug", 0);
				_blockEntity.getPersistentData().putDouble("Swamp Wort", 0);
				_blockEntity.getPersistentData().putDouble("Caterpillar", 0);
				_blockEntity.getPersistentData().putDouble("Salmon", 0);
				_blockEntity.getPersistentData().putDouble("Swamp Essence", 0);
				_blockEntity.getPersistentData().putDouble("Swamp Essence Dust", 0);
				_blockEntity.getPersistentData().putDouble("Pond Scum", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}