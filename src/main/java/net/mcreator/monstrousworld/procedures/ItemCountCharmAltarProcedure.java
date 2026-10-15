package net.mcreator.monstrousworld.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.monstrousworld.init.MonstrousWorldModMenus;
import net.mcreator.monstrousworld.init.MonstrousWorldModItems;

public class ItemCountCharmAltarProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CAPTIVE_SPIRIT.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CAPTIVE_SPIRIT
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CAPTIVE_SPIRIT
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.CAPTIVE_SPIRIT
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("CaptiveSpirit", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ANOINTMENT_OIL.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ANOINTMENT_OIL
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ANOINTMENT_OIL
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.ANOINTMENT_OIL
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("AnointmentOil", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.INCANTATION_BOOK
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.INCANTATION_BOOK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.INCANTATION_BOOK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.INCANTATION_BOOK.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("IncantationBook", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getItem() == MonstrousWorldModItems.MAGICALLY_TREATED_LEATHER.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.MAGICALLY_TREATED_LEATHER.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.MAGICALLY_TREATED_LEATHER.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.MAGICALLY_TREATED_LEATHER.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("MagicallyTreatedLeather", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.STRING
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu38 ? _menu38.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.STRING
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.STRING
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.STRING) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("String", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.FEATHER
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.FEATHER
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.FEATHER
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.FEATHER) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Feather", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.BOOK
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.BOOK
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu58 ? _menu58.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.BOOK
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.BOOK) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Book", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu67 ? _menu67.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_INK
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("DarkInk", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.RICH_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.RICH_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.RICH_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.RICH_INK
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("RichInk", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AUTUMNAL_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AUTUMNAL_INK
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AUTUMNAL_INK
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.AUTUMNAL_INK
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("AutumnalInk", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DEATHLY_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DEATHLY_INK
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu94 ? _menu94.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DEATHLY_INK
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DEATHLY_INK
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("DeathlyInk", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu99 ? _menu99.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.SPIRITUAL_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu101 ? _menu101.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SPIRITUAL_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu103 ? _menu103.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SPIRITUAL_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu105 ? _menu105.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.SPIRITUAL_INK.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("SpiritualInk", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.UNSTABLE_INK.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu110 ? _menu110.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.UNSTABLE_INK
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.UNSTABLE_INK
						.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu114 ? _menu114.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.UNSTABLE_INK
						.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("UnstableInk", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu117 ? _menu117.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu119 ? _menu119.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu121 ? _menu121.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu123 ? _menu123.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.PURE_DARK_ESSENCE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("PureDarkEssence", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu126 ? _menu126.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST
				.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu128 ? _menu128.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu130 ? _menu130.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu132 ? _menu132.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.DARK_ESSENCE_DUST.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("DarkEssenceDust", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu135 ? _menu135.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == MonstrousWorldModItems.FLIGHT_POWDER.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu137 ? _menu137.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.FLIGHT_POWDER.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu139 ? _menu139.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.FLIGHT_POWDER.get()
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu141 ? _menu141.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == MonstrousWorldModItems.FLIGHT_POWDER.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("FlightPowder", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu144 ? _menu144.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu146 ? _menu146.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu148 ? _menu148.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/malachite")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Malachite", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu153 ? _menu153.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu155 ? _menu155.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu157 ? _menu157.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu159 ? _menu159.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/rose_quartz")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("RoseQuartz", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu162 ? _menu162.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu164 ? _menu164.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu166 ? _menu166.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu168 ? _menu168.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/clear_quartz")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("ClearQuartz", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu171 ? _menu171.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu173 ? _menu173.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu175 ? _menu175.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu177 ? _menu177.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/tigers_eye")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("TigersEye", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu180 ? _menu180.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu184 ? _menu184.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu186 ? _menu186.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/green_agate")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("GreenAgate", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu189 ? _menu189.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu191 ? _menu191.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu193 ? _menu193.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu195 ? _menu195.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/blue_agate")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("BlueAgate", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu198 ? _menu198.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu200 ? _menu200.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu202 ? _menu202.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu204 ? _menu204.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/pale_agate")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("PaleAgate", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu207 ? _menu207.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu209 ? _menu209.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu211 ? _menu211.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu213 ? _menu213.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/red_agate")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("RedAgate", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu216 ? _menu216.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu218 ? _menu218.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu220 ? _menu220.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu222 ? _menu222.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/black_onyx")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("BlackOnyx", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu225 ? _menu225.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu227 ? _menu227.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu229 ? _menu229.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu231 ? _menu231.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/sardonyx")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Sardonyx", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu234 ? _menu234.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:nuggets/gold")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu236 ? _menu236.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:nuggets/gold")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu238 ? _menu238.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:nuggets/gold")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu240 ? _menu240.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:nuggets/gold")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("GoldNugget", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu243 ? _menu243.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu245 ? _menu245.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu247 ? _menu247.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))
				|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof MonstrousWorldModMenus.MenuAccessor _menu249 ? _menu249.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(ResourceLocation.parse("c:gems/moonstone")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Moonstone", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}