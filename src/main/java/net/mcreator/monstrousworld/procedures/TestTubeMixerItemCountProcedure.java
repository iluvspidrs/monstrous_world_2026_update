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

public class TestTubeMixerItemCountProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("UndeadTissueSample", 0);
				_blockEntity.getPersistentData().putDouble("FlyDNASample", 0);
				_blockEntity.getPersistentData().putDouble("SerpentDNASample", 0);
				_blockEntity.getPersistentData().putDouble("DreadfulWatcherDNASample", 0);
				_blockEntity.getPersistentData().putDouble("CreeperDNASample", 0);
				_blockEntity.getPersistentData().putDouble("GlowstoneSample", 0);
				_blockEntity.getPersistentData().putDouble("RedstoneSample", 0);
				_blockEntity.getPersistentData().putDouble("DarknessSample", 0);
				_blockEntity.getPersistentData().putDouble("VanishingPowder", 0);
				_blockEntity.getPersistentData().putDouble("FrogifyPowder", 0);
				_blockEntity.getPersistentData().putDouble("SinkingPowder", 0);
				_blockEntity.getPersistentData().putDouble("ParalyzePowder", 0);
				_blockEntity.getPersistentData().putDouble("ChickenifyPowder", 0);
				_blockEntity.getPersistentData().putDouble("MidasCursePowder", 0);
				_blockEntity.getPersistentData().putDouble("StabilizingPowder", 0);
				_blockEntity.getPersistentData().putDouble("StrangeSerumFly", 0);
				_blockEntity.getPersistentData().putDouble("StrangeSerumEye", 0);
				_blockEntity.getPersistentData().putDouble("StrangeSerumSerpent", 0);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.UNDEAD_TISSUE_SAMPLE
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.UNDEAD_TISSUE_SAMPLE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("UndeadTissueSample", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FLY_DNA_SAMPLE.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FLY_DNA_SAMPLE
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("FlyDNASample", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SERPENT_DNA_SAMPLE
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SERPENT_DNA_SAMPLE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("SerpentDNASample", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.DREADFUL_WATCHER_DNA_SAMPLE.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.DREADFUL_WATCHER_DNA_SAMPLE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("DreadfulWatcherDNASample", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CREEPER_DNA_SAMPLE
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.CREEPER_DNA_SAMPLE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("CreeperDNASample", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu43 ? _menu43.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.GLOWSTONE_SAMPLE
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.GLOWSTONE_SAMPLE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("GlowstoneSample", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARKNESS_SAMPLE.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.DARKNESS_SAMPLE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("DarknessSample", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu53 ? _menu53.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.REDSTONE_SAMPLE.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu55 ? _menu55.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.REDSTONE_SAMPLE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("RedstoneSample", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu58 ? _menu58.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.VANISHING_POWDER
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.VANISHING_POWDER.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("VanishingPowder", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FROGIFY_POWDER.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FROGIFY_POWDER
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("FrogifyPowder", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SINKING_POWDER.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu70 ? _menu70.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SINKING_POWDER
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("SinkingPowder", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu73 ? _menu73.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.MIDAS_CURSE_POWDER
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu75 ? _menu75.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.MIDAS_CURSE_POWDER.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("MidasCursePowder", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PARALYSIS_POWDER
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.PARALYSIS_POWDER.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("ParalyzePowder", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CHICKENIFY_POWDER
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.CHICKENIFY_POWDER.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("ChickenifyPowder", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.STABILIZING_DUST
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.STABILIZING_DUST.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("StabilizingPowder", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu93 ? _menu93.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_FLY.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu95 ? _menu95.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_FLY.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("StrangeSerumFly", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_EYE.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_EYE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("StrangeSerumEye", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu103 ? _menu103.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_SERPENT.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu105 ? _menu105.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.STRANGE_SERUM_SYRINGE_SERPENT.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("StrangeSerumSerpent", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu111 ? _menu111.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Empty", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}